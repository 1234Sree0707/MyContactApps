package com.seveneleven.mycontactsapp.search;
import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.ArrayList;
import java.util.List;
public class SearchByTag implements ContactSearch {
	@Override
    public List<Contact> search(List<Contact> contacts, String keyword) {

        List<Contact> result = new ArrayList<>();

        for (Contact c : contacts) {
            if (c.getTag() != null &&
                c.getTag().equalsIgnoreCase(keyword)) {
                result.add(c);
            }
        }
        return result;
    }
}