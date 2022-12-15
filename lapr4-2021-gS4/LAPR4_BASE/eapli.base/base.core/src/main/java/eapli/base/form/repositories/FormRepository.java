package eapli.base.form.repositories;

import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface FormRepository extends DomainRepository<BaseFormId, BaseForm> {

    /**
     * returns the Form with the given id
     *
     * @param id
     * @return
     */
    default Optional<BaseForm> findByCode(BaseFormId id) {
        return ofIdentity(id);
    }
}
