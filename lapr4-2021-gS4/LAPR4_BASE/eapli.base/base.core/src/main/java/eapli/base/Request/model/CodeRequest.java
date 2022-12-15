package eapli.base.Request.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeRequest implements ValueObject, Comparable<CodeRequest>{
    private String code;

    public CodeRequest(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeRequest() {
        // for ORM
    }

    public static CodeRequest valueOf(final String code) {
        return new CodeRequest(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeRequest)) {
            return false;
        }

        final CodeRequest that = (CodeRequest) o;
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
    public int compareTo(final CodeRequest arg0) {
        return code.compareTo(arg0.code);
    }
}

