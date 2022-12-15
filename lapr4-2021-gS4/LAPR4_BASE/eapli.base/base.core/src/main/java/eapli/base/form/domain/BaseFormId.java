package eapli.base.form.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class BaseFormId implements ValueObject, Comparable<BaseFormId> {

    private String formId;

    public BaseFormId(final String formId) {
        if (StringPredicates.isNullOrEmpty(formId)) {
            throw new IllegalArgumentException(
                    "Form ID should neither be null nor empty");
        }
        this.formId = formId;
    }

    protected BaseFormId() {
    }

    public static BaseFormId valueOf(final String formId) {
        return new BaseFormId(formId);
    }

    @Override
    public int hashCode() {
        return this.formId.hashCode();
    }

    @Override
    public String toString() {
        return this.formId;
    }

    @Override
    public int compareTo(final BaseFormId o) {
        return formId.compareTo(o.formId);
    }

}
