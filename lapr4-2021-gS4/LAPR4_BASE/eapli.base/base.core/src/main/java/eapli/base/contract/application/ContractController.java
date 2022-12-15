package eapli.base.contract.application;

import eapli.base.contract.domain.Contract;
import eapli.base.contract.domain.ContractID;
import eapli.base.contract.repositories.ContractRepository;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ContractController {

    private final ContractRepository contractRepository = PersistenceContext.repositories().contracts();
    private final CriticalityRepository criticalityRepository = PersistenceContext.repositories().criticalities();


    public Contract addContract(final Contract contract) { //TODO verificar se os controllers ja recebem os objetos instanciados
        return contractRepository.save(contract);
    }

    public Contract addCriticalityToContract(final Criticality criticality, final Long contractId){
        Contract contract = contractRepository.findContractByID(ContractID.valueOf(contractId));
        contract.getCriticalities().add(criticality);
        return contractRepository.save(contract);
    }


    public List<Contract> getAllContracts(){
        return (List<Contract>) contractRepository.findAll();
    }

    public Contract getContractByID(final Long id){
        return contractRepository.findContractByID(ContractID.valueOf((id)));
    }

    public Criticality getCriticalityByID(final Long id){
        return criticalityRepository.findByCriticalityId(CriticalityID.valueOf(id)).orElse(null);
    }

    public Set<Criticality> getCriticalitiesByContract(final Contract contract){
        return contract.getCriticalities();
    }
}
