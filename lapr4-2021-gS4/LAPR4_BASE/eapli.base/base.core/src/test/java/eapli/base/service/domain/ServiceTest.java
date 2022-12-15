package eapli.base.service.domain;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.Color.domain.Color;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ServiceTest {

    public static Collaborator dummyCollaborator(String mecanographicNumber) {
       Set<CollaboratorFunctions> collaboratorFunctions=new HashSet<>();
       collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber),CollaboratorFirstName.valueOf("dummyCollab"),
                CollaboratorLastName.valueOf("Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1,1,1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    public static Set<Collaborator> dummyCollaboratorSet(Set<String> mecNumbers){
        Set<Collaborator> collaboratorSet = new HashSet<>();
        for(String mn : mecNumbers)
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

    public static Criticality dummyCriticality(long criticalityId){
        Color color = new Color(ColorDesignation.valueOf("dummyColor"), ColorHexCode.valueOf("dummyHex"));
        Criticality criticality = new Criticality(CriticalityID.valueOf(criticalityId), 3, 5, color, 30, 20,50,40);
        return criticality;
    }

    public static Catalogue dummyCatalogue(String catalogueTitle, String colMecNumber, long critId){
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf(catalogueTitle),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator(colMecNumber), dummyCriticality(critId),
                new HashSet<>());
        return dummyCatalogue;
    }

    @Test
    public void ensureEqualsPassesForSameInstances(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        final boolean expected = dummyService.equals(dummyService);
        assertTrue(expected);
    }

    @Test
    public void ensureEqualsPassesForSameKeywords(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        Set<Keyword> expected = new HashSet<>();
        assertEquals(expected, dummyService.getKeywords());

        Keyword dummyKeyword = Keyword.valueOf("TEST");

        expected.add(dummyKeyword);
        assertNotEquals(expected, dummyCatalogue.getAllowedTeamList());

        dummyService.addKeyword(dummyKeyword);
        assertEquals(expected, dummyService.getKeywords());
    }

    @Test
    public void ensureNotEqualsPassesForDifferentKeywords(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        Set<Keyword> expected = new HashSet<>();

        Keyword dummyKeyword = Keyword.valueOf("TEST");
        Keyword otherDummyKeyword = Keyword.valueOf("TEST2");

        expected.add(dummyKeyword);
        assertNotEquals(expected, dummyCatalogue.getAllowedTeamList());

        dummyService.addKeyword(otherDummyKeyword);
        assertNotEquals(expected, dummyService.getKeywords());
    }

    @Test
    public void ensureEqualsFailsForDifferentTitles(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        Service otherDummyService = new Service(Title.valueOf("otherDummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        final boolean expected = dummyService.equals(otherDummyService);
        assertFalse(expected);
    }

    @Test
    public void ensureEqualsFailsForDifferentCodes(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        Service otherDummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("2164"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        final boolean expected = dummyService.equals(otherDummyService);
        assertFalse(expected);
    }

    @Test
    public void ensureBuilderIsCompleteWorks(){
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());

        ServiceBuilder serviceBuilder = new ServiceBuilder();
        boolean expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withTitle("dummyTitle");
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withBriefDescription("briefDescription");
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withDescription("description");
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withCode("4612");
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withIcon("dummyIcon");
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withKeywords(new HashSet<>());
        expected = serviceBuilder.isComplete();
        assertFalse(expected);

        serviceBuilder.withCatalogue(dummyCatalogue);
        expected = serviceBuilder.isComplete();
        assertTrue(expected);
    }

}
