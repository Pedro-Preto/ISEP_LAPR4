package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualRequest;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryTaskManualRequestRepository extends InMemoryDomainRepository<TaskManualRequest, CodeTaskManualRequest>
        implements TaskManualRequestRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<TaskManualRequest> getACollaboratorTasksInCourseAndUncompleted(Collaborator responsibleCollaborator) {
        return getACollaboratorTasksInCourseAndUncompleted(responsibleCollaborator);
    }

    @Override
    public List<TaskManualRequest> taskCollaboratorHistory(Collaborator collaborator) {
        return taskCollaboratorHistory(collaborator);
    }

    @Override
    public List<TaskManualRequest> getPendingTasksWithNoResponsibleCollaborator() {
        return null;
    }

    @Override
    public List<TaskManualRequest> getAllWaitingApprovalTask() {
        return null;
    }

    @Override
    public List<TaskManualRequest> getPendingTasks() {
        return getPendingTasks();
    }

    @Override
    public TaskManualRequest getTaskByCode(CodeTaskManualRequest code) {
        return getTaskByCode(code);
    }

    @Override
    public List<TaskManualRequest> allTasksHistory() {
        return allTasksHistory();
    }

    @Override
    public List<TaskManualRequest> getManualTasksOfCollaborator(Collaborator collaborator) {
        return getManualTasksOfCollaborator(collaborator);
    }
}
