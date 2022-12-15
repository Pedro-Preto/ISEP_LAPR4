package eapli.base.form.repositories;

import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.domain.TaskRequestForm;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TaskRequestFormRepository extends DomainRepository<RequestFormId, TaskRequestForm> {

    /**
     * returns the Form with the given id
     *
     * @param id
     * @return
     */
    default Optional<TaskRequestForm> findByCode(RequestFormId id) {
        return ofIdentity(id);
    }
}
