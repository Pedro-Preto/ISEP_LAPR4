package eapli.base.Request.application;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.Request.model.RequestState;
import eapli.base.Request.repository.RequestRepository;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.TaskRequestForm;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RequestController {

    private final RequestRepository requestRepository = PersistenceContext.repositories().requests();
    private final TaskManualRequestRepository taskManualRequestRepository = PersistenceContext.repositories().taskManualRequest();
    private final TaskAutomaticRequestRepository taskAutomaticRequestRepository = PersistenceContext.repositories().taskAutomaticRequest();
    private final TaskRequestFormRepository taskRequestFormRepository = PersistenceContext.repositories().taskRequestForms();

    private final CollaboratorController collaboratorController = new CollaboratorController();
    private final TaskManualRequestController taskManualRequestController = new TaskManualRequestController();

    public Request makeRequest(CodeRequest codeRequest, Service service, RequestForm requestForm, Collaborator requester, Collaborator beneficiary) {
        Date date1 = new Date();
        Request request = new Request(codeRequest, service, date1, RequestState.ON_COURSE, requester, beneficiary, requestForm, null);
        for (TaskManualBase tmb : service.getTaskWorkFlow().getManualTasksSet()) {
            addManualTaskToRequest(tmb, request);
        }
        for (TaskAutomaticBase tab : service.getTaskWorkFlow().getAutomaticTasksSet()) {
            addAutomaticTaskToRequest(tab, request);
        }
        return requestRepository.save(request);
    }

    public void addManualTaskToRequest(TaskManualBase task, Request request) {
        Collaborator col = taskManualRequestController.getCollaboratorByTaskAttributionTime(request);
        // Collaborator col = taskManualRequestController.getCollaboratorWithLessTaskTime(request);
        TaskRequestForm taskRequestForm = new TaskRequestForm(task.getTaskBaseForm(), request.getCodeRequest().toString());
        taskRequestFormRepository.save(taskRequestForm);
        TaskManualRequest requestTask = new TaskManualRequest(task, request.identity().toString(), col, taskRequestForm);
        taskManualRequestRepository.save(requestTask);
        request.addManualTask(requestTask);
    }

    public void addAutomaticTaskToRequest(TaskAutomaticBase task, Request request) {
        TaskAutomaticRequest requestTask = new TaskAutomaticRequest(task, request.identity().toString());
        taskAutomaticRequestRepository.save(requestTask);
        request.addAutomaticTask(requestTask);

    }

    public Request terminateRequestsWithAllTasksCompleted() {
        List<Request> requestList = getAllRequests();
        for (Request request : requestList) {
            if ((allManualTasksOfRequestAreDone(request.getManualTasks()) && allAutomaticTasksOfRequestAreDone(request.getAutomaticTasks())) == true) {
                request.setRequestState(RequestState.TERMINATED);
                Date date = new Date();
                request.setCompletionDate(date);
                return requestRepository.save(request);
            }
        }
        return null;
    }

    public Request setGrade(Request request) {
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return (List<Request>) requestRepository.findAll();
    }

    public Request getRequestByCode(CodeRequest code) {
        return requestRepository.findByCode(code);
    }

    public List<Request> getActiveRequestsByRequester(Collaborator collaborator) {
        List<Request> aux = requestRepository.findByRequester(collaborator);
        List<Request> activeReq = new LinkedList<>();
        for (Request r : aux) {
            if (r.getRequestState().equals(RequestState.ON_COURSE)) {
                activeReq.add(r);
            }
        }
        return activeReq;
    }

    public List<Request> getActiveRequestsByBeneficiary(Collaborator collaborator) {
        List<Request> aux = requestRepository.findByBeneficiary(collaborator);
        List<Request> activeReq = new LinkedList<>();
        for (Request r : aux) {
            if (r.getRequestState().equals(RequestState.ON_COURSE)) {
                activeReq.add(r);
            }
        }
        return activeReq;
    }

    public List<Request> getTerminatedRequestsByRequester(Collaborator collaborator) {
        List<Request> aux = requestRepository.findByRequester(collaborator);
        List<Request> activeReq = new LinkedList<>();
        for (Request r : aux) {
            if (r.getRequestState().equals(RequestState.TERMINATED)) {
                activeReq.add(r);
            }
        }
        return activeReq;
    }

    public List<Request> getTerminatedRequestsByBeneficiary(Collaborator collaborator) {
        List<Request> aux = requestRepository.findByBeneficiary(collaborator);
        List<Request> activeReq = new LinkedList<>();
        for (Request r : aux) {
            if (r.getRequestState().equals(RequestState.TERMINATED)) {
                activeReq.add(r);
            }
        }
        return activeReq;
    }

    public List<Request> getAllTerminatedRequestOfUserWithNoGrade(Collaborator collaborator) {
        return requestRepository.findTerminatedRequestOfUserWithNoGrade(collaborator);
    }

    public List<Request> getAllTerminatedRequestOfUserWithGrade(Collaborator collaborator) {
        return requestRepository.findTerminatedRequestOfUserWithGrade(collaborator);
    }

    public List<Request> getAllTerminatedRequests() {
        return requestRepository.findTerminatedRequests();
    }

    private boolean allManualTasksOfRequestAreDone(List<TaskManualRequest> taskManualRequests) {
        int count = 0;
        for (TaskManualRequest tt : taskManualRequests) {
            if (tt.getTaskState() == TaskState.Completed) {
                count++;
            }
        }
        if (count == taskManualRequests.size()) {
            return true;
        } else return false;
    }

    public boolean allAutomaticTasksOfRequestAreDone(List<TaskAutomaticRequest> taskAutomaticRequests) {
        int count = 0;
        for (TaskAutomaticRequest tt : taskAutomaticRequests) {
            if (tt.getTaskState() == TaskState.Completed) {
                count++;
            }
        }
        if (count == taskAutomaticRequests.size()) {
            return true;
        } else return false;
    }

    public double calculateCompletionTime(Request request) {

        Date d1 = request.getRequestDate();
        Date d2 = request.getCompletionDate();

        Duration difference = Duration.between(d1.toInstant(), d2.toInstant());

        return difference.toMinutes();
    }
}


