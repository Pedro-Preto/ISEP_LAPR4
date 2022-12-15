package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.application.TeamController;
import eapli.base.Team.domain.Team;
import eapli.base.catalogue.application.CatalogueController;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CatalogueBootstrapper implements Action{


        private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

        private final CatalogueController catalogueController = new CatalogueController();
        private final CollaboratorController collaboratorController = new CollaboratorController();
        private final CriticalityController criticalityController = new CriticalityController();
        private final TeamController teamController = new TeamController();

        @Override
        public boolean execute() {
            //CATALOGUE 1
            Title t1 = new Title("Catalogue 1");
            String bd1 = "This is the brief description of catalogue 1";
            String d1 = "This is the description of catalogue 1";
            Icon i1 = new Icon("/i1.png");
            Collaborator cr1 = collaboratorController.getCollaboratorByEmail("colabA@bootstrapper.com");
            long c1Id = 101;
            Optional<Criticality> crit1 = criticalityController.findCriticalityByID(c1Id);
            Set<Team> allowedTeamList = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr1));
            Catalogue c1 = new Catalogue(t1, bd1, d1, i1, cr1, crit1.orElse(null), allowedTeamList);
            addCatalogue(c1);

            //CATALOGUE 2
            Title t2 = new Title("Catalogue 2");
            String bd2 = "This is the brief description of catalogue 2";
            String d2 = "This is the description of catalogue 2";
            Icon i2 = new Icon("/i2.png");
            Collaborator cr2 = collaboratorController.getCollaboratorByEmail("colabB@bootstrapper.com");
            long c2Id = 102;
            Optional<Criticality> crit2 = criticalityController.findCriticalityByID(c2Id);
            Set<Team> allowedTeamList2 = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr2));
            Catalogue c2 = new Catalogue(t2, bd2, d2, i2, cr2, crit2.orElse(null), allowedTeamList2);
            addCatalogue(c2);

            //CATALOGUE 3
            Title t3 = new Title("Catalogue 3");
            String bd3 = "This is the brief description of catalogue 3";
            String d3 = "This is the description of catalogue 3";
            Icon i3 = new Icon("/i3.png");
            Collaborator cr3 = collaboratorController.getCollaboratorByEmail("colabC@bootstrapper.com");
            long c3Id = 103;
            Optional<Criticality> crit3 = criticalityController.findCriticalityByID(c3Id);
            Set<Team> allowedTeamList3 = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr3));
            Catalogue c3 = new Catalogue(t3, bd3, d3, i3, cr3, crit3.orElse(null), allowedTeamList3);
            addCatalogue(c3);

            //CATALOGUE 4
            Title t4 = new Title("Catalogue 4");
            String bd4 = "This is the brief description of catalogue 4";
            String d4 = "This is the description of catalogue 4";
            Icon i4 = new Icon("/i4.png");
            Collaborator cr4 = collaboratorController.getCollaboratorByEmail("colabD@bootstrapper.com");
            long c4Id = 104;
            Optional<Criticality> crit4 = criticalityController.findCriticalityByID(c4Id);
            Set<Team> allowedTeamList4 = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr4));
            Catalogue c4 = new Catalogue(t4, bd4, d4, i4, cr4, crit4.orElse(null), allowedTeamList4);
            addCatalogue(c4);

            //CATALOGUE 5
            Title t5 = new Title("Catalogue 5");
            String bd5 = "This is the brief description of catalogue 5";
            String d5 = "This is the description of catalogue 5";
            Icon i5 = new Icon("/i1.png");
            Collaborator cr5 = collaboratorController.getCollaboratorByEmail("colabE@bootstrapper.com");
            long c5Id = 105;
            Optional<Criticality> crit5 = criticalityController.findCriticalityByID(c5Id);
            Set<Team> allowedTeamList5 = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr5));
            Catalogue c5 = new Catalogue(t5, bd5, d5, i5, cr5, crit5.orElse(null), allowedTeamList5);
            addCatalogue(c5);

            //CATALOGUE 6
            Title t6 = new Title("Catalogue 6");
            String bd6 = "This is the brief description of catalogue 6";
            String d6 = "This is the description of catalogue 6";
            Icon i6 = new Icon("/i6.png");
            Collaborator cr6 = collaboratorController.getCollaboratorByEmail("colabF@bootstrapper.com");
            long c6Id = 106;
            Optional<Criticality> crit6 = criticalityController.findCriticalityByID(c6Id);
            Set<Team> allowedTeamList6 = new HashSet<>();
            allowedTeamList.add(teamController.getTeamByCollaborator(cr6));
            Catalogue c6 = new Catalogue(t6, bd6, d6, i6, cr6, crit6.orElse(null), allowedTeamList6);
            addCatalogue(c6);
            System.out.println("========================");
            System.out.println("Bootstrapping Catalogues...");
            System.out.println("========================");
            return true;
        }

        private boolean addCatalogue(Catalogue catalogue) {
            try {
                catalogueController.addCatalogue(catalogue);
            } catch (final ConcurrencyException | IntegrityViolationException e) {
                // ignoring exception. assuming it is just a primary key violation
                // due to the tentative of inserting a duplicated user
                LOGGER.warn("Assuming {} already exists (activate trace log for details)", catalogue);
                LOGGER.trace("Assuming existing record", e);
            }
            return true;
        }
    }


