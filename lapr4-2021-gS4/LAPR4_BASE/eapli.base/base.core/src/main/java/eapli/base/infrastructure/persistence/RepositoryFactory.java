/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.Collaborator.repositories.CollaboratorRepository;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.Request.repository.RequestRepository;
import eapli.base.Task.repository.*;
import eapli.base.Task.repository.Automatic.TaskAutomaticBaseRepository;
import eapli.base.Task.repository.Automatic.TaskAutomaticRequestRepository;
import eapli.base.Task.repository.Manual.TaskManualBaseRepository;
import eapli.base.Task.repository.Manual.TaskManualRequestRepository;
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
import eapli.base.service.repositories.ServiceRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CatalogueRepository catalogues(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CatalogueRepository catalogues();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CriticalityRepository criticalities(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CriticalityRepository criticalities();


    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ServiceRepository services(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ServiceRepository services();


    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    CollaboratorRepository collaborators(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CollaboratorRepository collaborators();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ContractRepository contracts(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ContractRepository contracts();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    TeamTypeRepository teamTypes(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    TeamTypeRepository teamTypes();

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    TeamRepository teams();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    TeamRepository teams(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ColorRepository colors();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    ColorRepository colors(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    FormRepository forms();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    FormRepository forms(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    RequestFormRepository requestForms();

    /**
     *
     * @param autoTx the transactional context to enroll
     * @return
     */
    RequestFormRepository requestForms(TransactionalContext autoTx);


    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskManualBaseRepository tasksManual();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskManualBaseRepository tasksManual(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskWorkFlowRepository workflows();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskWorkFlowRepository workflows(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    RequestRepository requests();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    RequestRepository requests(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskAutomaticBaseRepository tasksAutomatic();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskAutomaticBaseRepository tasksAutomatic(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskManualRequestRepository taskManualRequest();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskManualRequestRepository taskManualRequest(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskAutomaticRequestRepository taskAutomaticRequest();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskAutomaticRequestRepository taskAutomaticRequest(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskBaseFormRepository taskBaseForms();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskBaseFormRepository taskBaseForms(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TaskRequestFormRepository taskRequestForms();

    /**
     *
     * @param autoTx the transactional context to enrol
     * @return
     */
    TaskRequestFormRepository taskRequestForms(TransactionalContext autoTx);
}
