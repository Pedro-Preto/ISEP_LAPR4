package eapli.base.app.user.console.ui;


import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.framework.io.util.Console;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public class ManageTeamsUI {

    private static AddTeamTypeUI addTeamTypeUI = new AddTeamTypeUI();
    private static AddTeamUI addTeamUI = new AddTeamUI();
    private static RemoveCollaboratorFromTeamUI removeCollaboratorFromTeam = new RemoveCollaboratorFromTeamUI();
    private static AddCollaboratorToTeamUI addCollaboratorToTeamUI = new AddCollaboratorToTeamUI();

    public static void showMenu() {
        TeamTypeController teamTypeController = new TeamTypeController();
        TeamController teamController = new TeamController();
        CollaboratorController collaboratorController = new CollaboratorController();
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    addTeamTypeUI.addTeamType();
                    break;
                case 2:
                    if (teamTypeController.getAllTeamTypes().isEmpty()) {
                        System.out.println("There are no Registered Team Types!!");
                    } else {
                        addTeamUI.addTeam();
                    }
                    break;
                case 3:
                    if (teamController.getAllTeams().isEmpty()) {
                        System.out.println("There are no Registered Teams!!");
                    } else if (collaboratorController.getAllCollaborators().isEmpty()) {
                        System.out.println("There are no Registered Collaborators!!");
                    } else {
                        addCollaboratorToTeamUI.addCollaboratorFromTeam();

                    }
                    break;
                case 4:
                    if (teamController.getAllTeams().isEmpty()) {
                        System.out.println("You don't have Registered Teams!!");
                    } else if(getVerifyIfTeamSetOfColabsAreEmpty()==true){
                        removeCollaboratorFromTeam.removeCollaboratorFromTeam();
                    }else {
                        System.out.println("The Registered Teams have no Associated Collaborators!!");
                    }
                    break;
                default:
                    System.out.println("Option does not exist!\n\n");
                    break;
            }
        } while (option != 0);
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Manage Teams Menu: ");
        System.out.println("=============================\n");
        System.out.println("1.Add Team Type");
        System.out.println("2.Create team");
        System.out.println("3.Add collaborator to team");
        System.out.println("4.Remove collaborator from team");
        System.out.println("=============================");
        System.out.println("0.Back\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }
    public static boolean getVerifyIfTeamSetOfColabsAreEmpty(){
      boolean a =false;
        TeamController teamController = new TeamController();
        List<Team>teamList=teamController.getAllTeams();
        for (Team t:teamList){
            if(!t.getTeamCollaborators().isEmpty()){
                a=true;
            }

        }
        return a;
    }


}

