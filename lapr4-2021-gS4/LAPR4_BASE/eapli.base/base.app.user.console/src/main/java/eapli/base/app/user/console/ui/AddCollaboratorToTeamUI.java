package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.clientusermanagement.domain.MecanographicNumber;

import java.util.*;

public class AddCollaboratorToTeamUI {
    TeamController teamController;
    TeamTypeController teamTypeController;
    CollaboratorController collaboratorController;
    Scanner in = new Scanner(System.in);

    public boolean addCollaboratorFromTeam() {
        teamTypeController = new TeamTypeController();
        collaboratorController = new CollaboratorController();
        teamController = new TeamController();
        System.out.println("================================");
        System.out.println(" Add Collaborator to Team Option: ");
        System.out.println("================================\n");
        try {
            List<Team> teamList = teamController.getAllTeams();
            System.out.println("================================\n");
            System.out.println("Registered Teams");
            for (int i = 0; i < teamList.size(); i++) {
                System.out.println("Team code: " + teamList.get(i).getCode() + "\nTeam Designation: " + teamList.get(i).getDesignation() + "\n\n");
            }

            System.out.println("================================\n");

            System.out.println("Insert the Code of the Team that you wish to add a Collaborator...");
            String teamCode = in.nextLine();
            CodeTeam code = CodeTeam.valueOf(teamCode);
            Set<Collaborator> collaboratorSet = getCollaboratorsFromTeam(code);
            if (teamController.getTeamByCode(code).getTeamCollaborators().size() == collaboratorController.getAllCollaborators().size()) {
                System.out.println("All registered Collaborators are inserted in this team");
            } else {
                List<Collaborator> collaboratorList = collaboratorNotInTeam(code);
                System.out.println("================================\n");
                System.out.println("Registered Collaborators");
                Collections.sort(collaboratorList, Comparator.comparing(Collaborator::getNumMechanographic));
                for (int i = 0; i < collaboratorList.size(); i++) {
                    System.out.println("Collaborator Mechanographic Number: " + collaboratorList.get(i).getNumMechanographic() + "\nCollaborator Name: " + collaboratorList.get(i).getFirstName() + " " + collaboratorList.get(i).getLastName() + "\n\n");
                }
                System.out.println("================================\n");

                System.out.println("\nInsert the Collaborator's Mechanographic Number, in order to add him to the Team (Type 0 when you done adding Collaborators)");

                addToTeam(code, collaboratorList, collaboratorSet);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
        return true;

    }


    private boolean addToTeam(CodeTeam code, List<Collaborator> collaboratorList, Set<Collaborator> collaboratorSet) {
        try {
            String mechaNumber = "";
            while (!mechaNumber.equals("0")) {
                if (!collaboratorList.isEmpty()) {
                    mechaNumber = in.nextLine();
                    if (collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)) == null) {
                        System.out.println("That Collaborator doesn't exist");
                    } else if (collaboratorSet.contains(collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)))) {
                        System.out.println("This Collaborator has been added already to this Team!!");
                    } else {
                        collaboratorSet.add(collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)));
                        teamController.addCollaboratorToTeam(teamController.getTeamByCode(code), collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)));
                        collaboratorList.remove(collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)));
                        System.out.println("Collaborator With Mechanographic Number: " + collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mechaNumber)).getNumMechanographic() + " was added with success!!" + "\n");
                        if (collaboratorList.isEmpty()) {
                            System.out.println("All Registered Collaborators Were added to this Team!!");
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

    public List<Collaborator> collaboratorNotInTeam(CodeTeam teamCode) {
        List<Collaborator> collaboratorList = collaboratorController.getAllCollaborators();
        Team team = teamController.getTeamByCode(teamCode);
        List<Collaborator> collaboratorsOnTeam = new ArrayList<>();
        Set<Collaborator> cola = team.getTeamCollaborators();
        for (Collaborator collaborator : cola) {
            collaboratorsOnTeam.add(collaborator);
        }
        collaboratorList.removeAll(collaboratorsOnTeam);
        return collaboratorList;
    }

    private Set<Collaborator> getCollaboratorsFromTeam(CodeTeam code) {
        Team chosedTeam = teamController.getTeamByCode(code);
        chosedTeam.getTeamCollaborators();
        return chosedTeam.getTeamCollaborators();

    }
}
