package eapli.base.Request.model;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.RequestFormId;
import eapli.base.service.domain.Service;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RequestTest {


    public static Collaborator dummyCollaborator(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("dummyCollab"),
                CollaboratorLastName.valueOf("Collab"),
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
        Criticality criticality = new Criticality(CriticalityID.valueOf(criticalityId), 3, 5, color, 30, 20, 50, 40);
        return criticality;
    }

    public static Catalogue dummyCatalogue(String catalogueTitle, String colMecNumber, long critId) {
        Catalogue dummyCatalogue = new Catalogue(Title.valueOf(catalogueTitle),
                "description", "briefDescription", Icon.valueOf("dummyIcon"),
                dummyCollaborator(colMecNumber), dummyCriticality(critId),
                new HashSet<>());
        return dummyCatalogue;
    }

    public static Service dummyService() {
        Catalogue dummyCatalogue = dummyCatalogue("dummyCatalogue", "7863", 1234);

        Service dummyService = new Service(Title.valueOf("dummyTitle"), "briefDescription",
                "description", eapli.base.service.domain.Code.valueOf("4612"),
                Icon.valueOf("dummyIcon"), dummyCatalogue, new HashSet<>());
        return dummyService;
    }

    @Test
    public void equalsRequestTest() throws ParseException {
        Set<FormAttribute> formAttributes = new HashSet<>();
        formAttributes.add(FormAttribute.valueOf("Date", "21/2/2000", "dataNascimento"));

        Request request1 = new Request(CodeRequest.valueOf("1"), dummyService(), new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"), RequestState.ON_COURSE, dummyCollaborator("123"), dummyCollaborator("123"), new RequestForm(RequestFormId.valueOf("1"), "Form1", formAttributes),RequestGrade.GOOD);
        Request request2 = new Request(CodeRequest.valueOf("2"), dummyService(), new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"), RequestState.ON_COURSE, dummyCollaborator("1234"), dummyCollaborator("123"), new RequestForm(RequestFormId.valueOf("1"), "Form1", formAttributes),RequestGrade.GOOD);

        assertEquals(request1, request1);

        assertNotEquals(request1.toString(), request2.toString());


    }


}
