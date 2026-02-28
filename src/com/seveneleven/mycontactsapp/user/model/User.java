package com.seveneleven.mycontactsapp.user.model;
import com.seveneleven.mycontactsapp.contacts.Contact;

import java.util.ArrayList;
import java.util.List;
public abstract class User {
	protected String name;
	protected String email;
	protected String phone;
	protected String username;
	protected String password;
	protected int age;
	protected String id;
	protected List<Contact> contacts=new ArrayList<>();
	
	protected User(String name,String email,String phone,String username,String password,int age,String id) {
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.username=username;
		this.password=password;
		this.age=age;
		this.id=id;
		
	}
	public void addContact(Contact contact) {
		contacts.add(contact);
		System.out.println("Contact added successfully.");
	}
	
	public String getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public  void setPhone(String phone) {
		this.phone=phone;
	}
	public  void setUsername(String username) {
		this.username=username;
	}
	public  void setPassword(String password) {
		this.password=password;
	}
	public  void setEmail(String email) {
		this.email=email;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	abstract String getType();
	
	protected void printUser();
	
	
}
