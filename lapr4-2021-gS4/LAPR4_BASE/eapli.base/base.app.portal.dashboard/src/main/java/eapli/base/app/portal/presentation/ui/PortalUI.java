package eapli.base.app.portal.presentation.ui;

import eapli.base.app.portal.dashboard.LogInConsumer;
import eapli.base.app.user.console.ui.ManageRequestsUI;
import eapli.base.app.user.console.ui.ManageTasksUI;
import eapli.base.app.user.console.ui.ViewAuthorizedCataloguesUI;
import eapli.framework.io.util.Console;

public class PortalUI {

    public static void showMenu() {
        try {
            LogInConsumer.doLogin();
        } catch (Exception e) {
            System.out.println("Couldn't log into the Dashboard!");
        }

        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;

                case 1:
                    ViewAuthorizedCataloguesUI viewAuthorizedCataloguesUI = new ViewAuthorizedCataloguesUI();
                    viewAuthorizedCataloguesUI.showMenu();
                    break;
                case 2:
                    ManageTasksUI.showMenu();
                    break;
                case 3:
                    ManageRequestsUI.showMenu();
                    break;
                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (option != 0);
        try {
            LogInConsumer.doLogout();
        } catch (Exception e) {
            System.out.println("Couldn't log out of the Dashboard!");
        }
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println("        User Menu:           ");
        System.out.println("=============================");
        System.out.println("1.View Authorized Catalogues");
        System.out.println("2.Manage Tasks");
        System.out.println("3.Manage Requests");
        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }


}
