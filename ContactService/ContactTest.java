/**
 *  Title: CS-320 Project One - Contact Service
 *  Author: Aidan Leddy
 *  Institution: Southern New Hampshire University
 *  Course: CS-320 Software Test, Automation QA
 *  Instructor: Prof. Sherif Antoun
 *  Date: October 11, 2026
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Initialize valid contact before each test
        contact = new Contact("12345", "Aidan", "Leddy", "8006681249", "2500 N River Rd");
    }

    // ––– Positive Tests: Constructor & Setters –––

    @Test
    public void testContactCreationAndGettersSuccess() {
        assertEquals("12345", contact.getContactID());
        assertEquals("Aidan", contact.getFirstName());
        assertEquals("Leddy", contact.getLastName());
        assertEquals("8006681249", contact.getNumber());
        assertEquals("2500 N River Rd", contact.getAddress());
    }

    @Test
    public void testSettersSuccess() {
        contact.setFirstName("Sherif");
        contact.setLastName("Antoun");
        contact.setNumber("5555555555");
        contact.setAddress("123 Main St");

        assertEquals("Sherif", contact.getFirstName());
        assertEquals("Antoun", contact.getLastName());
        assertEquals("5555555555", contact.getNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    // ––– Boundary Tests: Exact Length Limits –––

    @Test
    public void testExactBoundaryLengthsSuccess() {
        // ID: 10 chars, First: 10 chars, Last: 10 chars, Phone: 10 digits, Address: 30 chars
        String exactId = "1234567890";
        String exactFirst = "1234567890";
        String exactLast = "1234567890";
        String exactPhone = "1234567890";
        String exactAddress = "123456789012345678901234567890";

        Contact boundaryContact = new Contact(exactId, exactFirst, exactLast, exactPhone, exactAddress);
        assertEquals(exactId, boundaryContact.getContactID());
        assertEquals(exactFirst, boundaryContact.getFirstName());
        assertEquals(exactLast, boundaryContact.getLastName());
        assertEquals(exactPhone, boundaryContact.getNumber());
        assertEquals(exactAddress, boundaryContact.getAddress());

        boundaryContact.setFirstName(exactFirst);
        boundaryContact.setLastName(exactLast);
        boundaryContact.setNumber(exactPhone);
        boundaryContact.setAddress(exactAddress);

        assertEquals(exactFirst, boundaryContact.getFirstName());
        assertEquals(exactLast, boundaryContact.getLastName());
        assertEquals(exactPhone, boundaryContact.getNumber());
        assertEquals(exactAddress, boundaryContact.getAddress());
    }

    // ––– Field Immutability Tests: Contact ID –––

    @Test
    public void testContactIdImmutability() throws NoSuchFieldException {
        // Confirm no setter exists for contactID
        for (Method m : Contact.class.getMethods()) {
            assertNotEquals("setContactID", m.getName());
            assertNotEquals("setContactId", m.getName());
        }

        // Verify the contactID field is declared final
        assertTrue(Modifier.isFinal(Contact.class.getDeclaredField("contactID").getModifiers()));
    }

    // ––– Negative Tests: Contact ID –––

    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Aidan", "Leddy", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            // "12345678901" has 11 characters
            new Contact("12345678901", "Aidan", "Leddy", "8006681249", "2500 N River Rd");
        });
    }

    // ––– Negative Tests: First Name –––

    @Test
    public void testFirstNameNullInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Leddy", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    public void testFirstNameTooLongInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "AidanAidan1", "Leddy", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    public void testSetFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("AidanAidan1");
        });
    }

    // ––– Negative Tests: Last Name –––

    @Test
    public void testLastNameNullInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", null, "8006681249", "2500 N River Rd");
        });
    }

    @Test
    public void testLastNameTooLongInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "LeddyLeddy1", "8006681249", "2500 N River Rd");
        });
    }

    @Test
    public void testSetLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testSetLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("LeddyLeddy1");
        });
    }

    // ––– Negative Tests: Phone Number –––

    @Test
    public void testNumberNullInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "Leddy", null, "2500 N River Rd");
        });
    }

    @Test
    public void testNumberTooShortInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "Leddy", "123456789", "2500 N River Rd");
        });
    }

    @Test
    public void testNumberTooLongInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "Leddy", "12345678901", "2500 N River Rd");
        });
    }

    @Test
    public void testNumberNonDigitsInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "Leddy", "800668124a", "2500 N River Rd");
        });
    }

    @Test
    public void testSetNumberNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber(null);
        });
    }

    @Test
    public void testSetNumberTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber("123456789");
        });
    }

    @Test
    public void testSetNumberTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber("12345678901");
        });
    }

    @Test
    public void testSetNumberNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setNumber("abcdefghij");
        });
    }

    // ––– Negative Tests: Address –––

    @Test
    public void testAddressNullInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Aidan", "Leddy", "8006681249", null);
        });
    }

    @Test
    public void testAddressTooLongInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            // 31 characters
            new Contact("12345", "Aidan", "Leddy", "8006681249", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testSetAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    @Test
    public void testSetAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            // 31 characters
            contact.setAddress("1234567890123456789012345678901");
        });
    }
}