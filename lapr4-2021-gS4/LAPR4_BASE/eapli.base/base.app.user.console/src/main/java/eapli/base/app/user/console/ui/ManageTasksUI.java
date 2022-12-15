package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Task.application.Manual.TaskManualBaseController;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.util.List;

public class ManageTasksUI {

    public static void showMenu() {
        ClaimPendingTasksUI claimPendingTasksUI = new ClaimPendingTasksUI();
        TaskManualBaseController taskManualController = new TaskManualBaseController();
        TaskManualRequestController taskManualResquestController = new TaskManualRequestController();
        CollaboratorController collaboratorController = new CollaboratorController();
        final AuthorizationService authz = AuthzRegistry.authorizationService();
        CompleteTasksUI completeTasksUI = new CompleteTasksUI();
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    if (!taskManualController.getAllUncumpletedTasksWithNoResponsibleCollaborator().isEmpty()) {
                        claimPendingTasksUI.claimTasks();
                    } else {
                        System.out.println("All The Tasks Are Already Assign To A Collaborator!!");
                    }
                    break;
                case 2:
                    List<TaskManualRequest> taskList = taskManualResquestController.getCollaboratorTasksInCourseAndUncompleted(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
                    if (!taskList.isEmpty()) {
                        ManageViewTasksUI.showMenu();
                    } else {
                        System.out.println("\nYou Don't Have Any Pending Tasks!!");
                    }
                    break;
                case 3:
                    completeTasksUI.makeManualTask();
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
        System.out.println(" Manage Tasks Menu: ");
        System.out.println("=============================\n");
        System.out.println("1.Claim Pending Tasks");
        System.out.println("2.View Pending Tasks");
        System.out.println("3.Complete a Task");
        System.out.println("=============================");
        System.out.println("0.Back\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }

}


