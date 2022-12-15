package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.*;

public class JpaServiceRepository extends JpaAutoTxRepository<Service, Code, Code>
        implements ServiceRepository {

    public JpaServiceRepository(TransactionalContext autoTx) {
        super(autoTx, "code");
    }

    public JpaServiceRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "code");
    }

    @Override
    public Optional<Service> findByCode(Code code) {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceCode", code);
        return matchOne("e.title=:serviceCode", params);
    }

    @Override
    public Iterable<Service> findAllByCatalogue(Catalogue catalogue) {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceCatalogue", catalogue);
        return match("e.catalogue=:serviceCatalogue", params);
    }

    @Override
    public List<Service> getServicesByCatalogueWithCompleteForm(Catalogue catalogue) {
        List<Service> allServices = (List<Service>) findAllByCatalogue(catalogue);
        List<Service> servicesWithNoNullForm = new ArrayList<>();
        for (Service service : allServices) {
            if (service.getBaseForm() != null) {
                servicesWithNoNullForm.add(service);
            }
        }
        return servicesWithNoNullForm;
    }

    @Override
    public List<Service> getCompletedServicesOfCatalogue(Catalogue catalogue) {
        List<Service> servicesWithNoNullForm = getServicesByCatalogueWithCompleteForm(catalogue);
        List<Service> completedServices = new ArrayList<>();
        for (Service service : servicesWithNoNullForm) {
            if (service.getTaskWorkFlow() != null) {
                completedServices.add(service);
            }
        }
        return completedServices;
    }

}
