package eapli.base.Request.repository;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Request.model.CodeRequest;
import eapli.base.Request.model.Request;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface RequestRepository extends DomainRepository<CodeRequest, Request> {

    public Request findByCode(CodeRequest code);

    public Iterable<Request> findAll();

    public List<Request> findByRequester(Collaborator collaborator);

    public List<Request> findByBeneficiary(Collaborator collaborator);

    public List<Request> findTerminatedRequestOfUserWithNoGrade(Collaborator collaborator);

    public List<Request> findTerminatedRequestOfUserWithGrade(Collaborator collaborator);

    public List<Request> findTerminatedRequests();
}
