package eapli.base.catalogue.domain;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Team.domain.Team;
import eapli.base.criticality.domain.Criticality;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Catalogue implements AggregateRoot<Title> {

    @EmbeddedId
    private Title title;

    private String briefDescription;
    private String description;
    private Icon icon;
    @ManyToOne
    private Collaborator responsible;
    @ManyToOne
    private Criticality criticality;
    @ManyToMany
    private Set<Team> allowedTeamList;

    public Catalogue(final Title title, final String briefDescription, final String description, final Icon icon, final Collaborator responsible, final Criticality criticality, final Set<Team> allowedTeamList) {
        if (title == null || briefDescription == null || description == null || icon == null || responsible == null || criticality == null) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.briefDescription = briefDescription;
        this.description = description;
        this.icon = icon;
        this.responsible = responsible;
        this.criticality = criticality;
        this.allowedTeamList = allowedTeamList;
    }

    protected Catalogue() {
    }

    public Set<Team> getAllowedTeamList() {
        return allowedTeamList;
    }

    public boolean addTeam(Team team) {
        return this.allowedTeamList.add(team);
    }

    public boolean removeTeam(Team team) {
        return this.allowedTeamList.remove(team);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Title title() {
        return identity();
    }

    public Title getTitle() {
        return title;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getDescription() {
        return description;
    }

    public Icon getIcon() {
        return icon;
    }

    public Collaborator getResponsible() {
        return responsible;
    }

    public Criticality getCriticality() {
        return criticality;
    }

    @Override
    public Title identity() {
        return this.title;
    }

    @Override
    public String toString() {
        return "\nCatalogue: " +title +" \nBrief Description: " +briefDescription +"\nDescription: " +description +"\nCriticality: " +criticality +"\nCollaborator Responsable for this Catalogue: " +responsible +"\n";
    }
}

