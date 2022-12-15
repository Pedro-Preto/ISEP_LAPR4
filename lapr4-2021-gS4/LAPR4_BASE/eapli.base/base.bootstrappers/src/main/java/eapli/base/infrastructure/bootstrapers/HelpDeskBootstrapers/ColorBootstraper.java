package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Color.application.ColorController;
import eapli.base.Color.domain.Color;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorBootstraper implements Action {


    private static final Logger LOGGER = LoggerFactory.getLogger(ColorBootstraper.class);

    private final ColorRepository colorRepository = PersistenceContext.repositories().colors();
    private final ColorController colorController = new ColorController();

    @Override
    public boolean execute() {
        String blue = "blue";
        String blueHexCode = "#0000FF";
        addColor(blue, blueHexCode);

        String red = "red";
        String redHexCode = "#FF0000";
        addColor(red, redHexCode);

        String gold = "gold";
        String goldHexcode = "#FFD700";
        addColor(gold, goldHexcode);

        String green = "green";
        String greenHexcode = "#00FF00";
        addColor(green, greenHexcode);

        String silver = "silver";
        String silverHexcode = "#C0C0C0";
        addColor(silver, silverHexcode);

        String pink = "pink";
        String pinkHexCode = "#FFC0CB";
        addColor(pink, pinkHexCode);
        System.out.println("========================");
        System.out.println("Bootstrapping Colors...");
        System.out.println("========================");

        return true;
    }

    private boolean addColor(final String colorName, final String hexCode) {
        try {
            colorController.addColor(colorName, hexCode);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", colorName);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
}
