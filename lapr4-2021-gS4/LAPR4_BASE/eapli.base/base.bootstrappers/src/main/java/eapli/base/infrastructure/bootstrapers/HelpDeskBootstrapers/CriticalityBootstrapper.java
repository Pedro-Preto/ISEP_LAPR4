package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.criticality.application.CriticalityController;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityID;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriticalityBootstrapper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(CriticalityBootstrapper.class);

    private final ColorController colorController = new ColorController();
    private final CriticalityController criticalityController = new CriticalityController();

    @Override
    public boolean execute() {
        long c1Id = 101;
        int c1Value = 4;
        int c1Scale = 10;
        String c1Color = "blue";
        int c1ApprovalMaxTime = 50;
        int c1ApprovalAverageTime = 20;
        int c1ResolutionMaxTime = 120;
        int c1ResolutionAverageTime = 90;
        addCriticality(c1Id,c1Value,c1Scale,c1Color,c1ApprovalMaxTime,c1ApprovalAverageTime, c1ResolutionMaxTime, c1ResolutionAverageTime);


        long c2Id = 102;
        int c2Value = 13;
        int c2Scale = 20;
        String c2Color = "red";
        int c2ApprovalMaxTime = 20;
        int c2ApprovalAverageTime = 10;
        int c2ResolutionMaxTime = 60;
        int c2ResolutionAverageTime = 40;
        addCriticality(c2Id,c2Value,c2Scale,c2Color,c2ApprovalMaxTime,c2ApprovalAverageTime, c2ResolutionMaxTime, c2ResolutionAverageTime);


        long c3Id = 103;
        int c3Value = 5;
        int c3Scale = 20;
        String c3Color = "gold";
        int c3ApprovalMaxTime = 30;
        int c3ApprovalAverageTime = 40;
        int c3ResolutionMaxTime = 80;
        int c3ResolutionAverageTime = 60;
        addCriticality(c3Id,c3Value,c3Scale,c3Color,c3ApprovalMaxTime,c3ApprovalAverageTime, c3ResolutionMaxTime, c3ResolutionAverageTime);


        long c4Id = 104;
        int c4Value = 15;
        int c4Scale = 20;
        String c4Color = "green";
        int c4ApprovalMaxTime = 40;
        int c4ApprovalAverageTime = 20;
        int c4ResolutionMaxTime = 160;
        int c4ResolutionAverageTime = 110;
        addCriticality(c4Id,c4Value,c4Scale,c4Color,c4ApprovalMaxTime,c4ApprovalAverageTime, c4ResolutionMaxTime, c4ResolutionAverageTime);


        long c5Id = 105;
        int c5Value = 8;
        int c5Scale = 10;
        String c5Color = "silver";
        int c5ApprovalMaxTime = 20;
        int c5ApprovalAverageTime = 10;
        int c5ResolutionMaxTime = 60;
        int c5ResolutionAverageTime = 50;
        addCriticality(c5Id,c5Value,c5Scale,c5Color,c5ApprovalMaxTime,c5ApprovalAverageTime, c5ResolutionMaxTime, c5ResolutionAverageTime);


        long c6Id = 106;
        int c6Value = 3;
        int c6Scale = 20;
        String c6Color = "pink";
        int c6ApprovalMaxTime = 20;
        int c6ApprovalAverageTime = 10;
        int c6ResolutionMaxTime = 90;
        int c6ResolutionAverageTime = 60;
        addCriticality(c6Id,c6Value,c6Scale,c6Color,c6ApprovalMaxTime,c6ApprovalAverageTime, c6ResolutionMaxTime, c6ResolutionAverageTime);
        System.out.println("==============================");
        System.out.println("Bootstrapping Criticality...");
        System.out.println("==============================");

        return true;
    }

    private boolean addCriticality(long id, int value, int scale, String colorName, int approvalMaxTime,
                                   int approvalAverageTime, int resolutionMaxTime, int resolutionAverageTime) {
        try {
            CriticalityID criticalityID = new CriticalityID(id);
            ColorDesignation colorDesignation = new ColorDesignation(colorName);
            Criticality criticality = new Criticality(criticalityID, value,scale,colorController.getCollorByDesignation(colorDesignation),approvalMaxTime,approvalAverageTime, resolutionMaxTime, resolutionAverageTime);
            criticalityController.addCriticality(criticality);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", colorName);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
