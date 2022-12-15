package eapli.base.form.domain;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BaseFormTest extends TestCase {

    public void testAddAttribute() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("trabalho", "relatorio", "fisica");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        BaseForm baseForm = new BaseForm(id, "Formulário");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, baseForm.getAttributes());

        baseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, baseForm.getAttributes());

    }


    public void testGetAttributes() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("trabalho", "relatorio", "fisica");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        BaseForm baseForm = new BaseForm(id, "Formulário");

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, baseForm.getAttributes());

        baseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, baseForm.getAttributes());

    }


    public void testGetId() {

        BaseFormId id2 = new BaseFormId("10L");

        BaseFormId id = new BaseFormId("15L");
        BaseForm baseForm = new BaseForm(id, "Formulário");

        assertNotSame("Should be different, id's are different", id2, baseForm.getId());
        assertEquals("Should be equal, attribute has been added", id, baseForm.getId());

    }


    public void testTestEquals() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        BaseForm baseForm = new BaseForm(id, "Formulário");
        BaseForm baseForm2 = new BaseForm(id2, "Formulário");

        assertEquals("Should be the same, instances are the same", baseForm, baseForm);
        assertNotSame("Should be different, instances are the same", baseForm, baseForm2);

    }


    public void testTestGetName() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        BaseForm baseForm = new BaseForm(id, "Formulário");

        assertEquals("Should be the same, name is the same", "Formulário", baseForm.getName());
        assertNotSame("Should be different, instances are the same", "MEKIE", baseForm.getName());


    }
}