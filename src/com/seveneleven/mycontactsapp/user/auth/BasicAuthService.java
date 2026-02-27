package com.seveneleven.mycontactsapp.user.auth;
import  com.seveneleven.mycontactsapp.user.model.User;


import java.util.Base64;
import java.util.HashMap;

public class BasicAuthService {

	public static User authenticate(
			String authHeader,
			HashMap<String, User> users
			) {

		String decoded = new String(
				Base64.getDecoder().decode(authHeader)
				);

		String[] parts = decoded.split(":");
		String username = parts[0];
		String password = parts[1];

		for (User u : users.values()) {
			if (u.username.equals(username)
					&& u.getPassword().equals(password)) {
				return u; 
			}
		}
		return null; 
	}

	public static String generate(String username, String password) {
		return Base64.getEncoder()
				.encodeToString((username + ":" + password).getBytes());
	}
}
