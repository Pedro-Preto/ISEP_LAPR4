package eapli.base.Utils;

import eapli.base.Task.domain.Manual.TaskManualBase;
import eapli.base.Task.domain.Manual.TaskManualRequest;

import java.util.*;

public class TaskComparator {

    public List<TaskManualRequest> sortTaskManualByLimitDate(List<TaskManualRequest> taskList, Date date, int option) {
        List<TaskManualRequest> tasks = new ArrayList<>();
        for (TaskManualRequest task : taskList) {
            if (date.after(task.getLimitDate())) {
                tasks.add(task);
            }
        }
        if (!tasks.isEmpty()) {
            switch (option) {
                case 1:
                    Collections.sort(tasks, Comparator.comparing(TaskManualRequest::getLimitDate));
                    break;
                case 2:
                    Collections.sort(tasks, (o1, o2) -> o2.getLimitDate().compareTo(o1.getLimitDate()));
                    break;
                default:
                    System.out.println("That Option Doesn't Exist");
                    break;
            }
        } else {
            System.out.println("--------------------------------------");
            System.out.println("There is no uncompleted tasks until date " + date);
        }
        return tasks;
    }

    public List<TaskManualRequest> sortTasksManualBetweenTwoDates(List<TaskManualRequest> taskList, Date date1, Date date2, int option) {
        List<TaskManualRequest> tasks = new ArrayList<>();
        for (TaskManualRequest task : taskList) {
            if (date1.before(task.getLimitDate()) && date2.after(task.getLimitDate())) {
                tasks.add(task);
            }
        }
        if (!tasks.isEmpty()) {
            switch (option) {
                case 1:
                    Collections.sort(tasks, new Comparator<TaskManualRequest>() {
                        @Override
                        public int compare(TaskManualRequest o1, TaskManualRequest o2) {
                            return o1.getLimitDate().compareTo(o2.getLimitDate());
                        }
                    });
                    break;
                case 2:
                    Collections.sort(tasks, new Comparator<TaskManualRequest>() {
                        @Override
                        public int compare(TaskManualRequest o1, TaskManualRequest o2) {
                            return o2.getLimitDate().compareTo(o1.getLimitDate());
                        }
                    });
                    break;
            }
        } else {
            System.out.println("--------------------------------------");
            System.out.println("There is no uncompleted tasks Between date " + date1 + " and date " + date2);

        }
        return tasks;
    }

    public TaskManualRequest sortTaskByAttributionTime(List<TaskManualRequest> taskManualRequests) {
        Collections.sort(taskManualRequests, new Comparator<TaskManualRequest>() {
            @Override
            public int compare(TaskManualRequest o1, TaskManualRequest o2) {
                return o1.getAttributionDate().compareTo(o2.getAttributionDate());
            }
        });

        return taskManualRequests.get(0);
    }


}
