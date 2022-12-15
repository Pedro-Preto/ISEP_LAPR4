package eapli.base.Task.repository.Automatic;

import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticRequest;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TaskAutomaticRequestRepository extends DomainRepository<CodeTaskAutomaticRequest, TaskAutomaticRequest> {

    public TaskAutomaticRequest getByCode(CodeTaskAutomaticRequest codeTask);
}
