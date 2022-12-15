package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryServiceRepository extends InMemoryDomainRepository<Service, Code>
        implements ServiceRepository {

    @Override
    public Optional<Service> findByCode(Code code) {
        return matchOne(e -> e.code().equals(code));
    }

    @Override
    public Iterable<Service> findAllByCatalogue(Catalogue catalogue) {
        //TODO find by catalogue
        return null;
    }

    @Override
    public List<Service> getServicesByCatalogueWithCompleteForm(Catalogue catalogue) {
        return getServicesByCatalogueWithCompleteForm(catalogue);
    }

    @Override
    public List<Service> getCompletedServicesOfCatalogue(Catalogue catalogue) {
        return null;
    }
}
