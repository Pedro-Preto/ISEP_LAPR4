package eapli.base.service.application;

import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.BaseForm;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;

import java.util.List;
import java.util.Optional;

public class ServiceController {

    private final ServiceRepository serviceRepository = PersistenceContext.repositories().services();

    public Service addService(final Service service) {
        return serviceRepository.save(service);
    }

    public Optional<Service> findServiceByCode(final String code) {
        return serviceRepository.ofIdentity(Code.valueOf(code));
    }

    public Service addFormToService(BaseForm baseForm, Service service) {
        service.setBaseForm(baseForm);
        return serviceRepository.save(service);
    }

    public Service addWorkFlowToService(TaskWorkFlow taskWorkFlow, Service service) {
        service.setTaskWorkFlow(taskWorkFlow);
        return serviceRepository.save(service);
    }

    public Iterable<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> addKeywordToService() { //TODO
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Iterable<Service> getServicesByCatalogue(Catalogue catalogue) { //TODO
        return serviceRepository.findAllByCatalogue(catalogue);
    }

    public List<Service> getServicesByCatalogueWithCompleteForm(Catalogue catalogue) { //TODO
        return serviceRepository.getServicesByCatalogueWithCompleteForm(catalogue);
    }

    public List<Service> getCompletedServicesOfCatalogue(Catalogue catalogue) {
        return serviceRepository.getCompletedServicesOfCatalogue(catalogue);
    }

}
