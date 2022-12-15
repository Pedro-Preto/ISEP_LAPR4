package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Request.application.RequestController;
import eapli.base.Request.model.CodeRequest;
import eapli.base.TeamType.domain.CodeTeamType;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.form.domain.RequestForm;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Service;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class RequestBootstrappers implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);
    private final RequestController requestController = new RequestController();
    private final ServiceController serviceController = new ServiceController();
    private CollaboratorController collaboratorController = new CollaboratorController();

    @Override
    public boolean execute() {


        Service service = serviceController.findServiceByCode("S001").orElse(null);
        Collaborator r = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("106"));
        Collaborator b = collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("105"));
/*
        addRequest(CodeRequest.valueOf("100"),service,,r,b)
        */

        System.out.println("===========================");
        System.out.println("Bootstrapping Requests...");
        System.out.println("===========================");
        return true;
    }


    private boolean addRequest(CodeRequest code, Service service, RequestForm requestForm, Collaborator benificiary, Collaborator requester) {
        try {
            requestController.makeRequest(code, service, requestForm, requester, benificiary);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
