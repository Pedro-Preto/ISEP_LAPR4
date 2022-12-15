package eapli.base.Collaborator.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CollaboratorAddress implements ValueObject, Comparable<CollaboratorAddress> {

    private String street;
    private String locality;
    private String country;


    public CollaboratorAddress(final String streetName, final String localityName, final String countryName) {
        if (StringPredicates.isNullOrEmpty(streetName) || StringPredicates.isNullOrEmpty(localityName) || StringPredicates.isNullOrEmpty(countryName)) {
            throw new IllegalArgumentException(
                    "Address attributes should neither be null nor empty");
        }
        // expression
        this.street = streetName;
        this.locality = localityName;
        this.country = countryName;
    }

    protected CollaboratorAddress() {
        // for ORM
    }

    public static CollaboratorAddress valueOf(final String street, final String localidade, final String country) {
        return new CollaboratorAddress(street, localidade, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollaboratorAddress)) return false;
        CollaboratorAddress address = (CollaboratorAddress) o;
        return Objects.equals(street, address.street) && Objects.equals(locality, address.locality) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, locality, country);
    }

    @Override
    public String toString() {
        return String.format("Street-%s,Locality-%s,Country-%s", street, locality, country);
    }

    @Override
    public int compareTo(final CollaboratorAddress arg0) {
        return street.compareTo(arg0.street);
    }
}


