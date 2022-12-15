package eapli.base.form.repositories;

import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.RequestFormId;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface RequestFormRepository extends DomainRepository<RequestFormId, RequestForm> {

    /**
     * returns the Form with the given id
     *
     * @param id
     * @return
     */
    default Optional<RequestForm> findByCode(RequestFormId id) {
        return ofIdentity(id);
    }
}
