package eapli.base.persistence.impl.inmemory;

import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.repositories.FormRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryFormRepository  extends InMemoryDomainRepository<BaseForm, BaseFormId>
        implements FormRepository {
}
