package eapli.base.Collaborator.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class CollaboratorLastName implements ValueObject , Comparable<CollaboratorLastName> {

    private String lastName;



    public CollaboratorLastName( final String nameFull) {
        if ( StringPredicates.isNullOrEmpty(nameFull) ) {
            throw new IllegalArgumentException(
                    "Name attribute should neither be null nor empty");
        }
        // expression
        this.lastName = nameFull;
    }
    protected CollaboratorLastName() {

    }
    public static CollaboratorLastName valueOf( final String lastName) {
        return new CollaboratorLastName(lastName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollaboratorLastName)) return false;
        CollaboratorLastName that = (CollaboratorLastName) o;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return String.format("%s",lastName);
    }

    @Override
    public int compareTo(CollaboratorLastName o) {
        return lastName.compareToIgnoreCase(o.lastName);
    }
}
