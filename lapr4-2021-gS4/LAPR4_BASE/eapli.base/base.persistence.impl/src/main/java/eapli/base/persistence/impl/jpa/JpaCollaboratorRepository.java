package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class JpaCollaboratorRepository extends JpaAutoTxRepository<Collaborator, MecanographicNumber, MecanographicNumber> implements CollaboratorRepository {

    public JpaCollaboratorRepository(TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JpaCollaboratorRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }

    @Override
    public Collaborator findByMecanographicNumber(MecanographicNumber number) {
        try {
            List<Collaborator> colList = (List<Collaborator>) findAll();
            Collaborator c1 = null;
            for (Collaborator c : colList) {
                if (c.getNumMechanographic().equals(number))
                    c1 = c;
            }

            return c1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Collaborator with Email " + number + " doesn't exist");
        }


    }



    @Override
    public Collaborator findByEmail(String email) {
        try {
            List<Collaborator> colList = (List<Collaborator>) findAll();
            Collaborator c1 = null;
            for (Collaborator c : colList) {
                if (c.getEmail().toString().equals(email))
                    c1 = c;
            }

            return c1;
        } catch (Exception e) {
            throw new IllegalArgumentException("Collaborator with Email " + email + " doesn't exist");
        }


    }
}
