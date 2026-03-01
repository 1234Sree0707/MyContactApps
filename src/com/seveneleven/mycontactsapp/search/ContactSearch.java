package com.seveneleven.mycontactsapp.search;
import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.List;
public interface ContactSearch {
    List<Contact> search(List<Contact> contacts, String keyword);
}

