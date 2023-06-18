package phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    Contact contact;
    @BeforeEach public void beforeEach(){
        contact = new Contact("firstName", "lastName", "07031005737", "dayokr@gmail.com", "null");
    }

    @Test public void testContactExist(){
        assertNotNull(contact);
    }

    @Test public void testDisplayingTheCreatedContactDetails(){
        String expectedContactDetails = """
                firstName lastName
                07031005737
                dayokr@gmail.com
                """;
        assertEquals(expectedContactDetails, contact.displayContactDetails());
    }

    @Test public void testEditingContactFirstName(){
        contact.editFirstNameN("Ret");

        String expectedContactDetails = """
                Ret lastName
                07031005737
                dayokr@gmail.com
                """;
        assertEquals(expectedContactDetails, contact.displayContactDetails());
    }

    @Test public void testEditingContactLastName(){
        contact.editLastName("Max");
        String expectedContactDetails = """
                firstName Max
                07031005737
                dayokr@gmail.com
                """;
        assertEquals(expectedContactDetails, contact.displayContactDetails());
    }

    @Test public void testEditingContactPhoneNumber(){
        contact.editPhoneNumber("08034513898");

        String expectedContactDetails = """
                firstName lastName
                08034513898
                dayokr@gmail.com
                """;
        assertEquals(expectedContactDetails, contact.displayContactDetails());
    }
}
