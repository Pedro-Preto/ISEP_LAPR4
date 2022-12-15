/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.Collaborator.application;

import eapli.base.Collaborator.domain.*;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Team;
import eapli.base.Utils.EmailSystem;
import eapli.base.Utils.PasswordGeneratorAlgorithm;
import eapli.base.Utils.TaskComparator;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class CollaboratorController {
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final AddUserController userController = new AddUserController();
    private static final Logger LOGGER = LoggerFactory.getLogger(CollaboratorController.class);
    public ListUsersController listUserController = new ListUsersController();
    public TeamController teamController = new TeamController();

    public Collaborator addAnRRHOrGSHCollaborator(final MecanographicNumber numMechanographic, final CollaboratorFirstName firstName, final CollaboratorLastName lastName, final EmailAddress email, final CollaboratorPhoneNumber phoneNumber, final CollaboratorBirthDay birthDate, final CollaboratorAddress address, final Set<CollaboratorFunctions> function, int role) {

        Collaborator c1 = new Collaborator(numMechanographic, firstName, lastName, email, phoneNumber, birthDate, address, function);

        Set<Role> roleSet = new HashSet<>();
        if (role == 1) {
            roleSet.add(BaseRoles.RRH);
        } else if (role == 2) {
            roleSet.add(BaseRoles.GSH);
        } else {
            throw new IllegalArgumentException("That Role doesn't exist!!!");
        }
        String password = PasswordGeneratorAlgorithm.generatesPassword();
        registerUser(c1.getNumMechanographic().toString(), password, c1.getFirstName().toString(), c1.getLastName().toString(), c1.getEmail().toString(), roleSet);

        EmailSystem.sendEmail(c1.getEmail().toString(), roleSet.toString(), c1.getNumMechanographic().toString(), password);
        return collaboratorRepository.save(c1);
    }

    public Collaborator addAnRRHCollaborator(final MecanographicNumber numMechanographic, final CollaboratorFirstName firstName, final CollaboratorLastName lastName, final EmailAddress email, final CollaboratorPhoneNumber phoneNumber, final CollaboratorBirthDay birthDate, final CollaboratorAddress address, final Set<CollaboratorFunctions> function) {

        Collaborator c1 = new Collaborator(numMechanographic, firstName, lastName, email, phoneNumber, birthDate, address, function);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(BaseRoles.RRH);

        String password = PasswordGeneratorAlgorithm.generatesPassword();
        registerUser(c1.getNumMechanographic().toString(), password, c1.getFirstName().toString(), c1.getLastName().toString(), c1.getEmail().toString(), roleSet);
        EmailSystem.sendEmail(c1.getEmail().toString(), roleSet.toString(), c1.getNumMechanographic().toString(), password);
        return collaboratorRepository.save(c1);

    }

    public Collaborator getCollaboratorByEmail(final String email) {
        return collaboratorRepository.findByEmail(email);
    }

    public Collaborator getCollaboratorByMecaNumber(MecanographicNumber number) {
        return collaboratorRepository.findByMecanographicNumber(MecanographicNumber.valueOf(number.toString()));
    }

    public List<Collaborator> getAllCollaborators() {
        return (List<Collaborator>) collaboratorRepository.findAll();
    }

    public boolean isCollaboratorInsertOnSetOfTeamsOfCatalogue(Collaborator collaborator, Set<Team> teams) {
        for (Team team : teams) {
            if (team.getTeamCollaborators().contains(collaborator)) {
                return true;
            }
        }
        return false;
    }


    protected SystemUser registerUser(final String username, final String password, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles) {
        SystemUser u = null;
        try {
            u = userController.addUser(username, password, firstName, lastName, email, roles);
            LOGGER.debug("»»» %s", username);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            u = listUserController.find(Username.valueOf(username)).orElseThrow(() -> e);
        }
        return u;
    }
}
