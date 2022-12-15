package eapli.base.app.user.console.ui;

import eapli.base.Task.application.Automatic.TaskAutomaticBaseController;
import eapli.base.Task.application.Manual.TaskManualBaseController;
import eapli.base.Task.application.TaskWorkFlowController;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.CodeTaskWorkFlow;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AddWorkFlowToServiceUI {

    Scanner in = new Scanner(System.in);
    ServiceController serviceController = new ServiceController();
    TaskWorkFlowController taskWorkFlowController = new TaskWorkFlowController();
    TaskManualBaseController taskManualController = new TaskManualBaseController();
    TaskAutomaticBaseController taskAutomaticController = new TaskAutomaticBaseController();

    public void showMenu(Service service) {


        System.out.println("============================================");
        System.out.println("      Add a New WorkFlow to a Service:      ");
        System.out.println("============================================\n");
        printExistingWorkFlows();
        System.out.println("============================================");
        System.out.println("Insert a Code For The WorkFlow");
        String code = in.nextLine();
        Set<TaskManualBase> manualTaskSet = new HashSet<>();
        Set<TaskAutomaticBase> automaticTaskSet = new HashSet<>();
        TaskWorkFlow taskWorkFlow = taskWorkFlowController.addWorkFlow(CodeTaskWorkFlow.valueOf(code), manualTaskSet, automaticTaskSet);
        //Mostra todas as tasks manuais, ele seleciona as que quer meter no workflow
        List<TaskManualBase> tasks = taskManualController.getAllWaitingApprovalTask();

        System.out.println("-------------------------");
        System.out.println("Registered Manual Tasks");
        System.out.println("-------------------------");
        for (TaskManualBase task : tasks) {
            System.out.println("\nTask Code: " + task.getCode() + "\nTask Description: " + task.getDescription() + "\nTask State: " + task.getTaskState() + task.getLimitDate());
        }

        System.out.println("\nInsert the code of the manual tasks that you wish to add to the workflow(Type 0 when you done adding tasks)");
        String option = "";

        while (!option.equals("0")) {
            if (!tasks.isEmpty()) {
                option = in.nextLine();
                if (taskManualController.getTaskByCode(CodeTaskManualBase.valueOf(option)) == null) {
                    System.out.println("That Task doesn't exist");
                } else if (manualTaskSet.contains(taskManualController.getTaskByCode(CodeTaskManualBase.valueOf(option)))) {
                    System.out.println("This Task has been added already to this Workflow!!");
                } else {
                    manualTaskSet.add(taskManualController.getTaskByCode(CodeTaskManualBase.valueOf(option)));
                    tasks.remove(taskManualController.getTaskByCode(CodeTaskManualBase.valueOf(option)));
                    System.out.println("Task With Code: " + taskManualController.getTaskByCode(CodeTaskManualBase.valueOf(option)).getCode() + " was added with success!!" + "\n");
                  if(tasks.isEmpty()){
                      System.out.println("All Available Manual Tasks have added to the Workflow!!");
                  }else
                    System.out.println("Insert Another Task or Type 0 if You Done Adding");
                }
            } else {
                option = "0";
            }
        }

        System.out.println("-------------------------");
        System.out.println("Registered Automatic Tasks");
        System.out.println("-------------------------");
        List<TaskAutomaticBase> automaticTasks = taskAutomaticController.getAllAutomaticTasks();
        for (TaskAutomaticBase task : automaticTasks) {
            System.out.println("\nTask Code: " + task.getCode() + "\nTask Description: " + task.getDescription() + "\nTask State: " + task.getTaskState() + task.getLimitDate());
        }

        System.out.println("\nInsert the code of the automatic tasks that you wish to add to the workflow(Type 0 when you done adding tasks)");
        option = "";
        while (!option.equals("0")) {
            if (!automaticTasks.isEmpty()) {
                option = in.nextLine();
                if (taskAutomaticController.getTaskAutomaticByCode(CodeTaskAutomaticBase.valueOf(option)) == null) {
                    System.out.println("That Task doesn't exist");
                }else if (automaticTaskSet.contains(taskAutomaticController.getTaskAutomaticByCode(CodeTaskAutomaticBase.valueOf(option)))){
                    System.out.println("This Task already has been added to the Workflow!!");
                } else {
                    automaticTaskSet.add(taskAutomaticController.getTaskAutomaticByCode(CodeTaskAutomaticBase.valueOf(option)));
                    automaticTasks.remove(taskAutomaticController.getTaskAutomaticByCode(CodeTaskAutomaticBase.valueOf(option)));
                    System.out.println("Task With Code: " + taskAutomaticController.getTaskAutomaticByCode(CodeTaskAutomaticBase.valueOf(option)).getCode() + " was added with success!!" + "\n");
                    if(automaticTasks.isEmpty()){
                        System.out.println("All Available Manual Tasks have added to the Workflow!!");
                    }else
                        System.out.println("Insert Another Task or Type 0 if You Done Adding");
                }
            } else {
                option = "0";
            }
        }
        taskWorkFlowController.addWorkFlow(CodeTaskWorkFlow.valueOf(code), manualTaskSet, automaticTaskSet);

        serviceController.addWorkFlowToService(taskWorkFlow, service);
        System.out.println("WorkFlow added!\n");


    }


    public void printExistingWorkFlows() {
        List<TaskWorkFlow> taskWorkFlowList = taskWorkFlowController.getAllWorkFlows();
        if (!taskWorkFlowList.isEmpty()) {
            for (TaskWorkFlow taskWorkFlow : taskWorkFlowList) {
                System.out.println("\nWorkFlow Code: " + taskWorkFlow.getCode() + "\n");
            }
        } else {
            System.out.println("(There are no Registered WorkFlows)");

        }
    }


}

