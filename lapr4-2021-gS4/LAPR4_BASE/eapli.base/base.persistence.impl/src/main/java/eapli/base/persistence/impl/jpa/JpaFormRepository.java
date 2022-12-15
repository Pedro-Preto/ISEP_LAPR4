package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.repositories.FormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaFormRepository extends JpaAutoTxRepository<BaseForm, BaseFormId, BaseFormId>
        implements FormRepository {

    public JpaFormRepository(TransactionalContext autoTx) {
        super(autoTx, "formId");
    }

    public JpaFormRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "formId");
    }

}
