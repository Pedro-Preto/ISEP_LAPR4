package eapli.base.contract.repositories;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ContractRepository extends DomainRepository<ContractID, Contract> {

    Contract findContractByID(ContractID contractID);

}
