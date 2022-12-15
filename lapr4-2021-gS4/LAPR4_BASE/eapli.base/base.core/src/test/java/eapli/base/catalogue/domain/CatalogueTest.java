package eapli.base.catalogue.domain;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.Color.domain.Color;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.Utils.AgeCalculator;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class CatalogueTest {

    public static Collaborator dummyCollaborator(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("dummyCollab"),
                CollaboratorLastName.valueOf(" Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1, 1, 1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    public static Set<Collaborator> dummyCollaboratorSet(Set<String> mecNumbers) {
        Set<Collaborator> collaboratorSet = new HashSet<>();
        for (String mn : mecNumbers)
            collaboratorSet.add(dummyCollaborator(mn));
        return collaboratorSet;
    }

    public static TeamType dummyTeamType(String code) {
        Color color = new Color(ColorDesignation.valueOf("dummyColor"), ColorHexCode.valueOf("dummyHex"));
        TeamType teamType = new TeamType(CodeTeamType.valueOf(code), "dummyDesignation", color);
        return teamType;
    }

    public static Team dummyTeam(String teamTypeCode, String teamCode, String acronym, String collaboratorMecNumber, Set<String> collaboratorSet) {
        Team team = new Team(CodeTeam.valueOf(teamCode), "dummyDesignation",
                Acronym.valueOf(acronym), dummyTeamType(teamTypeCode),
                dummyCollaborator(collaboratorMecNumber), dummyCollaboratorSet(collaboratorSet));
        return team;
    }

    public static Criticality dummyCriticality(long criticalityId) {
        Color color = new Color(ColorDesignation.valueOf("dummyColor"), ColorHexCode.valueOf("dummyHex"));
        Criticality criticality = new Criticality(CriticalityID.valueOf(criticalityId), 3, 5, color, 30, 20,50,40);
        return criticality;
    }

    @Test
    public void ensureEqualsPassesForSameAllowedTeamList() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());

        Set<Team> expected = new HashSet<>();
        assertEquals(expected, dummyCatalogue.getAllowedTeamList());

        expected.add(dummyTeam);
        assertNotEquals(expected, dummyCatalogue.getAllowedTeamList());

        dummyCatalogue.addTeam(dummyTeam);
        assertEquals(expected, dummyCatalogue.getAllowedTeamList());

        dummyCatalogue.removeTeam(dummyTeam);
        assertNotEquals(expected, dummyCatalogue.getAllowedTeamList());

        expected.remove(dummyTeam);
        assertEquals(expected, dummyCatalogue.getAllowedTeamList());
    }

    @Test
    public void ensureNotEqualsPassesForSameAllowedTeamList() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Team otherDummyTeam = dummyTeam("52641", "2311", "asz", "2324", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());

        Set<Team> unexpected = new HashSet<>();

        unexpected.add(dummyTeam);
        assertNotEquals(unexpected, dummyCatalogue.getAllowedTeamList());

        dummyCatalogue.addTeam(otherDummyTeam);
        assertNotEquals(unexpected, dummyCatalogue.getAllowedTeamList());
    }

    @Test
    public void ensureEqualsPassesForSameInstance() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Team otherDummyTeam = dummyTeam("52641", "2311", "asz", "2324", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());

        final boolean expected = dummyCatalogue.equals(dummyCatalogue);
        assertTrue(expected);

    }

    @Test
    public void ensureEqualsFailsForDifferentTitles() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Team otherDummyTeam = dummyTeam("52641", "2311", "asz", "2324", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());
        Catalogue otherDummyCatalogue = new Catalogue(Title.valueOf("otherDummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());

        final boolean expected = dummyCatalogue.equals(otherDummyCatalogue);
        assertFalse(expected);
    }

    @Test
    public void ensureEqualsFailsForDifferentDescriptions() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Team otherDummyTeam = dummyTeam("52641", "2311", "asz", "2324", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());
        Catalogue otherDummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "otherDescription", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());

        final boolean expected = dummyCatalogue.equals(otherDummyCatalogue);
        assertFalse(expected);
    }

    @Test
    public void ensureEqualsFailsForDifferentCollaborator() {
        Team dummyTeam = dummyTeam("54321", "4321", "abc", "1624", new HashSet<>());
        Team otherDummyTeam = dummyTeam("52641", "2311", "asz", "2324", new HashSet<>());
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("abcde"), dummyCriticality(1234),
                new HashSet<>());
        Catalogue otherDummyCatalogue = new Catalogue(Title.valueOf("dummyTitle"),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator("xyaz"), dummyCriticality(1234),
                new HashSet<>());

        final boolean expected = dummyCatalogue.equals(otherDummyCatalogue);
        assertFalse(expected);
    }

    @Test
    public void colorContainTest() {
        Color color1 = new Color(ColorDesignation.valueOf("blue"), ColorHexCode.valueOf("#0000FF"));
        Color color2 = new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000"));
        Color color3 = new Color(ColorDesignation.valueOf("gold"), ColorHexCode.valueOf("#FFD700"));
        Color color4 = new Color(ColorDesignation.valueOf("green"), ColorHexCode.valueOf("#00FF00"));
        Color color5 = new Color(ColorDesignation.valueOf("silver"), ColorHexCode.valueOf("#C0C0C0"));
        Color color6 = new Color(ColorDesignation.valueOf("pink"), ColorHexCode.valueOf("#FFC0CB"));

        List<TeamType> teamTypeList = new ArrayList<>();
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Type 1", color1);
        teamTypeList.add(teamType1);

        List<Color> colorList1 = new ArrayList<>();
        colorList1.add(color1);
        colorList1.add(color2);
        colorList1.add(color3);
        colorList1.add(color4);
        colorList1.add(color5);
        colorList1.add(color6);
/*
        for (TeamType teamType:teamTypeList){
            if(colorList1.contains(teamType.getColor())){
                colorList1.remove(teamType.getColor());
            }
        }

        for (Color c : colorList1) {
            System.out.println(c.toString());
        }
        assertEquals(colorList1.size(),5);
*/

        List<Color> colorList2 = new ArrayList<>();
        colorList2.add(color1);
        colorList2.add(color2);
        colorList2.add(color3);

        boolean a = colorList1.contains(color1);
        assertTrue(a);

        removeCommonEntries(colorList1, colorList2);
        for (Color c : colorList1) {
            System.out.println(c.toString());
        }

    }

    @Test
    public void ageTest() throws ParseException {
        Date date = new Date();

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

/*
        int age = AgeCalculator.getCalculateAge(date1);
        System.out.println(age);
        assertEquals(age, 19);
*/
        System.out.println( date.toString());
    }

    public static final <T> void removeCommonEntries(Collection<T> a, Collection<T> b) {
        b.removeIf(i -> a.remove(i));
    }


}
