package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.filter.*;
import com.seveneleven.mycontactsapp.user.model.User;

import java.util.List;
import java.util.Scanner;

public class FilterContactController {

    public static void filter(User user, Scanner sc) {

        System.out.println("Filter Contacts By:");
        System.out.println("1. Tag");
        System.out.println("2. Date Added");
        System.out.println("3. Frequently Contacted");

        String choice = sc.nextLine();
        ContactFilter filter = null;

        switch (choice) {
            case "1":
                System.out.println("Enter tag:");
                filter = new FilterByTag(sc.nextLine());
                break;
            case "2":
                filter = new FilterByDateAdded();
                break;
            case "3":
                filter = new FilterByFrequency();
                break;
            default:
                System.out.println("Invalid filter choice");
                return;
        }

        List<Contact> filtered = filter.apply(user.getContacts());

        System.out.println("Filtered Contacts:");
        for (Contact c : filtered) {
            System.out.println(c);
        }
    }
}