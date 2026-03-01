package com.seveneleven.mycontactsapp.contacts;

import java.time.LocalDateTime;

public class Contact {

    private String name;
    private String phone;
    private String email;
    private String tag;
    private LocalDateTime dateAdded;
    private int contactCount;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.tag = "Untagged";
        this.dateAdded = LocalDateTime.now(); // ✅ FIXED
        this.contactCount = 0;
    }

    // ===== GETTERS =====
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTag() {
        return tag;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public int getContactCount() {
        return contactCount;
    }

    // ===== SETTERS =====
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void incrementContactCount() {
        contactCount++;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Phone: " + phone +
               ", Email: " + email +
               ", Tag: " + tag +
               ", Added On: " + dateAdded +
               ", Frequency: " + contactCount;
    }
}
