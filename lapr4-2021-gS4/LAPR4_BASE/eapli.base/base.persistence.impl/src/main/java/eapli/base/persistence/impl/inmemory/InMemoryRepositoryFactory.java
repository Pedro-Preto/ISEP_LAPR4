package eapli.base.persistence.impl.inmemory;

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
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.contract.repositories.ContractRepository;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.form.repositories.FormRepository;
import eapli.base.form.repositories.RequestFormRepository;
import eapli.base.form.repositories.TaskBaseFormRepository;
import eapli.base.form.repositories.TaskRequestFormRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.repositories.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {
        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CatalogueRepository catalogues(TransactionalContext autoTx) {
        return new InMemoryCatalogueRepository();
    }

    @Override
    public CatalogueRepository catalogues() {
        return catalogues(null);
    }

    @Override
    public CriticalityRepository criticalities(TransactionalContext autoTx) {
        return new InMemoryCriticalityRepository();
    }

    @Override
    public CriticalityRepository criticalities() {
        return criticalities(null);
    }

    @Override
    public ServiceRepository services(TransactionalContext autoTx) {
        return new InMemoryServiceRepository();
    }

    @Override
    public ServiceRepository services() {
        return services(null);
    }

    @Override
    public CollaboratorRepository collaborators(TransactionalContext autoTx) {
        return new InMemoryCollaboratorRepository();
    }

    @Override
    public CollaboratorRepository collaborators() {
        return collaborators(null);

    }

    @Override
    public ContractRepository contracts(TransactionalContext autoTx) {
        return new InMemoryContractRepository();
    }

    @Override
    public ContractRepository contracts() {
        return contracts(null);
    }

    @Override
    public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
        return new InMemoryTeamTypeRepository();
    }

    @Override
    public TeamTypeRepository teamTypes() {
        return teamTypes(null);

    }

    @Override
    public TeamRepository teams(TransactionalContext autoTx) {
        return new InMemoryTeamRepository();
    }

    @Override
    public TeamRepository teams() {
        return teams(null);
    }

    @Override
    public ColorRepository colors() {
        return colors(null);
    }

    @Override
    public ColorRepository colors(TransactionalContext autoTx) {
        return new InMemoryColorRepository();
    }

    @Override
    public FormRepository forms() {
        return forms(null);
    }

    @Override
    public FormRepository forms(TransactionalContext autoTx) {
        return new InMemoryFormRepository();
    }

    @Override
    public RequestFormRepository requestForms() {
        return requestForms(null);
    }

    @Override
    public RequestFormRepository requestForms(TransactionalContext autoTx) {
        return new InMemoryRequestFormRepository();
    }

    @Override
    public TaskManualBaseRepository tasksManual() {
        return tasksManual(null);
    }

    @Override
    public TaskManualBaseRepository tasksManual(TransactionalContext autoTx) {
        return new InMemoryTaskManualBaseRepository();
    }

    @Override
    public TaskWorkFlowRepository workflows() {
        return workflows(null);
    }

    @Override
    public TaskWorkFlowRepository workflows(TransactionalContext autoTx) {
        return new InMemoryTaskWorkFlowCodeRepository();
    }

    @Override
    public RequestRepository requests() {
        return requests(null);
    }

    @Override
    public RequestRepository requests(TransactionalContext autoTx) {
        return new InMemoryRequestRepository();
    }

    @Override
    public TaskAutomaticBaseRepository tasksAutomatic() {
        return tasksAutomatic(null);
    }

    @Override
    public TaskAutomaticBaseRepository tasksAutomatic(TransactionalContext autoTx) {
        return new InMemoryTaskAutomaticBaseRepository();

    }

    @Override
    public TaskManualRequestRepository taskManualRequest() {
        return taskManualRequest(null);

    }

    @Override
    public TaskManualRequestRepository taskManualRequest(TransactionalContext autoTx) {
        return new InMemoryTaskManualRequestRepository();
    }

    @Override
    public TaskAutomaticRequestRepository taskAutomaticRequest() {
        return taskAutomaticRequest(null);

    }

    @Override
    public TaskAutomaticRequestRepository taskAutomaticRequest(TransactionalContext autoTx) {
        return new InMemoryTaskAutomaticRequestRepository();
    }

    @Override
    public TaskBaseFormRepository taskBaseForms() {
        return new InMemoryTaskBaseFormRepository();
    }

    @Override
    public TaskBaseFormRepository taskBaseForms(TransactionalContext autoTx) {
        return new InMemoryTaskBaseFormRepository();
    }

    @Override
    public TaskRequestFormRepository taskRequestForms() {
        return new InMemoryTaskRequestFormRepository();
    }

    @Override
    public TaskRequestFormRepository taskRequestForms(TransactionalContext autoTx) {
        return new InMemoryTaskRequestFormRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
