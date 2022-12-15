package eapli.base.form.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TaskBaseForm implements AggregateRoot<BaseFormId> {

    @EmbeddedId
    private BaseFormId id;
    private String name;
    @ElementCollection
    private Set<FormAttribute> formAttributes;

    public TaskBaseForm(BaseFormId id, String name) {
        this.id = id;
        this.name = name;
        this.formAttributes = new HashSet<>();
    }

    public TaskBaseForm() {
    }

    public TaskBaseForm addAttribute(FormAttribute formAttribute) {
        formAttributes.add(formAttribute);
        return this;
    }

    public Set<FormAttribute> getAttributes() {
        return this.formAttributes;
    }

    public BaseFormId getId() {
        return id;
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

    public BaseFormId id() {
        return identity();
    }

    @Override
    public BaseFormId identity() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        //TODO toString Service
        return null;
    }
}
