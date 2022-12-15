package eapli.base.app.user.console.ui;

import eapli.base.Request.application.RequestController;
import eapli.framework.io.util.Console;

public class ManageRequestsUI {


    public static void showMenu() {
        int option = 0;
        do {
            option = showOptions();
            RequestController requestController = new RequestController();
            requestController.terminateRequestsWithAllTasksCompleted();
            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    MyRequestsUI.showMenu();
                    break;
                case 2:
                    SetRequestSatisfactionGradeUI setRequestSatisfactionGradeUI = new SetRequestSatisfactionGradeUI();
                    setRequestSatisfactionGradeUI.shownMenu();
                    break;
                case 3:

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
        System.out.println("==========================================");
        System.out.println(" Manage Tasks Menu: ");
        System.out.println("========================================\n");
        System.out.println("1.Check Requests");
        System.out.println("2.Assign a Satisfaction Grade to a Request");
        System.out.println("==========================================");
        System.out.println("0.Back\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }


}
