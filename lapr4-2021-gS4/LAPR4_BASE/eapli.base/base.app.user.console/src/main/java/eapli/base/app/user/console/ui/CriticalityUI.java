package eapli.base.app.user.console.ui;

import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.contract.application.ContractController;
import eapli.base.contract.domain.Contract;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;


import java.util.List;
import java.util.Scanner;

public class CriticalityUI {

    CriticalityController criticalityController = new CriticalityController();
    ContractController contractController = new ContractController();

    ColorController colorController = new ColorController();

    public void addCriticalityUI() {
        int value, scale, maxTime, averageTime, maxTimeResolution, averageTimeResolution;

        Scanner in = new Scanner(System.in);

        System.out.println("Add Criticality ...");
        System.out.println("==================================");
        List<Contract> contracts = contractController.getAllContracts();
        for(Contract c : contracts){
            System.out.println(c);
        }
        System.out.println("Select one contract by typing its id:");
        long contractId = in.nextLong();
        Contract contract = contractController.getContractByID(contractId);
        if(contract == null){
            System.out.println("Contract not found");
            return;
        }
        System.out.println("Insert the Criticality Id...");
        long id = in.nextInt();
        CriticalityID criticalityID=CriticalityID.valueOf(id);
        System.out.println("Insert the Criticality scale (1 to ... )");
        scale = in.nextInt();
        System.out.println("Insert the Criticality value...");
        value = in.nextInt();
        System.out.println("Insert the Criticality average approval time (min) ...");
        averageTime = in.nextInt();
        System.out.println("Insert the Criticality max approval time  (min) ...");
        maxTime = in.nextInt();
        System.out.println("Insert the Criticality average resolution time (min) ...");
        averageTimeResolution = in.nextInt();
        System.out.println("Insert the Criticality max resolution time  (min) ...");
        maxTimeResolution = in.nextInt();
        in.nextLine();
        System.out.println("Pick a color from the list below:");

        List<Color> colors = colorController.getAllColors();
        for (Color c : colors) {
            System.out.println(c);
        }
        String c=in.nextLine();
        Color color=colorController.getCollorByDesignation(ColorDesignation.valueOf(c));
        Criticality criticality =new Criticality(criticalityID,value, scale, color, maxTime, averageTime, maxTimeResolution, averageTimeResolution);

        criticalityController.addCriticality(criticality);

        if (contractController.addCriticalityToContract(criticality, contractId)!=null)
        System.out.println("Criticality added successfully!");

    }
}
