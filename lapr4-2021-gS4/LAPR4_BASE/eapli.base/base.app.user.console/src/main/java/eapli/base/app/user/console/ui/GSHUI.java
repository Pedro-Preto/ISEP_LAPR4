package eapli.base.app.user.console.ui;

import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.contract.application.ContractController;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.service.domain.ServiceBuilder;
import eapli.framework.io.util.Console;

import java.util.List;
import java.util.Scanner;

public class GSHUI {

    public static void showMenu(){

        Scanner in = new Scanner(System.in);
        CriticalityController criticalityController = new CriticalityController();
        CatalogueController catalogueController = new CatalogueController();
        ContractController contractController = new ContractController();

        ServiceBuilder serviceBuilder = new ServiceBuilder();

        ContractUI contractUI = new ContractUI();
        ServiceUI serviceUI = new ServiceUI();
        CriticalityUI criticalityUI = new CriticalityUI();
        CreateCatalogueUI createCatalogueUI = new CreateCatalogueUI();
        ManageCatalogueUI manageCatalogueUI = new ManageCatalogueUI();
        ManageServicesUI manageServicesUI = new ManageServicesUI();
        int option = 0;
        do {
            option = showOptions();

            switch (option) {
                case 0:
                    System.out.println("Exiting ...");
                    break;
                case 1:
                    contractUI.addContractUI();
                    break;
                case 2:
                    if (contractController.getAllContracts().size() == 0) {
                        System.out.println("Please define a Contract first, there are no Contracts registered in the system ...");
                        break;
                    } else {
                        criticalityUI.addCriticalityUI();
                        break;
                    }
                case 3:
                    if (criticalityController.getAllCriticalities().size() == 0) {
                        System.out.println("Please define a Criticality first, there are no Criticalities in the System ...");
                        break;
                    } else {
                        createCatalogueUI.createCatalogue();
                        break;
                    }
                case 4:
                    if (((List<Catalogue>) catalogueController.getAllCatalogues()).size() == 0) {
                        System.out.println("Please create a Catalogue first, there are no Catalogues in the System ...");
                        break;
                    } else {
                        serviceBuilder = serviceUI.addService(serviceBuilder);
                        if (serviceBuilder.isComplete())
                            serviceBuilder = new ServiceBuilder();
                        break;
                    }
                case 5:
                    manageCatalogueUI.manageCatalogue();
                    break;
                case 6:
                    manageServicesUI.manageServices();
                    break;
                case 7:
                    ViewAuthorizedCataloguesUI viewAuthorizedCataloguesUI = new ViewAuthorizedCataloguesUI();
                    viewAuthorizedCataloguesUI.showMenu();
                    break;
                case 8:
                    ManageTasksUI.showMenu();
                    break;
                case 9:
                    ManageRequestsUI.showMenu();
                    break;
                case 10:
                    CheckContractsUI.showContractCompliance();
                    break;
                default:
                    System.out.println("Option does not exist!");
                    break;
            }
        } while (option != 0);
    }

    private static int showOptions() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" GSH Menu: ");
        System.out.println("=============================");
        System.out.println("1.Create Contract");
        System.out.println("2.Define Criticality");
        System.out.println("3.Create Catalogue");
        System.out.println("4.Create Service");
        System.out.println("5.Manage Catalogues");
        System.out.println("6.Manage Services");
        System.out.println("7.Make Request");
        System.out.println("8.Manage Tasks");
        System.out.println("9.Manage Requests");
        System.out.println("10.Check Contracts");
        System.out.println("=============================");
        System.out.println("0.Exit\n\n");
        option = Console.readInteger("Please select an option");
        return option;
    }


}
