package eapli.base.form.application;

import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class TaskFormController {
    private final TaskBaseFormRepository formRepository = PersistenceContext.repositories().taskBaseForms();

    public TaskBaseForm addForm(final TaskBaseForm taskBaseForm) {
        return formRepository.save(taskBaseForm);
    }

    public Optional<TaskBaseForm> findFormById(final String id) {
        return formRepository.ofIdentity(BaseFormId.valueOf(id));
    }

    public Iterable<TaskBaseForm> getAllForms() {
        return formRepository.findAll();
    }
}
