package eapli.base.Task.domain.Automatic;

import eapli.base.Task.domain.Manual.TaskState;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TaskAutomaticBase implements AggregateRoot<CodeTaskAutomaticBase> {

    @EmbeddedId
    private CodeTaskAutomaticBase code;

    private String description;

    private Script script;

    private TaskState taskState;

    private Date limitDate;

    private int standardResolutionTime;

    public TaskAutomaticBase(CodeTaskAutomaticBase code, String description, Script script, TaskState taskState, Date limitDate, int standardResolutionTime) {
        this.code = code;
        this.description = description;
        this.script = script;
        this.taskState = taskState;
        this.limitDate = limitDate;
        this.standardResolutionTime = standardResolutionTime;
    }

    protected TaskAutomaticBase() {

    }

    public void setCode(CodeTaskAutomaticBase code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public CodeTaskAutomaticBase getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public int getStandardResolutionTime() {
        return standardResolutionTime;
    }

    public void setStandardResolutionTime(int standardResolutionTime) {
        this.standardResolutionTime = standardResolutionTime;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public Script getScript() {
        return script;
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
    public CodeTaskAutomaticBase identity() {
        return this.code;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    @Override
    public String toString() {

        return String.format("Task->Code:%s,Description:%s,Script:%s,Task State:%s,Limit Date:%s", code, description, script, taskState, limitDate);
    }
}
