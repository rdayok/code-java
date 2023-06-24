package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdDiaryTest {
    RdDiary rdDiary;

    @BeforeEach public void beforeEach(){
        rdDiary = new RdDiary("username", "password");
    }

    @Test public void testDiaryExist(){
        assertNotNull(rdDiary);
    }

    @Test public void testDiaryIsLockedByDefault(){
        assertTrue(rdDiary.isDiaryLocked());
    }

    @Test public void testUnlockingDiaryWithPassword(){
        rdDiary.unlockDiary("password");

        assertFalse(rdDiary.isDiaryLocked());
    }

    @Test public void testDiaryCanBeLocked(){
        rdDiary.unlockDiary( "password");
        assertFalse(rdDiary.isDiaryLocked());

        rdDiary.lockDiary();

        assertTrue(rdDiary.isDiaryLocked());
    }

    @Test public void testUnlockingDiaryWithWrongPassword(){
        assertThrows(IllegalArgumentException.class, () -> rdDiary.unlockDiary("pass"));
    }

    @Test public void testDiaryCanCreateEntry() throws IllegalAccessException {
        rdDiary.unlockDiary("password");

        rdDiary.createEntry("Title", "This is my entry body");

        Entry gottenEntry = rdDiary.findEntryBy_ID(1);
        String expectedEntry = gottenEntry.getEntry();
        assertEquals(expectedEntry, gottenEntry.getEntry());
    }

    @Test public void testDiaryCannotCreateEntryWhenLocked(){
        assertThrows(IllegalAccessException.class, () -> rdDiary.createEntry("Title", "This is my entry body"));
    }

    @Test public void testEntryCanBeUpdated() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");

        rdDiary.updateEntry(1, "Title", "This entry body was edited");

        Entry gottenEntry = rdDiary.findEntryBy_ID(1);
        String expectedEntry = gottenEntry.getEntry();
        assertEquals(expectedEntry, gottenEntry.getEntry());
    }

    @Test public void testDiaryCannotUpdateEntryWhenLocked() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");
        rdDiary.lockDiary();

        assertThrows(IllegalAccessException.class, () -> rdDiary.updateEntry(1, "Title", "This entry body was edited"));
    }

    @Test public void testEntryCanBeDeleted() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");
        rdDiary.deleteEntryBy_ID(1);

        assertThrows(IllegalArgumentException.class, () -> rdDiary.findEntryBy_ID(1));
    }

    @Test public void testDiaryCannotDeleteEntryWhenLocked() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");
        rdDiary.lockDiary();

        assertThrows(IllegalAccessException.class, () -> rdDiary.deleteEntryBy_ID(1));
    }

    @Test public void testEntryCannotBeSearchedWhenDiaryIsUnlocked() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");
        rdDiary.lockDiary();

        assertThrows(IllegalAccessException.class, () -> rdDiary.findEntryBy_ID(1));
    }

    @Test public void testSearchingEntryWithIDThatDoesNotExist() throws IllegalAccessException {
        rdDiary.unlockDiary("password");
        rdDiary.createEntry("Title", "This is my entry body");
        assertThrows(IllegalArgumentException.class, () -> rdDiary.findEntryBy_ID(2));
    }
}



