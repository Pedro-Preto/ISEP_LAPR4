package eapli.base.app.user.console.ui;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.contract.application.ContractController;
import eapli.base.contract.domain.Contract;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.criticality.domain.Criticality;

import java.util.*;

public class CreateCatalogueUI {

    private CatalogueController catalogueController;
    private CollaboratorController collaboratorController;
    private CriticalityController criticalityController;
    private ContractController contractController;

    public void createCatalogue(){
        catalogueController = new CatalogueController();
        collaboratorController = new CollaboratorController();
        criticalityController = new CriticalityController();
        contractController = new ContractController();

        Scanner in = new Scanner(System.in);

        System.out.println("Create a new catalogue ...");
        System.out.println("==================================");

        Catalogue check;
        Title title;
        do {
            System.out.println("Insert the Catalogue title ...");
            title = Title.valueOf(in.nextLine());
            check = catalogueController.findCatalogueByTitle(title.toString()).orElse(null);
            if (check != null) {
                System.out.println("A Catalogue with that title already exists!");
            }
        } while(check != null);

        System.out.println("Insert a brief description ...");
        String briefDescription = in.nextLine();

        System.out.println("Insert the description ...");
        String description = in.nextLine();

        System.out.println("Insert the path to the icon ...");
        Icon icon = Icon.valueOf(in.nextLine());

        //===========================Collaborator===========================
        List<Collaborator> colabs = collaboratorController.getAllCollaborators();
        Collaborator responsable;
        System.out.println("\n==================================================================");
        for(Collaborator col: colabs){
            System.out.println(col.getFirstName() +" " +col.getLastName() +" (" + col.getNumMechanographic() +")");
        }
        do {
            System.out.println("Insert the mechanographic number of the responsable collaborator for the catalogue ...");
            String mecaNum = in.nextLine();

            responsable = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf(mecaNum));
            if (responsable == null){
                System.out.println("Collaborator not found!");
            }

        } while(responsable == null);
        //===========================Collaborator===========================


        //============================Contract================================
        List<Contract> contracts = contractController.getAllContracts();
        System.out.println("\n==================================================================");
        for(Contract c : contracts){
            if(c.getCriticalities().size() > 0){
                System.out.println("Contract: " +c.getContractID());
                if(c.getCriticalities().isEmpty()) {
                    System.out.println("No Criticalities");
                    System.out.println();
                }else {
                    System.out.print("Criticalities: ");
                    for (Criticality criticality : c.getCriticalities()) {
                        System.out.print(criticality.getId() +"  ");
                    }
                    System.out.println();
                    System.out.println();
                }
            }
        }
        Contract contract;
        do {
            System.out.println("Select one contract (SLA) by inserting its id ...");
            Long contractId = in.nextLong();
            contract = contractController.getContractByID(contractId);
            if(contract == null){
                System.out.println("Contract not found!");
            }
        }while(contract == null);
        //============================Contract================================

        //===========================Criticality==============================
        List<Criticality> criticalities = new LinkedList<>(contractController.getCriticalitiesByContract(contract));
        System.out.println("\n==================================================================");
        int counter = 0;
        for(Criticality criticality : criticalities){
            counter++;
            System.out.println(counter +"- Criticality: " +criticality.getId()
                    +" | Scale/Value: " +criticality.getScale() +"/" +criticality.getValue()
                    +"\n    Max/Average Approval Time: " +criticality.getApprovalMaxTime() +"/" +criticality.getApprovalAverageTime()
                    +"\n    Max/Average Resolution Time: " +criticality.getResolutionMaxTime() +"/" +criticality.getResolutionAverageTime());
            System.out.println();
            System.out.println();
        }
        Criticality criticality = null;
        int option = 0;
        do {
            System.out.println("Pick a criticality...");
            try {
                option = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Option!");
                continue;
            }
            if(option > criticalities.size() || option == 0){
                System.out.println("Invalid Option!");
                continue;
            }
            criticality = criticalityController.findCriticalityByID(Long.parseLong(criticalities.get(option - 1).identity().toString())).orElse(null);
        } while (criticality == null);
        //===========================Criticality===========================

        Catalogue catalogue = new Catalogue(title, briefDescription, description, icon, responsable, criticality, new HashSet<>());
        catalogueController.addCatalogue(catalogue);
        System.out.println("Catalogue was Added Successfully!");

    }
}
