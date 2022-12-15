package eapli.base.catalogue.repositories;

import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CatalogueRepository extends DomainRepository<Title, Catalogue> {

    /**
     * returns the catalogue with the given title
     *
     * @param title
     * @return
     */
    default Optional<Catalogue> findByTitle(Title title) {
        return ofIdentity(title);
    }

    public Iterable<Catalogue> findAllByTeam(Team team);
}
