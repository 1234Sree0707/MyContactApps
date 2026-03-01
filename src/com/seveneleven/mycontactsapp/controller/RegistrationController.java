package com.seveneleven.mycontactsapp.controller;

import java.util.UUID;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import com.seveneleven.mycontactsapp.modify.ModifyUserProfile;
import com.seveneleven.mycontactsapp.user.model.FreeUser;
import com.seveneleven.mycontactsapp.user.model.PremiumUser;
import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHash;
import com.seveneleven.mycontactsapp.user.validation.Validation;

public class RegistrationController {
	public static User registrationUser(Scanner sc,Map<String,User> hmap) {
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
		return user;
	}
}
