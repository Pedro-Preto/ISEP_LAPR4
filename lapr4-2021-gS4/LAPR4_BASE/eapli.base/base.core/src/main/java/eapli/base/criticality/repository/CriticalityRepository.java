package eapli.base.criticality.repository;

import eapli.base.Team.domain.Team;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CriticalityRepository  extends DomainRepository<CriticalityID, Criticality> {

    default Optional<Criticality> findByCriticalityId(CriticalityID id) {
        return ofIdentity(id);
    }

}
