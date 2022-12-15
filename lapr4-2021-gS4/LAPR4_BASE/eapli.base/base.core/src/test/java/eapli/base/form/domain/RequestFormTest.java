package eapli.base.form.domain;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class RequestFormTest extends TestCase {

    public void testAddAttribute() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("trabalho", "relatorio", "fisica");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        BaseForm baseForm = new BaseForm(id, "Formulário");
        RequestForm requestForm = new RequestForm(baseForm);

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, requestForm.getAttributes());

        baseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, requestForm.getAttributes());

    }


    public void testGetAttributes() {

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("trabalho", "relatorio", "fisica");
        formAttributeSet.add(attribute);

        BaseFormId id = new BaseFormId("15L");
        BaseForm baseForm = new BaseForm(id, "Formulário");
        RequestForm requestForm = new RequestForm(baseForm);

        assertNotSame("Should be different, attribute hasn't been added to BaseForm", formAttributeSet, requestForm.getAttributes());

        baseForm.addAttribute(attribute);

        assertEquals("Should be equal, attribute has been added", formAttributeSet, requestForm.getAttributes());

    }


    public void testGetId() {


        BaseFormId id = new BaseFormId("15L");

        RequestFormId requestFormId = RequestFormId.valueOf("15L");
        RequestFormId requestFormId2 = RequestFormId.valueOf("10L");


        BaseForm baseForm = new BaseForm(id, "Formulário");
        RequestForm requestForm = new RequestForm(baseForm);

        assertNotSame("Should be different, id's are different", requestFormId2.toString(), requestForm.getId().toString());
        assertEquals("Should be equal, attribute has been added", requestFormId.toString(), requestForm.getId().toString());

    }


    public void testTestEquals() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        BaseForm baseForm = new BaseForm(id, "Formulário");
        BaseForm baseForm2 = new BaseForm(id2, "Formulário");

        RequestForm requestForm = new RequestForm(baseForm);
        RequestForm requestForm2 = new RequestForm(baseForm2);

        assertEquals("Should be the same, instances are the same", requestForm, requestForm);
        assertNotSame("Should be different, instances are the same", requestForm, requestForm2);

    }


    public void testTestGetName() {

        BaseFormId id = new BaseFormId("15L");
        BaseFormId id2 = new BaseFormId("10L");

        BaseForm baseForm = new BaseForm(id, "Formulário");

        RequestForm requestForm = new RequestForm(baseForm);

        assertEquals("Should be the same, name is the same", "Formulário", requestForm.getName());
        assertNotSame("Should be different, instances are the same", "MEKIE", requestForm.getName());


    }
}