package com.seveneleven.mycontactsapp.filter;

import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.ArrayList;
import java.util.List;

public class FilterByTag implements ContactFilter {

    private final String tag;

    public FilterByTag(String tag) {
        this.tag = tag;
    }

    @Override
    public List<Contact> apply(List<Contact> contacts) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {
            if (c.getTag().equalsIgnoreCase(tag)) {
                result.add(c);
            }
        }
        return result;
    }
}