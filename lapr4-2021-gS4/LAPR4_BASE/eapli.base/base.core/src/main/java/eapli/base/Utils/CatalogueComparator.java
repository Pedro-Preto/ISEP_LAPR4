package eapli.base.Utils;

import eapli.base.catalogue.domain.Catalogue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CatalogueComparator {

    public List<Catalogue> sortByTitle(List<Catalogue> catalogueList) {

        Collections.sort(catalogueList, new Comparator<Catalogue>() {
            @Override
            public int compare(Catalogue c1, Catalogue c2) {
                return c1.getTitle().compareTo(c2.getTitle());
            }
        });
        return catalogueList;
    }

    public List<Catalogue> sortByResponsible(List<Catalogue> catalogueList) {

        Collections.sort(catalogueList, new Comparator<Catalogue>() {
            @Override
            public int compare(Catalogue c1, Catalogue c2) {
                return c1.getResponsible().getFirstName().compareTo(c2.getResponsible().getFirstName());
            }
        });
        return catalogueList;
    }


}