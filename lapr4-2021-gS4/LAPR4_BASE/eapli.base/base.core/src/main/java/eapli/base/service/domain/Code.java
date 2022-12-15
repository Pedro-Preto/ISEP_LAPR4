package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Code implements ValueObject, Comparable<Code> {

    private String code;

    public Code(final String serviceCode) {
        if (StringPredicates.isNullOrEmpty(serviceCode)) {
            throw new IllegalArgumentException(
                    "Service Code should neither be null nor empty");
        }
        this.code = serviceCode;
    }

    protected Code() {
    }

    public static Code valueOf(final String serviceCode) {
        return new Code(serviceCode);
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
    public int compareTo(final Code o) {
        return code.compareTo(o.code);
    }
}
