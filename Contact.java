package com;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if(contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }
        if(phone == null || phone.length() > 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number is invalid");
        }
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    public String getContactID() {
        return contactID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if(phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number is invalid");
        }
        this.phone = phone;
    }
    public void setAddress(String address) {
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }
        this.address = address;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contact ID: ").append(contactID);
        sb.append("\nFirst name: ").append(firstName);
        sb.append("\nLast name: ").append(lastName);
        sb.append("\nPhone number: ").append(phone);
        sb.append("\nAddress: ").append(address);
        return sb.toString();
    }
}
