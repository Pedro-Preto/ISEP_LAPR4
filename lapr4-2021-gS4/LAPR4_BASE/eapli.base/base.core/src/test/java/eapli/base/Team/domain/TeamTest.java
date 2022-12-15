package eapli.base.Team.domain;

import eapli.base.Collaborator.domain.*;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TeamTest {

    public Collaborator getCollaborator1() throws ParseException {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("Backup"));
        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("1190969"), CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf(" Manel"), EmailAddress.valueOf("1190969@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000001"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 2", "Porto", "Portugal"), collaboratorFunctions);

        return c1;
    }

    public Collaborator getResponsibleCollaborator() throws ParseException {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("Team Leader"));
        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("1190961"), CollaboratorFirstName.valueOf("Pikachu"), CollaboratorLastName.valueOf("Yellow"), EmailAddress.valueOf("1190961@isep.ipp.pt"), CollaboratorPhoneNumber.valueOf("938000000"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("21/02/2000")), CollaboratorAddress.valueOf("Rua 1", "Bragança", "Portugal"), collaboratorFunctions);

        return c1;
    }

    public TeamType getTeamType() {
        TeamType teamType1 = new TeamType(CodeTeamType.valueOf("1"), "Team Type 1", new Color(ColorDesignation.valueOf("red"), ColorHexCode.valueOf("#FF0000")));

        return teamType1;
    }

    public Team getTeam() throws ParseException {
        Team team = new Team(CodeTeam.valueOf("1"), "Team 1", Acronym.valueOf("t1"), getTeamType(), getResponsibleCollaborator(), new HashSet<>());
        return team;
    }

    @Test
    public void addCollaboratorToTeam() throws ParseException {
        Team team = getTeam();
        boolean a_1 = team.addCollaboratorToTeam(getCollaborator1());
        assertTrue(a_1);

        boolean a = team.getTeamCollaborators().isEmpty();
        assertFalse(a);
        Collaborator collaborator1 = getCollaborator1();

        assertEquals(collaborator1, getCollaborator1());
        boolean b = team.getTeamCollaborators().contains(collaborator1);
        assertTrue(b);

        boolean c = team.getTeamCollaborators().size() == 1;
        assertTrue(c);

        boolean b_1 = team.addCollaboratorToTeam(getResponsibleCollaborator());
        assertTrue(b_1);

        boolean d = team.getTeamCollaborators().size() == 2;
        assertTrue(d);
    }

    @Test
    public void removeCollaboratorToTeam() throws ParseException {
        Team team = getTeam();
        team.addCollaboratorToTeam(getCollaborator1());

        boolean a = team.getTeamCollaborators().size() == 1;
        assertTrue(a);

        team.addCollaboratorToTeam(getResponsibleCollaborator());

        boolean b = team.getTeamCollaborators().size() == 2;
        assertTrue(b);

        boolean c_1 = team.removeCollaboratorFromTeam(getResponsibleCollaborator());
        assertTrue(c_1);

        boolean c = team.getTeamCollaborators().size() == 1;
        assertTrue(c);

        boolean d_1 = team.removeCollaboratorFromTeam(getCollaborator1());
        assertTrue(d_1);

        boolean d = team.getTeamCollaborators().isEmpty();
        assertTrue(d);
    }

    @Test
    public void testEquals() throws ParseException {
        Team team1 = getTeam();
        Team team2 = getTeam();

        assertEquals(team1.toString(), team2.toString());

        Team team3 = new Team(CodeTeam.valueOf("2"), "Team 1", Acronym.valueOf("t1"), getTeamType(), getResponsibleCollaborator(), new HashSet<>());
        assertNotEquals("Code is different", team1.toString(), team3.toString());

        Team team4 = new Team(CodeTeam.valueOf("1"), "Team 2", Acronym.valueOf("t1"), getTeamType(), getResponsibleCollaborator(), new HashSet<>());
        assertNotEquals("Designation is different", team1.toString(), team4.toString());

        Team team5 = new Team(CodeTeam.valueOf("1"), "Team 1", Acronym.valueOf("t2"), getTeamType(), getResponsibleCollaborator(), new HashSet<>());
        assertNotEquals("Acronym is different", team1.toString(), team5.toString());

        team1.addCollaboratorToTeam(getCollaborator1());
        assertNotEquals("Set of collaborators size is different", team1.getTeamCollaborators().size(), team2.getTeamCollaborators().size());
    }


}