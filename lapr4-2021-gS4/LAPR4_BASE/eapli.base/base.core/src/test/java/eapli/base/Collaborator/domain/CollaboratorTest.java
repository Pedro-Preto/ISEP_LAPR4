package eapli.base.Collaborator.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CollaboratorTest {

    public Collaborator getCollaborator() throws ParseException {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("Backup"));
        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("1190969"),CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf(" Manel"), EmailAddress.valueOf("1190969@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000001"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 2", "Porto", "Portugal"), collaboratorFunctions);
        return c1;
    }


    @Test
    public void testEquals() throws ParseException {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("Backup"));
        Collaborator c1 = getCollaborator();
        Collaborator c2 = getCollaborator();
        assertEquals(c1.toString(), c2.toString());

        Collaborator c3 = new Collaborator(MecanographicNumber.valueOf("1190961"), CollaboratorFirstName.valueOf("Joao"),CollaboratorLastName.valueOf("Manel"), EmailAddress.valueOf("1190969@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000001"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 2", "Porto", "Portugal"), collaboratorFunctions);
        assertNotEquals("Meca Numbers are not equals", c1.toString(), c3.toString());

        Collaborator c4 = new Collaborator(MecanographicNumber.valueOf("1190969"), CollaboratorFirstName.valueOf("Joana"),CollaboratorLastName.valueOf("Garcia"), EmailAddress.valueOf("1190969@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000001"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 2", "Porto", "Portugal"), collaboratorFunctions);
        assertNotEquals("Names are not equals", c1.toString(), c4.toString());

        Collaborator c5 = new Collaborator(MecanographicNumber.valueOf("1190969"),CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf("Manel"), EmailAddress.valueOf("1190961@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000001"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 2", "Porto", "Portugal"), collaboratorFunctions);
        assertNotEquals("Emails are not equals", c1.toString(), c5.toString());
    }

    @Test
    public void testHashCode() throws ParseException {
        Collaborator c=getCollaborator();
        int expected=1994964128;
        assertEquals(c.hashCode(),expected);
    }
}