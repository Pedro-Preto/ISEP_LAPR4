package eapli.base.Task.application;

import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.CodeTaskWorkFlow;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.Task.repository.TaskWorkFlowRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;

import java.util.List;
import java.util.Set;

public class TaskWorkFlowController {
    private final TaskWorkFlowRepository taskWorkFlowRepository = PersistenceContext.repositories().workflows();


    public List<TaskWorkFlow> getAllWorkFlows() {
        return (List<TaskWorkFlow>) taskWorkFlowRepository.findAll();
    }

    public TaskWorkFlow addWorkFlow(CodeTaskWorkFlow codeTaskWorkFlow, Set<TaskManualBase> taskManuals, Set<TaskAutomaticBase> taskAutomatics) {
        TaskWorkFlow taskWorkFlow = new TaskWorkFlow(codeTaskWorkFlow, taskManuals, taskAutomatics);
        return taskWorkFlowRepository.save(taskWorkFlow);
    }

    public boolean addTaskToWorkFlow(TaskManualBase task, TaskWorkFlow taskWorkFlow) {
        taskWorkFlow.addManualTasksToWorkFlow(task);
        return true;
    }

    public boolean addTaskToWorkFlow(TaskAutomaticBase task, TaskWorkFlow taskWorkFlow) {
        taskWorkFlow.addAutomaticTasksToWorkFlow(task);
        return true;
    }

    public TaskWorkFlow getWorkFlowOfService(final Service service) {
        return service.getTaskWorkFlow();
    }

    public TaskWorkFlow getWorkFlowByCode(final CodeTaskWorkFlow codeTaskWorkFlow) {
        return taskWorkFlowRepository.findByCode(codeTaskWorkFlow);
    }
}
