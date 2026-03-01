package com.seveneleven.mycontactsapp.filter;

import com.seveneleven.mycontactsapp.contacts.Contact;
import java.util.List;

public interface ContactFilter {
    List<Contact> apply(List<Contact> contacts);
}