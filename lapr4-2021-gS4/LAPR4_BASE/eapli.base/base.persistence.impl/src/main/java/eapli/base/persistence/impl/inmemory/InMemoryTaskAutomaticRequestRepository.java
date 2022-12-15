package eapli.base.persistence.impl.inmemory;

import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticRequest;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTaskAutomaticRequestRepository extends InMemoryDomainRepository<TaskAutomaticRequest, CodeTaskAutomaticRequest>
        implements TaskAutomaticRequestRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public TaskAutomaticRequest getByCode(CodeTaskAutomaticRequest codeTask) {
        return null;
    }
}
