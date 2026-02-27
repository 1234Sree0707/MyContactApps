package com.seveneleven.mycontactsapp.user.model;

public abstract class User {
	protected String name;
	protected String email;
	protected String username;
	protected String password;
	protected int age;
	protected String id;
	protected User(String name,String email,String username,String password,int age,String id) {
		this.name=name;
		this.email=email;
		this.username=username;
		this.password=password;
		this.age=age;
		this.id=id;
		
	}
	public String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		username=username;
	}
	public static void setPassword(String password) {
		password=password;
	}
	public static void setEmail(String email) {
		email=email;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	abstract String getType();
	
	protected void print();
	
	
}
