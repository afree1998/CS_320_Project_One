package com;

import java.util.ArrayList;

public class ContactService {
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static int uniqueID = 0;

    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        contacts.add(new Contact(Integer.toString(uniqueID), firstName, lastName, phoneNumber, address));
        uniqueID++;
    }
    public void deleteContact(String uniqueId) {
        boolean found = contacts.removeIf(contact -> contact.getContactID().equals(uniqueId));
        if(!found) {
            throw new IllegalArgumentException("Contact not found");
        }
    }

    public void editFirstName(String uniqueId, String firstName) {
        for (Contact contact : contacts) {
            if(contact.getContactID().equals(uniqueId)) {
                contact.setFirstName(firstName);
                return;
            }
        }
    }
    public void editLastName(String uniqueId, String lastName) {
        for (Contact contact : contacts) {
            if(contact.getContactID().equals(uniqueId)) {
                contact.setLastName(lastName);
            }
        }
    }
    public void editPhoneNumber(String uniqueId, String phoneNumber) {
        for (Contact contact : contacts) {
            if(contact.getContactID().equals(uniqueId)) {
                contact.setPhone(phoneNumber);
            }
        }
    }
    public void editAddress(String uniqueId, String address) {
        for (Contact contact : contacts) {
            if(contact.getContactID().equals(uniqueId)) {
                contact.setAddress(address);
            }
        }
    }


}
