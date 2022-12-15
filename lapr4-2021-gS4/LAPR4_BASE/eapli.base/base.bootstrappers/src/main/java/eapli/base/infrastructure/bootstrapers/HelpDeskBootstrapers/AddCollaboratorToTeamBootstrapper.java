package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class AddCollaboratorToTeamBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

    private final TeamController teamController = new TeamController();
    private final CollaboratorController collaboratorController = new CollaboratorController();

    @Override
    public boolean execute() {



        /* -------------------------------------------------Add Colab to TEAM 1 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1001")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("101")));

        /* -------------------------------------------------Add Colab to TEAM 2 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1002")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("102")));

        /* -------------------------------------------------Add Colab to TEAM 3 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1003")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("103")));

        /* -------------------------------------------------Add Colab to TEAM 4 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1004")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("104")));

        /* -------------------------------------------------Add Colab to TEAM 5 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1005")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("105")));

        /* -------------------------------------------------Add Colab to TEAM 6 ------------------------------------------------- */

        addCollaboratorTeam(teamController.getTeamByCode(CodeTeam.valueOf("1006")), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("106")));


        System.out.println("==========================================");
        System.out.println("Bootstrapping Add Collaborator To Teams...");
        System.out.println("==========================================");
        return true;
    }

    private boolean addCollaboratorTeam(Team team, Collaborator collaborator) {
        try {
            teamController.addCollaboratorToTeam(team, collaborator);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", collaborator.getNumMechanographic());
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
