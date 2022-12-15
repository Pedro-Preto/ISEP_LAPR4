package eapli.base.persistence.impl.inmemory;

import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.domain.TaskRequestForm;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRequestFormRepository extends InMemoryDomainRepository<TaskRequestForm, RequestFormId>
        implements TaskRequestFormRepository {
}
