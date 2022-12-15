package eapli.base.Task.repository;

import eapli.base.Task.domain.CodeTaskWorkFlow;
import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.framework.domain.repositories.DomainRepository;

public interface TaskWorkFlowRepository extends DomainRepository<CodeTaskWorkFlow, TaskWorkFlow> {

    public Iterable<TaskWorkFlow> findAll();

    public TaskWorkFlow findByCode(CodeTaskWorkFlow codeTaskWorkFlow);
}
