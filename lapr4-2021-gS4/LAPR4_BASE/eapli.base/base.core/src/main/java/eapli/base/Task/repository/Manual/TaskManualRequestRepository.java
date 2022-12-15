package eapli.base.Task.repository.Manual;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.CodeTaskManualRequest;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TaskManualRequestRepository extends DomainRepository<CodeTaskManualRequest, TaskManualRequest> {

    public List<TaskManualRequest> getACollaboratorTasksInCourseAndUncompleted(Collaborator responsibleCollaborator);

    public List<TaskManualRequest> taskCollaboratorHistory(Collaborator collaborator);

    public List<TaskManualRequest> getPendingTasksWithNoResponsibleCollaborator();

    public List<TaskManualRequest> getAllWaitingApprovalTask();

    public List<TaskManualRequest> getPendingTasks();

    public TaskManualRequest getTaskByCode(CodeTaskManualRequest code);

    public List<TaskManualRequest> allTasksHistory();

    public List<TaskManualRequest>getManualTasksOfCollaborator(Collaborator collaborator);

}
