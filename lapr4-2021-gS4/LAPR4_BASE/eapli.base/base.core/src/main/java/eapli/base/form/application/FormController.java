package eapli.base.form.application;

import eapli.base.Utils.FormSystem;
import eapli.base.form.antlr.formBase.AntlrCheckBaseForm;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.repositories.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class FormController {

    private final FormRepository formRepository = PersistenceContext.repositories().forms();
    private final AntlrCheckBaseForm antlrCheckBaseForm = new AntlrCheckBaseForm();

    public BaseForm addForm(final BaseForm baseForm) {
        FormSystem.createBaseFormFile(baseForm);
        if (antlrCheckBaseForm.checkBaseForm(baseForm))
            return formRepository.save(baseForm);
        return null;
    }

    public Optional<BaseForm> findFormById(final String id) {
        return formRepository.ofIdentity(BaseFormId.valueOf(id));
    }

    public Iterable<BaseForm> getAllForms() {
        return formRepository.findAll();
    }
}
