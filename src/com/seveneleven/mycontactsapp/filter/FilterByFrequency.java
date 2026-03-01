package com.seveneleven.mycontactsapp.filter;

import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.*;

public class FilterByFrequency implements ContactFilter {

    @Override
    public List<Contact> apply(List<Contact> contacts) {

        List<Contact> result = new ArrayList<>(contacts);

        Collections.sort(result, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return Integer.compare(
                        c2.getContactCount(),
                        c1.getContactCount()
                );
            }
        });

        return result;
    }
}