package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.contract.application.ContractController;
import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContractsBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

    private final ContractController contractController = new ContractController();
    private final CriticalityController criticalityController = new CriticalityController();

    @Override
    public boolean execute() {

        /* ----------------------------------------------- CONTRACT 1 ----------------------------------------------- */
        List<Criticality> criticalityList = criticalityController.getAllCriticalities();
        Set<Criticality> criticality1 = new HashSet<>();
        criticality1.add(criticalityList.get(0));
        criticality1.add(criticalityList.get(1));
        Contract contract1 = new Contract(criticality1, new ContractID(101L));

        addContract(contract1);


        /* ----------------------------------------------- CONTRACT 2 ----------------------------------------------- */
        Set<Criticality> criticality2 = new HashSet<>();
        criticality2.add(criticalityList.get(2));
        criticality2.add(criticalityList.get(1));
        Contract contract2 = new Contract(criticality2, new ContractID(102L));

        addContract(contract2);


        /* ----------------------------------------------- CONTRACT 3 ----------------------------------------------- */
        Set<Criticality> criticality3 = new HashSet<>();
        criticality3.add(criticalityList.get(0));
        criticality3.add(criticalityList.get(2));
        Contract contract3 = new Contract(criticality3, new ContractID(103L));

        addContract(contract3);


        /* ----------------------------------------------- CONTRACT 4 ----------------------------------------------- */
        Set<Criticality> criticality4 = new HashSet<>();
        criticality4.add(criticalityList.get(2));
        criticality4.add(criticalityList.get(1));
        Contract contract4 = new Contract(criticality4, new ContractID(104L));

        addContract(contract4);


        /* ----------------------------------------------- CONTRACT 5 ----------------------------------------------- */
        Set<Criticality> criticality5 = new HashSet<>();
        criticality5.add(criticalityList.get(0));
        criticality5.add(criticalityList.get(3));
        Contract contract5 = new Contract(criticality5, new ContractID(101L));

        addContract(contract5);


        /* ----------------------------------------------- CONTRACT 6 ----------------------------------------------- */
        Set<Criticality> criticality6 = new HashSet<>();
        criticality6.add(criticalityList.get(3));
        criticality6.add(criticalityList.get(1));
        Contract contract6 = new Contract(criticality6, new ContractID(101L));

        addContract(contract6);
        System.out.println("========================");
        System.out.println("Bootstrapping Contracts...");
        System.out.println("========================");
        return true;
    }

    private boolean addContract(Contract contract) {
        try {
            contractController.addContract(contract);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", contract);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
