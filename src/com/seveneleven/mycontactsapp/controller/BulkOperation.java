package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.user.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BulkOperation {

    public static void bulkDelete(User user, Scanner sc) {

        if (user.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        user.viewContacts();
        System.out.println("Enter contact numbers to delete (comma separated):");
        String input = sc.nextLine();

        Set<Integer> indexes = parseIndexes(input, user.getContacts().size());

        if (indexes.isEmpty()) {
            System.out.println("No valid contacts selected.");
            return;
        }

        List<Contact> contacts = user.getContacts();

        // delete safely (reverse order)
        List<Integer> sorted = new ArrayList<>(indexes);
        Collections.sort(sorted, Collections.reverseOrder());

        for (int index : sorted) {
            contacts.remove(index - 1);
        }

        System.out.println("Selected contacts deleted successfully.");
    }

    // ===== BULK TAG =====
    public static void bulkTag(User user, Scanner sc) {

        user.viewContacts();
        System.out.println("Enter contact numbers to tag (comma separated):");
        String input = sc.nextLine();

        Set<Integer> indexes = parseIndexes(input, user.getContacts().size());

        System.out.println("Enter tag name:");
        String tag = sc.nextLine();

        for (int index : indexes) {
            Contact c = user.getContacts().get(index - 1);
            c.setTag(tag);   // requires tag field in Contact
        }

        System.out.println("Tag applied to selected contacts.");
    }

    // ===== BULK EXPORT =====
    public static void bulkExport(User user) {

        try (FileWriter writer = new FileWriter("contacts_export.txt")) {

            for (Contact c : user.getContacts()) {
                writer.write(c.toString() + System.lineSeparator());
            }

            System.out.println("Contacts exported successfully to contacts_export.txt");

        } catch (IOException e) {
            System.out.println("Error while exporting contacts.");
        }
    }

    // ===== HELPER METHOD =====
    private static Set<Integer> parseIndexes(String input, int size) {

        Set<Integer> indexes = new HashSet<>();
        String[] parts = input.split(",");

        for (String p : parts) {
            try {
                int index = Integer.parseInt(p.trim());
                if (index >= 1 && index <= size) {
                    indexes.add(index);
                }
            } catch (NumberFormatException ignored) {}
        }
        return indexes;
    }
}