package eapli.base.TeamType.domain;

import eapli.base.Color.domain.Color;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TeamType implements AggregateRoot<CodeTeamType> {

    @EmbeddedId
    private CodeTeamType code;

    private String designation;

    @ManyToOne
    private Color color;

    public TeamType(final CodeTeamType code, final String designation, final Color color) {
        if (code == null || designation == null || color == null || designation.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.designation = designation;
        this.color = color;
    }

    protected TeamType() {

    }

    @Override
    public String toString() {
        return String.format("Team Type: Code-%s, Designation-%s, Color-%s", code, designation, color);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    public CodeTeamType getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public CodeTeamType identity() {
        return this.code;
    }
}
