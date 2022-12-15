package eapli.base.TeamType.repositories;

import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.TeamType.domain.TeamType;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamTypeRepository extends DomainRepository<CodeTeamType, TeamType> {


    public TeamType findByCode(CodeTeamType code);


    public Iterable<TeamType> findAll();


}
