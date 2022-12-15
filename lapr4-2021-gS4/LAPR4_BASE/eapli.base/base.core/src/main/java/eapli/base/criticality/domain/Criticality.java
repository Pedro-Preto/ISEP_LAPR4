package eapli.base.criticality.domain;

import eapli.base.Color.domain.Color;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
public class Criticality implements AggregateRoot<CriticalityID> {

    @EmbeddedId
    private CriticalityID id;
    private int value;
    private int scale;
    @ManyToOne
    private Color color;

    private int approvalMaxTime;
    private int approvalAverageTime;

    private int resolutionMaxTime;
    private int resolutionAverageTime;

    public Criticality(final CriticalityID id ,final int value, final int scale, final Color color, final int approvalMaxTime,
                       final int approvalAverageTime, final int resolutionMaxTime, final int resolutionAverageTime) {
        if (id == null || value < 0 || scale < 0 || scale < value || color == null || approvalMaxTime < 0 ||
                approvalAverageTime < 0 || resolutionAverageTime < 0 || resolutionMaxTime < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.value = value;
        this.scale = scale;
        this.color = color;
        this.approvalMaxTime = approvalMaxTime;
        this.approvalAverageTime = approvalAverageTime;
        this.resolutionAverageTime = resolutionAverageTime;
        this.resolutionMaxTime = resolutionMaxTime;
    }
    protected Criticality() {
    }

    public CriticalityID getId() {
        return id;
    }

    public void setId(CriticalityID id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getApprovalMaxTime() {
        return approvalMaxTime;
    }

    public void setApprovalMaxTime(int approvalMaxTime) {
        this.approvalMaxTime = approvalMaxTime;
    }

    public int getApprovalAverageTime() {
        return approvalAverageTime;
    }

    public void setApprovalAverageTime(int approvalAverageTime) {
        this.approvalAverageTime = approvalAverageTime;
    }

    public int getResolutionMaxTime() {
        return resolutionMaxTime;
    }

    public void setResolutionMaxTime(int resolutionMaxTime) {
        this.resolutionMaxTime = resolutionMaxTime;
    }

    public int getResolutionAverageTime() {
        return resolutionAverageTime;
    }

    public void setResolutionAverageTime(int resolutionAverageTime) {
        this.resolutionAverageTime = resolutionAverageTime;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", value: " + value +
                ", scale: " + scale +
                ", approvalMaxTime: " + approvalMaxTime +
                ", approvalAverageTime: " + approvalAverageTime +
                ", resolutionMaxTime: " + resolutionMaxTime +
                ", resolutionAverageTime: " + resolutionAverageTime;
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

    public CriticalityID id() {
        return identity();
    }

    @Override
    public CriticalityID identity() {
        return this.id;
    }

}
