package eapli.base.Color.repository;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Color.domain.Color;
import eapli.base.Color.domain.ColorDesignation;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ColorRepository extends DomainRepository<ColorDesignation, Color> {

    public Color findColorByDesignation(ColorDesignation designation) ;



    public Iterable<Color> findAll();


}
