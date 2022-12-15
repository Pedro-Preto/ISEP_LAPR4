package eapli.base.Task.domain.Manual;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTaskManualRequest implements ValueObject, Comparable<CodeTaskManualRequest> {


    private String code;

    public CodeTaskManualRequest(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTaskManualRequest() {
        // for ORM
    }

    public static CodeTaskManualRequest valueOf(final String code) {
        return new CodeTaskManualRequest(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTaskManualRequest)) {
            return false;
        }

        final CodeTaskManualRequest that = (CodeTaskManualRequest) o;
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
    public int compareTo(final CodeTaskManualRequest arg0) {
        return code.compareTo(arg0.code);
    }
}