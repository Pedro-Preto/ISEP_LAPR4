package eapli.base.TeamType.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTeamType implements ValueObject, Comparable<CodeTeamType> {


    private String code;

    public CodeTeamType(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTeamType() {
        // for ORM
    }

    public static CodeTeamType valueOf(final String code) {
        return new CodeTeamType(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTeamType)) {
            return false;
        }

        final CodeTeamType that = (CodeTeamType) o;
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
    public int compareTo(final CodeTeamType arg0) {
        return code.compareTo(arg0.code);
    }
}