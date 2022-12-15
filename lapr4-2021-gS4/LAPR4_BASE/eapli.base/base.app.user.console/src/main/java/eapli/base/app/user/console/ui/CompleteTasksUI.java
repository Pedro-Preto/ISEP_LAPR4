package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Request.application.RequestController;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Manual.*;
import eapli.base.form.application.FormRequestRelationController;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.TaskRequestForm;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CompleteTasksUI {

    private TaskManualRequestController taskController = new TaskManualRequestController();
    private CollaboratorController collaboratorController = new CollaboratorController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private FormRequestRelationController formRequestRelationController = new FormRequestRelationController();

    public boolean makeManualTask() {
        try {
            Scanner in = new Scanner(System.in);
            List<TaskManualRequest> taskList = taskController.getCollaboratorTasksInCourseAndUncompleted(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
            if (taskList.isEmpty()) {
                System.out.println("You Can't Complete any Task at The Moment");
            } else {
                if (taskList.isEmpty()) {
                    System.out.println("There are no pending tasks...\n");
                } else {
                    for (TaskManualRequest taskManual : taskList) {
                        System.out.println("Task Code: " + taskManual.getCode().toString() + "\nLimit Date: " + taskManual.getLimitDate().toString() + "\nDescription: " + taskManual.getDescription() + "\n\n");
                    }

                    System.out.println("----------------------------");

                    System.out.println("\nInsert The Code Of The Task That You Want to Complete...");
                    String code = in.nextLine();
                    TaskManualRequest task = taskController.getTaskByCode(CodeTaskManualRequest.valueOf(code));
                    TaskRequestForm requestForm = fillForm(task);

                    if (formRequestRelationController.checkForm(requestForm)) {
                        formRequestRelationController.saveTaskRequestForm(requestForm);
                        taskController.completeManualPendingTask(task);
                    }

                    System.out.println("The Task With Code: " + code + " Was Completed With Success");

                }
            }

        } catch (Exception e) {
            System.out.println("Something Went Wrong While Completing The Task");
            return false;
        }
        return true;
    }

    private TaskRequestForm fillForm(TaskManualRequest task) {
        Scanner in = new Scanner(System.in);
        TaskRequestForm taskRequestForm = task.getTaskRequestForm();
        List<FormAttribute> attributeSet = new LinkedList<>(taskRequestForm.getAttributes());
        String auxValue;

        for (int i = attributeSet.size() - 1; i >= 0; i--) {
            System.out.println(attributeSet.get(i).getAttributeLabel());
            auxValue = in.nextLine();
            attributeSet.get(i).setAttributeValue(auxValue);
        }

        taskRequestForm.setAttributes(new HashSet<>(attributeSet));
        return taskRequestForm;
    }


}