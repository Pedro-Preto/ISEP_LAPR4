package eapli.base.Utils;

import eapli.base.Collaborator.domain.*;
import eapli.base.Task.domain.Manual.CodeTaskManualRequest;
import eapli.base.Task.domain.Manual.TaskManualRequest;
import eapli.base.Task.domain.Manual.TaskState;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class CollaboratorTaskATComparatorTest {

    @Test
    public void getCollaboratorByAttributionDate() throws ParseException {
        CollaboratorTaskATComparator comparator = new CollaboratorTaskATComparator();
        Set<CollaboratorFunctions> functions1 = new HashSet<>();
        functions1.add(CollaboratorFunctions.valueOf("Bison Expert"));
        Set<CollaboratorFunctions> functions2 = new HashSet<>();
        functions2.add(CollaboratorFunctions.valueOf("Lexer Expert"));

        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("12345"), CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf("Pedro"), EmailAddress.valueOf("joao@gmail.com"), CollaboratorPhoneNumber.valueOf("987654321"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2001")), CollaboratorAddress.valueOf("Rua das Rosas", "Porto", "Portugal"), functions1);
        Collaborator c2 = new Collaborator(MecanographicNumber.valueOf("67890"), CollaboratorFirstName.valueOf("Manel"), CollaboratorLastName.valueOf("Vaca"), EmailAddress.valueOf("manel@gmail.com"), CollaboratorPhoneNumber.valueOf("987654322"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2000")), CollaboratorAddress.valueOf("Rua das Rosalias", "Porto", "Portugal"), functions1);
        TaskManualRequest task1 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Matematica", c1, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("10/1/2021"));
        TaskManualRequest task2 = new TaskManualRequest(CodeTaskManualRequest.valueOf("2"), "Portugues", c2, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("19/4/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("1/3/2021"));

        List<TaskManualRequest> taskManualRequests = new ArrayList<>();
        taskManualRequests.add(task1);
        taskManualRequests.add(task2);

        Map<Collaborator, Date> map = new HashMap<>();

        for (TaskManualRequest tt : taskManualRequests) {
            map.put(tt.getResponsibleCollaborator(), tt.getAttributionDate());
        }


        List<Map.Entry<Collaborator, Date>> entryList = new LinkedList<>(map.entrySet());

        assertEquals(c1.toString(), comparator.getCollaboratorByAttributionDate(entryList).toString());
    }
    @Test
    public void getCollaboratorByLessTime() throws ParseException {
        CollaboratorTaskATComparator comparator = new CollaboratorTaskATComparator();
        Set<CollaboratorFunctions> functions1 = new HashSet<>();
        functions1.add(CollaboratorFunctions.valueOf("Bison Expert"));
        Set<CollaboratorFunctions> functions2 = new HashSet<>();
        functions2.add(CollaboratorFunctions.valueOf("Lexer Expert"));

        Collaborator c1 = new Collaborator(MecanographicNumber.valueOf("12345"), CollaboratorFirstName.valueOf("Joao"), CollaboratorLastName.valueOf("Pedro"), EmailAddress.valueOf("joao@gmail.com"), CollaboratorPhoneNumber.valueOf("987654321"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2001")), CollaboratorAddress.valueOf("Rua das Rosas", "Porto", "Portugal"), functions1);
        Collaborator c2 = new Collaborator(MecanographicNumber.valueOf("67890"), CollaboratorFirstName.valueOf("Manel"), CollaboratorLastName.valueOf("Vaca"), EmailAddress.valueOf("manel@gmail.com"), CollaboratorPhoneNumber.valueOf("987654322"), CollaboratorBirthDay.valueOf(new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2000")), CollaboratorAddress.valueOf("Rua das Rosalias", "Porto", "Portugal"), functions1);
        TaskManualRequest task1 = new TaskManualRequest(CodeTaskManualRequest.valueOf("1"), "Matematica", c1, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("15/3/2021"), 16, new SimpleDateFormat("dd/MM/yyyy").parse("10/1/2021"));
        TaskManualRequest task2 = new TaskManualRequest(CodeTaskManualRequest.valueOf("2"), "Portugues", c2, TaskState.Uncompleted, new SimpleDateFormat("dd/MM/yyyy").parse("19/4/2021"), 10, new SimpleDateFormat("dd/MM/yyyy").parse("1/3/2021"));

        List<TaskManualRequest> taskManualRequests = new ArrayList<>();
        taskManualRequests.add(task1);
        taskManualRequests.add(task2);

        Map<Collaborator, Integer> map = new HashMap<>();

        for (TaskManualRequest tt : taskManualRequests) {
            map.put(tt.getResponsibleCollaborator(), tt.getStandardResolutionTime());
        }


        List<Map.Entry<Collaborator, Integer>> entryList = new LinkedList<>(map.entrySet());
        System.out.println(entryList);
        assertEquals(c2.toString(), comparator.getCollaboratorByLessTime(entryList).toString());
    }
}