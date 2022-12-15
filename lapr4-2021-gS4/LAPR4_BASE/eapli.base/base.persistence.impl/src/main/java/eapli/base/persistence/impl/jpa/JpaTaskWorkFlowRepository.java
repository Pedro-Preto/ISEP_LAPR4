package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Task.domain.CodeTaskWorkFlow;
import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.Task.repository.TaskWorkFlowRepository;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaTaskWorkFlowRepository extends JpaAutoTxRepository<TaskWorkFlow, CodeTaskWorkFlow, CodeTaskWorkFlow> implements TaskWorkFlowRepository {


    public JpaTaskWorkFlowRepository(TransactionalContext autoTx) {
        super(autoTx, "taskWorkFlowCode");
    }

    public JpaTaskWorkFlowRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "taskWorkFlowCode");
    }

    @Override
    public TaskWorkFlow findByCode(CodeTaskWorkFlow codeTaskWorkFlow) {
        List<TaskWorkFlow> taskWorkFlowList = (List<TaskWorkFlow>) findAll();
        TaskWorkFlow taskWorkFlow1 = null;
        for (TaskWorkFlow taskWorkFlow2 : taskWorkFlowList) {
            if (taskWorkFlow2.getCode().equals(codeTaskWorkFlow)) {
                taskWorkFlow1 = taskWorkFlow2;
            }
        }
        return taskWorkFlow1;
    }
}
