package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCriticalityRepository extends JpaAutoTxRepository<Criticality, CriticalityID, CriticalityID>
        implements CriticalityRepository {

    public JpaCriticalityRepository(TransactionalContext autoTx) {
        super(autoTx, "criticalityID");
    }

    public JpaCriticalityRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "criticalityID");
    }

    @Override
    public Optional<Criticality> findByCriticalityId(final CriticalityID id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("criticalityId", id);
        return matchOne("e.id=:criticalityId", params);
    }


}
