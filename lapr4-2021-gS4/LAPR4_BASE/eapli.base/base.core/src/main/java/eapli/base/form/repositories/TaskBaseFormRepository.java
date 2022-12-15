package eapli.base.form.repositories;

import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TaskBaseFormRepository extends DomainRepository<BaseFormId, TaskBaseForm> {

    /**
     * returns the Form with the given id
     *
     * @param id
     * @return
     */
    default Optional<TaskBaseForm> findByCode(BaseFormId id) {
        return ofIdentity(id);
    }
}
