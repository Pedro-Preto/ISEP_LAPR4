package eapli.base.form.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class TaskRequestForm implements AggregateRoot<RequestFormId> {

    @EmbeddedId
    private RequestFormId id;
    private String name;
    @ElementCollection
    private Set<FormAttribute> formAttributes;

    public TaskRequestForm(RequestFormId id, String name, Set<FormAttribute> formAttributes) {
        this.id = id;
        this.name = name;
        this.formAttributes = formAttributes;
    }

    public TaskRequestForm(TaskBaseForm baseForm, String requestId) {
        this.id = RequestFormId.valueOf(requestId + baseForm.id().toString());
        this.name = baseForm.getName();
        this.formAttributes = baseForm.getAttributes();

        System.out.println(formAttributes);
        //System.out.println();
        //System.out.println(baseForm.getAttributes());

    }

    public TaskRequestForm() {
    }

    public Set<FormAttribute> getAttributes() {
        return this.formAttributes;
    }

    public void setAttributes(Set<FormAttribute> formAttributes) {
        this.formAttributes = formAttributes;
    }

    public RequestFormId getId() {
        return id;
    }

    public void setId(RequestFormId id) {
        this.id = id;
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

    public RequestFormId id() {
        return identity();
    }

    @Override
    public RequestFormId identity() {
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
