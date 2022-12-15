package eapli.base.Task.domain.Manual;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTaskManualBase implements ValueObject, Comparable<CodeTaskManualBase> {


    private String code;

    public CodeTaskManualBase(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTaskManualBase() {
        // for ORM
    }

    public static CodeTaskManualBase valueOf(final String code) {
        return new CodeTaskManualBase(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTaskManualBase)) {
            return false;
        }

        final CodeTaskManualBase that = (CodeTaskManualBase) o;
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
    public int compareTo(final CodeTaskManualBase arg0) {
        return code.compareTo(arg0.code);
    }
}