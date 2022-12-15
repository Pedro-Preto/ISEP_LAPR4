package eapli.base.Task.application.Manual;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.Request;
import eapli.base.Task.domain.Manual.*;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
import eapli.base.Team.application.TeamController;
import eapli.base.Utils.CollaboratorTaskATComparator;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.*;

public class TaskManualRequestController {

    private final TaskManualRequestRepository taskRepository = PersistenceContext.repositories().taskManualRequest();
    public TeamController teamController = new TeamController();
    public CollaboratorController collaboratorController = new CollaboratorController();
    public CollaboratorTaskATComparator comparator = new CollaboratorTaskATComparator();

    public TaskManualRequest claimTask(TaskManualRequest task, Collaborator collaborator) {
        Date date = new Date();
        task.setResponsibleCollaborator(collaborator);
        task.setAttributionDate(date);
        task.setTaskState(TaskState.Uncompleted);
        return taskRepository.save(task);
    }

    public List<TaskManualRequest> getAllIncompleteTasksWithNoResponsibleCollaborator() {
        return taskRepository.getPendingTasksWithNoResponsibleCollaborator();
    }

    public TaskManualRequest completeManualPendingTask(TaskManualRequest taskManualRequest) {
        taskManualRequest.setTaskState(TaskState.Completed);
        return taskRepository.save(taskManualRequest);
    }


    public List<TaskManualRequest> getAllTasks() {
        return (List<TaskManualRequest>) taskRepository.findAll();
    }

    public TaskManualRequest getTaskByCode(CodeTaskManualRequest code) {
        return taskRepository.getTaskByCode(code);
    }

    public List<TaskManualRequest> getCollaboratorTasksInCourseAndUncompleted(Collaborator responsibleCollaborator) {
        return taskRepository.getACollaboratorTasksInCourseAndUncompleted(responsibleCollaborator);
    }

    public List<TaskManualRequest> getTaskCollaboratorHistory(Collaborator collaborator) {
        return taskRepository.taskCollaboratorHistory(collaborator);
    }

    public List<TaskManualRequest>getManualTasksOfCollaborator(Collaborator collaborator){
        return taskRepository.getManualTasksOfCollaborator(collaborator);
    }


    public List<TaskManualRequest> getPendingTasks() {
        return taskRepository.getPendingTasks();
    }

    public List<Collaborator> getCollaboratorsWithTasks() {
        List<TaskManualRequest> allTasks = getAllTasks();
        List<Collaborator> collaboratorList = new ArrayList<>();
        for (TaskManualRequest taskManuales : allTasks) {
            if (taskManuales.getResponsibleCollaborator() != null) {
                collaboratorList.add(taskManuales.getResponsibleCollaborator());
            }
        }
        return collaboratorList;
    }

    public List<TaskManualRequest> getAllTasksWithResponsibleCollaborator() {
        List<TaskManualRequest> taskManualRequests = new LinkedList<>();
        for (TaskManualRequest taskManualRequest : getAllTasks()) {
            if (taskManualRequest.getResponsibleCollaborator() != null) {
                taskManualRequests.add(taskManualRequest);
            }
        }
        return taskManualRequests;
    }


    public List<Map.Entry<Collaborator, Date>> collaboratorsTasksAttributionDate() {
        List<Map.Entry<Collaborator, Date>> collaboratorDateMap = new LinkedList<>();
        List<TaskManualRequest> taskManualRequests = getAllTasksWithResponsibleCollaborator();
        int index;
        for (TaskManualRequest tt : taskManualRequests) {
            if (doesContainCollaborator(collaboratorDateMap, null, tt.getResponsibleCollaborator())) {
                index = positionOfCollaborator(collaboratorDateMap, null, tt.getResponsibleCollaborator());
                if (tt.getAttributionDate().after(collaboratorDateMap.get(index).getValue())) {
                    collaboratorDateMap.get(index).setValue(tt.getAttributionDate());
                }
            } else {
                Map<Collaborator, Date> map = new HashMap<>();
                map.put(tt.getResponsibleCollaborator(), tt.getAttributionDate());

                for (Map.Entry<Collaborator, Date> entry : map.entrySet()) {
                    collaboratorDateMap.add(entry);
                }
            }
        }


        return collaboratorDateMap;
    }


    public Collaborator getCollaboratorByTaskAttributionTime(Request request) {
        List<Collaborator> allCollaborators = collaboratorController.getAllCollaborators();
        List<Collaborator> collaboratorsWithTasks = getCollaboratorsWithTasks();
        for (Collaborator collaborator : allCollaborators) {
            if ((!collaboratorsWithTasks.contains(collaborator)) && collaboratorController.isCollaboratorInsertOnSetOfTeamsOfCatalogue(collaborator, request.getService().getCatalogue().getAllowedTeamList())) {
                return collaborator;
            }
        }
        List<Map.Entry<Collaborator, Date>> collaboratorsTasksAttributionDate = collaboratorsTasksAttributionDate();


        return comparator.getCollaboratorByAttributionDate(collaboratorsTasksAttributionDate);
    }

    public Collaborator getCollaboratorWithLessTaskTime(Request request) {
        List<Collaborator> allCollaborators = collaboratorController.getAllCollaborators();
        List<Collaborator> collaboratorsWithTasks = getCollaboratorsWithTasks();
        for (Collaborator collaborator : allCollaborators) {
            if ((!collaboratorsWithTasks.contains(collaborator)) && collaboratorController.isCollaboratorInsertOnSetOfTeamsOfCatalogue(collaborator, request.getService().getCatalogue().getAllowedTeamList())) {
                return collaborator;
            }
        }
        List<Map.Entry<Collaborator, Integer>> collaboratorsTasksLessTaskTime = collaboratorsTasksLessTaskTime();

        return comparator.getCollaboratorByLessTime(collaboratorsTasksLessTaskTime);
    }

    public List<Map.Entry<Collaborator, Integer>> collaboratorsTasksLessTaskTime() {

        List<Map.Entry<Collaborator, Integer>> collaboratorTimeMap = new LinkedList<>();
        List<TaskManualRequest> taskManualRequests = getAllTasksWithResponsibleCollaborator();
        int index;
        int value;
        for (TaskManualRequest tt : taskManualRequests) {
            if (doesContainCollaborator(null, collaboratorTimeMap, tt.getResponsibleCollaborator())) {
                index = positionOfCollaborator(null, collaboratorTimeMap, tt.getResponsibleCollaborator());
                value = collaboratorTimeMap.get(index).getValue() + tt.getStandardResolutionTime();
                collaboratorTimeMap.get(index).setValue(value);
            } else {
                Map<Collaborator, Integer> map = new HashMap<>();
                map.put(tt.getResponsibleCollaborator(), tt.getStandardResolutionTime());

                for (Map.Entry<Collaborator, Integer> entry : map.entrySet()) {
                    collaboratorTimeMap.add(entry);
                }
            }
        }
        return collaboratorTimeMap;
    }


    //TODO:Métodos auxiliares
    private boolean doesContainCollaborator(List<Map.Entry<Collaborator, Date>> entryList1, List<Map.Entry<Collaborator, Integer>> entryList2, Collaborator collaborator) {
        List<Collaborator> collaboratorList = new LinkedList<>();

        if (entryList2 == null) {
            for (Map.Entry<Collaborator, Date> entryListy : entryList1) {
                collaboratorList.add(entryListy.getKey());
            }
            if (collaboratorList.contains(collaborator)) {
                return true;
            }
            return false;
        } else {
            for (Map.Entry<Collaborator, Integer> entryListy : entryList2) {
                collaboratorList.add(entryListy.getKey());
            }
            if (collaboratorList.contains(collaborator)) {
                return true;
            }
            return false;
        }
    }

    private int positionOfCollaborator(List<Map.Entry<Collaborator, Date>> entryList1, List<Map.Entry<Collaborator, Integer>> entryList2, Collaborator collaborator) {
        int position = 0;
        if (entryList2 == null) {
            for (Map.Entry<Collaborator, Date> entryListy : entryList1) {
                if (entryListy.getKey().getNumMechanographic().equals(collaborator.getNumMechanographic())) {
                    position = entryList1.indexOf(entryListy);
                }
            }
            return position;
        } else {
            for (Map.Entry<Collaborator, Integer> entryListy : entryList2) {
                if (entryListy.getKey().getNumMechanographic().equals(collaborator.getNumMechanographic())) {
                    position = entryList2.indexOf(entryListy);
                }
            }
            return position;
        }
    }

    public TaskManualRequest save(TaskManualRequest task) {
        return taskRepository.save(task);
    }
}




