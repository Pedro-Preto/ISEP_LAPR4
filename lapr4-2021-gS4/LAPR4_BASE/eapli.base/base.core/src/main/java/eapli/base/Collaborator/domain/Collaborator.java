/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.Collaborator.domain;

import eapli.base.Utils.AgeCalculator;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Collaborator implements AggregateRoot<MecanographicNumber> {

    @EmbeddedId
    @Column(unique = true)
    private MecanographicNumber numMechanographic;

    private CollaboratorFirstName firstName;

    private CollaboratorLastName lastName;

    private EmailAddress email;

    private CollaboratorPhoneNumber phoneNumber;

    @Temporal(TemporalType.DATE)
    private CollaboratorBirthDay birthDate;

    private CollaboratorAddress address;

    @ElementCollection
    private Set<CollaboratorFunctions> function;

    public Collaborator(MecanographicNumber numMechanographic, CollaboratorFirstName firstName, CollaboratorLastName lastName, EmailAddress email, CollaboratorPhoneNumber phoneNumber, CollaboratorBirthDay birthDate, CollaboratorAddress address, Set<CollaboratorFunctions> function) {
        if (numMechanographic == null || firstName == null || lastName == null || email == null || phoneNumber == null || birthDate == null || address == null || function == null) {
            throw new IllegalArgumentException();
        }
        this.numMechanographic = numMechanographic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.function = function;
    }


    protected Collaborator() {

    }

    public MecanographicNumber getNumMechanographic() {
        return numMechanographic;
    }

    public CollaboratorFirstName getFirstName() {
        return firstName;
    }

    public CollaboratorLastName getLastName() {
        return lastName;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public CollaboratorPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public CollaboratorBirthDay getBirthDate() {
        return birthDate;
    }

    public CollaboratorAddress getAddress() {
        return address;
    }

    public Set<CollaboratorFunctions> getFunction() {
        return function;
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


    @Override
    public MecanographicNumber identity() {
        return this.numMechanographic;
    }

    @Override
    public String toString() {
        return String.format("Collaborator: Mechanographic Number: %s, Name: %s %s,Function: %s", numMechanographic, firstName, lastName, function);
    }
}
