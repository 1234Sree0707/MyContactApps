package com.seveneleven.mycontactsapp.main;
import com.seveneleven.mycontactsapp.user.model.FreeUser;
import com.seveneleven.mycontactsapp.user.model.PremiumUser;
import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHash;
import com.seveneleven.mycontactsapp.user.validation.Validation;
import com.seveneleven.mycontactsapp.user.auth.BasicAuthService;
import com.seveneleven.mycontactsapp.user.auth.OAuthService;
import com.seveneleven.mycontactsapp.modify.ModifyUserProfile;
import com.seveneleven.mycontactsapp.contacts.Contact;

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class Main {
	public static void main(String[] args) {
		Random rand=new Random(100);
		Scanner sc=new Scanner(System.in);
		HashMap<String,User> hmap=new HashMap<>();
		System.out.println("========New Registration========");
		System.out.println("Enter you detials:");
		System.out.print("Enter you name:");
		String name=sc.nextLine();
		System.out.println("");
		String email;
		do {
			System.out.print("Enter your email id:");
			email=sc.nextLine();
			if(!Validation.isValidEmail(email)) {
				System.out.println("Enter a valid email!");
			}

		}while(!Validation.isValidEmail(email));
		System.out.println("");
		System.out.println("Enter your phone number:");
		String phone=sc.nextLine();
		System.out.println("");
		System.out.print("Enter your age:");
		int age=sc.nextInt();
		System.out.println("");
		sc.nextLine();
		System.out.print("Enter your username:");
		String username=sc.nextLine();
		System.out.println("");
		System.out.print("Enter your password:");
		String password=sc.nextLine();
		ModifyUserProfile md=new ModifyUserProfile();
		System.out.println("Please wait! Checking password strength");
		if(Validation.isSafePassword(password)) {
			System.out.println("Password is safe");
		}else {
			System.out.println("Weak password.");
			System.out.println("Please change password");
			do {
				System.out.println("Enter the new password:");
				password=sc.nextLine();
				if(!Validation.isSafePassword(password)) {
					System.out.println("Enter a strong password.");

				}
			}while(!Validation.isSafePassword(password));
		
		}
		System.out.println("");
		System.out.println("Enter the account type:");
		String type=sc.nextLine();
		User user;
		String id;
		if(type.equalsIgnoreCase("free")) {
			id = UUID.randomUUID().toString();
			user=new FreeUser(name,email,phone,username,password,age,id);
		}else {
			id = UUID.randomUUID().toString();
			user=new PremiumUser(name,email,phone,username,password,age,id);

		}
		hmap.put(id,user);

		System.out.println("========Account created Successfully========");
		String saltvalue=PasswordHash.generateSalt();
		String hashvalue=PasswordHash.passwordHash(password, saltvalue);
		System.out.println("Hash of password is "+hashvalue);
		System.out.println("");
		System.out.println("========Login========");
		System.out.println("Choose login type:");
		System.out.println("Enter 1 for Basic Auth");
		System.out.println("Enter 2 for OAuth");
		String num=sc.nextLine();
		User loggedInUser=null;
		if(num.equals("1")) {
		String basAuth=BasicAuthService.generate(username, password);
		loggedInUser=BasicAuthService.authenticate(basAuth, hmap);
		if(loggedInUser!=null) {
			System.out.println("Basic Authentication Successful");
		}else {
			System.out.println("Basic Authentication failed");
		}
		}
		else if(num.equals("2")){
		String token=OAuthService.generateToken(loggedInUser);
		System.out.println("OAuth token generated");
		System.out.println(token);
		}else {
			System.out.println("Loggin Failed, please try again later");
			return;
		}	
		System.out.println("========Logged In========");
		String ismodify;
		System.out.println("Do you want to modfiy the profile information(yes/no)");
		ismodify=sc.nextLine();
		if(ismodify.equals("yes")) {
			System.out.println("Do you want to change the username(yes/no)");
			String userchange=sc.nextLine();
			if(userchange.equals("yes")) {
				System.out.println("Enter the new username");
				String newusername=sc.nextLine();
				md.modifyUsername(loggedInUser,newusername);

			}
			System.out.println("Do you want to change the password(yes/no)");
			String passwordchange=sc.nextLine();
			if(passwordchange.equals("yes")) {

				System.out.println("Enter the new password");
				String newpassword=sc.nextLine();
				System.out.println("Please wait! Checking password strength");
				if(Validation.isSafePassword(user.getPassword())) {
					System.out.println("Password is safe");
					md.modifyPassword(loggedInUser,newpassword);

				}else {
					String newpassword1;
					System.out.println("Weak password.");
					System.out.println("Please change password");
					do {
						System.out.println("Enter the new password:");
						newpassword1=sc.nextLine();
						if(!Validation.isSafePassword(newpassword1)) {
							System.out.println("Enter a strong password.");

						}
					}while(!Validation.isSafePassword(newpassword1));
					md.modifyPassword(loggedInUser,newpassword1);
				}

			}
			System.out.println("Do you want to change the email id(yes/no)");
			String emailchange=sc.nextLine();
			if(emailchange.equals("yes")) {
				System.out.println("Enter the new email id:");
				String newemail=sc.nextLine();
				md.modifyEmail(loggedInUser,newemail);
			}
		}
		Contact contact;
		if (loggedInUser != null) {
		    String add;
		    do {
		        System.out.println("Do you want to add a contact(yes/no)");
		        add = sc.nextLine();

		        if (add.equalsIgnoreCase("yes")) {
		            System.out.println("Enter contact name:");
		            String contactname = sc.nextLine();
		            System.out.println("Enter contact phone:");
		            String contactphone = sc.nextLine();
		            System.out.println("Enter contact email:");
		            String contactemail = sc.nextLine();

		            contact = new Contact(contactname, contactphone, contactemail);
		            loggedInUser.addContact(contact);
		        }
		    } while (add.equalsIgnoreCase("yes"));

		    System.out.println("========Contacts saved successfully========");
		    System.out.println("Your Contacts:");
		   loggedInUser.viewContacts();
		}

	}
}


