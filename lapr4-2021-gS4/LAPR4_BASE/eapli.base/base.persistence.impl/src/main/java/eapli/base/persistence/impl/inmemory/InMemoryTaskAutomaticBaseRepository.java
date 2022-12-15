package eapli.base.persistence.impl.inmemory;

import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskAutomaticBaseRepository extends InMemoryDomainRepository<TaskAutomaticBase, CodeTaskAutomaticBase>
        implements TaskAutomaticBaseRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public TaskAutomaticBase getTaskAutomaticByCode(CodeTaskAutomaticBase codeTask) {
        return getTaskAutomaticByCode(codeTask);
    }
}



