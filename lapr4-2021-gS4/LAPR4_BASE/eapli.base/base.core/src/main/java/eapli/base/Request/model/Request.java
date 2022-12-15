package eapli.base.Request.model;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Automatic.TaskAutomaticRequest;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.RequestForm;
import eapli.base.service.domain.Service;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Request implements AggregateRoot<CodeRequest> {

    @EmbeddedId
    private CodeRequest codeRequest;

    @OneToOne
    private Service service;


    private Date requestDate;

    private Date completionDate;

    private RequestState requestState;

    @ManyToOne
    private Collaborator requester;

    @ManyToOne
    private Collaborator beneficiary;

    @OneToOne
    private RequestForm requestForm;

    private RequestGrade requestGrade;

    @ManyToMany
    private List<TaskAutomaticRequest> automaticTasks;

    @ManyToMany
    private List<TaskManualRequest> manualTasks;


    public Request(CodeRequest codeRequest, Service service, Date requestDate, RequestState requestState, Collaborator requester, Collaborator beneficiary, RequestForm requestForm, RequestGrade requestGrade) {
        this.codeRequest = codeRequest;
        this.service = service;
        this.requestDate = requestDate;
        this.requestState = requestState;
        this.requester = requester;
        this.beneficiary = beneficiary;
        this.requestForm = requestForm;
        this.requestGrade = requestGrade;
        this.automaticTasks = new LinkedList<>();
        this.manualTasks = new LinkedList<>();
        this.completionDate = null;
    }

    protected Request() {
    }

    public void addAutomaticTask(TaskAutomaticRequest task) {
        automaticTasks.add(task);
    }

    public void addManualTask(TaskManualRequest task) {
        manualTasks.add(task);
    }

    public List<TaskAutomaticRequest> getAutomaticTasks(){
        return automaticTasks;
    }

    public List<TaskManualRequest> getManualTasks(){
        return manualTasks;
    }

    public CodeRequest getCodeRequest() {
        return codeRequest;
    }

    public Service getService() {
        return service;
    }

    public RequestForm getForm() {
        return requestForm;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Collaborator getRequester() {
        return requester;
    }

    public void setRequester(Collaborator requester) {
        this.requester = requester;
    }

    public Collaborator getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Collaborator beneficiary) {
        this.beneficiary = beneficiary;
    }

    public RequestState getRequestState() {
        return requestState;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getCompletionDate(){
        return completionDate;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }

    public void setRequestGrade(RequestGrade requestGrade) {
        this.requestGrade = requestGrade;
    }

    public RequestForm getRequestForm() {
        return requestForm;
    }

    public RequestGrade getRequestGrade() {
        return requestGrade;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public CodeRequest identity() {
        return this.codeRequest;
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
        return String.format("Request-> Code:%s,Service:%s,Request Date:%s,Form:%s", codeRequest, service, requestDate, requestForm);
    }
}
