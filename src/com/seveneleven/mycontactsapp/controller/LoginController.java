package com.seveneleven.mycontactsapp.controller;

import com.seveneleven.mycontactsapp.user.auth.BasicAuthService;
import com.seveneleven.mycontactsapp.user.auth.OAuthService;
import com.seveneleven.mycontactsapp.user.model.User;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;


public class LoginController {
	public static User login(Scanner sc,HashMap<String,User> hmap,String username,String password) {
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
			String basAuth=BasicAuthService.generate(username, password);
			loggedInUser=BasicAuthService.authenticate(basAuth, hmap);
		String token=OAuthService.generateToken(loggedInUser);
		System.out.println("OAuth token generated");
		System.out.println(token);
		}else {
			System.out.println("Loggin Failed, please try again later");
			return null;
		}
		System.out.println("========Logged In========");
		return loggedInUser;
	}
}
