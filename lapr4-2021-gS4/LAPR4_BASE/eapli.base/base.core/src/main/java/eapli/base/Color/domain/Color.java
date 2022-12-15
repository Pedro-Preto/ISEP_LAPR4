package eapli.base.Color.domain;

import eapli.base.catalogue.domain.Title;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Color implements AggregateRoot<ColorDesignation> {


    @EmbeddedId
    private ColorDesignation designation;

    private ColorHexCode hexCode;

    public Color(final ColorDesignation designation,final ColorHexCode hexCode) {
        this.designation = designation;
        this.hexCode = hexCode;
    }

    protected Color() {

    }

    public ColorDesignation getDesignation() {
        return designation;
    }

    public ColorHexCode getHexCode() {
        return hexCode;
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public ColorDesignation identity() {
        return this.designation;
    }

    public ColorDesignation designation() {
        return identity();
    }

    @Override
    public String toString() {
        return String.format("%s, HexCode:%s",designation,hexCode);
    }
}
