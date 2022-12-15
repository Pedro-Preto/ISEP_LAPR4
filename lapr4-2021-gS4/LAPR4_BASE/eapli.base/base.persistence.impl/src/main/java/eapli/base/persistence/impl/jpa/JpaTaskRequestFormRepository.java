package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.domain.TaskBaseForm;
import eapli.base.form.domain.TaskRequestForm;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaTaskRequestFormRepository extends JpaAutoTxRepository<TaskRequestForm, RequestFormId, RequestFormId>  implements TaskRequestFormRepository {
    public JpaTaskRequestFormRepository(TransactionalContext autoTx) {
        super(autoTx, "formId");
    }

    public JpaTaskRequestFormRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "formId");
    }
}
