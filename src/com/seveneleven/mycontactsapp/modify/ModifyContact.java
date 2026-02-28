package com.seveneleven.mycontactsapp.modify;

import com.seveneleven.mycontactsapp.contacts.Contact;

public class ModifyContact {
	public void modifyName(Contact contact,String name) {
		contact.setName(name);
		System.out.println("Name changed successfully");
	}
	public void modifyEmail(Contact contact,String email) {
		contact.setEmail(email);
		System.out.println("Email changed successfully");
	}
	public void modifyPhone(Contact contact,String phone) {
		contact.setPhone(phone);
		System.out.println("Phone number changed successfully");
	}
}
