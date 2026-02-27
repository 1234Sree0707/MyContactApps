package com.seveneleven.mycontactsapp.modify;
import  com.seveneleven.mycontactsapp.user.model.User;

public class ModifyUserProfile {
	public static void modifyUsername(String newusername) {
		User.setUsername(newusername);
		System.out.println("Username changed successfully");
		
	}
	public static void modifyPassword(String newpassword) {
		User.setPassword(newpassword);
		System.out.println("Password changed successfully");
	}
	public static void modifyEmail(String newemail) {
		User.setEmail(newemail);
		System.out.println("Email changed successfully");
	}
}
