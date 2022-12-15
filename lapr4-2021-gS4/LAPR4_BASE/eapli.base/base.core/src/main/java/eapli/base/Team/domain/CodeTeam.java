package eapli.base.Team.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class CodeTeam implements ValueObject, Comparable<CodeTeam> {


    private String code;

    public CodeTeam(final String code) {
        if (StringPredicates.isNullOrEmpty(code)) {
            throw new IllegalArgumentException(
                    "Code should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.code = code;
    }

    protected CodeTeam() {
        // for ORM
    }

    public static CodeTeam valueOf(final String code) {
        return new CodeTeam(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeTeam)) {
            return false;
        }

        final CodeTeam that = (CodeTeam) o;
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
    public int compareTo(final CodeTeam arg0) {
        return code.compareTo(arg0.code);
    }
}