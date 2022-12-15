package eapli.base.Team.domain;

import eapli.base.Utils.CoutingAlgorithms;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Acronym implements ValueObject, Comparable<Acronym> {

    private String acronym;

    public Acronym(final String acro) {
        if (StringPredicates.isNullOrEmpty(acro) ||getAcronymSize(acro) > 10) {
            throw new IllegalArgumentException(
                    "Acronym should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.acronym = acro;
    }

    protected Acronym() {
        // for ORM
    }

    public static Acronym valueOf(final String code) {
        return new Acronym(code);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Acronym)) {
            return false;
        }

        final Acronym that = (Acronym) o;
        return this.acronym.equals(that.acronym);
    }
    public static int getAcronymSize(String size){
        return CoutingAlgorithms.stringLength(size);
    }

    @Override
    public int hashCode() {
        return this.acronym.hashCode();
    }

    @Override
    public String toString() {
        return this.acronym;
    }

    @Override
    public int compareTo(final Acronym arg0) {
        return acronym.compareTo(arg0.acronym);
    }
}