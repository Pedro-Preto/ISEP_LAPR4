package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.Request.repository.RequestRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryRequestRepository extends InMemoryDomainRepository<Request, CodeRequest>
        implements RequestRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public Request findByCode(CodeRequest code) {
        return findByCode(code);
    }

    @Override
    public List<Request> findByRequester(Collaborator collaborator) {
        return null;
    }

    @Override
    public List<Request> findByBeneficiary(Collaborator collaborator) {
        return null;
    }

    @Override
    public List<Request> findTerminatedRequestOfUserWithNoGrade(Collaborator collaborator) {
        return findTerminatedRequestOfUserWithNoGrade(collaborator);
    }

    @Override
    public List<Request> findTerminatedRequestOfUserWithGrade(Collaborator collaborator) {
        return findTerminatedRequestOfUserWithGrade(collaborator);
    }

    @Override
    public List<Request> findTerminatedRequests() {
        return findTerminatedRequests();
    }
}
