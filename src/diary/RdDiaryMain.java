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

        String menuSelection = takeStringInput(menuPrompt);
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
        String username = takeStringInput("Please enter a username: ");
        String password = takeStringInput("Please enter a password: ");
        rdDiary = new RdDiary(username, password);
        display("** Diary created successfully **");
        menuAfterCreatingDiary();
    }

    private static void menuAfterCreatingDiary() {
        String menuPrompt = """
                            DIARY MENU
                **********************************
                1 ->> Unlock diary to use.
                2 ->> Exit the diary application.
                """;

        String menuSelection = takeStringInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> unlockDiary();
            case '2' -> exitDiaryApplication();
            default -> menuAfterCreatingDiary();
        }
    }

    private static void unlockDiary() {
        display("** To unlock diary for use **");
        String password = takeStringInput("Please  enter your password: ");
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
                         ** ENTRY MENU **
                *********************************
                1 ->> To create an entry.
                2 ->> To edit and entry.
                3 ->> To delete an entry.
                4 ->> To find entry by ID.
                5 ->> To lock diary.
                6 ->> Exit the diary application.
                """;

        String menuSelection = takeStringInput(menuPrompt);
        switch (menuSelection.charAt(0)){
            case '1' -> createAnEntry();
            case '2' -> editAnEntry();
            case '3' -> deleteAnEntry();
            case '4' -> findAnEntryByID();
            case '5' -> lockDiary();
            case '6' -> exitDiaryApplication();
            default -> entryMenu();
        }
    }

    private static void findAnEntryByID() throws IllegalAccessException {
        int selectedEntryToFind = takeIntegerInput("Please ID of entry you want to view? ");
        try {
            Entry foundEntry = rdDiary.findEntryBy_ID(selectedEntryToFind);
            display(foundEntry.getEntry());
        } catch (IllegalAccessException exception) {
            display(exception.getMessage());
            entryMenu();
        }
    }

    private static void deleteAnEntry() throws IllegalAccessException {
        int selectedEntryToDelete = takeIntegerInput("Please what is the entry ID you want to delete? ");
        try {
            rdDiary.deleteEntryBy_ID(selectedEntryToDelete);
            display("** Entry deleted successfully **");
        } catch (IllegalArgumentException | IllegalAccessException exception) {
            display(exception.getMessage());
            entryMenu();
        }
    }

    private static void editAnEntry() throws IllegalAccessException {
        int selectedEntry = takeIntegerInput("Please what is the entry ID you want to edit? ");
        String entryTitle = takeStringInput("Please enter a new title: ");
        String entryBody = takeStringInput("Please enter a new entry body: ");
        try {
            rdDiary.updateEntry(selectedEntry, entryTitle, entryBody);
            display("** Entry edited successfully **");
        } catch (IllegalArgumentException | IllegalAccessException exception) {
            display(exception.getMessage());
            entryMenu();
        }
    }

    private static int takeIntegerInput(String prompt) {
        display(prompt);
        String errorMessage = "Your input is not valid. Please enter a number";
        try {
            return userInput.nextInt();
        }catch (InputMismatchException exception){
            display(errorMessage);
            userInput.next();
            return takeIntegerInput(prompt);
        }
    }

    private static void createAnEntry() throws IllegalAccessException {
        int ID  = rdDiary.generateID_forNewEntry();
        display("Entry ID: "+ ID);
        String entryTitle = takeStringInput("Title: ");
        String entryBody = takeStringInput("Entry Body: ");
        rdDiary.createEntry(entryTitle, entryBody);

        String menuPrompt = """
                     ** Entry successful **
                *********************************
                1 ->> To create another entry.
                2 ->> To go back to entry menu.
                3 ->> To lock diary.
                4 ->> Exit the diary application.
                """;
        String menuSelection = takeStringInput(menuPrompt);
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

    private static String takeStringInput(String menuPrompt) {
        display(menuPrompt);
        return userInput.next();
    }

    private static void display(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

}
