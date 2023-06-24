package diary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Entry {
    private final int ID;
    private String title;
    private String bodyOfEntry;
    private String dateAndTime;
    private LocalDateTime date = LocalDateTime.now();


    public Entry(int ID, String title, String bodyOfEntry) {
        this.ID = ID;
        this.title = title;
        this.bodyOfEntry = bodyOfEntry;
        this.dateAndTime = date.format(DateTimeFormatter.ofPattern("E, dd MMM yyy HH:mm:ss"));
    }

    public int getID() {
        return ID;
    }

    public String getEntry() {
        return String.format("""
                %s
                %s
                ********************************************************
                %S
                """, title, dateAndTime, bodyOfEntry);
    }

    public void updateEntry(String title, String editedEntryBody) {
        this.title = title;
        this.bodyOfEntry = editedEntryBody;
        this.dateAndTime = date.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss"));
    }
}
