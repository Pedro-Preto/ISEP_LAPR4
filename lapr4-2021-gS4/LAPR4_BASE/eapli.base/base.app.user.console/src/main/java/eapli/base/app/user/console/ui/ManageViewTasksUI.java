package eapli.base.app.user.console.ui;

import eapli.framework.io.util.Console;

public class ManageViewTasksUI {

    public static void showMenu() {
        int option;
        option = showOptions();
        switch (option) {
            case 0:
                System.out.println("Exiting ...");
                break;
            case 1:
                ViewPendingTasksUI.showMenu1();
                break;
            case 2:
                ViewPendingTasksUI.showMenu2();
                break;
            default:
                System.out.println("Option does not exist!");
                break;
        }
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("===================================================================");
        System.out.println("                       Sort Tasks:                                 ");
        System.out.println("===================================================================\n");
        System.out.println("1.Sort Tasks By Inserting A Limit Date ...");
        System.out.println("2.Sort Tasks Between A Period Of Time ...");
        System.out.println("===================================================================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }
}
