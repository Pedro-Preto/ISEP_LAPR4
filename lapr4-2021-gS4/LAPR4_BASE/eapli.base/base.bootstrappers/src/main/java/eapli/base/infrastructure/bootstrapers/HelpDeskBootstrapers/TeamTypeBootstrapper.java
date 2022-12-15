package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
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

public class TeamTypeBootstrapper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

    private final TeamTypeController teamTypeController = new TeamTypeController();
    private final ColorController colorController = new ColorController();

    @Override
    public boolean execute() {

        /* ----------------------------------------------- TEAM TYPE 1 ---------------------------------------------- */
        CodeTeamType code1 = new CodeTeamType("1");
        String designation1 = "TeamType 1";
        Color color1 = colorController.getCollorByDesignation(new ColorDesignation("pink"));

        addTeamType(code1, designation1, color1);

        /* ----------------------------------------------- TEAM TYPE 2 ---------------------------------------------- */
        CodeTeamType code2 = new CodeTeamType("2");
        String designation2 = "TeamType 2";
        Color color2 = colorController.getCollorByDesignation(new ColorDesignation("blue"));

        addTeamType(code2, designation2, color2);

        /* ----------------------------------------------- TEAM TYPE 3 ---------------------------------------------- */
        CodeTeamType code3 = new CodeTeamType("3");
        String designation3 = "TeamType 3";
        Color color3 = colorController.getCollorByDesignation(new ColorDesignation("gold"));

        addTeamType(code3, designation3, color3);


        /* ----------------------------------------------- TEAM TYPE 4 ---------------------------------------------- */
        CodeTeamType code4 = new CodeTeamType("4");
        String designation4 = "TeamType 4";
        Color color4 = colorController.getCollorByDesignation(new ColorDesignation("silver"));

        addTeamType(code4, designation4, color4);


        /* ----------------------------------------------- TEAM TYPE 5 ---------------------------------------------- */
        CodeTeamType code5 = new CodeTeamType("5");
        String designation5 = "TeamType 5";
        Color color5 = colorController.getCollorByDesignation(new ColorDesignation("green"));

        addTeamType(code5, designation5, color5);


        /* ----------------------------------------------- TEAM TYPE 6 ---------------------------------------------- */
        CodeTeamType code6 = new CodeTeamType("6");
        String designation6 = "TeamType 6";
        Color color6 = colorController.getCollorByDesignation(new ColorDesignation("red"));

        addTeamType(code6, designation6, color6);

        System.out.println("===========================");
        System.out.println("Bootstrapping Team Types...");
        System.out.println("===========================");
        return true;
    }

    private boolean addTeamType(CodeTeamType code, String designation, Color color) {
        try {
            teamTypeController.registerTeamType(code, designation, color);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
