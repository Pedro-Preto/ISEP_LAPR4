package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.application.RequestController;
import eapli.base.Task.application.Manual.TaskManualBaseController;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.CodeTaskManualRequest;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClaimPendingTasksUI {
    TaskManualRequestController taskController = new TaskManualRequestController();
    Scanner in = new Scanner(System.in);
    CollaboratorController collaboratorController = new CollaboratorController();
    AuthorizationService authz = AuthzRegistry.authorizationService();

    public boolean claimTasks() {
        try {

            List<TaskManualRequest> pendingTasks = taskController.getAllIncompleteTasksWithNoResponsibleCollaborator();
            System.out.println("----------------------------");
            for (TaskManualRequest task : pendingTasks) {
                System.out.println("\nTask Code: " + task.getCode() + "\nDesignation: " + task.getDescription() + "\nTask State: " + task.getTaskState() + "\nTask Limit Date: " + task.getLimitDate().toString() + "\nStandard Resolution Time: " + task.getStandardResolutionTime() + " min" + "\n");
            }
            System.out.println("\n----------------------------");

            System.out.println("\nInsert The Code Of The Task That You Wish To Claim");

            String code = in.nextLine();
            TaskManualRequest task = taskController.getTaskByCode(CodeTaskManualRequest.valueOf(code));

            Collaborator collaborator = collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString());
            taskController.claimTask(task, collaborator);
            System.out.println("The Task With Code: " + code + " Was Claimed With Success");
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Claiming The Task");
        }
        return true;
    }

}
