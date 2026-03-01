
package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.user.model.User;

import java.util.Scanner;

public class DeleteContact {

    public static void deleteContact(User user, Scanner sc) {

        if (user.getContacts().isEmpty()) {
            System.out.println("No contacts available to delete.");
            return;
        }

        System.out.println("Your Contacts:");
        user.viewContacts();

        System.out.println("Enter the number of the contact you want to delete:");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice < 1 || choice > user.getContacts().size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contactToDelete = user.getContacts().get(choice - 1);

        System.out.println("Are you sure you want to delete this contact? (yes/no)");
        System.out.println(contactToDelete);

        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            user.getContacts().remove(choice - 1);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }

        System.out.println("Updated Contacts:");
        user.viewContacts();
    }
}
