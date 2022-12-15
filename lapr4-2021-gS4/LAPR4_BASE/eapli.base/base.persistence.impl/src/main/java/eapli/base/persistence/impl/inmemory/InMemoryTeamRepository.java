package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.Team.repositories.TeamRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, CodeTeam>
        implements TeamRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public Team findByCode(CodeTeam code) {
        return findByCode(code);
    }

    @Override
    public Team getTeamByCollaborator(Collaborator collaborator) {
        return getTeamByCollaborator(collaborator);
    }

    @Override
    public Optional<Team> ofIdentity(CodeTeam code) {
        return matchOne(e -> e.getCode().equals(code));
    }

}
