/**
 *  Title: CS-320 Project One - Contact Service
 *  Author: Aidan Leddy
 *  Institution: Southern New Hampshire University
 *  Course: CS-320 Software Test, Automation QA
 *  Instructor: Prof. Sherif Antoun
 *  Date: October 11, 2026
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Hash map in-memory data structure for storing contacts by unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add contact with unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete contact per unique ID
    public void deleteContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID);
    }

    // Update first name per unique ID
    public void updateFirstName(String contactID, String firstName) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(firstName);
    }

    // Update last name per unique ID
    public void updateLastName(String contactID, String lastName) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setLastName(lastName);
    }

    // Update phone number per unique ID
    public void updateNumber(String contactID, String number) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setNumber(number);
    }

    // Update address per unique ID
    public void updateAddress(String contactID, String address) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setAddress(address);
    }

    // Helper for testing verification
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}