package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.clientusermanagement.domain.MecanographicNumber;

import java.util.*;

public class RemoveCollaboratorFromTeamUI {

    TeamController teamController;
    TeamTypeController teamTypeController;
    CollaboratorController collaboratorController;
    Scanner in = new Scanner(System.in);

    public boolean removeCollaboratorFromTeam() {
        teamTypeController = new TeamTypeController();
        collaboratorController = new CollaboratorController();
        teamController = new TeamController();
        System.out.println("=======================================");
        System.out.println(" Remove Collaborator From Team Option: ");
        System.out.println("=====================================\n");
        try {
            System.out.println("================================\n");
            System.out.println("Registered Teams With Collaborators");

            List<Team> teamsWithCollaborators = getTeamsWithCollaborators();
            for (int i = 0; i < teamsWithCollaborators.size(); i++) {
                System.out.println("Team code: " + teamsWithCollaborators.get(i).getCode() + "\nTeam Designation: " + teamsWithCollaborators.get(i).getDesignation() + "\n\n");
            }

            System.out.println("================================\n");
            System.out.println("Insert the code of the team that you wish to remove a collaborator...");
            String teamCode1 = in.nextLine();
            CodeTeam code = CodeTeam.valueOf(teamCode1);
            System.out.println("================================\n");
            if (teamController.getTeamByCode(code).getTeamCollaborators().isEmpty()) {
                System.out.println("This team has no collaborators to remove!!");
            } else {
                System.out.println("Collaborators that Belongs to team with code :" + teamCode1);
                List<Collaborator> collaboratorFromChosedTeam = getCollaboratorsFromTeam(code);
                Collections.sort(collaboratorFromChosedTeam, (o1, o2) -> o1.getNumMechanographic().compareTo(o2.getNumMechanographic()));
                for (int i = 0; i < collaboratorFromChosedTeam.size(); i++) {
                    System.out.println("Collaborator Mechanographic Number: " + collaboratorFromChosedTeam.get(i).getNumMechanographic() + "\nCollaborator Name: " + collaboratorFromChosedTeam.get(i).getFirstName() + " " + collaboratorFromChosedTeam.get(i).getLastName() + "\n\n");
                }

                System.out.println("===============================================");
                System.out.println("Insert the Mechanographic Number of the collaborator that you wish to remove from the team...");

                removeFromTeam(code, collaboratorFromChosedTeam);

            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
        return true;
    }

    private boolean removeFromTeam(CodeTeam codeTeam, List<Collaborator> collaboratorList) {
        try {
            String mechaNumber = "";
            while (!mechaNumber.equals("0")) {
                if (!collaboratorList.isEmpty()) {
                    mechaNumber = in.nextLine();
                    if (collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)) == null) {
                        System.out.println("That Collaborator doesn't exist");
                    } else if (!collaboratorList.contains(collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)))) {
                        System.out.println("This Collaborator has been removed already to this Team!!");
                    } else {
                        collaboratorList.remove(collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)));
                        teamController.removeCollaboratorFromTeam(teamController.getTeamByCode(codeTeam), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)));
                        System.out.println("Collaborator With Mechanographic Number: " + collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)).getNumMechanographic() + " was added with success!!" + "\n");
                        if (collaboratorList.isEmpty()) {
                            System.out.println("All Registered Collaborators Were removed from this Team!!");
                        } else
                            System.out.println("Insert Another Collaborator or Type 0 if You Done Adding");
                    }
                } else {
                    mechaNumber = "0";
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
        return true;
    }

    public List<Team> getTeamsWithCollaborators() {
        List<Team> teamList = teamController.getAllTeams();
        List<Team> teamsWithCollaborators = new ArrayList<>();
        for (Team team : teamList) {
            if (!team.getTeamCollaborators().isEmpty()) {
                teamsWithCollaborators.add(team);
            }
        }
        return teamsWithCollaborators;
    }

    public List<Collaborator> getCollaboratorsFromTeam(CodeTeam code) {
        Team chosedTeam = teamController.getTeamByCode(code);
        Set<Collaborator> collaboratorSet = chosedTeam.getTeamCollaborators();
        List<Collaborator> collaboratorsFromTeam = new ArrayList<>();
        for (Collaborator collaborator : collaboratorSet) {
            collaboratorsFromTeam.add(collaborator);

        }
        return collaboratorsFromTeam;

    }
}
