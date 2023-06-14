package phonebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContactTest {

    @Test public void testContactExist(){
        Contact contact = new Contact("firstName", "lastName", "07031005737", "email");
        assertNotNull(contact);
    }

    @Test public void testDisplayingTheCreatedContact(){
        Contact contact = new Contact("firstName", "lastName", "07031005737", "email");
        String expectedContact = "firstName lastName";
        assertEquals(expectedContact, contact.toString());
    }

    @Test public void testSeveralContactsCanBeCreated(){
        Contact contact2 = new Contact("Ret", "Max", "08034513898", "dayokr@gmail.com");

        String expectedContact = "Ret Max";
        assertEquals(expectedContact, contact2.toString());
    }


}
