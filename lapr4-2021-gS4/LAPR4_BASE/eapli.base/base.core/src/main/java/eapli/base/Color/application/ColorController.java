package eapli.base.Color.application;

import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.domain.ColorHexCode;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class ColorController {

    private final ColorRepository colorRepository = PersistenceContext.repositories().colors();

    public Color addColor(String colorName, String hexCode) {
        Color c = new Color(ColorDesignation.valueOf(colorName), ColorHexCode.valueOf(hexCode));
        return colorRepository.save(c);
    }

    public List<Color> getAllColors() {
        return (List<Color>) colorRepository.findAll();
    }

    public Color getCollorByDesignation(ColorDesignation designation) {
        return colorRepository.findColorByDesignation(designation);
    }

}
