package eapli.base.Utils;

import eapli.base.Collaborator.domain.Collaborator;
import eapli.base.Task.domain.Manual.TaskManualRequest;

import java.util.*;

public class CollaboratorTaskATComparator {


    public Collaborator getCollaboratorByAttributionDate(List<Map.Entry<Collaborator, Date>> entryList) {

        Collections.sort(entryList, new Comparator<Map.Entry<Collaborator, Date>>() {
            @Override
            public int compare(Map.Entry<Collaborator, Date> o1, Map.Entry<Collaborator, Date> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return entryList.get(0).getKey();
    }

    public Collaborator getCollaboratorByLessTime(List<Map.Entry<Collaborator, Integer>> entryList) {

        Collections.sort(entryList, new Comparator<Map.Entry<Collaborator, Integer>>() {
            @Override
            public int compare(Map.Entry<Collaborator, Integer> o1, Map.Entry<Collaborator, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        return entryList.get(0).getKey();
    }

}