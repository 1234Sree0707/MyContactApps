package com.seveneleven.mycontactsapp.user.validation;
public class Validation {
	public static boolean isSafePassword(String password) {
		String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
		if(password.matches(regex)) {
			return true;
			
		}else {
			return false;
			
		}
	}
	public static boolean isValidEmail(String email) {
		String regex="^[A-Za-z-0-9+_.-]+@[A-Za-z0-9.-]+$";
		return email.matches(regex);
	}
	public static boolean isValidPhone(String phone) {
		String regex = "^[6-9][0-9]{9}$";
		return phone.matches(regex);
	}
	
	
}

