package com.seveneleven.mycontactsapp.user.model;

public class PremiumUser extends User{
	public PremiumUser(String name,String email,String phone,String username,String password,int age,String id) {
		super(name,email,phone,username,password,age,id);
	}
	@Override
	public void printUser() {
		
	}
	@Override
	public String getType() {
		return "premium";
	}
}
