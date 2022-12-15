package eapli.base.criticality.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import javax.persistence.Embeddable;

@Embeddable
public class CriticalityID implements ValueObject, Comparable<CriticalityID> {

    private Long id;

    public CriticalityID(final Long id) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(id))) {
            throw new IllegalArgumentException(
                    "CriticalityID should neither be null nor empty");
        }
        this.id = id;
    }

    protected CriticalityID() {
    }

    public static CriticalityID valueOf(final Long id) {
        return new CriticalityID(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CriticalityID)) {
            return false;
        }

        final CriticalityID that = (CriticalityID) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }


    @Override
    public int compareTo(final CriticalityID o) {
        return id.compareTo(o.id);
    }


}
