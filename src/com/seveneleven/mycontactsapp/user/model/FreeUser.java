package com.seveneleven.mycontactsapp.user.model;

public class FreeUser extends User{
	public FreeUser(String name,String email,String username,String password,int age,String id) {
		super(name,email,username,password,age,id);
	}
	@Override
	public void printUser() {
		
	}
	@Override
	public String getType() {
		return "free";
	}
	
	
}
