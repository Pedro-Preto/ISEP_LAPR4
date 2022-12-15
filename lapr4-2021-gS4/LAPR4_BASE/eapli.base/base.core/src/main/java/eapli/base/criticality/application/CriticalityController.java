package eapli.base.criticality.application;

import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CriticalityController {

    private final CriticalityRepository criticalityRepository = PersistenceContext.repositories().criticalities();

    public Criticality addCriticality(final Criticality criticality) { //TODO verificar se os controllers ja recebem os objetos instanciados
        return criticalityRepository.save(criticality);
    }

    public Optional<Criticality> findCriticalityByID(final Long id) {
        return criticalityRepository.findByCriticalityId(CriticalityID.valueOf(id));
    }

    public List<Criticality> getAllCriticalities() {
        return (List<Criticality>) criticalityRepository.findAll();
    }
}
