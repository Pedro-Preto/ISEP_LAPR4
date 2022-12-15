package eapli.base.service.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Keyword implements ValueObject, Comparable<Keyword> {

    private String keyword;

    public Keyword(final String serviceKeyword) {
        if (StringPredicates.isNullOrEmpty(serviceKeyword)) {
            throw new IllegalArgumentException(
                    "Service Keyword should neither be null nor empty");
        }
        this.keyword = serviceKeyword;
    }

    protected Keyword() {
    }

    public static Keyword valueOf(final String serviceKeyword) {
        return new Keyword(serviceKeyword);
    }

    @Override
    public int hashCode() {
        return this.keyword.hashCode();
    }

    @Override
    public String toString() {
        return this.keyword;
    }

    @Override
    public int compareTo(final Keyword o) {
        return keyword.compareTo(o.keyword);
    }
}