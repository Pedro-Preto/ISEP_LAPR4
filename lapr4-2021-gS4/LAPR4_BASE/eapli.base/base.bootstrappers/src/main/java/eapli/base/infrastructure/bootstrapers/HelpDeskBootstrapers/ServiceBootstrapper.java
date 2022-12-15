package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.service.application.ServiceController;
import eapli.base.service.domain.Code;
import eapli.base.service.domain.Keyword;
import eapli.base.service.domain.Service;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ServiceBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(CriticalityBootstrapper.class);
    private final ServiceController serviceController = new ServiceController();
    private final CatalogueController catalogueController = new CatalogueController();

    @Override
    public boolean execute() {

        /* ----------------------------------------------- SERVICE 1 ------------------------------------------------ */
        Title title1 = new Title("Service 1");
        String briefDescription1 = "This is brief description of service 1";
        String description1 = "This is the description of service 1";
        Code code1 = new Code("S001");
        Icon icon1 = new Icon("/s1.png");
        Optional<Catalogue> catalogue1 = catalogueController.findCatalogueByTitle("Catalogue 1");
        Set<Keyword> keywords1 = new HashSet<>();
        keywords1.add(new Keyword("keyword1"));
        keywords1.add(new Keyword("keyword2"));
        keywords1.add(new Keyword("keyword3"));
        Service service1 = new Service(title1, briefDescription1, description1, code1, icon1, catalogue1.orElse(null), keywords1);

        addService(service1);


        /* ----------------------------------------------- SERVICE 2 ------------------------------------------------ */
        Title title2 = new Title("Service 2");
        String briefDescription2 = "This is brief description of service 2";
        String description2 = "This is the description of service 2";
        Code code2 = new Code("S002");
        Icon icon2 = new Icon("/s2.png");
        Optional<Catalogue> catalogue2 = catalogueController.findCatalogueByTitle("Catalogue 2");
        Set<Keyword> keywords2 = new HashSet<>();
        keywords2.add(new Keyword("keyword2"));
        keywords2.add(new Keyword("keyword3"));
        keywords2.add(new Keyword("keyword4"));
        Service service2 = new Service(title2, briefDescription2, description2, code2, icon2, catalogue2.orElse(null), keywords2);

        addService(service2);


        /* ----------------------------------------------- SERVICE 3 ------------------------------------------------ */
        Title title3 = new Title("Service 3");
        String briefDescription3 = "This is brief description of service 3";
        String description3 = "This is the description of service 3";
        Code code3 = new Code("S003");
        Icon icon3 = new Icon("/s3.png");
        Optional<Catalogue> catalogue3 = catalogueController.findCatalogueByTitle("Catalogue 3");
        Set<Keyword> keywords3 = new HashSet<>();
        keywords3.add(new Keyword("keyword3"));
        keywords3.add(new Keyword("keyword4"));
        keywords3.add(new Keyword("keyword5"));
        Service service3 = new Service(title3, briefDescription3, description3, code3, icon3, catalogue3.orElse(null), keywords3);

        addService(service3);


        /* ----------------------------------------------- SERVICE 4 ------------------------------------------------ */
        Title title4 = new Title("Service 4");
        String briefDescription4 = "This is brief description of service 4";
        String description4 = "This is the description of service 4";
        Code code4 = new Code("S004");
        Icon icon4 = new Icon("/s4.png");
        Optional<Catalogue> catalogue4 = catalogueController.findCatalogueByTitle("Catalogue 4");
        Set<Keyword> keywords4 = new HashSet<>();
        keywords4.add(new Keyword("keyword4"));
        keywords4.add(new Keyword("keyword5"));
        keywords4.add(new Keyword("keyword6"));
        Service service4 = new Service(title4, briefDescription4, description4, code4, icon4, catalogue4.orElse(null), keywords4);

        addService(service4);


        /* ----------------------------------------------- SERVICE 5 ------------------------------------------------ */
        Title title5 = new Title("Service 5");
        String briefDescription5 = "This is brief description of service 5";
        String description5 = "This is the description of service 5";
        Code code5 = new Code("S005");
        Icon icon5 = new Icon("/s5.png");
        Optional<Catalogue> catalogue5 = catalogueController.findCatalogueByTitle("Catalogue 5");
        Set<Keyword> keywords5 = new HashSet<>();
        keywords5.add(new Keyword("keyword1"));
        keywords5.add(new Keyword("keyword6"));
        keywords5.add(new Keyword("keyword3"));
        Service service5 = new Service(title5, briefDescription5, description5, code5, icon5, catalogue5.orElse(null), keywords5);

        addService(service5);


        /* ----------------------------------------------- SERVICE 6 ------------------------------------------------ */
        Title title6 = new Title("Service 6");
        String briefDescription6 = "This is brief description of service 6";
        String description6 = "This is the description of service 6";
        Code code6 = new Code("S006");
        Icon icon6 = new Icon("/s6.png");
        Optional<Catalogue> catalogue6 = catalogueController.findCatalogueByTitle("Catalogue 6");
        Set<Keyword> keywords6 = new HashSet<>();
        keywords6.add(new Keyword("keyword3"));
        keywords6.add(new Keyword("keyword4"));
        keywords6.add(new Keyword("keyword2"));
        Service service6 = new Service(title6, briefDescription6, description6, code6, icon6, catalogue6.orElse(null), keywords6);

        addService(service6);
        System.out.println("=========================");
        System.out.println("Bootstrapping Services...");
        System.out.println("=========================");
        return true;
    }

    private boolean addService(Service service) {
        try {
            serviceController.addService(service);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", service.code());
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
