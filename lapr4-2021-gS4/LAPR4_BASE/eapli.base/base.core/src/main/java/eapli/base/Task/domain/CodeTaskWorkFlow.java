package eapli.base.Task.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTaskWorkFlow implements ValueObject, Comparable<CodeTaskWorkFlow> {


    private String code;

    public CodeTaskWorkFlow(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTaskWorkFlow() {
        // for ORM
    }

    public static CodeTaskWorkFlow valueOf(final String code) {
        return new CodeTaskWorkFlow(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTaskWorkFlow)) {
            return false;
        }

        final CodeTaskWorkFlow that = (CodeTaskWorkFlow) o;
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
    public int compareTo(final CodeTaskWorkFlow arg0) {
        return code.compareTo(arg0.code);
    }
}