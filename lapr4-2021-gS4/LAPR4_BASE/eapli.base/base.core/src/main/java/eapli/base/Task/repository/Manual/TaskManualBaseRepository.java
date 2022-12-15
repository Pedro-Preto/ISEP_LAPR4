package eapli.base.Task.repository.Manual;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TaskManualBaseRepository extends DomainRepository<CodeTaskManualBase, TaskManualBase> {


    public Iterable<TaskManualBase> findAll();

    public TaskManualBase getTaskByCode(CodeTaskManualBase codeTask);

    public List<TaskManualBase> getPendingTasksWithNoResponsibleCollaborator();

    public List<TaskManualBase> getAllWaitingApprovalTask();

}

