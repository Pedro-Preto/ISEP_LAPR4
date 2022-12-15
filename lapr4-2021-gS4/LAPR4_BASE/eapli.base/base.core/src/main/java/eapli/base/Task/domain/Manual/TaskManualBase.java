package eapli.base.Task.domain.Manual;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.form.domain.TaskBaseForm;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TaskManualBase implements AggregateRoot<CodeTaskManualBase> {

    @EmbeddedId
    private CodeTaskManualBase code;

    private String description;

    @ManyToOne
    private Collaborator responsibleCollaborator;

    private TaskState taskState;

    private Date limitDate;

    private int standardResolutionTime;

    private Date attributionDate;

    @OneToOne
    private TaskBaseForm taskBaseForm;

    public TaskManualBase(final CodeTaskManualBase code, final String description, final Collaborator responsibleCollaborator, final TaskState taskState, final Date limitDate, final int standardResolutionTime, final Date atributtionDate) {
        if (code == null || description == null) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.description = description;
        this.responsibleCollaborator = responsibleCollaborator;
        this.taskState = taskState;
        this.limitDate = limitDate;
        this.standardResolutionTime = standardResolutionTime;
        this.attributionDate = atributtionDate;

    }
    
    protected TaskManualBase() {
    }

    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }

    public CodeTaskManualBase getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public void setTaskBaseForm(TaskBaseForm taskBaseForm) {
        this.taskBaseForm = taskBaseForm;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public int getStandardResolutionTime() {
        return standardResolutionTime;
    }

    public TaskBaseForm getTaskBaseForm() {
        return taskBaseForm;
    }

    public Date getAttributionDate() {
        return attributionDate;
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
    public CodeTaskManualBase identity() {
        return this.code;
    }

    @Override
    public String toString() {

                return String.format("Task->Code:%s,Description:%s,Responsible Collaborator:%s,Task State:%s", code, description, responsibleCollaborator, taskState);

     }

}