package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.Request.model.RequestGrade;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Scanner;

public class SetRequestSatisfactionGradeUI {
    RequestController requestController = new RequestController();
    CollaboratorController collaboratorController = new CollaboratorController();
    AuthorizationService authz = AuthzRegistry.authorizationService();
    Scanner in = new Scanner(System.in);

    public boolean shownMenu() {

        System.out.println("==========================================");
        System.out.println("1-Assign Satisfaction Grades To Requests  ");
        System.out.println("2-List Evaluated Requests");
        System.out.println("==========================================");
        System.out.println("0-Back");

        int option = in.nextInt();

        switch (option) {
            case 1:
                List<Request> requests = requestController.getAllTerminatedRequestOfUserWithNoGrade(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
                if (requests.isEmpty()) {
                    System.out.println("There Is No Available Requests to Assign a Satisfaction Grade");
                } else {
                    assignGrade();
                    System.out.println("The Satisfaction Grade Was Assign With Success");
                }
                break;
            case 2:
                printRequestWithGrades();
                break;
            default:
                break;
        }

        return true;
    }

    private boolean assignGrade() {

        try {
            List<Request> requests = requestController.getAllTerminatedRequestOfUserWithNoGrade(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));

            System.out.println("============================");
            System.out.println("     Registered Requests    ");
            System.out.println("============================");

            for (Request r : requests) {
                System.out.println("\nRequest Code: " + r.getCodeRequest() + "\nRequest Service Title" + r.getService().getTitle() + "\nRequest Date: " + r.getRequestDate() + "\n\n");
            }

            System.out.println("Insert the Code of The Request That You Wish To Assign a Satisfaction Grade");
            System.out.println("---------------------------------------------------------------------------");
            in.nextLine();
            String code = in.nextLine();

            Request r = requestController.getRequestByCode(CodeRequest.valueOf(code));

            System.out.println("\n1-EXCELLENT\n2-GOOD\n3-SATISFYING\n4-BAD\n5-HORRIBLE");

            System.out.println("Choose Your Satisfaction Grade (Type the Respective Number)");
            int choice = in.nextInt();

            requestController.setGrade(requestGrades(r, choice));
            System.out.println("Your Grade was Assigned!!");
        } catch (Exception e) {
            System.out.println("Something Went Wrong While Setting The Request Grade ");
        }


        return true;
    }


    private Request requestGrades(Request request, int choice) {


        switch (choice) {
            case 1:
                request.setRequestGrade(RequestGrade.EXCELLENT);
                break;
            case 2:
                request.setRequestGrade(RequestGrade.GOOD);
                break;
            case 3:
                request.setRequestGrade(RequestGrade.SATISFYING);
                break;
            case 4:
                request.setRequestGrade(RequestGrade.BAD);
                break;
            case 5:
                request.setRequestGrade(RequestGrade.HORRIBLE);
                break;
            default:
                System.out.println("That Option Doesn't Exist");
                break;
        }
        return request;
    }


    private boolean printRequestWithGrades() {

        List<Request> requests = requestController.getAllTerminatedRequestOfUserWithGrade(collaboratorController.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
        if (!requests.isEmpty()) {
            System.out.println("=======================================");
            System.out.println("     Registered Evaluated Requests    ");
            System.out.println("=======================================");
            for (Request r : requests) {
                System.out.println("\nRequest Code: " + r.getCodeRequest() + "\nRequest Service Title: " + r.getService().getTitle() + "\nRequest Date: " + r.getRequestDate() + "\nSatisfaction Grade: " + r.getRequestGrade() + "\n\n");
            }
        } else {
            System.out.println("You Have No Evaluated Requests!!");
        }
        return true;
    }


}
