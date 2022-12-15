package eapli.base.app.user.console.ui;


import eapli.framework.io.util.Console;

public class RRHUI {

    public static void showMenu() {
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    ManageCollaboratorsUI.showMenu();
                    break;
                case 2:
                    ManageTeamsUI.showMenu();
                    break;
                case 3:
                    ViewAuthorizedCataloguesUI viewAuthorizedCataloguesUI = new ViewAuthorizedCataloguesUI();
                    viewAuthorizedCataloguesUI.showMenu();
                    break;
                case 4:
                    ManageTasksUI.showMenu();
                    break;
                case 5:
                    ManageRequestsUI.showMenu();
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
        System.out.println(" RRH Menu: ");
        System.out.println("=============================\n");
        System.out.println("1.Manage Collaborators");
        System.out.println("2.Manage Teams");
        System.out.println("3.View Authorized Catalogues");
        System.out.println("4.Manage Tasks");
        System.out.println("5.Manage Requests");
        System.out.println("=============================");
        System.out.println("0. Log Out\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }
}
