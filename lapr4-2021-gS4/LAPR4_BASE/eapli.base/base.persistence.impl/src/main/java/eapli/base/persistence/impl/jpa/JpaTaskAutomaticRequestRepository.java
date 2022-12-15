package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticRequest;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaTaskAutomaticRequestRepository extends JpaAutoTxRepository<TaskAutomaticRequest, CodeTaskAutomaticRequest, CodeTaskAutomaticRequest> implements TaskAutomaticRequestRepository {


    public JpaTaskAutomaticRequestRepository(TransactionalContext autoTx) {
        super(autoTx, "taskCode");
    }

    public JpaTaskAutomaticRequestRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "taskCode");
    }
/*
    @Override
    public Optional<TaskAutomaticRequest> getByCode(CodeTaskAutomaticRequest codeTask) {
        final Map<String, Object> params = new HashMap<>();
        params.put("taskCode", codeTask.toString());
        return matchOne("e.code=:taskCode", params);
    }
*/

    @Override
    public TaskAutomaticRequest getByCode(CodeTaskAutomaticRequest codeTask) {
        TaskAutomaticRequest task = null;
        List<TaskAutomaticRequest> taskAutomatics = (List<TaskAutomaticRequest>) findAll();
        for (TaskAutomaticRequest taskAutomatic : taskAutomatics) {
            if (taskAutomatic.getCode().equals(codeTask))
                task = taskAutomatic;
        }
        return task;
    }
}
