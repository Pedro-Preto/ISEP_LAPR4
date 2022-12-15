package eapli.base.Team.domain;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.TeamType.domain.TeamType;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team implements AggregateRoot<CodeTeam> {


    @EmbeddedId
    private CodeTeam code;

    private String designation;

    @Column(unique = true)
    private Acronym acronym;

    @ManyToOne
    private TeamType teamType;

    @ManyToOne
    private Collaborator responsibleCollaborator;

    @ManyToMany
    private Set<Collaborator> teamCollaborators;

    public Team(final CodeTeam code, final String designation, final Acronym acronym, final TeamType teamType, final Collaborator responsibleCollaborator, final Set<Collaborator> teamCollaborators) {
       if(code==null||designation==null||acronym==null||acronym.toString().length()>10||teamType==null||responsibleCollaborator==null){
           throw new IllegalArgumentException();
       }
        this.code = code;
        this.designation = designation;
        this.acronym = acronym;
        this.teamType = teamType;
        this.responsibleCollaborator = responsibleCollaborator;
        this.teamCollaborators = teamCollaborators;
    }

    protected Team() {
    }

    public boolean addCollaboratorToTeam(Collaborator collaborator) {
        return this.teamCollaborators.add(collaborator);
    }

    public boolean removeCollaboratorFromTeam(Collaborator collaborator) {
        return this.teamCollaborators.remove(collaborator);
    }

    public CodeTeam getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    public Set<Collaborator> getTeamCollaborators() {
        return teamCollaborators;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public CodeTeam identity() {
        return this.code;
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
    public String toString() {
        return String.format("Team: Code-:%s,Designation:%s, Acronym:%s,Team Type:%s,Responsible Collaborator:%s", code, designation, acronym, teamType, responsibleCollaborator);
    }
}
