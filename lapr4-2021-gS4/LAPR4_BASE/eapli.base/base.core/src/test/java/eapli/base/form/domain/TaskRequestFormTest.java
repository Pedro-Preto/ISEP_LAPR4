package eapli.base.form.domain;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class TaskRequestFormTest extends TestCase {

    public void testSetAttributes() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("String", "name", "Insert the name of the method: ");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form");
        TaskRequestForm requestForm = new TaskRequestForm(taskBaseForm, "R1");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, requestForm.getAttributes());

        requestForm.setAttributes(formAttributeSet);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, requestForm.getAttributes());

    }


    public void testGetAttributes() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("String", "name", "Insert the name of the method: ");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form");
        TaskRequestForm requestForm = new TaskRequestForm(taskBaseForm, "R1");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, requestForm.getAttributes());

        requestForm.setAttributes(formAttributeSet);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, requestForm.getAttributes());

    }


    public void testGetId() {

        BaseFormId id = new BaseFormId("15L");
        RequestFormId requestFormId = RequestFormId.valueOf("15L");
        RequestFormId requestFormId2 = RequestFormId.valueOf("10L");


        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form");
        TaskRequestForm taskRequestForm = new TaskRequestForm(taskBaseForm, "R1");

        assertNotSame("Should be different, id's are different", "R1" + requestFormId2.toString(), taskRequestForm.getId().toString());
        assertEquals("Should be equal, attribute has been added", "R1" + requestFormId.toString(), taskRequestForm.getId().toString());

    }


    public void testTestEquals() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form 1");
        TaskBaseForm taskBaseForm2 = new TaskBaseForm(id2, "Form 2");

        TaskRequestForm taskRequestForm = new TaskRequestForm(taskBaseForm, "R1");
        TaskRequestForm taskRequestForm2 = new TaskRequestForm(taskBaseForm2, "R2");

        assertEquals("Should be the same, instances are the same", taskRequestForm, taskRequestForm);
        assertNotSame("Should be different, instances are the same", taskRequestForm, taskRequestForm2);

    }


    public void testTestGetName() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form");

        TaskRequestForm taskRequestForm = new TaskRequestForm(taskBaseForm, "R1");

        assertEquals("Should be the same, name is the same", "Form", taskRequestForm.getName());
        assertNotSame("Should be different, instances are the same", "MEKIE", taskRequestForm.getName());


    }
}
