package eapli.base.form.application;

import eapli.base.Utils.FormSystem;
import eapli.base.form.antlr.formRequest2.AntlrCheckRequestForm2;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.RequestFormId;
import eapli.base.form.domain.TaskRequestForm;
import eapli.base.form.repositories.RequestFormRepository;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;

public class FormRequestRelationController {

    private final RequestFormRepository requestFormRepository = PersistenceContext.repositories().requestForms();
    private final TaskRequestFormRepository taskRequestFormRepository = PersistenceContext.repositories().taskRequestForms();
    private final AntlrCheckRequestForm2 antlrFormChecker = new AntlrCheckRequestForm2();

    public RequestForm makeRequestFormByService(Service service, String reqId) {
        RequestForm requestForm = new RequestForm(service.getBaseForm());
        requestForm.setId(RequestFormId.valueOf(reqId));
        return requestForm;
    }

    public boolean checkForm(RequestForm form) {
        FormSystem.createRequestFormFile(form);

        return antlrFormChecker.checkRequestForm(form);
    }

    public boolean checkForm(TaskRequestForm form) {
        FormSystem.createTaskFormFile(form);

        return antlrFormChecker.checkTaskRequestForm(form);
    }

    public RequestForm saveRequestForm(RequestForm requestForm) {
        return requestFormRepository.save(requestForm);
    }

    public TaskRequestForm saveTaskRequestForm(TaskRequestForm requestForm) {
        return taskRequestFormRepository.save(requestForm);
    }
}
