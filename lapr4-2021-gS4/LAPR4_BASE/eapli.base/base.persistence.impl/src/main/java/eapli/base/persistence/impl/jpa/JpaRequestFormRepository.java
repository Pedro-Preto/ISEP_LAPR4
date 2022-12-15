package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.repositories.RequestFormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaRequestFormRepository extends JpaAutoTxRepository<RequestForm, RequestFormId, RequestFormId>
        implements RequestFormRepository {

    public JpaRequestFormRepository(TransactionalContext autoTx) {
        super(autoTx, "formId");
    }

    public JpaRequestFormRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "formId");
    }
}
