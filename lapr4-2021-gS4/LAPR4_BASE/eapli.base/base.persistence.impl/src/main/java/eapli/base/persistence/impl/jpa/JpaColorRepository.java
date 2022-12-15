package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.base.Color.repository.ColorRepository;
import eapli.base.catalogue.domain.Catalogue;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaColorRepository extends JpaAutoTxRepository<Color, ColorDesignation, ColorDesignation> implements ColorRepository {

    public JpaColorRepository(TransactionalContext autoTx) {
        super(autoTx, "colorName");
    }

    public JpaColorRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "colorName");
    }

    @Override
    public Color findColorByDesignation(ColorDesignation designation) {
        List<Color> colorList = (List<Color>) findAll();
        Color c = null;

        for (Color color : colorList)
            if (color.getDesignation().equals(designation))
                c = color;

        return c;
    }
}
