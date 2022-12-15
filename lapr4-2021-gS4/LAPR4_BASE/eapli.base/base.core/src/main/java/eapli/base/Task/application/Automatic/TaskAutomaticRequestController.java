package eapli.base.Task.application.Automatic;

import eapli.base.Request.application.RequestController;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticRequest;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class TaskAutomaticRequestController {

    private final TaskAutomaticRequestRepository taskRepository = PersistenceContext.repositories().taskAutomaticRequest();
    private final RequestController requestController = new RequestController();

    public List<TaskAutomaticRequest> getUncompletedTasks() {
        List<TaskAutomaticRequest> uncompletedTasks = new ArrayList<>();
        for (TaskAutomaticRequest task : taskRepository.findAll()) {
            if (task.getTaskState().equals(TaskState.Uncompleted)) {
                uncompletedTasks.add(task);
            }
        }
        return uncompletedTasks;
    }

    public List<TaskAutomaticRequest> getUncompletedAndInCourseTasks() {
        List<TaskAutomaticRequest> uncompletedTasks = new ArrayList<>();
        for (TaskAutomaticRequest task : taskRepository.findAll()) {
            if (task.getTaskState().equals(TaskState.InCourse) || task.getTaskState().equals(TaskState.Uncompleted)) {
                uncompletedTasks.add(task);
            }
        }
        return uncompletedTasks;
    }

    public void completeTask(TaskAutomaticRequest task) {
        task.setTaskState(TaskState.Completed);
        taskRepository.save(task);
    }

    public List<TaskAutomaticRequest> getAllTasks() {
        return (List<TaskAutomaticRequest>) taskRepository.findAll();
    }

    public void setInCourse(TaskAutomaticRequest task) {
        task.setTaskState(TaskState.InCourse);
        taskRepository.save(task);
    }

    public TaskAutomaticRequest getTaskByCode(CodeTaskAutomaticRequest codeTask) {
        return taskRepository.getByCode(codeTask);
    }


}
