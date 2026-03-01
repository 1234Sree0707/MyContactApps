package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.contacts.Contact;
import com.seveneleven.mycontactsapp.modify.ModifyContact;
import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.validation.Validation;

import java.util.Scanner;

public class ContactController {

    public static void manageContacts(User user, Scanner sc) {

        String add;

        // ===== ADD CONTACTS =====
        do {
            System.out.println("Do you want to add a contact (yes/no)");
            add = sc.nextLine();

            if (add.equalsIgnoreCase("yes")) {

                System.out.println("Enter contact name:");
                String contactname = sc.nextLine();

                String contactphone;
                do {
                    System.out.println("Enter contact no:");
                    contactphone = sc.nextLine();
                    if (!Validation.isValidPhone(contactphone)) {
                        System.out.println("Enter a valid contact no");
                    }
                } while (!Validation.isValidPhone(contactphone));

                String contactemail;
                do {
                    System.out.println("Enter contact email:");
                    contactemail = sc.nextLine();
                    if (!Validation.isValidEmail(contactemail)) {
                        System.out.println("Enter a valid email");
                    }
                } while (!Validation.isValidEmail(contactemail));

                Contact contact = new Contact(contactname, contactphone, contactemail);
                user.addContact(contact);
            }

        } while (add.equalsIgnoreCase("yes"));

        System.out.println("========Contacts saved successfully========");
        user.viewContacts();

        // ===== EDIT CONTACT =====
        System.out.println("Do you want to edit contact? (yes/no)");
        String ans = sc.nextLine();

        if (ans.equalsIgnoreCase("yes")) {

            System.out.println("Enter the number of the contact you want to edit:");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > user.getContacts().size()) {
                System.out.println("Invalid contact number.");
                return;
            }

            Contact contactToEdit = user.getContacts().get(choice - 1);
            ModifyContact modifier = new ModifyContact();

            String continueEditing;
            do {
                System.out.println("What do you want to edit? (name/email/phone)");
                String field = sc.nextLine();

                switch (field.toLowerCase()) {

                    case "name":
                        System.out.println("Enter new name:");
                        modifier.modifyName(contactToEdit, sc.nextLine());
                        break;

                    case "email":
                        String newEmail;
                        do {
                            System.out.println("Enter new email:");
                            newEmail = sc.nextLine();
                        } while (!Validation.isValidEmail(newEmail));
                        modifier.modifyEmail(contactToEdit, newEmail);
                        break;

                    case "phone":
                        String newPhone;
                        do {
                            System.out.println("Enter new phone:");
                            newPhone = sc.nextLine();
                        } while (!Validation.isValidPhone(newPhone));
                        modifier.modifyPhone(contactToEdit, newPhone);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

                System.out.println("Do you want to edit something else for this contact? (yes/no)");
                System.out.println("Contact changed successfully");

                continueEditing = sc.nextLine();

            } while (continueEditing.equalsIgnoreCase("yes"));
        }

        user.viewContacts();
        
    }
}
