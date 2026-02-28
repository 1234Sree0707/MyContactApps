package com.seveneleven.mycontactsapp.modify;
import  com.seveneleven.mycontactsapp.user.model.User;

public class ModifyUserProfile {
	public  void modifyUsername(User user,String newusername) {
		user.setUsername(newusername);
		System.out.println("Username changed successfully");
		
	}
	public  void modifyPassword(User user,String newpassword) {
		user.setPassword(newpassword);
		System.out.println("Password changed successfully");
	}
	public  void modifyEmail(User user,String newemail) {
		user.setEmail(newemail);
		System.out.println("Email changed successfully");
	}
}
