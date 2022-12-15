package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryTaskManualBaseRepository extends InMemoryDomainRepository<TaskManualBase, CodeTaskManualBase>
        implements TaskManualBaseRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public List<TaskManualBase> getPendingTasksWithNoResponsibleCollaborator() {
        return getPendingTasksWithNoResponsibleCollaborator();
    }

    @Override
    public TaskManualBase getTaskByCode(CodeTaskManualBase codeTask) {
        return getTaskByCode(codeTask);
    }

    @Override
    public List<TaskManualBase> getAllWaitingApprovalTask() {
        return getAllWaitingApprovalTask();
    }


}
