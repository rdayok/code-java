package diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RdDiary {
    private static int entryID;
    private Boolean isDiaryLocked = true;
    private String username;
    private String password;
    private List<Entry> listOfEntries = new ArrayList<>();

    public RdDiary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isDiaryLocked() {
        return isDiaryLocked;
    }

    public void unlockDiary( String password) {
        validatePassword(password);
        isDiaryLocked = false;
    }

    public void lockDiary() {
        isDiaryLocked = true;
    }

    private void validatePassword(String password) {
        boolean isPasswordWrong = !Objects.equals(password, this.password);
        if(isPasswordWrong) throwIllegalArgumentException("** Entered password is wrong **");
    }

    public void createEntry(String title, String thisIsMyEntryBody) throws IllegalAccessException {
        validateDiaryAccess();
        Entry entry = new Entry(generateID_forNewEntry(), title, thisIsMyEntryBody);
        listOfEntries.add(entry);
    }

    private void validateDiaryAccess() throws IllegalAccessException {
        if(isDiaryLocked) throw new IllegalAccessException("** You dont have access to this diary ** ");
    }

    public int generateID_forNewEntry() {
        return entryID = listOfEntries.size() + 1;
    }

    public Entry findEntryBy_ID(int entryID) throws IllegalAccessException {
        validateDiaryAccess();
        for (Entry entry : listOfEntries){
            if (entryID == entry.getID()) return entry;
        }
        throwIllegalArgumentException("This entry does not exist");
        return null;
    }

    public void updateEntry(int entryID, String title, String editedEntryBody) throws IllegalAccessException {
        Entry foundEntry = findEntryBy_ID(entryID);
        foundEntry.updateEntry(title, editedEntryBody);
    }

    public void deleteEntryBy_ID(int entryID) throws IllegalAccessException {
        Entry foundEntry = findEntryBy_ID(entryID);
        listOfEntries.remove(foundEntry);
    }

    public String getDiaryUsername() {
        return username;
    }

    private void throwIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
