package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.search.*;
import com.seveneleven.mycontactsapp.user.model.User;

import java.util.List;
import java.util.Scanner;

public class SearchContactController {

    public static void search(User user, Scanner sc) {

        System.out.println("Search Contacts By:");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Email");
        System.out.println("4. Tag");

        String choice = sc.nextLine();
        System.out.println("Enter search keyword:");
        String keyword = sc.nextLine();

        ContactSearch searchStrategy = null;

        switch (choice) {
            case "1":
                searchStrategy = new SearchByName();
                break;
            case "2":
                searchStrategy = new SearchByPhone();
                break;
            case "3":
                searchStrategy = new SearchByEmail();
                break;
            case "4":
                searchStrategy = new SearchByTag();
                break;
            default:
                System.out.println("Invalid search option");
                return;
        }

        List<Contact> results =
                searchStrategy.search(user.getContacts(), keyword);

        if (results.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Search Results:");
            for (Contact c : results) {
                System.out.println(c);
            }
        }
    }
}