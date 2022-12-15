package eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers;

import eapli.base.Collaborator.application.CollaboratorController;
import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.application.Automatic.TaskAutomaticBaseController;
import eapli.base.Task.application.Manual.TaskManualBaseController;
import eapli.base.Task.application.Manual.TaskManualRequestController;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.Script;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.form.application.TaskFormController;
import eapli.base.form.domain.BaseFormId;
import eapli.base.form.domain.FormAttribute;
import eapli.base.form.domain.TaskBaseForm;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TaskBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(eapli.base.infrastructure.bootstrapers.HelpDeskBootstrapers.ColorBootstraper.class);

    TaskManualBaseController taskManualController = new TaskManualBaseController();
    TaskAutomaticBaseController taskAutomaticController = new TaskAutomaticBaseController();
    CollaboratorController collaboratorController = new CollaboratorController();
    TaskFormController taskFormController = new TaskFormController();
    TaskManualRequestController taskManualResquestController = new TaskManualRequestController();

    @Override
    public boolean execute() {

        /* ------------------------------------------------- TASK 1 ------------------------------------------------- */
        String description1 = "This is the description of task 1";
        Date limitDate1 = null;
        try {
            limitDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("1"), description1, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("101")), limitDate1, 20);

        /* ------------------------------------------------- TASK 2 ------------------------------------------------- */
        String description2 = "This is the description of task 2";
        Date limitDate2 = null;
        try {
            limitDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("08/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("2"), description2, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("102")), limitDate2, 30);

        /* ------------------------------------------------- TASK 3 ------------------------------------------------- */
        String description3 = "This is the description of task 3";
        Date limitDate3 = null;
        try {
            limitDate3 = new SimpleDateFormat("dd/MM/yyyy").parse("18/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("3"), description3, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("103")), limitDate3, 10);

        /* ------------------------------------------------- TASK 4 ------------------------------------------------- */
        String description4 = "This is the description of task 4";
        Date limitDate4 = null;
        try {
            limitDate4 = new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("4"), description4, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("104")), limitDate4, 15);

        /* ------------------------------------------------- TASK 5 ------------------------------------------------- */
        String description5 = "This is the description of task 5";
        Date limitDate5 = null;
        try {
            limitDate5 = new SimpleDateFormat("dd/MM/yyyy").parse("29/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("5"), description5, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("105")), limitDate5, 50);

        /* ------------------------------------------------- TASK 6 ------------------------------------------------- */
        String description6 = "This is the description of task 6";
        Date limitDate6 = null;
        try {
            limitDate6 = new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //addTaskPendingTask(CodeTaskManualBase.valueOf("6"), description6, collaboratorController.getCollaboratorByMecaNumber(MecanographicNumber.valueOf("106")), limitDate6, 60);

        /* ------------------------------------------------- TASK 7 ------------------------------------------------- */
        String description7 = "This is the description of task 7";
        Date limitDate7 = null;
        try {
            limitDate7 = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("7"), description7, limitDate7, 2);

        Set<FormAttribute> formAttributeSet = new HashSet<>();
        FormAttribute attribute = new FormAttribute("String", "name", "New name: ");
        formAttributeSet.add(attribute);
        BaseFormId id = new BaseFormId("15L");
        TaskBaseForm baseForm = new TaskBaseForm(id, "Formulário");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("7"), baseForm);
        /* ------------------------------------------------- TASK 8 ------------------------------------------------- */
        String description8 = "This is the description of task 8";
        Date limitDate8 = null;
        try {
            limitDate8 = new SimpleDateFormat("dd/MM/yyyy").parse("08/10/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("8"), description8, limitDate8, 45);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("Date", "date", "New date (Format: dd/MM/yyyy): ");
        formAttributeSet.add(attribute);
        id = new BaseFormId("15L");
        baseForm = new TaskBaseForm(id, "Formulário 2");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("8"), baseForm);

        /* ------------------------------------------------- TASK 9 ------------------------------------------------- */
        String description9 = "This is the description of task 9";
        Date limitDate9 = null;
        try {
            limitDate9 = new SimpleDateFormat("dd/MM/yyyy").parse("19/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("9"), description9, limitDate9, 50);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("Bool", "bool", "Approved? (TRUE or FALSE)");
        formAttributeSet.add(attribute);
        id = new BaseFormId("16L");
        baseForm = new TaskBaseForm(id, "Formulário 2");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("9"), baseForm);
        /* ------------------------------------------------- TASK 10 ------------------------------------------------- */
        String description10 = "This is the description of task 10";
        Date limitDate10 = null;
        try {
            limitDate10 = new SimpleDateFormat("dd/MM/yyyy").parse("20/06/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("10"), description10, limitDate10, 55);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("Integer", "rate", "Rate (0-10): ");
        formAttributeSet.add(attribute);
        id = new BaseFormId("17L");
        baseForm = new TaskBaseForm(id, "Formulário 3");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("10"), baseForm);
        /* ------------------------------------------------- TASK 11 ------------------------------------------------- */
        String description11 = "This is the description of task 11";
        Date limitDate11 = null;
        try {
            limitDate11 = new SimpleDateFormat("dd/MM/yyyy").parse("5/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("11"), description11, limitDate11, 65);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("String", "message", "Please leave a comment: ");
        formAttributeSet.add(attribute);
        id = new BaseFormId("18L");
        baseForm = new TaskBaseForm(id, "Formulário 4");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("11"), baseForm);
        /* ------------------------------------------------- TASK 12 ------------------------------------------------- */
        String description12 = "This is the description of task 12";
        Date limitDate12 = null;
        try {
            limitDate12 = new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("12"), description12, limitDate12, 10);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("String", "meeting", "Type of meeting: ");
        formAttributeSet.add(attribute);
        attribute = new FormAttribute("Date", "date", "Insert the date of the meeting (Format: dd/MM/yyyy): ");
        formAttributeSet.add(attribute);
        id = new BaseFormId("19L");
        baseForm = new TaskBaseForm(id, "Formulário 5");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("12"), baseForm);
        /* ------------------------------------------------- TASK 13 ------------------------------------------------- */
        String description13 = "This is the description of task 13";
        Date limitDate13 = null;
        try {
            limitDate13 = new SimpleDateFormat("dd/MM/yyyy").parse("09/07/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        addTaskManual(CodeTaskManualBase.valueOf("13"), description13, limitDate13, 14);

        formAttributeSet = new HashSet<>();
        attribute = new FormAttribute("String", "meeting", "Type of meeting: ");
        formAttributeSet.add(attribute);
        attribute = new FormAttribute("Date", "date", "Insert the date of the meeting (Format: dd/MM/yyyy): ");
        formAttributeSet.add(attribute);
        id = new BaseFormId("20L");
        baseForm = new TaskBaseForm(id, "Formulário 6");
        baseForm.addAttribute(attribute);

        addFormToManualTask(CodeTaskManualBase.valueOf("13"), baseForm);
        /* ------------------------------------------------- TASK Automatic 1 ------------------------------------------------- */
        String descriptionAuto1 = "This is the description of task 1";
        final String SCRIPT1 = "scripts//script1.js";
        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("1"), descriptionAuto1, new SimpleDateFormat("dd/mm/yyyy").parse("26/9/2021"), Script.valueOf(new File(SCRIPT1)), 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* ------------------------------------------------- TASK Automatic 2 ------------------------------------------------- */
        String descriptionAuto2 = "This is the description of task 2";
        final String SCRIPT2 = "scripts//script2.js";
        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("2"), descriptionAuto2, new SimpleDateFormat("dd/mm/yyyy").parse("26/11/2021"), Script.valueOf(new File(SCRIPT2)), 20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* ------------------------------------------------- TASK Automatic 3 ------------------------------------------------- */
        String descriptionAuto3 = "This is the description of task 3";
        final String SCRIPT3 = "scripts//script3.js";

        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("3"), descriptionAuto3, new SimpleDateFormat("dd/mm/yyyy").parse("26/6/2021"), Script.valueOf(new File(SCRIPT3)), 30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* ------------------------------------------------- TASK Automatic 4 ------------------------------------------------- */
        String descriptionAuto4 = "This is the description of task 4";
        final String SCRIPT4 = "scripts//script4.js";

        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("4"), descriptionAuto4, new SimpleDateFormat("dd/mm/yyyy").parse("28/9/2021"), Script.valueOf(new File(SCRIPT4)), 40);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* ------------------------------------------------- TASK Automatic 5 ------------------------------------------------- */
        String descriptionAuto5 = "This is the description of task 5";
        final String SCRIPT5 = "scripts//script5.js";

        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("5"), descriptionAuto5, new SimpleDateFormat("dd/mm/yyyy").parse("15/6/2021"), Script.valueOf(new File(SCRIPT5)), 50);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* ------------------------------------------------- TASK Automatic 6 ------------------------------------------------- */
        String descriptionAuto6 = "This is the description of task 6";
        final String SCRIPT6 = "scripts//script6.js";

        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("6"), descriptionAuto6, new SimpleDateFormat("dd/mm/yyyy").parse("18/6/2021"), Script.valueOf(new File(SCRIPT6)), 60);
        } catch (ParseException e) {
        }

        /* ------------------------------------------------- TASK Automatic 7 ------------------------------------------------- */
        String descriptionAuto7 = "This is the description of task 7";
        final String SCRIPT7 = "scripts//script7.js";

        try {
            addTaskAutomatic(CodeTaskAutomaticBase.valueOf("7"), descriptionAuto7, new SimpleDateFormat("dd/mm/yyyy").parse("10/9/2021"), Script.valueOf(new File(SCRIPT7)), 70);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("========================");
        System.out.println("Bootstrapping Tasks...");
        System.out.println("========================");
        return true;
    }

    private boolean addTaskAutomatic(CodeTaskAutomaticBase code, String description, Date limitDate, Script script, int standardResolutionTime) {
        try {
            taskAutomaticController.addAutomaticTask(code, description, limitDate, script, standardResolutionTime);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }
/*
    private boolean addTaskPendingTask(CodeTaskManualBase code, String description, Collaborator responsible, Date limitDate, int standardResolutionTime) {
        try {
            Date date = new Date();
            taskManualController.addManualPendingTask(code, description, responsible, limitDate, standardResolutionTime, date);
            taskManualResquestController.addManualPendingTask(code, description, responsible, limitDate, standardResolutionTime, date);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }

 */

 /*   private boolean addCompletedTask(CodeTask code, String description, Collaborator responsible, Date limitDate, int standartResolutionTime) {
        try {
            taskManualController.addManualCompletedTask(code, description, responsible, limitDate, standartResolutionTime);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }*/

    private boolean addTaskManual(CodeTaskManualBase code, String description, Date limitDate, int standartResolutionTime) {
        try {
            taskManualController.addManualTask(code, description, limitDate, standartResolutionTime, null);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }

    private boolean addFormToManualTask(CodeTaskManualBase code, TaskBaseForm baseForm) {
        try {
            TaskManualBase task = taskManualController.getTaskByCode(code);
            taskFormController.addForm(baseForm);
            taskManualController.addFormToManualTask(baseForm, task);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", code);
            LOGGER.trace("Assuming existing record", e);
        }
        return true;
    }


}
