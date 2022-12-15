package eapli.base.Utils;

import com.sun.xml.bind.v2.schemagen.xmlschema.AttributeType;
import eapli.base.form.domain.BaseForm;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.RequestForm;
import eapli.base.form.domain.TaskRequestForm;

import java.io.FileWriter;

public class FormSystem {

    /**
     * Hide the implicit constructor.
     */
    private FormSystem() {
    }

    public static boolean createRequestFormFile(RequestForm requestForm) {

        try {
            FileWriter myWriter;
            String outputLocation = "requestForms//" + requestForm.id().toString() + "_requestForm.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                for (FormAttribute fa : requestForm.getAttributes()) {
                    myWriter.write(String.format("%s %s: %s%n", fa.getAttributeType(), fa.getAttributeName(), fa.getAttributeValue()));
                }
                myWriter.write("");
            } finally {
                myWriter.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error outputting the form request to a txt!");
            return false;
        }

        return true;
    }

    public static boolean createBaseFormFile(BaseForm baseForm) {

        try {
            FileWriter myWriter;
            String outputLocation = "baseForms//" + baseForm.id().toString() + "_baseForm.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                for (FormAttribute fa : baseForm.getAttributes()) {
                    myWriter.write(String.format("%s %s//%s%n", fa.getAttributeType(), fa.getAttributeName(), fa.getAttributeLabel()));
                }
                myWriter.write("");
            } finally {
                myWriter.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error outputting the form request to a txt!");
            return false;
        }

        return true;
    }

    public static boolean createTaskFormFile(TaskRequestForm taskRequestForm) {

        try {
            FileWriter myWriter;
            String outputLocation = "taskForms//" + taskRequestForm.id().toString() + "taskForm.txt";
            myWriter = new FileWriter(outputLocation, true);

            try {
                for (FormAttribute fa : taskRequestForm.getAttributes()) {
                    myWriter.write(String.format("%s %s: %s%n", fa.getAttributeType(), fa.getAttributeName(), fa.getAttributeValue()));
                }
                myWriter.write("");
            } finally {
                myWriter.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error outputting the form request to a txt!");
            return false;
        }

        return true;
    }
}
