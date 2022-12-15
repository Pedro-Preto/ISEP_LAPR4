package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Team;
import eapli.base.Utils.CatalogueComparator;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;


import java.util.List;
import java.util.Scanner;

public class ViewAuthorizedCataloguesUI {

    private static ServicesOfCatalogueUI servicesOfCatalogueUI = new ServicesOfCatalogueUI();
    private static CatalogueComparator catalogueComparator = new CatalogueComparator();
    private static CollaboratorController collaboratorController = new CollaboratorController();
    private static TeamController teamController = new TeamController();
    private static CatalogueController catalogueController = new CatalogueController();

    public void showMenu() {
        int option;
        option = showOptions();
        switch (option) {
            case 0:
                System.out.println("Exiting ...");
                break;
            case 1:
                List<Catalogue> cataloguesSortedByTitle = catalogueComparator.sortByTitle(viewCatalogues());
                if (cataloguesSortedByTitle.isEmpty()) {
                    System.out.println("This user has no associated Catalogues");
                } else {
                    showSortedCatalogues(cataloguesSortedByTitle);
                }
                break;
            case 2:
                List<Catalogue> cataloguesSortedByResponsible = catalogueComparator.sortByResponsible(viewCatalogues());
                if (cataloguesSortedByResponsible.isEmpty()) {
                    System.out.println("This user has no associated Catalogues");
                } else {
                    showSortedCatalogues(cataloguesSortedByResponsible);
                }
                break;
            default:
                System.out.println("Option does not exist!");
                break;
        }
    }

    private static void showSortedCatalogues(List<Catalogue> catalogues){
        int option;
        int counter = 0;
        for (Catalogue cat : catalogues) {
            counter ++;
            System.out.println("\n"+counter+": Catalogue Title: " + cat.getTitle()
                    + "\n   Catalogue Description: " + cat.getBriefDescription()
                    + "\n   Catalogue Responsible: " + cat.getResponsible().getFirstName()
                    + " " + cat.getResponsible().getLastName() + "\n");
        }
        System.out.println("-----------------");
        try {
            option = Console.readInteger("Please select a catalogue (insert the number): ");
        }catch(Exception e){
            System.out.println("Invalid Option!");
            return;
        }
        if(option > catalogues.size() || option < 1) {
            System.out.println("Invalid Option!");
            return;
        }
        String catTitle = catalogues.get(option -1).getTitle().toString();
        Catalogue catalogue = catalogueController.findCatalogueByTitle(catTitle).orElse(null);
        if(catalogue == null){
            System.out.println("Catalogue not found!");
        } else {
            servicesOfCatalogueUI.showMenu(catalogue);
        }
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("===================================================================");
        System.out.println("                       Sort Catalogues:                            ");
        System.out.println("===================================================================\n");
        System.out.println("1.Sort Catalogues by Title (Ascending Order) ...");
        System.out.println("2.Sort Catalogues by Responsible Collaborator (Ascending Order) ...");
        System.out.println("===================================================================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }


    private static List<Catalogue> viewCatalogues() {
        final AuthorizationService authz = AuthzRegistry.authorizationService();
        Collaborator c = collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString());
        Team team = teamController.getTeamByCollaborator(c);
        List<Catalogue> catalogueList = (List<Catalogue>) catalogueController.getCataloguesByTeam(team);
        System.out.println("View Catalogues");
        System.out.println("-----------------");

        return catalogueList;
    }
}
