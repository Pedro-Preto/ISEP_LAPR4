package eapli.base.Color.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class ColorDesignation implements ValueObject, Comparable<ColorDesignation> {

    private String designation;

    public ColorDesignation(final String name) {
        if (StringPredicates.isNullOrEmpty(name)) {
            throw new IllegalArgumentException(
                    "Color name should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.designation = name;
    }

    protected ColorDesignation() {
        // for ORM
    }

    public static ColorDesignation valueOf(final String designation) {
        return new ColorDesignation(designation);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ColorDesignation)) {
            return false;
        }

        final ColorDesignation that = (ColorDesignation) o;
        return this.designation.equals(that.designation);
    }

    @Override
    public int hashCode() {
        return this.designation.hashCode();
    }

    @Override
    public String toString() {
        return this.designation;
    }

    @Override
    public int compareTo(ColorDesignation o) {
        return designation.compareTo(o.designation);
    }
}
