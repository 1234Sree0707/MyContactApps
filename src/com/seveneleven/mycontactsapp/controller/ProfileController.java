package com.seveneleven.mycontactsapp.controller;
import  com.seveneleven.mycontactsapp.user.model.*;

import  java.util.Scanner;


import com.seveneleven.mycontactsapp.modify.ModifyUserProfile;
import com.seveneleven.mycontactsapp.user.validation.Validation;

public class ProfileController {
	public static void handleProfile(User user,Scanner sc) {
		ModifyUserProfile md=new ModifyUserProfile();
		String ismodify;
		System.out.println("Do you want to modfiy the profile information(yes/no)");
		ismodify=sc.nextLine();
		if(ismodify.equals("yes")) {
			System.out.println("Do you want to change the username(yes/no)");
			String userchange=sc.nextLine();
			if(userchange.equals("yes")) {
				System.out.println("Enter the new username");
				String newusername=sc.nextLine();
				md.modifyUsername(user,newusername);

			}
			System.out.println("Do you want to change the password(yes/no)");
			String passwordchange=sc.nextLine();
			if(passwordchange.equals("yes")) {

				System.out.println("Enter the new password");
				String newpassword=sc.nextLine();
				System.out.println("Please wait! Checking password strength");
				if(Validation.isSafePassword(user.getPassword())) {
					System.out.println("Password is safe");
					md.modifyPassword(user,newpassword);

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
					md.modifyPassword(user,newpassword1);
				}

			}
			System.out.println("Do you want to change the email id(yes/no)");
			String emailchange=sc.nextLine();
			if(emailchange.equals("yes")) {
				System.out.println("Enter the new email id:");
				String newemail=sc.nextLine();
				md.modifyEmail(user,newemail);
			}
		}

	}

}
