package eapli.base.contract.domain;

import eapli.base.criticality.domain.Criticality;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract  implements AggregateRoot<ContractID> {

    @EmbeddedId
    private ContractID id;
    @OneToMany
    private Set<Criticality> criticalities;


    public Contract(final Set<Criticality> criticalities, final ContractID id) {
        if (criticalities == null ) {
            throw new IllegalArgumentException();
        }
        if (id == null){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.criticalities = criticalities;
    }

    protected Contract() {
    }

    public Set<Criticality> getCriticalities() {
        return criticalities;
    }

    public ContractID getContractID(){
        return this.id;
    }

    public boolean addCriticalityToContract(Criticality criticality) {
        return this.criticalities.add(criticality);
    }

    public boolean removeCriticalityToContract(Criticality criticality) {
        return this.criticalities.remove(criticality);
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

    public ContractID code() {
        return identity();
    }

    @Override
    public ContractID identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", criticalities=" + criticalities +
                '}';
    }
}