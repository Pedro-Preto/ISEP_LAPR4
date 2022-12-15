package eapli.base.service.repositories;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends DomainRepository<Code, Service> {

    /**
     * returns the service with the given code
     *
     * @param code
     * @return
     */
    default Optional<Service> findByCode(Code code) {
        return ofIdentity(code);
    }

    public Iterable<Service> findAllByCatalogue(Catalogue catalogue);

    public List<Service> getServicesByCatalogueWithCompleteForm(Catalogue catalogue);

    public List<Service> getCompletedServicesOfCatalogue(Catalogue catalogue);
}

