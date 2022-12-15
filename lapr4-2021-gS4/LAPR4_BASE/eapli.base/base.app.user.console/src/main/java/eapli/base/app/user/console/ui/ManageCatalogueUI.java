package eapli.base.app.user.console.ui;

import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.framework.io.util.Console;

import java.util.LinkedList;
import java.util.List;

public class ManageCatalogueUI {

    public void manageCatalogue() {

        CatalogueController catalogueController = new CatalogueController();
        TeamController teamController = new TeamController();

        if (((List<Catalogue>) catalogueController.getAllCatalogues()).size() == 0) {
            System.out.println("There are no Catalogues in the System!");
            return;
        }
        if (teamController.getAllTeams().size() == 0) {
            System.out.println("There are no Teams in the System!");
            return;
        }
        int option = showMenu();
        switch (option) {
            case 0:
                System.out.println("Exiting ...");
                break;
            case 1:
                addTeamsToCatalogue();
                break;
            case 2:
                removeTeamsFromCatalogue();
                break;
            default:
                System.out.println("Option does not exist ...");
                break;
        }

    }

    public int showMenu() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println("Manage Catalogues: ");
        System.out.println("=============================");

        System.out.println("1.Add Teams to Catalogue");
        System.out.println("2.Remove Teams from Catalogue");

        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;

    }

    public void addTeamsToCatalogue() {
        CatalogueController catalogueController = new CatalogueController();
        TeamController teamController = new TeamController();

        String catalogueTitle = showCatalogues();
        if(catalogueTitle == null){
            return;
        }

        if (!catalogueTitle.isEmpty()) {
            Catalogue catalogue = catalogueController.findCatalogueByTitle(catalogueTitle).orElse(null);
            if (catalogue == null) {
                System.out.println("Could not find a Catalogue with that title!");
                return;
            }

            List<Team> teams = catalogueController.getTeamsNotInCatalogue(catalogue);
            List<Team> allTeamsAllreadyInCatalogue = catalogueController.getTeamsNotInCatalogue(catalogue);

            if (teams.size() == 0) {
                System.out.println("All the registered Teams have already been added to this Catalogue!");
                return;
            }

            showTeams(teams);

            String option="" ;
            List<Team> teamList = new LinkedList<>();
            while (!option.equals("0")) {
                if (!allTeamsAllreadyInCatalogue.isEmpty()) {
                    option = Console.readLine("\nInsert a Team code in order to add it to the Catalogue (When you done type 0):");
                    Team t = teamController.getTeamByCode(CodeTeam.valueOf(option));
                    if(option.equals("0")){
                        break;
                    }
                    if (t != null && !teamList.contains(t)) {
                        teamList.add(t);
                        allTeamsAllreadyInCatalogue.remove(t);
                        System.out.println("Team " + t.getDesignation() + " has been added to Catalogue " + catalogue.getTitle());
                    } else {
                        System.out.println("Invalid team code");
                    }
                } else {
                    option = "0";
                }
            }
            catalogueController.addTeamsToCatalogue(catalogue, teamList);

        }
    }

    public void removeTeamsFromCatalogue() {
        CatalogueController catalogueController = new CatalogueController();
        TeamController teamController = new TeamController();

        String catalogueTitle = showCatalogues();
        if(catalogueTitle == null){
            return;
        }

        if (!catalogueTitle.isEmpty()) {
            Catalogue catalogue = catalogueController.findCatalogueByTitle(catalogueTitle).orElse(null);
            if (catalogue == null) {
                System.out.println("Could not find a Catalogue with that title!");
                return;
            }

            List<Team> teams = new LinkedList<>(catalogueController.getTeamsByCatalogue(catalogue));
            if (teams.size() == 0) {
                System.out.println("This Catalogue already does not have any Team!");
                return;
            }

            showTeams(teams);

            String option = Console.readLine("Please insert the Code of the Team to Remove:");
            List<Team> teamsToRemove = new LinkedList<>();
            while (!option.equals("0")) {
                Team t = teamController.getTeamByCode(CodeTeam.valueOf(option));
                if(option.equals("0")){
                    break;
                }
                if (t != null && !teamsToRemove.contains(t)) {
                    teamsToRemove.add(t);
                    System.out.println("Team " + t.getDesignation() + " has been removed from Catalogue " + catalogue.getTitle());
                } else {
                    System.out.println("Invalid team code");
                }
                option = Console.readLine("\nInsert another Team code if you wish to remove more Teams, otherwise, type \"0\":");
            }
            catalogueController.removeTeamsFromCatalogue(catalogue, teamsToRemove);
        }
    }

    private void showTeams(List<Team> teams) {
        System.out.println("\n=============================");
        System.out.println("Available Teams:");
        System.out.println("=============================");

        for (Team t : teams) {
            System.out.println("\nTeam Designation: " + t.getDesignation() +
                    " (Team Code: " + t.getCode() + ")\nTeam Responsible: "
                    + t.getResponsibleCollaborator().getFirstName() + " " + t.getResponsibleCollaborator().getLastName()
                    + " (" + t.getResponsibleCollaborator().getNumMechanographic()
                    + ")\nTeam Type: " + t.getTeamType().getDesignation() + "\n");
        }
    }


    private String showCatalogues() {
        String catalogueTitle = "";
        CatalogueController catalogueController = new CatalogueController();
        List<Catalogue> catalogueList = (List<Catalogue>) catalogueController.getAllCatalogues();
        System.out.println("=============================");
        System.out.println("Available Catalogues:");
        System.out.println("=============================");
        int counter = 0;
        int option = 0;
        for (Catalogue c : catalogueList) {
            counter++;
            System.out.println("\n" +counter +"- Catalogue Title: " + c.getTitle() + "\n   Catalogue Description: " + c.getBriefDescription());
            if (!c.getAllowedTeamList().isEmpty()) {
                System.out.println("   Teams in this Catalogue:");
                for (Team team : c.getAllowedTeamList()) {
                    System.out.println("       Team Name: " + team.getDesignation());
                }
            } else {
                System.out.println("   This Catalogue does not have Teams associated");
            }
            System.out.println();
        }

        do {
            try {
                option = Console.readInteger("Please select a Catalogue:");
            } catch (Exception e) {
                System.out.println("Invalid Option!");
                continue;
            }
            if (option > catalogueList.size() || option < 0) {
                System.out.println("Invalid Option!");
                continue;
            }
            if (option == 0){
                return null;
            }
            catalogueTitle = catalogueList.get(option - 1).getTitle().toString();
        } while(catalogueTitle.equals(""));

        return catalogueTitle;
    }
}
