package eapli.base.Task.application.Automatic;

import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.Script;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.*;

public class TaskAutomaticBaseController {
    private final TaskAutomaticBaseRepository taskRepository = PersistenceContext.repositories().tasksAutomatic();

    public TaskAutomaticBase addAutomaticTask(CodeTaskAutomaticBase codeTask, String description, Date date, Script script, int standardResolutionTime) {
        TaskAutomaticBase taskAutomatic = new TaskAutomaticBase(codeTask, description, script, TaskState.WaitingApproval, date, standardResolutionTime);
        return taskRepository.save(taskAutomatic);
    }

    public TaskAutomaticBase changeTaskState(TaskAutomaticBase task, TaskState state) {
        task.setTaskState(state);
        return taskRepository.save(task);
    }

    public List<TaskAutomaticBase> getUncompletedTasks() {
        List<TaskAutomaticBase> uncompletedTasks = new ArrayList<>();
        for (TaskAutomaticBase task : taskRepository.findAll()) {
            if (task.getTaskState().equals(TaskState.Uncompleted)) {
                uncompletedTasks.add(task);
            }
        }
        return uncompletedTasks;
    }

    public List<TaskAutomaticBase> getAllAutomaticTasks() {
        return (List<TaskAutomaticBase>) taskRepository.findAll();

    }
    
    public TaskAutomaticBase getTaskAutomaticByCode(CodeTaskAutomaticBase codeTask) {
        return taskRepository.getTaskAutomaticByCode(codeTask);
    }

}
