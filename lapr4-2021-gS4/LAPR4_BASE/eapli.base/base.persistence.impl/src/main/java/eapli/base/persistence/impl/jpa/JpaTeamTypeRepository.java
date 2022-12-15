package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.TeamType.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaTeamTypeRepository  extends JpaAutoTxRepository<TeamType, CodeTeamType, CodeTeamType> implements TeamTypeRepository {


    public JpaTeamTypeRepository(TransactionalContext autoTx) {
        super(autoTx, "code");
    }

    public JpaTeamTypeRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "code");
    }
    @Override
    public TeamType findByCode(CodeTeamType code) {
        try {
            List<TeamType> teamTypeList = (List<TeamType>) findAll();
            TeamType c1 = null;
            for (TeamType c : teamTypeList) {
                if (c.getCode().toString().equals(code.toString()))
                    c1 = c;
            }

            return c1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Team Type with Code " + code + " doesn't exist!!");
        }


    }
}
