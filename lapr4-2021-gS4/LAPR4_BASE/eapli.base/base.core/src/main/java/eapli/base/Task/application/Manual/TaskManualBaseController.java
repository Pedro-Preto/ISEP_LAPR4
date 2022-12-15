package eapli.base.Task.application.Manual;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.base.Team.application.TeamController;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.*;

public class TaskManualBaseController {
    private final TaskManualBaseRepository taskRepository = PersistenceContext.repositories().tasksManual();
    CollaboratorController collaboratorController = new CollaboratorController();
    TeamController teamController = new TeamController();
    TaskManualRequestController taskManualResquestController = new TaskManualRequestController();

    public List<TaskManualBase> getAllTasks() {
        return (List<TaskManualBase>) taskRepository.findAll();
    }

    public TaskManualBase getTaskByCode(CodeTaskManualBase codeTask) {
        return taskRepository.getTaskByCode(codeTask);
    }

    public TaskManualBase addManualTask(CodeTaskManualBase code, String description, Date limitDate, int standartResolutionTime, Date attributionDate) {
        TaskManualBase task = new TaskManualBase(code, description, null, TaskState.WaitingApproval, limitDate, standartResolutionTime, attributionDate);
        return taskRepository.save(task);
    }
/*
    public TaskManualBase addManualPendingTask(TaskManualRequest task, Collaborator collaborator) {
        taskManualResquestController.redeemTask(task, collaborator);
        return taskRepository.save(task);
    }

*/

    public List<TaskManualBase> getAllUncumpletedTasksWithNoResponsibleCollaborator() {
        return taskRepository.getPendingTasksWithNoResponsibleCollaborator();
    }

    public List<TaskManualBase> getAllWaitingApprovalTask() {
        return taskRepository.getAllWaitingApprovalTask();
    }

    public TaskManualBase addFormToManualTask(TaskBaseForm taskBaseForm, TaskManualBase taskManualBase){
        taskManualBase.setTaskBaseForm(taskBaseForm);
        return this.taskRepository.save(taskManualBase);
    }
    public Collaborator getCollaboratorWithLessTasks() {
        Collaborator lessTaskCollaborator;//Return Collaborator
        Map<Collaborator, Integer> allCollaborators = new HashMap<>();//Map Com Todos os Collaborators
        List<Collaborator> allColabs = collaboratorController.getAllCollaborators();//List Com Todos os Collaborators
        List<TaskManualBase> taskManual = getAllTasks();//List das Tasks Todas
        List<Collaborator> tasksWithCollaborators = new LinkedList<>();//List Dos Collaborators com tasks

        for (TaskManualBase taskManuales : taskManual) {
            if (taskManuales.getResponsibleCollaborator() != null) {
                tasksWithCollaborators.add(taskManuales.getResponsibleCollaborator());
            }
        }

        for (int i = 0; i < allColabs.size(); i++) {
            allCollaborators.put(allColabs.get(i), i);
        }

        List<Map.Entry<Collaborator, Integer>> entryList = new LinkedList<>(allCollaborators.entrySet());
        for (Map.Entry<Collaborator, Integer> setValues : entryList) {
            if (setValues.getValue() != 0) {
                setValues.setValue(0);
            }
        }


        int value;
        if (!tasksWithCollaborators.isEmpty()) {

            for (TaskManualBase taskManuales : taskManual) {
                if (taskManuales.getResponsibleCollaborator() != null) {
                    for (Map.Entry<Collaborator, Integer> entryListy : entryList) {
                        if (entryListy.getKey().getNumMechanographic().equals(taskManuales.getResponsibleCollaborator().getNumMechanographic())) {
                                value = entryListy.getValue() + 1;
                                entryListy.setValue(value);
                        }
                    }
                }
            }
            Collections.sort(entryList, new Comparator<Map.Entry<Collaborator, Integer>>() {
                @Override
                public int compare(Map.Entry<Collaborator, Integer> o1, Map.Entry<Collaborator, Integer> o2) {
                    return o1.getValue() - o2.getValue();

                }
            });
            lessTaskCollaborator = entryList.get(0).getKey();

        } else {
            lessTaskCollaborator = allColabs.get(0);

        }

        return lessTaskCollaborator;
    }
}
