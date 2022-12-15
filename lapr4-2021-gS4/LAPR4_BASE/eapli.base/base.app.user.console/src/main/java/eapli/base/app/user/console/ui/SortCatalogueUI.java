package eapli.base.app.user.console.ui;

import eapli.base.Utils.CatalogueComparator;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.framework.io.util.Console;

import java.net.CacheResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortCatalogueUI {
    private static CatalogueComparator catalogueComparator = new CatalogueComparator();
    private static CatalogueController catalogueController = new CatalogueController();

    public static void showMenu() {
        Scanner in = new Scanner(System.in);
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    sortByTitle();
                    break;
                case 2:
                    sortByResponsable();
                    break;

                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (option != 0);
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("===================================================");
        System.out.println("               Search Catalogue Menu:          ");
        System.out.println("=================================================\n");
        System.out.println("1-Sort Catalogues by Title (Ascending Order) ...");
        System.out.println("2-Sort Catalogues by Responsible Collaborator (Ascending Order) ...");
        System.out.println("===================================================");
        System.out.println("0. Back\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }

    private static List<Catalogue> sortByTitle() {
        System.out.println("===================================================");
        System.out.println("               Registered Catalogues :             ");
        System.out.println("=================================================\n");
        List<Catalogue> catalogueList = (List<Catalogue>) catalogueController.getAllCatalogues();
        catalogueComparator.sortByTitle(catalogueList);
        printCatalogueInfo(catalogueList);

        return catalogueList;
    }

    private static List<Catalogue> sortByResponsable() {
        System.out.println("===================================================");
        System.out.println("               Registered Catalogues :             ");
        System.out.println("=================================================\n");
        List<Catalogue> catalogueList = (List<Catalogue>) catalogueController.getAllCatalogues();
        catalogueComparator.sortByResponsible(catalogueList);
        printCatalogueInfo(catalogueList);

        return catalogueList;
    }

    public static void printCatalogueInfo(List<Catalogue> catalogueList) {

        for (Catalogue c : catalogueList) {
            System.out.println("Title- " + c.getTitle() + "\nDescription- " + c.getDescription() + " ("+c.getBriefDescription() + ") " + "\nIcon- " + c.getIcon()
                    + "\nResponsible: " + c.getResponsible().getFirstName() + " " + c.getResponsible().getLastName() + "\nCriticality Id: " + c.getCriticality().getId() + "\nAllowed Teams:  " + c.getAllowedTeamList() + "\n\n");
        }
    }

}
