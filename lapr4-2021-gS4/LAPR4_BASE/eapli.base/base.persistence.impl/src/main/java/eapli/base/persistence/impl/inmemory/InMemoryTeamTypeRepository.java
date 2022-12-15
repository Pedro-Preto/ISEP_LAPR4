package eapli.base.persistence.impl.inmemory;

import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.TeamType.repositories.TeamTypeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamTypeRepository extends InMemoryDomainRepository<TeamType, CodeTeamType>
        implements TeamTypeRepository {
    static {
        InMemoryInitializer.init();
    }



    @Override
    public TeamType findByCode(CodeTeamType code) {
        return findByCode(code);
    }
}
