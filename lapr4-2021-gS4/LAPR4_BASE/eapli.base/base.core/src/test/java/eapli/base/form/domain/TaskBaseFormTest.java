package eapli.base.form.domain;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class TaskBaseFormTest extends TestCase {

    public void testAddAttribute() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("String", "name", "Insert the name of method: ");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form 1");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, taskBaseForm.getAttributes());

        taskBaseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, taskBaseForm.getAttributes());

    }


    public void testGetAttributes() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("String", "name", "Insert the name of method: ");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form 1");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, taskBaseForm.getAttributes());

        taskBaseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, taskBaseForm.getAttributes());

    }


    public void testGetId() {

        BaseFormId id2 = new BaseFormId("10L");

        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form 1");

        assertNotSame("Should be different, id's are different", id2, taskBaseForm.getId());
        assertEquals("Should be equal, attribute has been added", id, taskBaseForm.getId());

    }


    public void testTestEquals() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        TaskBaseForm taskBaseForm2 = new TaskBaseForm(id, "Form 2");
        TaskBaseForm taskBaseForm1 = new TaskBaseForm(id2, "Form 1");

        assertEquals("Should be the same, instances are the same", taskBaseForm2, taskBaseForm2);
        assertNotSame("Should be different, instances are the same", taskBaseForm2, taskBaseForm1);

    }


    public void testTestGetName() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        TaskBaseForm taskBaseForm = new TaskBaseForm(id, "Form");

        assertEquals("Should be the same, name is the same", "Form", taskBaseForm.getName());
        assertNotSame("Should be different, instances are the same", "MEKIE", taskBaseForm.getName());


    }
}
