package eapli.base.persistence.impl.inmemory;

import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCatalogueRepository extends InMemoryDomainRepository<Catalogue, Title>
        implements CatalogueRepository {

        static {
            InMemoryInitializer.init();
        }

    @Override
    public Optional<Catalogue> findByTitle(Title title) {
        return matchOne(e -> e.title().equals(title));
    }

    @Override
    public Iterable<Catalogue> findAllByTeam(Team team) {
        //TODO find by team
        return null;
    }
}
