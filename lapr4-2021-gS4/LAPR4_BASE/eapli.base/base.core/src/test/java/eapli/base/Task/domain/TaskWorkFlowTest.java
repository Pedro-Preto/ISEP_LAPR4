package eapli.base.Task.domain;

import eapli.base.Collaborator.domain.*;
import eapli.base.Task.domain.Automatic.CodeTaskAutomaticBase;
import eapli.base.Task.domain.Automatic.Script;
import eapli.base.Task.domain.Automatic.TaskAutomaticBase;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TaskWorkFlowTest {

    public Collaborator getCollaborator() {

        Collaborator c1 = null;
        Set<CollaboratorFunctions> collaboratorFunctionsSet = new HashSet<>();
        collaboratorFunctionsSet.add(CollaboratorFunctions.valueOf("Leader"));
        try {
            c1 = new Collaborator(MecanographicNumber.valueOf("1190963"), CollaboratorFirstName.valueOf("Pedro"), CollaboratorLastName.valueOf("God"), EmailAddress.valueOf("asa@gmail.com"), CollaboratorPhoneNumber.valueOf("987654321"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/mm/yyyy").parse("21/2/2000")), CollaboratorAddress.valueOf("Street 1", "Porto", "Country"), collaboratorFunctionsSet);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return c1;
    }

    public TaskManualBase getTask1() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task1", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskManualBase getTask2() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("2"), "Task2", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskManualBase getTask3() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("3"), "Task3", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskManualBase getTask4() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("4"), "Task4", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskManualBase getTask5() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("5"), "Task5", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskManualBase getTask6() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("6"), "Task6", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());

        return task1;
    }

    public TaskAutomaticBase getTask7() throws ParseException, IOException {
        File file = File.createTempFile("scripts//script1", ".txt");
        TaskAutomaticBase task = new TaskAutomaticBase(CodeTaskAutomaticBase.valueOf("7"), "Task7", new Script(file), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10);
        return task;
    }

    @Test
    public void equalsWorkFlowTest() throws ParseException, IOException {
        Set<TaskManualBase> tasks1 = new HashSet<>();
        Set<TaskAutomaticBase> automaticTasks1 = new HashSet<>();
        tasks1.add(getTask1());
        tasks1.add(getTask2());
        tasks1.add(getTask3());
        automaticTasks1.add(getTask7());

        TaskWorkFlow taskWorkFlow1 = new TaskWorkFlow(CodeTaskWorkFlow.valueOf("1"), tasks1, automaticTasks1);

        Set<TaskManualBase> tasks2 = new HashSet<>();
        Set<TaskAutomaticBase> automaticTasks2 = new HashSet<>();
        tasks2.add(getTask4());
        tasks2.add(getTask5());
        tasks2.add(getTask6());
        automaticTasks2.add(getTask7());

        TaskWorkFlow taskWorkFlow2 = new TaskWorkFlow(CodeTaskWorkFlow.valueOf("2"), tasks2, automaticTasks2);

        assertNotEquals(taskWorkFlow1.toString(), taskWorkFlow2.toString());

        taskWorkFlow2 = new TaskWorkFlow(CodeTaskWorkFlow.valueOf("1"), tasks1, automaticTasks1);

        assertEquals(taskWorkFlow1.toString(), taskWorkFlow2.toString());
    }


}