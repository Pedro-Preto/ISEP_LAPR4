package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JpaTaskManualBaseRepository extends JpaAutoTxRepository<TaskManualBase, CodeTaskManualBase, CodeTaskManualBase> implements TaskManualBaseRepository {


    public JpaTaskManualBaseRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaTaskManualBaseRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }


    @Override
    public List<TaskManualBase> getPendingTasksWithNoResponsibleCollaborator() {
        List<TaskManualBase> taskList = getAllWaitingApprovalTask();
        List<TaskManualBase> tasks = new ArrayList<>();
        for (TaskManualBase task : taskList) {
            if (task.getResponsibleCollaborator() == null) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    @Override
    public TaskManualBase getTaskByCode(CodeTaskManualBase codeTask) {
        List<TaskManualBase> taskList = (List<TaskManualBase>) findAll();
        TaskManualBase t = null;
        for (TaskManualBase task : taskList) {
            if (task.getCode().equals(codeTask)) {
                t = task;
            }
        }

        return t;
    }

    @Override
    public List<TaskManualBase> getAllWaitingApprovalTask() {
        List<TaskManualBase> tasks = (List<TaskManualBase>) findAll();
        List<TaskManualBase> taskList = new ArrayList<>();
        for (TaskManualBase task : tasks) {
            if (task.getTaskState() == TaskState.WaitingApproval) {
                taskList.add(task);
            }
        }

        return taskList;
    }

}
