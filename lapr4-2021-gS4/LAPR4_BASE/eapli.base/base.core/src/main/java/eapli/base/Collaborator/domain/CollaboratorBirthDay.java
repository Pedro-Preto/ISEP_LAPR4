package eapli.base.Collaborator.domain;


import eapli.base.Utils.AgeCalculator;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Calendar;
import java.util.Date;

@Embeddable
public class CollaboratorBirthDay implements ValueObject, Comparable<CollaboratorBirthDay> {


    private Date birthdate;

    public CollaboratorBirthDay(final Date dateBirht) {
     // int year= Calendar.getInstance().get(Calendar.YEAR);
        if (dateBirht == null||getAge(dateBirht)<18)  {
            throw new IllegalArgumentException(
                    "Age attributes should neither be null nor empty and you should have at least 18 ");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression

        this.birthdate = dateBirht;
    }

    protected CollaboratorBirthDay() {

    }

    public static CollaboratorBirthDay valueOf(final Date birthdate) {
        return new CollaboratorBirthDay(birthdate);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollaboratorBirthDay)) {
            return false;
        }

        final CollaboratorBirthDay that = (CollaboratorBirthDay) o;
        return this.birthdate.equals(that.birthdate);
    }

    public static int getAge(Date date){
        return AgeCalculator.getCalculateAge(date);
    }

    @Override
    public int hashCode() {
        return this.birthdate.hashCode();
    }

    @Override
    public String toString() {
        return this.birthdate.toString();
    }

    @Override
    public int compareTo(CollaboratorBirthDay o) {
        return birthdate.compareTo(o.birthdate);
    }
}
