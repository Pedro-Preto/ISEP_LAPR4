package eapli.base.Task.repository.Automatic;

import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.framework.domain.repositories.DomainRepository;

public interface TaskAutomaticBaseRepository extends DomainRepository<CodeTaskAutomaticBase, TaskAutomaticBase> {

    public Iterable<TaskAutomaticBase> findAll();

    public TaskAutomaticBase getTaskAutomaticByCode(CodeTaskAutomaticBase codeTask);

}
