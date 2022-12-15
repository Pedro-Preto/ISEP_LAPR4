package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CollaboratorBootstrapper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(CriticalityBootstrapper.class);

    private final CollaboratorController collaboratorController = new CollaboratorController();

    @Override
    public boolean execute() {

        //COLLABORATOR 1
        Set<CollaboratorFunctions> functions1 = new HashSet<>();
        functions1.add(CollaboratorFunctions.valueOf("First Adviser"));

        try {
            addRRHCollaborator(MecanographicNumber.valueOf("101"), CollaboratorFirstName.valueOf("CollaboratorA"), CollaboratorLastName.valueOf("ColA"), EmailAddress.valueOf("colabA@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("911111111"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua das Flores", "Porto", "Portugal"), functions1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //COLLABORATOR 2

        Set<CollaboratorFunctions> functions2 = new HashSet<>();
        functions2.add(CollaboratorFunctions.valueOf("Team Leader"));

        try {
            addRRHCollaborator(MecanographicNumber.valueOf("102"), CollaboratorFirstName.valueOf("CollaboratorB"), CollaboratorLastName.valueOf("ColB"), EmailAddress.valueOf("colabB@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("922222222"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua dos Pinheiros", "Guarda", "Portugal"), functions2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //COLLABORATOR 3
        CollaboratorAddress ad3 = new CollaboratorAddress("Rua das Couves", "Alentejo", "Portugal");
        Set<CollaboratorFunctions> functions3 = new HashSet<>();
        functions3.add(CollaboratorFunctions.valueOf("Code Expert"));

        try {
            addRRHCollaborator(MecanographicNumber.valueOf("103"), CollaboratorFirstName.valueOf("CollaboratorC"), CollaboratorLastName.valueOf("ColC"), EmailAddress.valueOf("colabC@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("933333333"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua das Couves", "Alentejo", "Portugal"), functions3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //COLLABORATOR 4
        Set<CollaboratorFunctions> functions4 = new HashSet<>();
        functions4.add(CollaboratorFunctions.valueOf("Software Expert"));

        try {
            addGSHCollaborator(MecanographicNumber.valueOf("104"), CollaboratorFirstName.valueOf("CollaboratorD"), CollaboratorLastName.valueOf("ColD"), EmailAddress.valueOf("colabD@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("944444444"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua das Cores", "Braga", "Portugal"), functions4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //COLLABORATOR 5
        Set<CollaboratorFunctions> functions5 = new HashSet<>();
        functions5.add(CollaboratorFunctions.valueOf("Bison Expert"));

        try {
            addGSHCollaborator(MecanographicNumber.valueOf("105"), CollaboratorFirstName.valueOf("CollaboratorE"), CollaboratorLastName.valueOf("ColE"), EmailAddress.valueOf("colabE@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("955555555"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua das Virtudes", "Setubal", "Portugal"), functions5);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //COLLABORATOR 6
        Set<CollaboratorFunctions> functions6 = new HashSet<>();
        functions6.add(CollaboratorFunctions.valueOf("Flex Expert"));

        try {
            addGSHCollaborator(MecanographicNumber.valueOf("106"), CollaboratorFirstName.valueOf("CollaboratorF"), CollaboratorLastName.valueOf("ColF"), EmailAddress.valueOf("colabF@bootstrapper.com"), CollaboratorPhoneNumber.valueOf("966666666"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("29/08/2001")), CollaboratorAddress.valueOf("Rua das Travessias", "Coimbra", "Portugal"), functions6);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean addRRHCollaborator(MecanographicNumber number, CollaboratorFirstName firstName,
                                       CollaboratorLastName lastName, EmailAddress emailAddress,
                                       CollaboratorPhoneNumber phoneNumber, CollaboratorBirthDay birthDay,
                                       CollaboratorAddress address, Set<CollaboratorFunctions> functions) {
        try {
            collaboratorController.addAnRRHOrGSHCollaborator(number, firstName, lastName, emailAddress, phoneNumber, birthDay, address, functions, 1);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", number);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }

    private boolean addGSHCollaborator(MecanographicNumber number, CollaboratorFirstName firstName,
                                       CollaboratorLastName lastName, EmailAddress emailAddress,
                                       CollaboratorPhoneNumber phoneNumber, CollaboratorBirthDay birthDay,
                                       CollaboratorAddress address, Set<CollaboratorFunctions> functions) {
        try {
            collaboratorController.addAnRRHOrGSHCollaborator(number, firstName, lastName, emailAddress, phoneNumber, birthDay, address, functions, 2);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", number);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
