package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class TeamBootstrapper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

    private final TeamController teamController = new TeamController();
    private final TeamTypeController teamTypeController = new TeamTypeController();
    private final CollaboratorController collaboratorController = new CollaboratorController();

    @Override
    public boolean execute() {

        /* ------------------------------------------------- TEAM 1 ------------------------------------------------- */
        CodeTeam code1 = new CodeTeam("1001");
        String designation1 = "Team 1001";
        Acronym acronym1 = new Acronym("T1010");
        TeamType teamType1 = teamTypeController.getTeamTypeByCode(new CodeTeamType("1"));
        Collaborator responsible1 = collaboratorController.getCollaboratorByEmail("colabA@bootstrapper.com");
        Set<Collaborator> teamCollaborators1 = new HashSet<>();
        teamCollaborators1.add(collaboratorController.getCollaboratorByEmail("colab2@bootstrapper.com"));
        teamCollaborators1.add(collaboratorController.getCollaboratorByEmail("colab3@bootstrapper.com"));

        addTeam(code1, designation1, acronym1, teamType1, responsible1,teamCollaborators1);


        /* ------------------------------------------------- TEAM 2 ------------------------------------------------- */
        CodeTeam code2 = new CodeTeam("1002");
        String designation2 = "Team 1002";
        Acronym acronym2 = new Acronym("T1002");
        TeamType teamType2 = teamTypeController.getTeamTypeByCode(new CodeTeamType("2"));
        Collaborator responsible2 = collaboratorController.getCollaboratorByEmail("colabB@bootstrapper.com");
        Set<Collaborator> teamCollaborators2 = new HashSet<>();
        teamCollaborators2.add(collaboratorController.getCollaboratorByEmail("colab1@bootstrapper.com"));
        teamCollaborators2.add(collaboratorController.getCollaboratorByEmail("colab3@bootstrapper.com"));

        addTeam(code2, designation2, acronym2, teamType2, responsible2, teamCollaborators2);


        /* ------------------------------------------------- TEAM 3 ------------------------------------------------- */
        CodeTeam code3 = new CodeTeam("1003");
        String designation3 = "Team 1003";
        Acronym acronym3 = new Acronym("T1003");
        TeamType teamType3 = teamTypeController.getTeamTypeByCode(new CodeTeamType("3"));
        Collaborator responsible3 = collaboratorController.getCollaboratorByEmail("colabC@bootstrapper.com");
        Set<Collaborator> teamCollaborators3 = new HashSet<>();
        teamCollaborators3.add(collaboratorController.getCollaboratorByEmail("colab2@bootstrapper.com"));
        teamCollaborators3.add(collaboratorController.getCollaboratorByEmail("colab1@bootstrapper.com"));

        addTeam(code3, designation3, acronym3, teamType3, responsible3, teamCollaborators3);


        /* ------------------------------------------------- TEAM 4 ------------------------------------------------- */
        CodeTeam code4 = new CodeTeam("1004");
        String designation4 = "Team 1004";
        Acronym acronym4 = new Acronym("T1004");
        TeamType teamType4 = teamTypeController.getTeamTypeByCode(new CodeTeamType("4"));
        Collaborator responsible4 = collaboratorController.getCollaboratorByEmail("colabD@bootstrapper.com");
        Set<Collaborator> teamCollaborators4 = new HashSet<>();
        teamCollaborators4.add(collaboratorController.getCollaboratorByEmail("colab3@bootstrapper.com"));
        teamCollaborators4.add(collaboratorController.getCollaboratorByEmail("colab5@bootstrapper.com"));

        addTeam(code4, designation4, acronym4, teamType4, responsible4, teamCollaborators4);


        /* ------------------------------------------------- TEAM 5 ------------------------------------------------- */
        CodeTeam code5 = new CodeTeam("1005");
        String designation5 = "Team 1005";
        Acronym acronym5 = new Acronym("T1005");
        TeamType teamType5 = teamTypeController.getTeamTypeByCode(new CodeTeamType("5"));
        Collaborator responsible5 = collaboratorController.getCollaboratorByEmail("colabE@bootstrapper.com");
        Set<Collaborator> teamCollaborators5 = new HashSet<>();
        teamCollaborators5.add(collaboratorController.getCollaboratorByEmail("colab4@bootstrapper.com"));
        teamCollaborators5.add(collaboratorController.getCollaboratorByEmail("colab3@bootstrapper.com"));

        addTeam(code5, designation5, acronym5, teamType5, responsible5, teamCollaborators5);


        /* ------------------------------------------------- TEAM 6 ------------------------------------------------- */
        CodeTeam code6 = new CodeTeam("1006");
        String designation6 = "Team 1006";
        Acronym acronym6 = new Acronym("T1006");
        TeamType teamType6 = teamTypeController.getTeamTypeByCode(new CodeTeamType("6"));
        Collaborator responsible6 = collaboratorController.getCollaboratorByEmail("colabF@bootstrapper.com");
        Set<Collaborator> teamCollaborators6 = new HashSet<>();
        teamCollaborators6.add(collaboratorController.getCollaboratorByEmail("colab4@bootstrapper.com"));
        teamCollaborators6.add(collaboratorController.getCollaboratorByEmail("colab5@bootstrapper.com"));

        addTeam(code6, designation6, acronym6, teamType6, responsible6, teamCollaborators6);

        System.out.println("========================");
        System.out.println("Bootstrapping Teams...");
        System.out.println("========================");
        return true;
    }

    private boolean addTeam(CodeTeam code, String designation, Acronym acronym, TeamType teamType, Collaborator responsible, Set<Collaborator> teamCollaborators) {
        try {
            teamController.registerTeam(code, designation, acronym,teamType,responsible, teamCollaborators);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}



