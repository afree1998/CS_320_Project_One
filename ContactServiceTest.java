package com;

import org.junit.jupiter.api.*;

public class ContactServiceTest {

    @BeforeEach
    void removeItem() throws Exception {
        ContactService.contacts.clear();
        ContactService.uniqueID = 0;
    }

    @DisplayName("Testing addContact")
    @Test
    public void testAddContact() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();

        Assertions.assertTrue(ContactService.contacts.isEmpty());

        cs.addContact(firstName, lastName, number, address);
        Assertions.assertFalse(ContactService.contacts.isEmpty());
        Assertions.assertEquals(Integer.toString(0), ContactService.contacts.get(0).getContactID());
        Assertions.assertEquals(firstName, ContactService.contacts.get(0).getFirstName());
        Assertions.assertEquals(lastName, ContactService.contacts.get(0).getLastName());
        Assertions.assertEquals(number, ContactService.contacts.get(0).getPhone());
        Assertions.assertEquals(address, ContactService.contacts.get(0).getAddress());
        Assertions.assertNotNull(ContactService.contacts.get(0).toString());
    }
    @DisplayName("Testing invalid data for addContact")
    @Test
    public void testAddInvalidData() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "12345678910";
        String address = "Street Address";
        ContactService cs = new ContactService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> cs.addContact(firstName, lastName, number, address));

    }
    @DisplayName("Testing deleteContact")
    @Test
    public void testDeleteContact() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";

        ContactService cs = new ContactService();

        cs.addContact(firstName, lastName, number, address);
        cs.addContact(firstName, lastName, number, address);
        cs.addContact(firstName, lastName, number, address);
        cs.addContact(firstName, lastName, number, address);
        cs.addContact(firstName, lastName, number, address);

        Assertions.assertEquals(5, ContactService.contacts.size());

        cs.deleteContact(Integer.toString(1));

        Assertions.assertEquals(4, ContactService.contacts.size());

        boolean found = false;

        for (Contact c : ContactService.contacts) {
            if(c.getContactID().equals(Integer.toString(1))) {
                found = true;
            }
        }
        Assertions.assertFalse(found);
    }
    @DisplayName("Testing bad uniqueId on deleteContact")
    @Test
    public void testBadUniqueIdDeleteContact() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> cs.deleteContact("58"));
    }
    @DisplayName("Testing editFirstName")
    @Test
    public void testEditFirstName() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";

        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editFirstName(Integer.toString(0), "John");
        Assertions.assertEquals("John", ContactService.contacts.get(0).getFirstName());
    }
    @DisplayName("Testing bad uniqueID to ensure it doesn't affect firstName")
    @Test
    public void testBadIdFirstName() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);

        cs.editFirstName("75", "John");

        Assertions.assertEquals("Austin", ContactService.contacts.get(0).getFirstName());
    }
    @DisplayName("Testing bad replacement for firstName")
    @Test
    public void testBadReplacementForFirstName() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();

        cs.addContact(firstName, lastName, number, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cs.editFirstName(Integer.toString(0), "JohnJacobJingleheimerSchmit");
        });
    }
    @DisplayName("Testing editLastName")
    @Test
    public void testEditLastName() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editLastName(Integer.toString(0), "Smith");
        Assertions.assertEquals("Smith", ContactService.contacts.get(0).getLastName());
    }
    @DisplayName("Testing bad uniqueId on lastName")
    @Test
    public void testBadIdLastName() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);

        cs.editLastName("75", "Smith");
        Assertions.assertEquals("Freeman", ContactService.contacts.get(0).getLastName());
    }
    @DisplayName("Testing bad replacement for lastName")
    @Test
    public void testBadReplacementForLastName() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();

        cs.addContact(firstName, lastName, number, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cs.editLastName(Integer.toString(0), "JohnJacobJingleheimerSchmit");
        });
    }
    @DisplayName("Testing editPhoneNumber")
    @Test
    public void testEditPhoneNumber() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";

        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editPhoneNumber(Integer.toString(0), "5555555555");
        Assertions.assertEquals("5555555555", ContactService.contacts.get(0).getPhone());
    }
    @DisplayName("Testing bad uniqueId on phoneNumber")
    @Test
    public void testBadIdPhoneNumber() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";

        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editPhoneNumber("98", "5555555555");
        Assertions.assertEquals("1234567890", ContactService.contacts.get(0).getPhone());
    }
    @DisplayName("Testing bad replacement for phoneNumber")
    @Test
    public void testBadReplacementForPhoneNumber() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();

        cs.addContact(firstName, lastName, number, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cs.editPhoneNumber(Integer.toString(0), "88888888888");
        });
    }
    @DisplayName("Testing editAddress")
    @Test
    public void testEditAddress() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editAddress(Integer.toString(0), "42 Wallaby Way, Australia");
        Assertions.assertEquals("42 Wallaby Way, Australia", ContactService.contacts.get(0).getAddress());
    }
    @DisplayName("Testing bad uniqueId on address")
    @Test
    public void testBadIdAddress() {

        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.editAddress("67", "42 Wallaby Way, Australia");
        Assertions.assertEquals("Street Address", ContactService.contacts.get(0).getAddress());
    }
    @DisplayName("Testing bad replacement for address")
    @Test
    public void testBadReplacementForAddress() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();

        cs.addContact(firstName, lastName, number, address);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cs.editAddress(Integer.toString(0), "Testing if a long string is enough to throw an exception is fairly easy if you yap hard enough");
        });
    }

    @DisplayName("Testing non-integer numbers in phone")
    @Test
    public void testNonIntegerNumbers() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "AAAAAAAAAA";
        String address = "Street Address";
        ContactService cs = new ContactService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> cs.addContact(firstName, lastName, number, address));
    }

    @DisplayName("Testing to ensure non-duplicate ID's")
    @Test
    public void testNonDuplicateIDs() {
        String firstName = "Austin";
        String lastName = "Freeman";
        String number = "1234567890";
        String address = "Street Address";
        ContactService cs = new ContactService();
        cs.addContact(firstName, lastName, number, address);
        cs.addContact(firstName, lastName, number, address);

        Assertions.assertNotEquals(ContactService.contacts.get(0).getContactID(), ContactService.contacts.get(1).getContactID());
    }

}