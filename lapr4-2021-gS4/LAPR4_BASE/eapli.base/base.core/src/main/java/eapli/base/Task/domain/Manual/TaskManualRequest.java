package eapli.base.Task.domain.Manual;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.form.domain.TaskRequestForm;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class TaskManualRequest implements AggregateRoot<CodeTaskManualRequest> {

    @EmbeddedId
    private CodeTaskManualRequest code;

    private String description;

    @ManyToOne
    private Collaborator responsibleCollaborator;

    private TaskState taskState;

    private Date limitDate;

    private int standardResolutionTime;

    private Date attributionDate;

    @OneToOne
    private TaskRequestForm taskRequestForm;

    public TaskManualRequest(final CodeTaskManualRequest code, final String description, final Collaborator responsibleCollaborator, final TaskState taskState, final Date limitDate, final int standardResolutionTime, final Date attributionDate) {
        if (code == null || description == null||responsibleCollaborator==null) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.description = description;
        this.responsibleCollaborator = responsibleCollaborator;
        this.taskState = taskState;
        this.limitDate = limitDate;
        this.standardResolutionTime = standardResolutionTime;
        this.attributionDate = attributionDate;
    }

    public TaskManualRequest(TaskManualBase baseTask, String code, Collaborator responsibleCollaborator, TaskRequestForm taskRequestForm) {
        this.code = CodeTaskManualRequest.valueOf(code + baseTask.getCode());
        this.description = baseTask.getDescription();
        this.responsibleCollaborator = responsibleCollaborator;
        this.taskState = TaskState.Uncompleted;
        this.limitDate = baseTask.getLimitDate();
        this.standardResolutionTime = baseTask.getStandardResolutionTime();
        this.attributionDate = new Date();
        this.taskRequestForm = taskRequestForm;
    }

    protected TaskManualRequest() {
    }

    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }

    public void setAttributionDate(Date attributionDate) {
        this.attributionDate = attributionDate;
    }

    public CodeTaskManualRequest getCode() {
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

    public Date getLimitDate() {
        return limitDate;
    }

    public int getStandardResolutionTime() {
        return standardResolutionTime;
    }

    public Date getAttributionDate() {
        return attributionDate;
    }

    public TaskRequestForm getTaskRequestForm() {
        return taskRequestForm;
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
    public CodeTaskManualRequest identity() {
        return this.code;
    }

    @Override
    public String toString() {

        return String.format("Task->Code:%s,Description:%s,Responsible Collaborator:%s,Task State:%s", code, description, responsibleCollaborator, taskState);

    }

}