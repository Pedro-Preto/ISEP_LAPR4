package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.contract.repositories.ContractRepository;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryContractRepository extends InMemoryDomainRepository<Contract, ContractID>
        implements ContractRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Contract findContractByID(ContractID contractID) {
        return findContractByID(contractID);
    }

}
