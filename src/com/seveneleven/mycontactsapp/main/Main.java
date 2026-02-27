package com.seveneleven.mycontactsapp.main;
import com.seveneleven.mycontactsapp.user.model.FreeUser;
import com.seveneleven.mycontactsapp.user.model.PremiumUser;
import com.seveneleven.mycontactsapp.user.model.User;
import com.seveneleven.mycontactsapp.user.utilities.PasswordHash;
import com.seveneleven.mycontactsapp.user.validation.Validation;
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
		System.out.println("======New Registration======");
		System.out.println("Enter you detials:");
		System.out.print("Enter you name:");
		String name=sc.nextLine();
		System.out.println("");
		System.out.print("Enter your email id:");
		String email=sc.nextLine();
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
		System.out.println("");
		System.out.println("Enter the account type:");
		String type=sc.nextLine();
		User user;
		String id;
		if(type.equalsIgnoreCase("free")) {
			id = UUID.randomUUID().toString();
			user=new FreeUser(name,email,username,password,age,id);
		}else {
			id = UUID.randomUUID().toString();
			user=new PremiumUser(name,email,username,password,age,id);

		}
		hmap.put(id,user);
		System.out.println("Account created");
		if(Validation.isSafePassword(user.getPassword())) {
			System.out.println("Password is safe");
		}else {
			System.out.println("Weak password.");
			System.out.println("Please change password");

		}
		
	}

}


