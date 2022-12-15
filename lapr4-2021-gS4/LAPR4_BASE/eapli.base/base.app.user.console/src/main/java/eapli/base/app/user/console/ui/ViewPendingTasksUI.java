package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Utils.TaskComparator;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewPendingTasksUI {
    TaskManualRequestController taskController = new TaskManualRequestController();
    CollaboratorController collaboratorController = new CollaboratorController();
    AuthorizationService authz = AuthzRegistry.authorizationService();
    TaskComparator taskComparator = new TaskComparator();

    public boolean viewPendingTasksByLimitDate(int option) {
        try {
            Scanner in = new Scanner(System.in);

            List<TaskManualRequest> taskList = taskController.getCollaboratorTasksInCourseAndUncompleted(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));

            System.out.println("Insert a Limit Date (Use this format: dd/MM/yyyy)");
            String sDate1 = in.nextLine();
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

            List<TaskManualRequest> tasksFiltered = new LinkedList<>();
            switch (option) {
                case 1:
                    tasksFiltered = taskComparator.sortTaskManualByLimitDate(taskList, date1,1);
                    break;
                case 2:
                    tasksFiltered = taskComparator.sortTaskManualByLimitDate(taskList, date1,2);
                    break;
                default:
                    System.out.println("That Option Doesn't Exist");
                    break;
            }


            System.out.println("--------------------------------");
            if (!taskList.isEmpty()) {
                for (TaskManualRequest task : tasksFiltered) {
                    System.out.println("\nTask Code: " + task.getCode() + "\nTask Description: " + task.getDescription() + "\nTask State: " + task.getTaskState() + "\nTask Limit Date: " + task.getLimitDate() + "\nStandard Resolution Time: " + task.getStandardResolutionTime() + " min" + "\n\n");
                }
            } else {
                System.out.println("You Don't Have Pending Tasks At This Period Of Time");
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Showing the Pending Tasks");
        }
        return true;
    }

    public boolean viewPendingTasksBetweenDates(int option) {
        try {
            Scanner in = new Scanner(System.in);

            List<TaskManualRequest> taskList = taskController.getCollaboratorTasksInCourseAndUncompleted(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));

            System.out.println("Insert the First Date (Use this format: dd/MM/yyyy)");
            String sDate1 = in.nextLine();
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

            System.out.println("Insert the Second Date (Use this format: dd/MM/yyyy)");
            String sDate2 = in.nextLine();
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
            List<TaskManualRequest> tasksFiltered = new LinkedList<>();
            switch (option) {
                case 1:
                    tasksFiltered = taskComparator.sortTasksManualBetweenTwoDates(taskList, date1, date2,1);
                    break;
                case 2:
                    tasksFiltered = taskComparator.sortTasksManualBetweenTwoDates(taskList, date1, date2,2);
                    break;
                default:
                    System.out.println("That Option Doesn't Exist");
                    break;
            }
            System.out.println("-----------------------------------");
            for (TaskManualRequest task : tasksFiltered) {
                System.out.println("\nTask Code: " + task.getCode() + "\nTask Description: " + task.getDescription() + "\nTask State: " + task.getTaskState() + "\nTask Limit Date: " + task.getLimitDate() + "\nStandard Resolution Time: " + task.getStandardResolutionTime() + " min" + "\n\n");
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Showing the Pending Tasks");
        }
        return true;
    }

    public static void showMenu1() {
        ViewPendingTasksUI viewPendingTasksUI = new ViewPendingTasksUI();
        int option;
        option = showOptions();
        switch (option) {
            case 0:
                System.out.println("Exiting ...");
                break;
            case 1:
                viewPendingTasksUI.viewPendingTasksByLimitDate(1);
                break;
            case 2:
                viewPendingTasksUI.viewPendingTasksByLimitDate(2);

                break;
            default:
                System.out.println("Option does not exist!");
                break;
        }
    }

    public static void showMenu2() {
        ViewPendingTasksUI viewPendingTasksUI = new ViewPendingTasksUI();
        int option;
        option = showOptions();
        switch (option) {
            case 0:
                System.out.println("Exiting ...");
                break;
            case 1:
                viewPendingTasksUI.viewPendingTasksBetweenDates(1);
                break;
            case 2:
                viewPendingTasksUI.viewPendingTasksBetweenDates(2);
                break;
            default:
                System.out.println("Option does not exist!");
                break;
        }
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("===================================================================");
        System.out.println("                       Order Tasks:                                 ");
        System.out.println("===================================================================\n");
        System.out.println("1.Crescent Order By Date ...");
        System.out.println("2.Decreasing Order By Date...");
        System.out.println("===================================================================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }
}
