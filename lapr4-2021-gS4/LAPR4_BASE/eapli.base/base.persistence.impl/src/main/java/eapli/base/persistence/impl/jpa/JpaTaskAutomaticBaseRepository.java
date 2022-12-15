package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaTaskAutomaticBaseRepository extends JpaAutoTxRepository<TaskAutomaticBase, CodeTaskAutomaticBase, CodeTaskAutomaticBase> implements TaskAutomaticBaseRepository {


    public JpaTaskAutomaticBaseRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaTaskAutomaticBaseRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }


    @Override
    public TaskAutomaticBase getTaskAutomaticByCode(CodeTaskAutomaticBase codeTask) {
        TaskAutomaticBase taskAutomatic1 = null;
        List<TaskAutomaticBase> taskAutomatics = (List<TaskAutomaticBase>) findAll();
        for (TaskAutomaticBase taskAutomatic : taskAutomatics) {
            if (taskAutomatic.getCode().equals(codeTask))
                taskAutomatic1 = taskAutomatic;
        }
        return taskAutomatic1;
    }
}
