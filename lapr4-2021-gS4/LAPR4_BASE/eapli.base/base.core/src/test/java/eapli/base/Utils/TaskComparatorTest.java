package eapli.base.Utils;

import eapli.base.Collaborator.domain.*;
import eapli.base.Task.domain.Manual.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class TaskComparatorTest {

    public static Collaborator dummyCollaborator(String mecanographicNumber) {
        Set<CollaboratorFunctions> collaboratorFunctions = new HashSet<>();
        collaboratorFunctions.add(CollaboratorFunctions.valueOf("dummyFunction"));
        Collaborator collaborator = new Collaborator(MecanographicNumber.valueOf(mecanographicNumber), CollaboratorFirstName.valueOf("dummyCollab"),
                CollaboratorLastName.valueOf(" Collab"),
                EmailAddress.valueOf("dummyEmail@email.com"),
                CollaboratorPhoneNumber.valueOf("911111111"),
                CollaboratorBirthDay.valueOf(new Date(1, 1, 1)),
                CollaboratorAddress.valueOf("dummyStreet", "dummyLocal", "dummyCountry"),
                collaboratorFunctions);
        return collaborator;
    }

    @Test
    public void BetweenTwoDates() throws ParseException {
        TaskComparator taskComparator = new TaskComparator();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("1/2/2001");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("1/6/2001");

        List<TaskManualRequest> taskList = new ArrayList<>();
        TaskManualRequest task1 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Matematica", dummyCollaborator("1"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/3/2001"), 10, new Date());
        TaskManualRequest task2 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Portugues", dummyCollaborator("2"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("6/4/2001"), 10, new Date());
        TaskManualRequest task3 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Biologia", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/5/2001"), 10, new Date());
        TaskManualRequest task4 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Quimica", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/7/2001"), 10, new Date());
        TaskManualRequest task5 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Geologia", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/2/2001"), 10, new Date());
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);

        List<TaskManualRequest> expectedTasks = new ArrayList<>();
        expectedTasks.add(task1);
        expectedTasks.add(task2);
        expectedTasks.add(task3);

        List<TaskManualRequest> tasksComparator = taskComparator.sortTasksManualBetweenTwoDates(taskList, date1, date2, 1);
        int size = tasksComparator.size();
        assertEquals(size, 3);
        assertEquals(expectedTasks, tasksComparator);

    }

    @Test
    public void sortByLimitDatesort() throws ParseException {

        TaskComparator taskComparator = new TaskComparator();
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("1/6/2001");

        List<TaskManualRequest> taskList = new ArrayList<>();
        TaskManualRequest task1 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Matematica", dummyCollaborator("1"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/3/2001"), 10, new Date());
        TaskManualRequest task2 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Portugues", dummyCollaborator("2"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("6/4/2001"), 10, new Date());
        TaskManualRequest task3 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Biologia", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/5/2001"), 10, new Date());
        TaskManualRequest task4 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Quimica", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/7/2001"), 10, new Date());
        TaskManualRequest task5 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Geologia", dummyCollaborator("3"), TaskState.WaitingApproval, new SimpleDateFormat("dd/MM/yyyy").parse("1/2/2001"), 10, new Date());
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);
        taskList.add(task5);

        List<TaskManualRequest> expectedTasks = new ArrayList<>();
        expectedTasks.add(task5);
        expectedTasks.add(task1);
        expectedTasks.add(task2);
        expectedTasks.add(task3);

        List<TaskManualRequest> tasksComparator = taskComparator.sortTaskManualByLimitDate(taskList, date2, 1);
        int size = tasksComparator.size();
        assertEquals(size, 4);
        assertEquals(Arrays.toString(new List[]{expectedTasks}), Arrays.toString(new List[]{tasksComparator}));
    }

    @Test
    public void sortTaskByAttributionTime() throws ParseException {
        TaskComparator taskComparator = new TaskComparator();
        Set<CollaboratorFunctions> functions1 = new HashSet<>();
        functions1.add(CollaboratorFunctions.valueOf("Bison Expert"));
        Set<CollaboratorFunctions> functions2 = new HashSet<>();
        functions2.add(CollaboratorFunctions.valueOf("Lexer Expert"));

        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("12345"), CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf("Pedro"), EmailAddress.valueOf("joao@gmail.com"), CollaboratorPhoneNumber.valueOf("987654321"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2001")), CollaboratorAddress.valueOf("Rua das Rosas", "Porto", "Portugal"), functions1);
        Collaborator c2 = new Collaborator(MecanographicNumber.valueOf("67890"), CollaboratorFirstName.valueOf("Manel"), CollaboratorLastName.valueOf("Vaca"), EmailAddress.valueOf("manel@gmail.com"), CollaboratorPhoneNumber.valueOf("987654322"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2000")), CollaboratorAddress.valueOf("Rua das Rosalias", "Porto", "Portugal"), functions1);
        TaskManualRequest task1 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Matematica", c1, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("10/1/2021"));
        TaskManualRequest task2 = new TaskManualRequest(CodeTaskManualRequest.valueOf("2"), "Portugues", c1, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("19/4/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("1/3/2021"));

        TaskManualRequest task3 = new TaskManualRequest(CodeTaskManualRequest.valueOf("3"), "Quimica", c2, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("1/1/2021"));
        TaskManualRequest task4 = new TaskManualRequest(CodeTaskManualRequest.valueOf("4"), "Biologia", c2, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("19/4/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("1/4/2021"));
        List<TaskManualRequest> taskManualRequests = new ArrayList<>();
        taskManualRequests.add(task1);
        taskManualRequests.add(task2);
        taskManualRequests.add(task3);
        taskManualRequests.add(task4);
        Collaborator actual = taskComparator.sortTaskByAttributionTime(taskManualRequests).getResponsibleCollaborator();

        assertEquals(actual.getNumMechanographic(), c2.getNumMechanographic());
    }
}