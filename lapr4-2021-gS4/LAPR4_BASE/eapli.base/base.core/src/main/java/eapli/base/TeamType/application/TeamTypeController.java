package eapli.base.TeamType.application;

import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.Color.domain.Color;
import eapli.base.TeamType.domain.TeamType;
import eapli.base.TeamType.repositories.TeamTypeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;

public class TeamTypeController {
    private final TeamTypeRepository teamTypeRepository = PersistenceContext.repositories().teamTypes();

    public TeamType registerTeamType(CodeTeamType code, String designation, Color color) {
        final TeamType teamType = new TeamType(code, designation, color);

        return teamTypeRepository.save(teamType);

    }

    public List<TeamType> getAllTeamTypes() {
        return (List<TeamType>) teamTypeRepository.findAll();
    }

    public TeamType getTeamTypeByCode(CodeTeamType code) {
        return teamTypeRepository.findByCode(code);
    }

}
