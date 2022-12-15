package eapli.base.Task.domain.Automatic;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTaskAutomaticRequest implements ValueObject, Comparable<CodeTaskAutomaticRequest> {


    private String code;

    public CodeTaskAutomaticRequest(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTaskAutomaticRequest() {
        // for ORM
    }

    public static CodeTaskAutomaticRequest valueOf(final String code) {
        return new CodeTaskAutomaticRequest(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTaskAutomaticRequest)) {
            return false;
        }

        final CodeTaskAutomaticRequest that = (CodeTaskAutomaticRequest) o;
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
    public int compareTo(final CodeTaskAutomaticRequest arg0) {
        return code.compareTo(arg0.code);
    }
}