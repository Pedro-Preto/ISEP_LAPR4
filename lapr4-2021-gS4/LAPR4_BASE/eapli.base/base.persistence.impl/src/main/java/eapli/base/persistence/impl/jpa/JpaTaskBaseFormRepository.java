package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskBaseFormRepository extends JpaAutoTxRepository<TaskBaseForm, BaseFormId, BaseFormId>  implements TaskBaseFormRepository {
    public JpaTaskBaseFormRepository(TransactionalContext autoTx) {
        super(autoTx, "formId");
    }

    public JpaTaskBaseFormRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "formId");
    }
}
