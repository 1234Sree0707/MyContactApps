package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.tag.Tag;
import com.seveneleven.mycontactsapp.user.model.User;

import java.util.Scanner;

public class ApplyTagController {

    public static void applyOrRemoveTags(User user, Scanner sc) {

        if (user.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        if (user.getAvailableTags().isEmpty()) {
            System.out.println("No tags available. Please create tags first.");
            return;
        }

        // Show contacts
        user.viewContacts();
        System.out.println("Select contact number:");
        int contactIndex = Integer.parseInt(sc.nextLine());

        if (contactIndex < 1 || contactIndex > user.getContacts().size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = user.getContacts().get(contactIndex - 1);

        System.out.println("Current Tags: " + contact.getTags());
        System.out.println("Available Tags: " + user.getAvailableTags());

        System.out.println("Choose operation:");
        System.out.println("1. Add tag(s)");
        System.out.println("2. Remove tag");

        String option = sc.nextLine();

        switch (option) {

            case "1": // ADD TAGS
                System.out.println("Enter tag names to add (comma separated):");
                String[] addTags = sc.nextLine().split(",");

                for (String tagName : addTags) {
                    Tag tag = new Tag(tagName.trim());
                    if (user.getAvailableTags().contains(tag)) {
                        contact.addTag(tag);
                    }
                }

                System.out.println("Tags added successfully.");
                break;

            case "2": // REMOVE TAG
                System.out.println("Enter tag name to remove:");
                String removeTagName = sc.nextLine();
                Tag tagToRemove = new Tag(removeTagName);

                if (contact.getTags().contains(tagToRemove)) {
                    contact.removeTag(tagToRemove);
                    System.out.println("Tag removed successfully.");
                } else {
                    System.out.println("Tag not found on contact.");
                }
                break;

            default:
                System.out.println("Invalid option.");
        }

        System.out.println("Updated Contact:");
        System.out.println(contact);
    }
}