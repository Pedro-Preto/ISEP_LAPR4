package eapli.base.app.user.console.ui;

import eapli.base.Task.application.Manual.TaskManualBaseController;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Keyword;
import eapli.base.service.domain.Service;
import eapli.framework.io.util.Console;

import java.util.List;

public class ManageServicesUI {

    public void manageServices() {
        TaskManualBaseController taskController = new TaskManualBaseController();
        ServiceController serviceController = new ServiceController();

        AddFormToServiceUI addFormToServiceUI = new AddFormToServiceUI();
        AddWorkFlowToServiceUI addWorkFlowToServiceUI = new AddWorkFlowToServiceUI();

        if (((List<Service>) serviceController.getAllServices()).size() == 0) {
            System.out.println("There are no Services in the System!");
            return;
        }
        System.out.println("===================================================================");
        System.out.println("                          Manage Services:                         ");
        System.out.print("===================================================================");
        Service service = showServices((List<Service>) serviceController.getAllServices());
        if (service == null) {
            return;
        } else {
            int option = showOptions();
            switch (option) {
                case 1:
                    if(service.getBaseForm() != null){
                        System.out.println("The chosen Service already has a Form!");
                        break;
                    }
                    addFormToServiceUI.showMenu(service);
                    break;
                case 2:
                    if(service.getTaskWorkFlow() != null){
                        System.out.println("The chosen Service already has a Workflow!");
                        break;
                    }
                    if(taskController.getAllWaitingApprovalTask().isEmpty()) {
                        System.out.println("There are no Tasks registered in the System!");
                        break;
                    }
                    addWorkFlowToServiceUI.showMenu(service);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("That option does not exist!");
                    return;
            }
        }
    }

    private static int showOptions() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("What do you want to add to the Service? : ");
        System.out.println("==================================================");

        System.out.println("1.Add a Form to the Service");
        System.out.println("2.Add a Workflow to the Service");

        System.out.println("==================================================");
        System.out.println("0.Exit\n\n");
        int option = Console.readInteger("What do you want to add to the Service? : ");
        return option;
    }

    private static Service showServices(List<Service> services) {
        ServiceController serviceController = new ServiceController();

        Service service = null;
        int option;
        int counter = 0;
        for (Service ser : services) {
            counter ++;
            System.out.println();
            System.out.print("\n" +counter +"- Service Title: " + ser.getTitle() + " (Code : " + ser.code() + ")"
                    + "\n   Service Keywords : ");
            for (Keyword keyword : ser.getKeywords()) {
                System.out.print(keyword + "  ");
            }
            System.out.println();
        }
        System.out.println();
        do {
            try {
                option = Console.readInteger("Please select a Service: ");
            } catch (Exception e) {
                System.out.println("Invalid Option!");
                continue;
            }
            if (option > services.size() || option < 0){
                System.out.println("Invalid Option!");
                continue;
            }
            if (option == 0){
                return null;
            }

            service = serviceController.findServiceByCode(services.get(option - 1).getCode().toString()).orElse(null);
        }while (service == null);

        return service;
    }


}
