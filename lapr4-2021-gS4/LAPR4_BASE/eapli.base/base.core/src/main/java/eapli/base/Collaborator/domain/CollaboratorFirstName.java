package eapli.base.Collaborator.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class CollaboratorFirstName implements ValueObject, Comparable<CollaboratorFirstName> {

    private String firstName;



    public CollaboratorFirstName(final String nameShort) {
        if (StringPredicates.isNullOrEmpty(nameShort) ) {
            throw new IllegalArgumentException(
                    "Name attribute should neither be null nor empty");
        }
        // expression
        this.firstName = nameShort;
    }
    protected CollaboratorFirstName() {

    }
    public static CollaboratorFirstName valueOf(final String firstName) {
        return new CollaboratorFirstName(firstName);
    }



    @Override
    public String toString() {
        return String.format("%s", firstName);
    }

    @Override
    public int compareTo(CollaboratorFirstName o) {
        return firstName.compareToIgnoreCase(o.firstName);
    }
}

