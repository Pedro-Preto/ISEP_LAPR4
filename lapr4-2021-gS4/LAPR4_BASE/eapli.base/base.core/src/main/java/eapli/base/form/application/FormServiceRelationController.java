package eapli.base.form.application;

import eapli.base.form.domain.BaseForm;
import eapli.base.form.repositories.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.service.repositories.ServiceRepository;

public class FormServiceRelationController {

    private final FormRepository formRepository = PersistenceContext.repositories().forms();
    private final ServiceRepository serviceRepository = PersistenceContext.repositories().services();

    public Service addFormToService(final BaseForm baseForm, final Service service) {
        service.setBaseForm(baseForm);
        return serviceRepository.save(service);
    }

    public BaseForm getFormOfService(final Service service) {
        return service.getBaseForm();
    }

}
