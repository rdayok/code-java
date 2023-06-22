package phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {
    Phonebook phonebook;

    @BeforeEach
    public void beforeEach() {
        phonebook = new Phonebook("userName", "password");
        phonebook.addContact("firstName", "lastName", "07031005737", "max_ret@yahoo.com");
    }

    @Test
    public void testPhoneBookExist() {
        assertNotNull(phonebook);
    }

    @Test public void testPhoneBookIsLocked(){
        assertTrue(phonebook.isPhonebookUnlocked());
    }

    @Test public void testUnlockingPhoneBook(){
        phonebook.lockPhonebook();
        assertFalse(phonebook.isPhonebookUnlocked());

        phonebook.unlockPhonebook("userName", "password");
        assertTrue(phonebook.isPhonebookUnlocked());
    }

    @Test public void testUnlockingPhonebookWithWrongUsername(){
        phonebook.lockPhonebook();
        assertFalse(phonebook.isPhonebookUnlocked());

        assertThrows(IllegalArgumentException.class, () -> phonebook.unlockPhonebook("username", "password"));
    }

    @Test public void testUnlockingPhonebookWithWrongPassword(){
        phonebook.lockPhonebook();
        assertFalse(phonebook.isPhonebookUnlocked());

        assertThrows(IllegalArgumentException.class, () -> phonebook.unlockPhonebook("userName", "passWord"));
    }

    @Test public void testContactListCounter(){
        assertEquals(1, phonebook.getNumberOfContactsInPhonebook());
    }

    @Test public void testContactListCounterAfterAddingTwoContacts(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        assertEquals(2, phonebook.getNumberOfContactsInPhonebook());
    }

    @Test public void testDisplayContactList(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 firstName lastName
                1 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());
    }

    @Test public void testDisplayContactListAgain(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");

        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());
    }
    @Test public void testSelectingAContactInTheDisplayList(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        String selectedContactDetails = """
                firstName lastName
                07031005737
                max_ret@yahoo.com
                """;
        assertEquals(selectedContactDetails, phonebook.displaySelectedContact(1));
    }

    @Test public void testSelectingContactWithSerialNumberThatDoesNotExist(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertThrows(IllegalArgumentException.class, () -> phonebook.displaySelectedContact(5));
    }

    @Test public void testDeletingSelectedContactFromDisplayedContactList(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        phonebook.deleteSelectedContact(1);

        String contactListAfterDeleting = """
                0 Angel Joe
                1 ret max
                """;
        assertEquals(contactListAfterDeleting, phonebook.displayContactList());
    }

    @Test public void testEditingFirstNameOfASelectedContact(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        phonebook.editFirstNameOfSelectedContact(1, "Retnaa");

        String contactListAfterEdit = """
                0 Angel Joe
                1 ret max
                2 Retnaa lastName
                """;
        assertEquals(contactListAfterEdit, phonebook.displayContactList());
    }

    @Test public void testEditingLastNameOfASelectedContact(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        phonebook.editLastNameOfSelectedContact(1, "Dayok");

        String contactListAfterEdit = """
                0 Angel Joe
                1 firstName Dayok
                2 ret max
                """;
        assertEquals(contactListAfterEdit, phonebook.displayContactList());
    }

    @Test public void testEditingPhoneNumberOfASelectedContact(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        phonebook.editPhoneNumberOfSelectedContact(1, "07050657321");

        String selectedContactDetails = """
                firstName lastName
                07050657321
                max_ret@yahoo.com
                """;
        assertEquals(selectedContactDetails, phonebook.displaySelectedContact(1));
    }


    @Test public void testSearchingByFullName(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                """, phonebook.search("Angel Joe"));
    }

    @Test public void testSearchingByFullName2(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                """, phonebook.search("Angel Joe"));
    }

    @Test public void testSearchingByFirstName(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                """, phonebook.search("Angel"));
    }

    @Test public void testSearchingByLastName(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                """, phonebook.search("Joe"));
    }

    @Test public void testSearchingByPhoneNumber(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08041005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                ret max
                  08031005737
                """, phonebook.search("08031005737"));
    }

    @Test public void testSearchingByADetailThatTwoContactHave(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                ret max
                  08031005737
                """, phonebook.search("08031005737"));
    }

    @Test public void testCaseInsensitiveSearchingByFullName(){
        phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com");
        phonebook.addContact("Angel", "Joe", "08031005737", "max_ret@yahoo.com");
        String contactList = """
                0 Angel Joe
                1 firstName lastName
                2 ret max
                """;
        assertEquals(contactList, phonebook.displayContactList());

        assertEquals("""
                Angel Joe
                  08031005737
                """, phonebook.search("angel Joe"));
    }

    @Test public void testAddingContactWithPhonebookLocked(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.addContact("ret", "max", "08031005737", "max_ret@yahoo.com"));
    }

    @Test public void testDisplayContactListWithPhonebookLocked(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.displayContactList());
    }

    @Test public void testDeletingContactWithPhonebookLocked(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.deleteSelectedContact(1));
    }

    @Test public void testSearchWithPhonebookLocke(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.search("firstName"));
    }

    @Test public void testDisplaySelectedContactWithPhonebookLocked(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.displaySelectedContact(0));
    }

    @Test public void testEditingContactFirstNameWithPhonebookLocked(){
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.editFirstNameOfSelectedContact(0, "Retnaa"));
    }

    @Test public void testEditingContactLastNameWithPhonebookLocked() {
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.editLastNameOfSelectedContact(0, "Retnaa"));
    }

    @Test public void testEditingContactPhoneNumberWithPhonebookLocked() {
        phonebook.lockPhonebook();

        assertThrows(IllegalArgumentException.class, () -> phonebook.editPhoneNumberOfSelectedContact(0, "07045674932"));
    }
}
