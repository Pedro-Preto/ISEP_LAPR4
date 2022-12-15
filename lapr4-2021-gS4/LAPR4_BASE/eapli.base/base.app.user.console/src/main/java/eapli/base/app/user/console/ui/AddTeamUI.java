package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.TeamType.application.TeamTypeController;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.clientusermanagement.domain.MecanographicNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AddTeamUI {
    TeamController teamController;
    TeamTypeController teamTypeController;
    CollaboratorController collaboratorController;

    public boolean addTeam() {
        Scanner in = new Scanner(System.in);
        teamTypeController = new TeamTypeController();
        collaboratorController = new CollaboratorController();
        teamController = new TeamController();

        try {
            System.out.println("===================");
            System.out.println(" Add Team Option: ");
            System.out.println("===================\n");
            List<Team> teamList = teamController.getAllTeams();
            System.out.println("================================\n");
            System.out.println("Registered Teams");
            if (!teamList.isEmpty()) {
                for (int i = 0; i < teamList.size(); i++) {
                    System.out.println("Team code: " + teamList.get(i).getCode() + "\nTeam Designation: " + teamList.get(i).getDesignation() + "\n\n");
                }
            } else {
                System.out.println("(There are no Registered Teams at the moment)");
            }
            System.out.println("================================\n");
            System.out.println("Insert a Team Code...");
            String cod = in.nextLine();
            CodeTeam code = CodeTeam.valueOf(cod);

            System.out.println("================================\n");
            System.out.println("Insert a Team Designation...");
            String designation = in.nextLine();

            System.out.println("================================\n");
            System.out.println("Insert a Team Acronym...");
            String acronym = in.nextLine();
            Acronym acro = Acronym.valueOf(acronym);

            System.out.println("================================\n");
            List<TeamType> teamTypeList = teamTypeController.getAllTeamTypes();
            System.out.println("Registered Team Types");
            for (int i = 0; i < teamTypeList.size(); i++) {
                System.out.println("Team Type code: " + teamTypeList.get(i).getCode() + "\nTeam Designation: " + teamTypeList.get(i).getDesignation() + "\nColor: " + teamTypeList.get(i).getColor().getDesignation().toString() + "\n\n");
            }
            System.out.println("================================\n");

            System.out.println("Insert a TeamType Code in order to add it to the team...");
            String code1 = in.nextLine();
            CodeTeamType typeCode = CodeTeamType.valueOf(code1);
            TeamType tt = teamTypeController.getTeamTypeByCode(typeCode);


            List<Collaborator> collaboratorList = collaboratorController.getAllCollaborators();
            if (!collaboratorList.isEmpty()) {
                System.out.println("=================================\n");
                System.out.println("Registered Collaborators");
                for (int i = 0; i < collaboratorList.size(); i++) {
                    System.out.println("Collaborator Mechanographic Number: " + collaboratorList.get(i).getNumMechanographic() + "\nCollaborator Name: " + collaboratorList.get(i).getFirstName() + " " + collaboratorList.get(i).getLastName() + "\n\n");
                }
            }
            System.out.println("================================\n");

            System.out.println("Insert a Collaborator Mechanographic number in order to make him Responsible for the team...");

            String mecha = in.nextLine();
            MecanographicNumber mecanographicNumber = MecanographicNumber.valueOf(mecha);
            Collaborator collaborator = collaboratorController.getCollaboratorByMecaNumber(mecanographicNumber);
            teamController.registerTeam(code, designation, acro, tt, collaborator, new HashSet<>());
            Team c1 = teamController.getTeamByCode(code);
            System.out.println("Team With code: " + c1.getCode() + " And Team Type: " + c1.getTeamType().getDesignation() + " And With Responsible Collaborator :" + c1.getResponsibleCollaborator().getFirstName() + " " + c1.getResponsibleCollaborator().getLastName() + " Was Registered" + "\n");
            return true;
        } catch (Exception e) {
            System.out.println("Something Went Wrong Registering The Team Went Wrong");
            return false;
        }
    }
}
