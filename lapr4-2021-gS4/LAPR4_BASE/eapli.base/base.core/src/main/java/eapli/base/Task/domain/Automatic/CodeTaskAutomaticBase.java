package eapli.base.Task.domain.Automatic;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTaskAutomaticBase implements ValueObject, Comparable<CodeTaskAutomaticBase> {


    private String code;

    public CodeTaskAutomaticBase(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTaskAutomaticBase() {
        // for ORM
    }

    public static CodeTaskAutomaticBase valueOf(final String code) {
        return new CodeTaskAutomaticBase(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTaskAutomaticBase)) {
            return false;
        }

        final CodeTaskAutomaticBase that = (CodeTaskAutomaticBase) o;
        return this.code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public String toString() {
        return this.code;
    }

    @Override
    public int compareTo(final CodeTaskAutomaticBase arg0) {
        return code.compareTo(arg0.code);
    }
}