package com.seveneleven.mycontactsapp.main;

import com.seveneleven.mycontactsapp.controller.ContactController;
import com.seveneleven.mycontactsapp.controller.LoginController;
import com.seveneleven.mycontactsapp.controller.ProfileController;
import com.seveneleven.mycontactsapp.controller.RegistrationController;
import com.seveneleven.mycontactsapp.user.model.User;
import  com.seveneleven.mycontactsapp.controller.DeleteContact;
import com.seveneleven.mycontactsapp.controller.BulkOperation;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            HashMap<String, User> hmap = new HashMap<>();

            User registeredUser = RegistrationController.registrationUser(sc, hmap);
            if (registeredUser == null) {
                System.out.println("Registration failed. Exiting.");
                return;
            }

            User loggedInUser = LoginController.login(
                sc, hmap, registeredUser.getUsername(), registeredUser.getPassword()
            );
            if (loggedInUser == null) {
                System.out.println("Login failed. Exiting.");
                return;
            }

            ProfileController.handleProfile(loggedInUser, sc);

            ContactController.manageContacts(loggedInUser, sc);
            System.out.println("Do you want to delete a contact? (yes/no)");
            String deleteAns = sc.nextLine();

            if (deleteAns.equalsIgnoreCase("yes")) {
                DeleteContact.deleteContact(loggedInUser, sc);
            }
            
        } finally {
            sc.close();
        }
    }
}
		
		


