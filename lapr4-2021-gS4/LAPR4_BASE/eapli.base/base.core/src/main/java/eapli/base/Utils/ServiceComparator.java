package eapli.base.Utils;

import eapli.base.service.domain.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceComparator {

    public List<Service> sortByTitle(List<Service> serviceList) {

        Collections.sort(serviceList, new Comparator<Service>() {
            @Override
            public int compare(Service s1, Service s2) {
                return s1.getTitle().toString().compareToIgnoreCase(s2.getTitle().toString());
            }
        });
        return serviceList;
    }

}
