package com.seveneleven.mycontactsapp.filter;

import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.*;

public class FilterByDateAdded implements ContactFilter {

    @Override
    public List<Contact> apply(List<Contact> contacts) {

        List<Contact> result = new ArrayList<>(contacts);

        Collections.sort(result, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c2.getDateAdded().compareTo(c1.getDateAdded());
            }
        });

        return result;
    }
}