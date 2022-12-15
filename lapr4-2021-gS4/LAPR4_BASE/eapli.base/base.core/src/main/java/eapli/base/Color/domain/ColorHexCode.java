package eapli.base.Color.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class ColorHexCode implements ValueObject {


    private String hexCode;

    public ColorHexCode(final String name) {
        if (StringPredicates.isNullOrEmpty(name)) {
            throw new IllegalArgumentException(
                    "Color HexCode should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.hexCode = name;
    }

    protected ColorHexCode() {
        // for ORM
    }

    public static ColorHexCode valueOf(final String code) {
        return new ColorHexCode(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ColorHexCode)) {
            return false;
        }

        final ColorHexCode that = (ColorHexCode) o;
        return this.hexCode.equals(that.hexCode);
    }

    @Override
    public int hashCode() {
        return this.hexCode.hashCode();
    }

    @Override
    public String toString() {
        return this.hexCode;
    }

}
