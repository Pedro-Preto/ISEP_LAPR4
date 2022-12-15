package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.Request.model.RequestState;
import eapli.base.Request.repository.RequestRepository;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.form.repositories.FormRepository;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Service;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.*;

public class JpaRequestRepository extends JpaAutoTxRepository<Request, CodeRequest, CodeRequest> implements RequestRepository {

    public JpaRequestRepository(TransactionalContext autoTx) {
        super(autoTx, "requestCode");
    }

    public JpaRequestRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "requestCode");
    }

    @Override
    public Request findByCode(CodeRequest code) {
        List<Request> requests = (List<Request>) findAll();
        Request request = null;
        for (Request r : requests) {
            if (r.getCodeRequest().equals(code)) {
                request = r;
            }
        }
        return request;
    }

    @Override
    public List<Request> findByRequester(Collaborator collaborator) {
        List<Request> requests = (List<Request>) findAll();
        List<Request> list = new LinkedList<>();
        for (Request r : requests) {
            if (r.getRequester().equals(collaborator)) {
                list.add(r);
            }
        }
        return list;
    }

    @Override
    public List<Request> findByBeneficiary(Collaborator collaborator) {
        List<Request> requests = (List<Request>) findAll();
        List<Request> list = new LinkedList<>();
        for (Request r : requests) {
            if (r.getBeneficiary().equals(collaborator)) {
                list.add(r);
            }
        }
        return list;
    }

    @Override
    public List<Request> findTerminatedRequestOfUserWithNoGrade(Collaborator collaborator) {
        List<Request> requests = (List<Request>) findAll();
        List<Request> list = new LinkedList<>();
        for (Request r : requests) {
            if (r.getRequestGrade() == null)
                if (r.getRequester().equals(collaborator) && r.getRequestState() == RequestState.TERMINATED) {
                    list.add(r);
                }
        }
        return list;
    }

    @Override
    public List<Request> findTerminatedRequestOfUserWithGrade(Collaborator collaborator) {
        List<Request> requests = (List<Request>) findAll();
        List<Request> list = new LinkedList<>();
        for (Request r : requests) {
            if (r.getRequestGrade() != null)
                if (r.getRequester().equals(collaborator) && r.getRequestState() == RequestState.TERMINATED) {
                    list.add(r);
                }
        }
        return list;
    }

    @Override
    public List<Request> findTerminatedRequests() {
        final Map<String, Object> params = new HashMap<>();
        params.put("Terminated", RequestState.TERMINATED);
        List<Request> requestList = match("e.requestState =:Terminated", params);
        return requestList;
    }

}
