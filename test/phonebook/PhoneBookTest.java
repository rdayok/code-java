package phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhoneBookTest {

    PhoneBook phoneBook;

    @BeforeEach
    public void beforeEach() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testPhoneBookExist() {
        assertNotNull(phoneBook);
    }

    @Test public void testContactListSizeAfterAddingA_contact(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");

        assertEquals(1, phoneBook.getNumberOfContactsInPhoneBook());
    }

    @Test public void estContactListSizeAfterAddingTwo_contacts(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");
        phoneBook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");

        assertEquals(2, phoneBook.getNumberOfContactsInPhoneBook());
    }

    @Test public void testSearchingContactList(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");

        String contactList = """
                firstName lastName
                """;
        assertEquals(contactList, phoneBook.displayContactList());
    }

    @Test public void testSearchingContactList2(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");
        phoneBook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");

        String contactList = """
                firstName lastName
                ret max
                """;
        assertEquals(contactList, phoneBook.displayContactList());
    }

    @Test public void testDeletingAContact(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");
        phoneBook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");

        phoneBook.deleteContactByName("firstName lastName");
        String contactList = """
                ret max
                """;
        assertEquals(contactList, phoneBook.displayContactList());
    }

    @Test public void testSelectingAContactFromTheList(){
        phoneBook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");
        phoneBook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");

        String expectedDetailsOfSelectedContact = """
                ret max
                08031005737
                max_ret@yahoo.com
                """;
        assertEquals(expectedDetailsOfSelectedContact, phoneBook.selectContactByName("ret max"));
    }
}
