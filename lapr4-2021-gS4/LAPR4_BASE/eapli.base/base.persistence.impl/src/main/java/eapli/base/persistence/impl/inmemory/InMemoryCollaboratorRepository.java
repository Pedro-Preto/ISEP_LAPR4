package eapli.base.persistence.impl.inmemory;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCollaboratorRepository extends InMemoryDomainRepository<Collaborator, MecanographicNumber>
        implements CollaboratorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Collaborator findByMecanographicNumber(MecanographicNumber number) {
        return findByMecanographicNumber(number);
    }

    @Override
    public Collaborator findByEmail(String email) {

        return findByEmail(email);
    }
}
