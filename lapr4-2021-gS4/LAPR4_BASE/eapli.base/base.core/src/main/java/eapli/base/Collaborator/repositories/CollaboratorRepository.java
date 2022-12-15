package eapli.base.Collaborator.repositories;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Title;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber, Collaborator> {


    public Collaborator findByMecanographicNumber(MecanographicNumber number);


    public Iterable<Collaborator> findAll();

    public Collaborator findByEmail(String email);
}
