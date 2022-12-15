package eapli.base.persistence.impl.inmemory;

import eapli.base.Task.domain.CodeTaskWorkFlow;
import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.Task.repository.TaskWorkFlowRepository;

import eapli.base.TeamType.domain.CodeTeamType;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskWorkFlowCodeRepository extends InMemoryDomainRepository<TaskWorkFlow, CodeTaskWorkFlow>
        implements TaskWorkFlowRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public TaskWorkFlow findByCode(CodeTaskWorkFlow codeTaskWorkFlow) {
        return findByCode(codeTaskWorkFlow);
    }
}
