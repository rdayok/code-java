package diary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RdDiaryMain {
    private static Scanner userInput = new Scanner(System.in);
    private static RdDiary rdDiary;
    public static void main(String[] args) {
        String welcomeMessage = """
                *****************************************************
                *****************************************************
                                    ** WELCOME **
                *****************************************************
                *****************************************************
                """;
        display(welcomeMessage);
        diaryMenu();
    }

    private static void diaryMenu() {
        String menuPrompt = """
                1 ->> To create your diary.
                2 ->> Exit the diary application.
                """;

        String menuSelection = takeUserInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> createA_diary();
            case '2' -> exitDiaryApplication();
            default -> diaryMenu();
        }
    }

    private static void exitDiaryApplication() {
        String goodbyeMessage = """
                *****************************************************
                *****************************************************
                                   ** GOOD BYE **
                *****************************************************
                *****************************************************
                """;
        display(goodbyeMessage);
        System.exit(0);
    }

    public static void createA_diary() {
        String username = takeUserInput("Please enter a username: ");
        String password = takeUserInput("Please enter a password: ");
        rdDiary = new RdDiary(username, password);
        display("** Diary created successfully **");
        menuAfterCreatingDiary();
    }

    private static void menuAfterCreatingDiary() {
        String menuPrompt = """
                1 ->> Unlock diary to use.
                2 ->> Exit the diary application.
                """;

        String menuSelection = takeUserInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> unlockDiary();
            case '2' -> exitDiaryApplication();
            default -> menuAfterCreatingDiary();
        }
    }

    private static void unlockDiary() {
        display("** To unlock diary for use **");
        String password = takeUserInput("Please  enter your password: ");
        try {
            rdDiary.unlockDiary(password);
            display("** Diary successfully unlocked **");
            entryMenu();
        }catch (IllegalArgumentException | IllegalAccessException exception){
            display(exception.getMessage());
            menuAfterCreatingDiary();
        }
    }

    private static void entryMenu() throws IllegalAccessException {
        String menuPrompt = """
                         ** Entry Menu **
                *********************************
                1 ->> To create an entry.
                2 ->> To edit and entry.
                3 ->> To delete an entry.
                4 ->> To find entry by ID.
                5 ->> To lock diary.
                6 ->> Exit the diary application.
                """;

        String menuSelection = takeUserInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> createAnEntry();
            case '2' -> editAnEntry();
            case '3' -> deleteAnEntry();
            case '4' -> findAnEntry();
            case '5' -> lockDiary();
            case '6' -> exitDiaryApplication();
            default -> entryMenu();
        }
    }

    private static void findAnEntry() throws IllegalAccessException {
        String selectedEntryToEdit = takeUserInput("Please ID of entry you want to view? ");
        validateInputForSelection(selectedEntryToEdit);
        int entryID = Integer.parseInt(selectedEntryToEdit);

        try {
            Entry foundEntry = rdDiary.findEntryBy_ID(entryID);
            display(foundEntry.getEntry());
        } catch (IllegalAccessException exception) {
            display(exception.getMessage());
            entryMenu();
        }
    }

    private static void deleteAnEntry() throws IllegalAccessException {
        String selectedEntryToEdit = takeUserInput("Please what is the entry ID you want to delete? ");
        validateInputForSelection(selectedEntryToEdit);
        int entryID = Integer.parseInt(selectedEntryToEdit);
        try {
            rdDiary.deleteEntryBy_ID(entryID);
            display("** Entry deleted successfully **");
        } catch (IllegalArgumentException | IllegalAccessException exception) {
            display(exception.getMessage());
            entryMenu();
        }
    }

    private static void editAnEntry()  {
//        String selectedEntryToEdit = takeUserInput("Please what is the entry ID you want to edit? ");
//        validateInputForSelection(selectedEntryToEdit);
        int inpp = takeIntegerInput("Please what is the entry ID you want to edit? ");
//        int entryID = Integer.parseInt(selectedEntryToEdit);

        String entryTitle = takeUserInput("Please enter a new title: ");
        String entryBody = takeUserInput("Enter the entry body: ");
//        try {
////            rdDiary.updateEntry(entryID, entryTitle, entryBody);
//            display("** Entry edited successfully **");
//        } catch (IllegalArgumentException exception) {
//            display(exception.getMessage());
//
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static int takeIntegerInput(String s) {
        try {
            return userInput.nextInt();
        }catch (InputMismatchException e){
            display("Please enter number ");
            userInput.nextLine();
            return takeIntegerInput(s);
        }
    }

    private static void validateInputForSelection(String selectedEntryToEdit) {
        try {
            Integer.parseInt(selectedEntryToEdit);
        }catch(IllegalArgumentException exception){
            display("** Please enter a number **");
        }
    }

    private static void createAnEntry() throws IllegalAccessException {
        int ID  = rdDiary.generateID_forNewEntry();
        display("Entry ID: "+ ID);
        String entryTitle = takeUserInput("Title: ");
        String entryBody = takeUserInput("Entry Body: ");
        rdDiary.createEntry(entryTitle, entryBody);

        String menuPrompt = """
                     ** Entry successful **
                *********************************
                1 ->> To create another entry.
                2 ->> To go back to entry menu.
                3 ->> To lock diary.
                4 ->> Exit the diary application.
                """;
        String menuSelection = takeUserInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> createAnEntry();
            case '2' -> {entryMenu();}
            case '3' -> lockDiary();
            case '4' -> exitDiaryApplication();
            default -> entryMenu();

        }
    }

    private static void lockDiary() {
        rdDiary.lockDiary();
        display("** Diary is locked successfully **");
        menuAfterCreatingDiary();
    }

    private static String takeUserInput(String menuPrompt) {
        display(menuPrompt);
        return userInput.nextLine();
    }

    private static void display(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

}
