package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.tag.Tag;
import com.seveneleven.mycontactsapp.user.model.User;

import java.util.Scanner;

public class TagController {

    public static void createAndAssignTag(User user, Scanner sc) {

        System.out.println("Enter new tag name:");
        String tagName = sc.nextLine();

        Tag tag = new Tag(tagName);
        user.addTag(tag);

        System.out.println("Tag created successfully.");
        System.out.println("Available Tags: " + user.getAvailableTags());

        user.viewContacts();
        System.out.println("Enter contact number to assign this tag:");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice < 1 || choice > user.getContacts().size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = user.getContacts().get(choice - 1);
        contact.addTag(tag);

        System.out.println("Tag assigned to contact successfully.");
    }
}