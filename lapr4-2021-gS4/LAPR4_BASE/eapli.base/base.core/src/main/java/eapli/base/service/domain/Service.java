package eapli.base.service.domain;

import eapli.base.Task.domain.TaskWorkFlow;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.Icon;
import eapli.base.catalogue.domain.Title;
import eapli.base.form.domain.BaseForm;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service implements AggregateRoot<Code> {

    private Title title;
    private String briefDescription;
    private String description;
    @EmbeddedId
    private Code code;
    private Icon icon;
    @ManyToOne
    private Catalogue catalogue;
    @ElementCollection
    private Set<Keyword> keywords;

    @OneToOne
    private BaseForm baseForm; //if null, then its not complete

    @OneToOne
    private TaskWorkFlow taskWorkFlow; //if null, then its not complete

    public Service(final Title title, final String briefDescription, final String description, final Code code, final Icon icon, final Catalogue catalogue, final Set<Keyword> keywords) {
        if (title == null || briefDescription == null || description == null || code == null  || icon == null || catalogue == null || keywords == null ) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.briefDescription = briefDescription;
        this.description = description;
        this.code = code;
        this.icon = icon;
        this.catalogue = catalogue;
        this.keywords = keywords;
    }

    protected Service() {
    }

    public Code getCode() {
        return code;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setBaseForm(BaseForm baseForm) {
        this.baseForm = baseForm;
    }

    public BaseForm getBaseForm() {
        return baseForm;
    }

    public TaskWorkFlow getTaskWorkFlow() {
        return taskWorkFlow;
    }

    public void setTaskWorkFlow(TaskWorkFlow taskWorkFlow) {
        this.taskWorkFlow = taskWorkFlow;
    }

    public boolean addKeyword(Keyword keyword) {
        return this.keywords.add(keyword);
    }

    public boolean removeKeyword(Keyword keyword) {
        return this.keywords.remove(keyword);
    }

    public Catalogue getCatalogue() {
        return catalogue;
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

    public Code code() {
        return identity();
    }

    @Override
    public Code identity() {
        return this.code;
    }

    public Title getTitle() {
        return title;
    }

    public boolean hasForm(){
        if(this.baseForm == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        //TODO toString Service
        return null;
    }

}