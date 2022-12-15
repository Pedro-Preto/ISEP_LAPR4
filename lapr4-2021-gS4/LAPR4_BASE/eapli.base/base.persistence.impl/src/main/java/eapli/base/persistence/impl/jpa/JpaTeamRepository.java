package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.Team.repositories.TeamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaTeamRepository extends JpaAutoTxRepository<Team, CodeTeam, CodeTeam> implements TeamRepository {

    public JpaTeamRepository(TransactionalContext autoTx) {
        super(autoTx, "code");
    }

    public JpaTeamRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "code");
    }

    @Override
    public Team findByCode(CodeTeam code) {
        try {
            List<Team> teamTypeList = (List<Team>) findAll();
            Team c1 = null;
            for (Team c : teamTypeList) {
                if (c.getCode().toString().equals(code.toString()))
                    c1 = c;
            }

            return c1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Team with Code " + code + " doesn't exist!!");
        }


    }

    @Override
    public Team getTeamByCollaborator(Collaborator collaborator) {
        List<Team> teams = (List<Team>) findAll();
        Team t = null;
        for (Team tt : teams) {
            if (tt.getResponsibleCollaborator().getNumMechanographic().equals(collaborator.getNumMechanographic())) {
                t = tt;
            }
        }
        return t;
    }
}
