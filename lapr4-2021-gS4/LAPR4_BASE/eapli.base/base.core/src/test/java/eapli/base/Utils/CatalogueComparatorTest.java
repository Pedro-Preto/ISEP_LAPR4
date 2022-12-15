package eapli.base.Utils;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class CatalogueComparatorTest {
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
        CatalogueComparator catalogueComparator = new CatalogueComparator();

        long longo = 1;
        Criticality criticality1 = new Criticality(CriticalityID.valueOf(longo), 3, 3, new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF")), 32, 20,50,40);
        Collaborator a1 = dummyCollaborator1("1");
        Collaborator a2 = dummyCollaborator2("2");
        Collaborator a3 = dummyCollaborator3("3");
        Catalogue c1 = new Catalogue(Title.valueOf("Porta"), "M", "A", Icon.valueOf("ds"), a1, criticality1, new HashSet<>());
        Catalogue c2 = new Catalogue(Title.valueOf("Jarro"), "M", "A", Icon.valueOf("ds"), a2, criticality1, new HashSet<>());
        Catalogue c3 = new Catalogue(Title.valueOf("Esquilar"), "M", "A", Icon.valueOf("ds"), a3, criticality1, new HashSet<>());

        List<Catalogue> actual = new LinkedList<>();
        List<Catalogue> expected = new LinkedList<>();
        actual.add(c1);
        actual.add(c2);
        actual.add(c3);
        catalogueComparator.sortByTitle(actual);

        expected.add(c3);
        expected.add(c2);
        expected.add(c1);


        for (Catalogue c : actual) {
            System.out.println("Actual");
            System.out.println(c.toString());
        }

        for (Catalogue c : expected) {
            System.out.println("Expected");
            System.out.println(c.toString());
        }

        assertEquals(expected, actual);


    }

    @Test
    public void sortByResponsible() {
        CatalogueComparator catalogueComparator = new CatalogueComparator();

        long longo = 1;
        Criticality criticality1 = new Criticality(CriticalityID.valueOf(longo), 3, 3, new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF")), 32, 20,50,40);
        Collaborator a1 = dummyCollaborator1("1");
        Collaborator a2 = dummyCollaborator2("2");
        Collaborator a3 = dummyCollaborator3("3");
        Catalogue c1 = new Catalogue(Title.valueOf("Porta"), "M", "A", Icon.valueOf("ds"), a1, criticality1, new HashSet<>());
        Catalogue c2 = new Catalogue(Title.valueOf("Jarro"), "M", "A", Icon.valueOf("ds"), a2, criticality1, new HashSet<>());
        Catalogue c3 = new Catalogue(Title.valueOf("Esquilar"), "M", "A", Icon.valueOf("ds"), a3, criticality1, new HashSet<>());

        List<Catalogue> actual = new LinkedList<>();
        List<Catalogue> expected = new LinkedList<>();
        actual.add(c1);
        actual.add(c2);
        actual.add(c3);
        catalogueComparator.sortByResponsible(actual);
        expected.add(c1);
        expected.add(c2);
        expected.add(c3);


        assertEquals(expected, actual);


    }
}