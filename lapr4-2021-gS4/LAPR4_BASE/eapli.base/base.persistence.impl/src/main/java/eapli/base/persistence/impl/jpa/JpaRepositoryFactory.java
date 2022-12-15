package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.Request.repository.RequestRepository;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
import eapli.base.Task.repository.TaskWorkFlowRepository;
import eapli.base.Team.repositories.TeamRepository;
import eapli.base.TeamType.repositories.TeamTypeRepository;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.contract.repositories.ContractRepository;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.form.repositories.FormRepository;
import eapli.base.form.repositories.RequestFormRepository;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.repositories.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CatalogueRepository catalogues(TransactionalContext autoTx) {
        return new JpaCatalogueRepository(autoTx);
    }

    @Override
    public CatalogueRepository catalogues() {
        return new JpaCatalogueRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JpaCriticalityRepository criticalities(TransactionalContext autoTx) {
        return new JpaCriticalityRepository(autoTx);
    }

    @Override
    public CriticalityRepository criticalities() {
        return new JpaCriticalityRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
	public ServiceRepository services(TransactionalContext autoTx) {
		return new JpaServiceRepository(autoTx);
	}

	@Override
	public ServiceRepository services() {
		return new JpaServiceRepository(Application.settings().getPersistenceUnitName());
	}

    @Override
    public CollaboratorRepository collaborators(TransactionalContext autoTx) {
        return new JpaCollaboratorRepository(autoTx);
    }

    @Override
    public CollaboratorRepository collaborators() {
        return new JpaCollaboratorRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ContractRepository contracts(TransactionalContext autoTx) {
        return new JpaContractRepository(autoTx);
    }

    @Override
    public ContractRepository contracts() {
        return new JpaContractRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
        return new JpaTeamTypeRepository(autoTx);
    }

    @Override
    public TeamTypeRepository teamTypes() {
        return new JpaTeamTypeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeamRepository teams(TransactionalContext autoTx) {
        return new JpaTeamRepository(autoTx);
    }

    @Override
    public TeamRepository teams() {
        return new JpaTeamRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ColorRepository colors() {
        return new JpaColorRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ColorRepository colors(TransactionalContext autoTx) {
        return new JpaColorRepository(autoTx);
    }

    @Override
    public FormRepository forms() {
        return new JpaFormRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public FormRepository forms(TransactionalContext autoTx) {
        return new JpaFormRepository(autoTx);
    }

    @Override
    public RequestFormRepository requestForms() {
        return new JpaRequestFormRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RequestFormRepository requestForms(TransactionalContext autoTx) {
        return new JpaRequestFormRepository(autoTx);
    }

    @Override
    public TaskBaseFormRepository taskBaseForms() {
        return new JpaTaskBaseFormRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskBaseFormRepository taskBaseForms(TransactionalContext autoTx) {
        return new JpaTaskBaseFormRepository(autoTx);
    }

    @Override
    public TaskRequestFormRepository taskRequestForms() {
        return new JpaTaskRequestFormRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskRequestFormRepository taskRequestForms(TransactionalContext autoTx) {
        return new JpaTaskRequestFormRepository(autoTx);
    }

    @Override
    public TaskManualBaseRepository tasksManual() {
        return new JpaTaskManualBaseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskManualBaseRepository tasksManual(TransactionalContext autoTx) {
        return new JpaTaskManualBaseRepository(autoTx);
    }

    @Override
    public TaskWorkFlowRepository workflows() {
        return new JpaTaskWorkFlowRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskWorkFlowRepository workflows(TransactionalContext autoTx) {
        return new JpaTaskWorkFlowRepository(autoTx);
    }

    @Override
    public RequestRepository requests() {
        return new JpaRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public RequestRepository requests(TransactionalContext autoTx) {
        return new JpaRequestRepository(autoTx);
    }

    @Override
    public TaskAutomaticBaseRepository tasksAutomatic() {
        return new JpaTaskAutomaticBaseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskAutomaticBaseRepository tasksAutomatic(TransactionalContext autoTx) {
        return new JpaTaskAutomaticBaseRepository(autoTx);
    }

    @Override
    public TaskManualRequestRepository taskManualRequest() {
        return new JpaTaskManualRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskManualRequestRepository taskManualRequest(TransactionalContext autoTx) {
        return new JpaTaskManualRequestRepository(autoTx);
    }

    @Override
    public TaskAutomaticRequestRepository taskAutomaticRequest() {
        return new JpaTaskAutomaticRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TaskAutomaticRequestRepository taskAutomaticRequest(TransactionalContext autoTx) {
        return new JpaTaskAutomaticRequestRepository(autoTx);
    }


    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}
