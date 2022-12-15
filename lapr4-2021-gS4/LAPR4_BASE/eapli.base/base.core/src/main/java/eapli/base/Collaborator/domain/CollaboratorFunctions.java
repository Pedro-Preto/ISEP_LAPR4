package eapli.base.Collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Date;

public class CollaboratorFunctions implements ValueObject,Comparable<CollaboratorFunctions> {
    private String functions;

    public CollaboratorFunctions(final String funct) {
        if (funct == null) {
            throw new IllegalArgumentException(
                    "Address attributes should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression

        this.functions = funct;
    }

    protected CollaboratorFunctions() {

    }

    public static CollaboratorFunctions valueOf(final String functions) {
        return new CollaboratorFunctions(functions);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollaboratorFunctions)) {
            return false;
        }

        final CollaboratorFunctions that = (CollaboratorFunctions) o;
        return this.functions.equals(that.functions);
    }

    @Override
    public int hashCode() {
        return this.functions.hashCode();
    }

    @Override
    public String toString() {
        return this.functions.toString();
    }

    @Override
    public int compareTo(CollaboratorFunctions o) {
        return functions.compareTo(o.functions);
    }
}


