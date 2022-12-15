package eapli.base.form.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class FormAttribute implements ValueObject, Comparable<FormAttribute> {

    private String attributeType; // Integer, String, Bool, Date, PhoneNumber, Postal-Code, Address, Name.
    private String attributeName;
    private String attributeLabel;
    private String attributeValue;

    public FormAttribute(final String type, final String name, final String label) {
        if (StringPredicates.isNullOrEmpty(type))
            throw new IllegalArgumentException("Invalid Attribute Type!");

        if (StringPredicates.isNullOrEmpty(name))
            throw new IllegalArgumentException("Invalid Attribute Name!");

        this.attributeType = type;
        this.attributeName = name;
        this.attributeLabel = label;
    }

    protected FormAttribute() {
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeLabel() {
        return attributeLabel;
    }

    public void setAttributeLabel(String attributeLabel) {
        this.attributeLabel = attributeLabel;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public static FormAttribute valueOf(final String type, final String name, final String label) {
        return new FormAttribute(type, name, label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeType, attributeName, attributeLabel, attributeValue);
    }

    @Override
    public String toString() {
        return this.attributeType + " " + this.attributeName;
    }

    @Override
    public int compareTo(final FormAttribute o) {
        return attributeName.compareTo(o.attributeName);
    }

}
