package eapli.base.Collaborator.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CollaboratorPhoneNumber implements ValueObject, Comparable<CollaboratorPhoneNumber> {

    private String phoneNumber;


    public CollaboratorPhoneNumber(final String numberPhone) {
        if (StringPredicates.isNullOrEmpty(numberPhone)) {
            throw new IllegalArgumentException(
                    "Name attribute should neither be null nor empty");
        }
        if (numberPhone.matches("\\d{9}")) {
            this.phoneNumber = numberPhone;
        }
    }

    protected CollaboratorPhoneNumber() {

    }

    public static CollaboratorPhoneNumber valueOf(final String phoneNumber) {
        return new CollaboratorPhoneNumber(phoneNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollaboratorPhoneNumber)) {
            return false;
        }

        final CollaboratorPhoneNumber that = (CollaboratorPhoneNumber) o;
        return this.phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return this.phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return this.phoneNumber;
    }

    @Override
    public int compareTo(CollaboratorPhoneNumber o) {
        return phoneNumber.compareTo(o.phoneNumber);
    }
}
