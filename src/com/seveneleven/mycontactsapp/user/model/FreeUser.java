package com.seveneleven.mycontactsapp.user.model;

public class FreeUser extends User{
	public FreeUser(String name,String email,String phone,String username,String password,int age,String id) {
		super(name,email,phone,username,password,age,id);
	}
	@Override
	public void printUser() {
		
	}
	@Override
	public String getType() {
		return "free";
	}
	
	
}
