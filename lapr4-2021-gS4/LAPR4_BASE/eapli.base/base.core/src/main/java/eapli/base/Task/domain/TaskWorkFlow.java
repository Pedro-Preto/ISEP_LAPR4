package eapli.base.Task.domain;

import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class TaskWorkFlow implements AggregateRoot<CodeTaskWorkFlow> {

    @EmbeddedId
    private CodeTaskWorkFlow code;

    @ManyToMany
    private Set<TaskManualBase> manualTasksSet;

    @ManyToMany
    private Set<TaskAutomaticBase> automaticTasksSet;

    public TaskWorkFlow(final CodeTaskWorkFlow code, final Set<TaskManualBase> manualTasksSet, final Set<TaskAutomaticBase> automaticTasksSet) {
        if (code == null) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.manualTasksSet = manualTasksSet;
        this.automaticTasksSet = automaticTasksSet;
    }

    protected TaskWorkFlow() {
    }

    public boolean addManualTasksToWorkFlow(TaskManualBase task) {
        return this.manualTasksSet.add(task);
    }

    public boolean addAutomaticTasksToWorkFlow(TaskAutomaticBase task) {
        return this.automaticTasksSet.add(task);
    }

    public CodeTaskWorkFlow getCode() {
        return code;
    }

    public Set<TaskManualBase> getManualTasksSet() {
        return manualTasksSet;
    }

    public Set<TaskAutomaticBase> getAutomaticTasksSet() {
        return automaticTasksSet;
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
    public CodeTaskWorkFlow identity() {
        return this.code;
    }

    @Override
    public String toString() {
        return String.format("Task Work flow->Code:%s,Task Set:%s", code, manualTasksSet);
    }
}
