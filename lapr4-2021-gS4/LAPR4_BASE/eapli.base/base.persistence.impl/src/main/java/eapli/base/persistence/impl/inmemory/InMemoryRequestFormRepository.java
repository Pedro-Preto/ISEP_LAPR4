package eapli.base.persistence.impl.inmemory;

import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.repositories.RequestFormRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryRequestFormRepository extends InMemoryDomainRepository<RequestForm, RequestFormId>
        implements RequestFormRepository {

}
