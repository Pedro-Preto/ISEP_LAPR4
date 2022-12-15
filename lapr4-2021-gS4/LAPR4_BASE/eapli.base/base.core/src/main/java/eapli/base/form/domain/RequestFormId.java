package eapli.base.form.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class RequestFormId implements ValueObject, Comparable<RequestFormId> {

    private String formId;

    public RequestFormId(final String formId) {
        if (StringPredicates.isNullOrEmpty(formId)) {
            throw new IllegalArgumentException(
                    "Form ID should neither be null nor empty");
        }
        this.formId = formId;
    }

    protected RequestFormId() {
    }

    public static RequestFormId valueOf(final String formId) {
        return new RequestFormId(formId);
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
    public int compareTo(final RequestFormId o) {
        return formId.compareTo(o.formId);
    }

}
