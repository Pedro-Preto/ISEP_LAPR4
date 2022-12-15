package eapli.base.contract.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import javax.persistence.Embeddable;

@Embeddable
public class ContractID implements ValueObject, Comparable<ContractID> {

    private Long id;

    public ContractID(final Long id) {
        if (StringPredicates.isNullOrEmpty(String.valueOf(id))) {
            throw new IllegalArgumentException(
                    "ContractID should neither be null nor empty");
        }
        this.id = id;
    }

    protected ContractID() {
    }

    public static ContractID valueOf(final Long id) {
        return new ContractID(id);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ContractID)) {
            return false;
        }

        final ContractID that = (ContractID) o;
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
    public int compareTo(final ContractID o) {
        return id.compareTo(o.id);
    }


}
