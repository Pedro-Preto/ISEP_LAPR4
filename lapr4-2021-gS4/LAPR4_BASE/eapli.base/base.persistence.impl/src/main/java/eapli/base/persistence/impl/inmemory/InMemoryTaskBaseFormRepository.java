package eapli.base.persistence.impl.inmemory;

import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskBaseFormRepository extends InMemoryDomainRepository<TaskBaseForm, BaseFormId>
        implements TaskBaseFormRepository {
}
