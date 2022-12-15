package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.Request;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.*;

public class MyRequestsUI {

    private static CollaboratorController collaboratorController = new CollaboratorController();
    private static RequestController requestController = new RequestController();

    public static void showMenu() {
        Scanner in = new Scanner(System.in);
        activeOrHistory();
        String option = in.nextLine();
        switch(option) {
            case "1":
                showActiveMenu();
                break;
            case "2":
                showHistoryMenu();
                break;
            case "0":
                System.out.println("Leaving...");
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }

    private static void activeOrHistory() {
        System.out.println("Requests:");
        System.out.println("1 - Check Active Requests");
        System.out.println("2 - Check Request History");
        System.out.println("0 - Back");
    }

    public static void showActiveMenu() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        Collaborator col = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
        Scanner in = new Scanner(System.in);
        showOptions();
        String option = in.nextLine();
        switch(option) {
            case "1":
                activeRequestsRequester(col);
                break;
            case "2":
                activeRequestsBeneficiary(col);
                break;
            case "0":
                System.out.println("Leaving...");
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }

    public static void showHistoryMenu() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        Collaborator col = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
        Scanner in = new Scanner(System.in);
        showOptions();
        String option = in.nextLine();
        switch(option) {
            case "1":
                historyRequestsRequester(col);
                break;
            case "2":
                historyRequestsBeneficiary(col);
                break;
            case "0":
                System.out.println("Leaving...");
                break;
            default:
                System.out.println("Invalid Option!");
                break;
        }
    }

    private static void showOptions() {
        System.out.println("What do you want to see?\nRequests in which...");
        System.out.println("1 - ...I am the Requester");
        System.out.println("2 - ...I am the Beneficiary");
        System.out.println("0 - Back");
    }

    private static void activeRequestsRequester(Collaborator collaborator){
        List<Request> requestList = requestController.getActiveRequestsByRequester(collaborator);
        if (requestList.isEmpty()) {
            System.out.println("You haven't requested any Request!");
        } else {
            showRequests(requestList);
        }
    }

    private static void activeRequestsBeneficiary(Collaborator collaborator){
        List<Request> requestList = requestController.getActiveRequestsByBeneficiary(collaborator);
        if (requestList.isEmpty()) {
            System.out.println("There are no Requests in which you are the Beneficiary!");
        } else {
            showRequests(requestList);
        }
    }

    private static void historyRequestsRequester(Collaborator collaborator){
        List<Request> requestList = requestController.getTerminatedRequestsByRequester(collaborator);
        if (requestList.isEmpty()) {
            System.out.println("You haven't requested any completed Request!");
        } else {
            showRequests(requestList);
        }
    }

    private static void historyRequestsBeneficiary(Collaborator collaborator){
        List<Request> requestList = requestController.getTerminatedRequestsByBeneficiary(collaborator);
        if (requestList.isEmpty()) {
            System.out.println("There are no completed Requests in which you are the Beneficiary!");
        } else {
            showRequests(requestList);
        }
    }

    private static void showRequests(List<Request> requestList) {
        for (Request r: requestList) {
            System.out.println("Request: " +r.getCodeRequest() +", requested by: " +r.getRequester().getNumMechanographic() +", for: " +r.getBeneficiary().getNumMechanographic());
        }
    }
}
