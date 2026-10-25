/**
 *  Title: CS-320 Project One - Contact Service
 *  Author: Aidan Leddy
 *  Institution: Southern New Hampshire University
 *  Course: CS-320 Software Test, Automation QA
 *  Instructor: Prof. Sherif Antoun
 *  Date: October 11, 2026
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Initialize service and valid contact before each test
        service = new ContactService();
        contact = new Contact("12345", "Aidan", "Leddy", "8006681249", "2500 N River Rd");
    }

    // ––– Positive Tests: Add Contact –––

    @Test
    public void testAddContactSuccess() {
        service.addContact(contact);
        Contact retrieved = service.getContact("12345");
        assertNotNull(retrieved);
        assertEquals("12345", retrieved.getContactID());
    }

    // ––– Negative Tests: Add Contact –––

    @Test
    public void testAddContactDuplicateIdFails() {
        service.addContact(contact);
        Contact duplicateContact = new Contact("12345", "Sherif", "Antoun", "5555555555", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicateContact);
        });
    }

    @Test
    public void testAddNullContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // ––– Delete Contact Tests –––

    @Test
    public void testDeleteContactSuccess() {
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));

        // Post-condition verification: deleting an already deleted contact throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    public void testDeleteContactNullIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(null);
        });
    }

    @Test
    public void testDeleteNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    // ––– Positive Tests: Update Contact –––

    @Test
    public void testUpdateFirstNameSuccess() {
        service.addContact(contact);
        service.updateFirstName("12345", "Sherif");
        assertEquals("Sherif", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastNameSuccess() {
        service.addContact(contact);
        service.updateLastName("12345", "Antoun");
        assertEquals("Antoun", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdateNumberSuccess() {
        service.addContact(contact);
        service.updateNumber("12345", "5555555555");
        assertEquals("5555555555", service.getContact("12345").getNumber());
    }

    @Test
    public void testUpdateAddressSuccess() {
        service.addContact(contact);
        service.updateAddress("12345", "123 Main St");
        assertEquals("123 Main St", service.getContact("12345").getAddress());
    }

    // ––– Negative Tests: Update With Null Contact ID –––

    @Test
    public void testUpdateFirstNameNullIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName(null, "Sherif");
        });
    }

    @Test
    public void testUpdateLastNameNullIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName(null, "Antoun");
        });
    }

    @Test
    public void testUpdateNumberNullIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateNumber(null, "5555555555");
        });
    }

    @Test
    public void testUpdateAddressNullIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress(null, "123 Main St");
        });
    }

    // ––– Negative Tests: Update Non-Existent Contact –––

    @Test
    public void testUpdateFirstNameNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Sherif");
        });
    }

    @Test
    public void testUpdateLastNameNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("99999", "Antoun");
        });
    }

    @Test
    public void testUpdateNumberNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateNumber("99999", "5555555555");
        });
    }

    @Test
    public void testUpdateAddressNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("99999", "123 Main St");
        });
    }

    // ––– Negative Tests: Update With Invalid Data –––

    @Test
    public void testUpdateFirstNameInvalidFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("12345", "AidanAidan1");
        });
    }

    @Test
    public void testUpdateLastNameInvalidFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("12345", "LeddyLeddy1");
        });
    }

    @Test
    public void testUpdateNumberInvalidFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateNumber("12345", "12345");
        });
    }

    @Test
    public void testUpdateAddressInvalidFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            // 31 characters
            service.updateAddress("12345", "1234567890123456789012345678901");
        });
    }
}