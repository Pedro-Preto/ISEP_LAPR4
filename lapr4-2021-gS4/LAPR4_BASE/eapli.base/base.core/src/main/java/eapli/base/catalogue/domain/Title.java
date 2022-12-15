package eapli.base.catalogue.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Title implements ValueObject, Comparable<Title> {

    private String name;

    public Title(final String titleName) {
        if (StringPredicates.isNullOrEmpty(titleName)) {
            throw new IllegalArgumentException(
                    "Title should neither be null nor empty");
        }
        this.name = titleName;
    }

    protected Title() {
    }

    public static Title valueOf(final String titleName) {
        return new Title(titleName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(final Title o) {
        return name.compareTo(o.name);
    }
}
