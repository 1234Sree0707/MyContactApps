package com.seveneleven.mycontactsapp.user.auth;
import  com.seveneleven.mycontactsapp.user.model.User;


import java.util.HashMap;
import java.util.UUID;

public class OAuthService {
	private static HashMap<String, User> tokenStore = new HashMap<>();
	public static String generateToken(User user) {
		String token = UUID.randomUUID().toString();
		tokenStore.put(token, user);
		return token;
	}
	public static User validateToken(String token) {
		return tokenStore.get(token); 
	}
	public static void revokeToken(String token) {
		tokenStore.remove(token);
	}
}	
