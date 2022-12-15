package eapli.base.app.user.console.ui;

import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.Request;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.domain.Manual.TaskManualRequest;

import java.util.LinkedList;
import java.util.List;

public class CheckContractsUI {

    private static RequestController requestController = new RequestController();


    public static void showContractCompliance() {
        try {
            if (!requestController.getAllTerminatedRequests().isEmpty()) {
                List<Request> achievedContracts = new LinkedList<>();
                List<Request> failedContracts = new LinkedList<>();
                List<Request> allRequests = requestController.getAllRequests();
                boolean flag;
                List<TaskManualRequest> allManualTasks;
                List<TaskAutomaticRequest> allAutomaticTasks;


                for (Request r : allRequests) { //Iterates every request
                    flag = false; //flag only changes when a task fails to comply to the contract

                    allManualTasks = r.getManualTasks(); //Manual tasks for the current request
                    allAutomaticTasks = r.getAutomaticTasks(); //Automatic tasks for the current request

                    for (TaskManualRequest t : allManualTasks) { //Iterates through the manual tasks
                        if (t.getStandardResolutionTime() < requestController.calculateCompletionTime(r)) {
                            failedContracts.add(r);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        for (TaskAutomaticRequest t : allAutomaticTasks) {
                            if (t.getStandardResolutionTime() < requestController.calculateCompletionTime(r)) {
                                failedContracts.add(r);
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) { //if every task was successful in achieving the contract (flag still false), adds it to the list
                        achievedContracts.add(r);
                    }
                }
                System.out.println("====================================");
                if (failedContracts.isEmpty()) {
                    System.out.println("\nThere Are no Failed Contracts!!");
                } else {
                    System.out.println("\nRequests With Failed contracts:");
                    System.out.println("-------------------------------------------");
                    for (Request r : failedContracts) {
                        System.out.println("Request " + r.getCodeRequest().toString() + " ->Requester Collaborator: " + r.getRequester().getNumMechanographic() + "\n");

                    }
                }
                System.out.println("=========================================");
                if (achievedContracts.isEmpty()) {
                    System.out.println("There are no Achieved Contracts!!");
                } else {
                    System.out.println("Requests WithAchieved contracts:");
                    System.out.println("-------------------------------------------");
                    for (Request r : achievedContracts) {
                        System.out.println("Request " + r.getCodeRequest().toString() + " ->Requester Collaborator: " + r.getRequester().getNumMechanographic() + "\n");
                    }
                }
            } else {
                System.out.println("There are no Terminated Requests!!!");
            }

        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
    }
}
