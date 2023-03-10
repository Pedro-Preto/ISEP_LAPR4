/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.app.other.console;

import eapli.base.app.other.console.Domain.MotorFluxoAtividades;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public final class OtherApp {

    /**
     * Empty constructor is private to avoid instantiation of this class.
     */
    private OtherApp() {
    }

    public static void main(final String[] args) throws Exception {
        System.out.println("======================================");
        System.out.println("=====Motor de Fluxo de Atividades=====");
        System.out.println("===========(4P) 2020 - 2021===========");
        System.out.println("======================================");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        MotorFluxoAtividades.manageTasks();
        // exiting the application, closing all threads
        System.exit(0);
    }
}
