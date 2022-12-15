package eapli.base.Utils;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class ServiceComparatorTest {

    public static Collaborator dummyCollaborator1(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("Ana"),
                CollaboratorLastName.valueOf(" Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1, 1, 1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    public static Collaborator dummyCollaborator2(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("Joao"),
                CollaboratorLastName.valueOf(" Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1, 1, 1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    public static Collaborator dummyCollaborator3(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("Ruben"),
                CollaboratorLastName.valueOf(" Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1, 1, 1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    @Test
    public void sortByTitle() {
        ServiceComparator serviceComparator = new ServiceComparator();


        long longo = 1;
        Criticality criticality1 = new Criticality(CriticalityID.valueOf(longo), 3, 3, new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF")), 32, 20,50,40);
        Collaborator a1 = dummyCollaborator1("1");
        Collaborator a2 = dummyCollaborator2("2");
        Collaborator a3 = dummyCollaborator3("3");
        Catalogue c1 = new Catalogue(Title.valueOf("Porta"), "M", "A", Icon.valueOf("ds"), a1, criticality1, new HashSet<>());
        Catalogue c2 = new Catalogue(Title.valueOf("Jarro"), "M", "A", Icon.valueOf("ds"), a2, criticality1, new HashSet<>());
        Catalogue c3 = new Catalogue(Title.valueOf("Esquilar"), "M", "A", Icon.valueOf("ds"), a3, criticality1, new HashSet<>());


        Service s1 = new Service(Title.valueOf("Yoshi limpeza"), "nulql", "nu2ll", Code.valueOf("1"), Icon.valueOf("sa"), c1, new HashSet<>());
        Service s2 = new Service(Title.valueOf("Toad powerUp"), "nulql", "nu2ll", Code.valueOf("1"), Icon.valueOf("sa"), c2, new HashSet<>());
        Service s3 = new Service(Title.valueOf("Chomper, o grande"), "nulql", "nu2ll", Code.valueOf("1"), Icon.valueOf("sa"), c3, new HashSet<>());

        List<Service> actual = new LinkedList<>();
        List<Service> expected = new LinkedList<>();
        actual.add(s1);
        actual.add(s2);
        actual.add(s3);
        serviceComparator.sortByTitle(actual);

        expected.add(s3);
        expected.add(s2);
        expected.add(s1);

        System.out.println("Actual");
        for (Service c : actual) {
            System.out.println(c.getTitle());
        }

        System.out.println("Expected");
        for (Service c : expected) {

            System.out.println(c.getTitle());
        }

        assertEquals(expected, actual);

    }
}