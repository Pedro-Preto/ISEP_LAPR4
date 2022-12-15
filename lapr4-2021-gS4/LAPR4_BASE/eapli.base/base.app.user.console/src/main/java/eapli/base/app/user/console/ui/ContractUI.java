package eapli.base.app.user.console.ui;



import eapli.base.Collaborator.domain.*;
import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.contract.application.ContractController;
import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.general.domain.model.EmailAddress;

import java.text.SimpleDateFormat;
import java.util.*;

public class ContractUI {

    ColorController colorController = new ColorController();
    ContractController contractController = new ContractController();

    public boolean addContractUI()  {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Insert the Contract's id to be created...");
            Long contractId = in.nextLong();

            Set<Criticality> criticalities = new HashSet<>();

            Contract contract = new Contract(criticalities, ContractID.valueOf(contractId));
            if((contractController.addContract(contract)) != null){
                System.out.println("Contract added successfully");
            }

            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return false;
        }
    }
}
