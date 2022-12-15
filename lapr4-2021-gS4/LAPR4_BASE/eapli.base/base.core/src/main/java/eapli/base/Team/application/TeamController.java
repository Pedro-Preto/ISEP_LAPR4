package eapli.base.Team.application;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.domain.Acronym;
import eapli.base.Team.domain.CodeTeam;
import eapli.base.Team.domain.Team;
import eapli.base.Team.repositories.TeamRepository;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;
import java.util.Set;

public class TeamController {
    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();

    public Team registerTeam(CodeTeam code, String designation, Acronym acronym, TeamType teamType, Collaborator responsibleCollaborator, Set<Collaborator> teamCollaborators) {

        Team team = new Team(code, designation, acronym, teamType, responsibleCollaborator, teamCollaborators);
        return teamRepository.save(team);

    }

    public Team addCollaboratorToTeam(Team team, Collaborator collaborator) { //TODO testar
        team.addCollaboratorToTeam(collaborator);
        return teamRepository.save(team);
    }

    public Team removeCollaboratorFromTeam(Team team, Collaborator collaborator) { //TODO testar
        team.removeCollaboratorFromTeam(collaborator);
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team getTeamByCode(CodeTeam code) {
        return teamRepository.findByCode(code);
    }

    public Team getTeamByCollaborator(Collaborator collaborator) {
        return teamRepository.getTeamByCollaborator(collaborator);
    }

}
