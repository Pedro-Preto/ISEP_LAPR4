package eapli.base.app.user.console.ui;

import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Team.application.TeamController;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;

import java.util.List;
import java.util.Scanner;

public class AddTeamTypeUI {
    TeamTypeController teamTypeController;
    ColorController colorController;
    TeamController teamController;

    public boolean addTeamType() {
        Scanner in = new Scanner(System.in);
        teamTypeController = new TeamTypeController();
        colorController = new ColorController();
        teamController = new TeamController();

        try {
            System.out.println("======================");
            System.out.println(" Add Team Type Option: ");
            System.out.println("======================\n");

            List<TeamType> teamTypeList = teamTypeController.getAllTeamTypes();
            System.out.println("================================\n");
            System.out.println("Registered Team Types");
            if (!teamTypeList.isEmpty()) {
                for (int i = 0; i < teamTypeList.size(); i++) {
                    System.out.println("Team Type code: " + teamTypeList.get(i).getCode() + "\nTeam Type Designation: " + teamTypeList.get(i).getDesignation() + "\nColor: " + teamTypeList.get(i).getColor().designation().toString() + "\n\n");
                }
            } else {
                System.out.println("(There are no Team Type Registered at the moment)");
            }
            System.out.println("================================\n");
            System.out.println("Insert a team type Code...");
            String teamTypeCode = in.nextLine();

            System.out.println("================================\n");
            System.out.println("Insert a team type designation...");
            String teamName = in.nextLine();

            List<Color> availableColors = colorController.getAllColors();
            List<TeamType> teamTypesRegistered = teamTypeController.getAllTeamTypes();
            for (TeamType teamType : teamTypesRegistered) {
                if (availableColors.contains(teamType.getColor())) {
                    availableColors.remove(teamType.getColor());
                }
            }
            System.out.println("================================\n");
            System.out.println("Available Colors");
            for (Color c : availableColors) {
                System.out.println("Name: " + c.getDesignation());
            }
            System.out.println("================================\n");
            System.out.println("Insert a Color name...");
            String colorName = in.nextLine();
            ColorDesignation colorDesignation = new ColorDesignation(colorName);
            Color color = colorController.getCollorByDesignation(colorDesignation);


            teamTypeController.registerTeamType(CodeTeamType.valueOf(teamTypeCode), teamName, color);


            TeamType c1 = teamTypeController.getTeamTypeByCode(CodeTeamType.valueOf(teamTypeCode));
            System.out.println("Team Type With Code: " + c1.getCode() + "Was Registered" + "\n");
            return true;
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Registering the Team Type");
            return false;
        }
    }

}
