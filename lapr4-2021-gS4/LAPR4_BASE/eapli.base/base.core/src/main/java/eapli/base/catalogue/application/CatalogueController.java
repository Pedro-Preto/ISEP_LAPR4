package eapli.base.catalogue.application;

import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.*;

public class CatalogueController {

    private final CatalogueRepository catalogueRepository = PersistenceContext.repositories().catalogues();
    private final TeamController teamController = new TeamController();

    public Catalogue addCatalogue(final Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    public Optional<Catalogue> findCatalogueByTitle(final String title) {
        return catalogueRepository.ofIdentity(Title.valueOf(title));
    }

    public Iterable<Catalogue> getAllCatalogues() {
        return catalogueRepository.findAll();
    }

    public Catalogue addTeamsToCatalogue(Catalogue catalogue, List<Team> teams) {
        for (Team t : teams) {
            catalogue.addTeam(t);
        }
        return catalogueRepository.save(catalogue);
    }

    public Catalogue removeTeamsFromCatalogue(Catalogue catalogue, List<Team> teams) {
        for(Team team : teams){
            catalogue.removeTeam(team);
        }
        return catalogueRepository.save(catalogue);
    }

    public Iterable<Catalogue> getCataloguesByTeam(Team team) {
        return catalogueRepository.findAllByTeam(team);
    }

    public Set<Team> getTeamsByCatalogue(Catalogue catalogue) {
        return catalogue.getAllowedTeamList();
    }

    public List<Team> getTeamsNotInCatalogue(Catalogue catalogue) {
        Iterable<Team> allTeams = teamController.getAllTeams();
        List<Team> teams = new LinkedList<>();
        for (Team team : allTeams) {
            if(!catalogue.getAllowedTeamList().contains(team))
                teams.add(team);
        }
        return teams;
    }

}

