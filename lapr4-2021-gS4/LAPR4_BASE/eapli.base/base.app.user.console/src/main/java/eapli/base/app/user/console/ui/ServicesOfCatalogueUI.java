package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.form.application.FormController;
import eapli.base.form.application.FormRequestRelationController;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.RequestForm;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Service;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.util.*;

public class ServicesOfCatalogueUI {

    private static ServiceController serviceController = new ServiceController();
    private static FormRequestRelationController formRequestRelationController = new FormRequestRelationController();
    private static CollaboratorController collaboratorController = new CollaboratorController();
    private static RequestController requestController = new RequestController();
    private static FormController formController = new FormController();

    public static void showMenu(Catalogue catalogue) {
        try {
            Scanner in = new Scanner(System.in);
            String serviceCode;

            System.out.println("\n" +catalogue.getTitle() +": ");
            System.out.println("===================================================================");
            System.out.println("                 Pick a Service to make a Request:                 ");
            System.out.println("===================================================================\n");
            Service service = listCompletedServicesOfCatalogue(catalogue);
            if (service == null)
                return;

            listOfRequests();
            System.out.println("=============================");
            System.out.println("Insert a Code for the Request");
            String codeRequest = in.nextLine();

            makeRequestToService(service, codeRequest);

        } catch (Exception e) {
            System.out.println("Something went Wrong While Making The Request");
        }

    }

    private static boolean makeRequestToService(Service service, String codeRequest) {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        Collaborator requester = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
        Collaborator beneficiary = pickBeneficiary();

        if (beneficiary == null) {
            System.out.println("Something went wrong while picking the beneficiary!");
            return false;
        }

        RequestForm requestForm = fillForm(service, codeRequest);
        if (formRequestRelationController.checkForm(requestForm) == true) {
            formRequestRelationController.saveRequestForm(requestForm);
            System.out.println("Creating Request...");
            requestController.makeRequest(CodeRequest.valueOf(codeRequest), service, requestForm, requester, beneficiary);
            System.out.println("Requested added with success!!");
            return true;
        } else {
            System.out.println("Something went wrong while filling the form!");
            return false;
        }
    }

    private static Collaborator pickBeneficiary() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        Scanner in = new Scanner(System.in);
        System.out.println("Are you requesting this service for yourself? \n1-Yes\n2-No\n0-Back");
        String option = in.nextLine();
        switch (option) {
            case "1":
                return collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(authz.session().get().authenticatedUser().identity().toString()));
            case "2":
                listCollaborators();
                String colNum = in.nextLine();
                return collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(colNum));
            case "0":
                System.out.println("Leaving...");
                return null;
            default:
                System.out.println("Invalid Option!");
                return null;
        }
    }

    private static void listCollaborators() {
        List<Collaborator> colList = collaboratorController.getAllCollaborators();
        for (Collaborator col : colList) {
            System.out.println("Name: " + col.getFirstName() + " " + col.getLastName()
                    + " (" + col.getNumMechanographic() + ")");
        }
    }

    private static RequestForm fillForm(Service service, String codeRequest) {
        Scanner in = new Scanner(System.in);
        RequestForm requestForm = formRequestRelationController.makeRequestFormByService(service, codeRequest);
        List<FormAttribute> attributeSet = new LinkedList<>(requestForm.getAttributes());
        String auxValue;

        for (int i = attributeSet.size() - 1; i >= 0; i--) {
            System.out.println(attributeSet.get(i).getAttributeLabel());
            auxValue = in.nextLine();
            attributeSet.get(i).setAttributeValue(auxValue);
        }

        /*
        for(FormAttribute fa : attributeSet) {
            System.out.println(fa.getAttributeLabel());
            auxValue = in.nextLine();
            fa.setAttributeValue(auxValue);
        }
        */

        requestForm.setAttributes(new HashSet<>(attributeSet));
        return requestForm;
    }

    private static Service listCompletedServicesOfCatalogue(Catalogue catalogue) {
        List<Service> completedServices = serviceController.getCompletedServicesOfCatalogue(catalogue);
        if (completedServices.size() == 0) {
            System.out.println("This Catalogue currently has no Services to provide!");
            return null;
        } else {
            int option;
            int counter = 0;
            for (Service s : completedServices) {
                counter++;
                System.out.println(counter+": Service Title: " + s.getTitle() + " (Code: " + s.code() + ")\n");
            }
            System.out.println("===================================================================");
            System.out.println("0.Exit\n");
            try {
                option = Console.readInteger("Please select a Service: ");
            }catch(Exception e){
                System.out.println("Invalid Option!");
                return null;
            }
            if (option > completedServices.size() || option < 1){
                System.out.println("Invalid Option!");
                return null;
            } else {
                String serviceCode = completedServices.get(option - 1).getCode().toString();
                return serviceController.findServiceByCode(serviceCode).orElse(null);
            }
        }
    }

    private static void listOfRequests() {
        List<Request> requests = requestController.getAllRequests();
        System.out.println("Registered Requests");
        System.out.println("=============================");
        if (requests.isEmpty()) {
            System.out.println("(There's no Registered Requests)");
        } else {
            for (Request request : requests) {
                System.out.println("\nRequest Code: " + request.getCodeRequest() + "\nRequest Date: " + request.getRequestDate() + "\nRequest Service: " + request.getService().getTitle() + "\nForm Name: " + request.getForm().getName());
            }
        }

    }
}
