package eapli.base.app.user.console.ui;

import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Keyword;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceBuilder;
import eapli.framework.io.util.Console;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ServiceUI {

    private ServiceController serviceController;

    public ServiceBuilder addService(ServiceBuilder serviceBuilder){ //Continue specifying an incomplete service ou start a new one, depending on the received ServiceBuilder

        Scanner in = new Scanner(System.in);
        serviceController = new ServiceController();

        if(!serviceBuilder.isNew()) {
            int option;
            System.out.println("Please select an Option: ");
            System.out.println("1- Continue specifying Service");
            System.out.println("2- Specify a new Service");

            try {
                option = in.nextInt();
            } catch (Exception e){
                System.out.println("Invalid Option!");
                return serviceBuilder;
            }

            switch (option) {
                case 1:
                    in.nextLine();
                    break;
                case 2:
                    serviceBuilder = new ServiceBuilder();
                    in.nextLine();
                    break;
                default :
                    System.out.println("Invalid Option!");
                    return serviceBuilder;
            }

        }

        int auxCounter = 0;
        String title,  briefDescription,  description,  code,  icon;
        Catalogue catalogue;
        Set<Keyword> keywords = new HashSet<>();

        if (serviceBuilder.isNew()) {
            System.out.println("Add Service, to exit midway specification, please input \"0\" ...");
        } else {
            System.out.println("Continue Adding a Service, to exit midway specification, please input \"0\" ...");
        }
        System.out.println("==================================");

        if(serviceBuilder.getTitle() == null) {
            System.out.println("1- Insert the Service title ...");
            title = in.nextLine();
            if(title.equals("0"))
                return serviceBuilder;
            serviceBuilder.withTitle(title);
        }

        if(serviceBuilder.getBriefDescription() == null) {
            System.out.println("2- Insert the Service brief description ...");
            briefDescription = in.nextLine();
            if(briefDescription.equals("0"))
                return serviceBuilder;
            serviceBuilder.withBriefDescription(briefDescription);
        }

        if(serviceBuilder.getDescription() == null) {
            System.out.println("3- Insert the Service description ...");
            description = in.nextLine();
            if(description.equals("0"))
                return serviceBuilder;
            serviceBuilder.withDescription(description);
        }

        if(serviceBuilder.getCode() == null) {
            Service check = null;
            do {
                System.out.println("4- Insert the Service code ...");
                code = in.nextLine();
                check = serviceController.findServiceByCode(code).orElse(null);
                if (check != null) {
                    System.out.println("Please pick another code, the code you chose is already in use.");
                }
            } while(check != null);
            if(code.equals("0"))
                return serviceBuilder;
            serviceBuilder.withCode(code);
        }

        if(serviceBuilder.getIcon() == null) {
            System.out.println("5- Insert the Service icon ...");
            icon = in.nextLine();
            if(icon.equals("0"))
                return serviceBuilder;
            serviceBuilder.withIcon(icon);
        }


        //=======================Add Keywords=======================
        if(serviceBuilder.getKeywords() == null) {
            String keyword;
            do {
                keyword = Console.readLine("6- Insert a Keyword, when done, please type \"0\": \n" +
                        "(If \"0\" is inserted as the first Keyword, no keywords will be added, and the service can be completed later)\n ");
                if (!keyword.equals("0")) {
                    keywords.add(Keyword.valueOf(keyword));
                } else if (auxCounter == 0) {
                    return serviceBuilder;
                }
                auxCounter++;
            } while (!keyword.equals("0"));
            serviceBuilder.withKeywords(keywords);
        }
        //=======================Add Keywords=======================

        //======================Chose Catalogue======================
        if(serviceBuilder.getCatalogue() == null) {
            System.out.println("7- Choose a catalogue from the list above ...");
            CatalogueController catalogueController = new CatalogueController();
            List<Catalogue> catalogueList = (List<Catalogue>) catalogueController.getAllCatalogues();
            int option;
            int counter = 0;
            for (Catalogue c : catalogueList) {
                counter++;
                System.out.println(counter +"- Catalogue: " +c.getTitle() +"\n   Brief Description: " +c.getBriefDescription() +"\n");
            }
            try {
                option = Console.readInteger("Select a Catalogue: ");
            }catch(Exception e) {
                System.out.println("Invalid Option!");
                return serviceBuilder;
            }
            if(option > catalogueList.size()){
                System.out.println("Invalid Option!");
                return serviceBuilder;
            }
            if(option == 0)
                return serviceBuilder;
            String catalogueTitle = catalogueList.get(option -1).getTitle().toString();
            catalogue = catalogueController.findCatalogueByTitle(catalogueTitle).orElse(null);
            if (catalogue == null) {
                System.out.println("Could not find a Catalogue with that title");
                return serviceBuilder;
            }
            serviceBuilder.withCatalogue(catalogue);
        }
        //======================Chose Catalogue======================

        serviceController.addService(serviceBuilder.build());
        System.out.println("The Service has been registered!");
        return serviceBuilder;
    }
}
