package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.*;

public class JpaCatalogueRepository extends JpaAutoTxRepository<Catalogue, Title, Title>
        implements CatalogueRepository {

    public JpaCatalogueRepository(TransactionalContext autoTx) {
        super(autoTx, "title");
    }

    public JpaCatalogueRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "title");
    }

    @Override
    public Optional<Catalogue> findByTitle(final Title title) {
        final Map<String, Object> params = new HashMap<>();
        params.put("catalogueTitle", title);
        return matchOne("e.title=:catalogueTitle", params);
    }

    @Override
    public Iterable<Catalogue> findAllByTeam(final Team team) { //TODO testar
        List<Catalogue> catalogueByTeam = new ArrayList<>();
        List<Catalogue> catalogueList = (List<Catalogue>) findAll();
        for (Catalogue catalogue : catalogueList) {
            if (catalogue.getAllowedTeamList().contains(team)) {
                catalogueByTeam.add(catalogue);
            }
        }
        return catalogueByTeam;
    }

}
