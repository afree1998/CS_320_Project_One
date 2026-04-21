package com;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

    @DisplayName("Testing valid constructor use")
    @Test
    void testContact() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertEquals("1", c.getContactID());
        Assertions.assertEquals("Austin", c.getFirstName());
        Assertions.assertEquals("Freeman", c.getLastName());
        Assertions.assertEquals("5555555555", c.getPhone());
        Assertions.assertEquals("108 Wallaby Way, Australia", c.getAddress());
    }
    @DisplayName("Testing uniqueId when set to NULL")
    @Test
    void uniqueIdNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia"));
    }
    @DisplayName("Testing uniqueId length")
    @Test
    void uniqueIdTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("16789998212", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing firstName when set to NULL")
    @Test
    void firstNameNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Freeman", "5555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing firstName length")
    @Test
    void firstNameTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "AustinWesley", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing lastName when set to NULL")
    @Test
    void lastNameNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", null, "5555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing lastName length")
    @Test
    void lastNameTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "WesleyFreeman", "5555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing phone when set to NULL")
    @Test
    void phoneNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "Freeman", null, "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing phone length")
    @Test
    void phoneTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "Freeman", "555555555555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing phone too short")
    @Test
    void phoneTooShortTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "Freeman", "555", "108 Wallaby Way, Australia");
        });
    }
    @DisplayName("Testing when address is set to NULL")
    @Test
    void addressNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "Freeman", "5555555555", null);
        });
    }
    @DisplayName("Testing address length")
    @Test
    void addressTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Austin", "Freeman", "5555555555", "Too many characters can lead to an issue where we throw an exception");
        });
    }
    @DisplayName("Testing set firstName")
    @Test
    void setFirstNameTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        c.setFirstName("Ozzy");
        Assertions.assertEquals("Ozzy", c.getFirstName());
    }
    @DisplayName("Testing set firstName NULL")
    @Test
    void setFirstNameNullTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setFirstName(null);
        });
    }
    @DisplayName("Testing set lastName")
    @Test
    void setLastNameTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        c.setLastName("Wallaby");
        Assertions.assertEquals("Wallaby", c.getLastName());
    }
    @DisplayName("Testing set lastName NULL")
    @Test
    void setLastNameNullTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setLastName(null);
        });
    }
    @DisplayName("Testing set phone")
    @Test
    void setPhoneTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        c.setPhone("6666666666");
        Assertions.assertEquals("6666666666", c.getPhone());
    }
    @DisplayName("Testing set phone NULL")
    @Test
    void setPhoneNullTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setPhone(null);
        });
    }
    @DisplayName("Testing set phone length")
    @Test
    void setPhoneTooShortTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setPhone("333");
        });
    }
    @DisplayName("Testing set address")
    @Test
    void setAddressTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        c.setAddress("Test Case Ideally Works");
        Assertions.assertEquals("Test Case Ideally Works", c.getAddress());
    }
    @DisplayName("Testing set address NULL")
    @Test
    void setAddressNullTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setAddress(null);
        });
    }
    @DisplayName("Testing set firstName length")
    @Test
    void setFirstNameLengthTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setFirstName("AustinWesley");
        });
    }
    @DisplayName("Testing set lastName length")
    @Test
    void setLastNameLengthTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setLastName("WesleyFreeman");
        });
    }
    @DisplayName("Testing set phone length")
    @Test
    void setPhoneLengthTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setPhone("55555555555");
        });
    }
    @DisplayName("Testing set address length")
    @Test
    void setAddressLengthTest() {
        Contact c = new Contact("1", "Austin", "Freeman", "5555555555", "108 Wallaby Way, Australia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.setAddress("Once again, we test the link to ensure that this throws an error");
        });
    }
}