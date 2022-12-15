package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.*;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaTaskManualRequestRepository extends JpaAutoTxRepository<TaskManualRequest, CodeTaskManualRequest, CodeTaskManualRequest> implements TaskManualRequestRepository {


    public JpaTaskManualRequestRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaTaskManualRequestRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }

    @Override
    public List<TaskManualRequest> getACollaboratorTasksInCourseAndUncompleted(Collaborator responsibleCollaborator) {
        final Map<String, Object> params = new HashMap<>();
        params.put("InCourse", TaskState.InCourse);
        params.put("Uncompleted", TaskState.Uncompleted);
        params.put("responsible", responsibleCollaborator);
        List<TaskManualRequest> taskManuals = match("e.responsibleCollaborator=:responsible AND (e.taskState =:InCourse OR e.taskState =:Uncompleted)", params);
        return taskManuals;

    }

    @Override
    public List<TaskManualRequest> getPendingTasksWithNoResponsibleCollaborator() {
        List<TaskManualRequest> taskList = getAllWaitingApprovalTask();
        List<TaskManualRequest> tasks = new ArrayList<>();
        for (TaskManualRequest task : taskList) {
            if (task.getResponsibleCollaborator() == null) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    @Override
    public List<TaskManualRequest> getAllWaitingApprovalTask() {
        List<TaskManualRequest> tasks = (List<TaskManualRequest>) findAll();
        List<TaskManualRequest> taskList = new ArrayList<>();
        for (TaskManualRequest task : tasks) {
            if (task.getTaskState() == TaskState.WaitingApproval) {
                taskList.add(task);
            }
        }

        return taskList;
    }


    @Override
    public List<TaskManualRequest> taskCollaboratorHistory(Collaborator collaborator) {
        final Map<String, Object> params = new HashMap<>();
        params.put("responsible", collaborator);
        params.put("Completed", TaskState.Completed);

        List<TaskManualRequest> taskManuals = match("e.responsibleCollaborator=:responsible AND e.taskState =:Completed", params);
        return taskManuals;
    }

    @Override
    public List<TaskManualRequest> getPendingTasks() {
        final Map<String, Object> params = new HashMap<>();
        params.put("InCourse", TaskState.InCourse);
        params.put("Uncompleted", TaskState.Uncompleted);

        List<TaskManualRequest> taskManuals = match("e.taskState =:InCourse OR e.taskState =:Uncompleted", params);
        return taskManuals;
    }

    @Override
    public TaskManualRequest getTaskByCode(CodeTaskManualRequest code) {
        List<TaskManualRequest> taskList = (List<TaskManualRequest>) findAll();
        TaskManualRequest t = null;
        for (TaskManualRequest task : taskList) {
            if (task.getCode().equals(code)) {
                t = task;
            }
        }

        return t;
    }

    @Override
    public List<TaskManualRequest> allTasksHistory() {
        final Map<String, Object> params = new HashMap<>();
        params.put("Completed", TaskState.Completed);

        List<TaskManualRequest> taskManuals = match("e.taskState =:Completed", params);
        return taskManuals;
    }

    @Override
    public List<TaskManualRequest> getManualTasksOfCollaborator(Collaborator collaborator) {
        final Map<String, Object> params = new HashMap<>();
        params.put("responsible", collaborator);
        List<TaskManualRequest> taskManuals = match("e.responsibleCollaborator=:responsible", params);
        return taskManuals;
    }
}

