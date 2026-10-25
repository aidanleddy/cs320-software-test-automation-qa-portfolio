/**
 *  Title: CS-320 Project One - Contact Service
 *  Author: Aidan Leddy
 *  Institution: Southern New Hampshire University
 *  Course: CS-320 Software Test, Automation QA
 *  Instructor: Prof. Sherif Antoun
 *  Date: October 11, 2026
 */

public class Contact {
    // Instance variables
    private final String contactID;        // Unique ID (10 char max, not null, not updatable)
    private String firstName;              // First name (10 char max, not null)
    private String lastName;               // Last name (10 char max, not null)
    private String number;                 // Phone number (exactly 10 digits, not null)
    private String address;                // Address (30 char max, not null)

    // Constructor to initialize instance variables
    public Contact(String contactID, String firstName, String lastName, String number, String address) {
        // Validate variables first
        validateContactID(contactID);
        validateFirstName(firstName);
        validateLastName(lastName);
        validateNumber(number);
        validateAddress(address);

        // Assign variables once validated
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
    }

    // ––– Getter methods –––
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // ––– Setter methods –––
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        validateNumber(number);
        this.number = number;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // ––– Helper methods to validate variables –––
    private void validateContactID(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
        }
    }

    private void validateNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        if (number.length() != 10) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
        if (!isDigitOnly(number)) {
            throw new IllegalArgumentException("Phone number must only contain digits");
        }
    }

    private void validateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters");
        }
    }

    private boolean isDigitOnly(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}