package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCriticalityRepository  extends InMemoryDomainRepository<Criticality, CriticalityID>
        implements CriticalityRepository {


    @Override
    public Optional<Criticality> findByCriticalityId(CriticalityID id) {
        return matchOne(e -> e.id().equals(id));
    }
}
