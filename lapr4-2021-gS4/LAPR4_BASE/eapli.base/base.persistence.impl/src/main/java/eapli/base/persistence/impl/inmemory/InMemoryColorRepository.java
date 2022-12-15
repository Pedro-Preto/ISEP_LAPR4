package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryColorRepository extends InMemoryDomainRepository<Color, ColorDesignation>
        implements ColorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Color findColorByDesignation(ColorDesignation designation) {
        return findColorByDesignation(designation);
    }

}
