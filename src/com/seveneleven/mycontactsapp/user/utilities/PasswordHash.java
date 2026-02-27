package com.seveneleven.mycontactsapp.user.utilities;

import java.security.MessageDigest;
import java.util.Base64;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordHash {
		public static String generateSalt() {
			SecureRandom random =new SecureRandom();
			byte[] salt=new byte[16];
			random.nextBytes(salt);
			
			return Base64.getEncoder().encodeToString(salt);
		}
		public static String passwordHash(String password,String salt) {
			try {
				MessageDigest md=MessageDigest.getInstance("SHA-256");
				md.update(Base64.getDecoder().decode(salt));
				byte[] hash=md.digest(password.getBytes());
				return Base64.getEncoder().encodeToString(hash);
				
			}catch(Exception e){
				throw new RuntimeException("Error",e);
			}
			
		}
}