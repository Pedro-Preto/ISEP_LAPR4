package eapli.base.Task.domain;

import eapli.base.Collaborator.domain.*;
import eapli.base.Task.domain.Manual.CodeTaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TaskTest {

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

    @Test
    public void equalsManualTaskTest() throws ParseException {
        TaskManualBase task1 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task1", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10, new Date());
        TaskManualBase task2 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task1", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());
        assertEquals(task1.toString(), task2.toString());


        TaskManualBase task3 = new TaskManualBase(CodeTaskManualBase.valueOf("3"), "Task1", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());
        assertNotEquals(task3.toString(), task1.toString());


        TaskManualBase task4 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task1", getCollaborator(), TaskState.WaitingApproval, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());
        assertNotEquals(task1.toString(), task4.toString());

        TaskManualBase task5 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task5", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2021"),10,new Date());
        assertNotEquals(task1.toString(), task5.toString());


        TaskManualBase task6 = new TaskManualBase(CodeTaskManualBase.valueOf("1"), "Task1", getCollaborator(), TaskState.Uncompleted, new SimpleDateFormat("dd/mm/yyyy").parse("21/8/2022"),10,new Date());
        assertNotEquals(task1.getLimitDate(), task6.getLimitDate());

    }

}