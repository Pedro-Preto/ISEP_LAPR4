package eapli.base.Team.repositories;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamRepository extends DomainRepository<CodeTeam, Team> {


    public Team findByCode(CodeTeam code);

    public Iterable<Team> findAll();

    public Team getTeamByCollaborator(Collaborator collaborator);
}
