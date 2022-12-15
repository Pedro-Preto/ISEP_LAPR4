package eapli.base.catalogue.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Icon implements ValueObject, Comparable<Icon> {

    private String path;

    public Icon(final String iconPath) {
        if (StringPredicates.isNullOrEmpty(iconPath)) {
            throw new IllegalArgumentException(
                    "Icon Path should neither be null nor empty");
        }
        this.path = iconPath;
    }

    protected Icon() {
    }

    public static Icon valueOf(final String iconPath) {
        return new Icon(iconPath);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Icon)) {
            return false;
        }

        final Icon that = (Icon) o;
        return this.path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return this.path.hashCode();
    }

    @Override
    public String toString() {
        return this.path;
    }


    @Override
    public int compareTo(final Icon o) {
        return path.compareTo(o.path);
    }


}
