package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.contract.repositories.ContractRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import java.util.List;


class JpaContractRepository extends JpaAutoTxRepository<Contract, ContractID, ContractID> implements ContractRepository {


    public JpaContractRepository(TransactionalContext autoTx) {
        super(autoTx, "contractID");
    }

    public JpaContractRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "contractID");
    }

    @Override
    public Contract findContractByID(ContractID contractID){
        try {
            List<Contract> contractList = (List<Contract>) findAll();
            Contract c1 = null;
            for (Contract c : contractList) {
                if (c.getContractID().equals(contractID))
                    c1 = c;
            }

            return c1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Contract with id " + contractID + " doesn't exist");
        }
    }


}
