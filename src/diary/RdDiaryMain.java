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
        }catch (IllegalArgumentException exception){
            display(exception.getMessage());
            menuAfterCreatingDiary();
            entryMenu();
        }
    }

    private static void entryMenu() {
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

    private static void editAnEntry() {
        String selectedEntryToEdit = takeUserInput("Please what is the entry ID you want to edit? ");
        int entryID = convertStringToInt(selectedEntryToEdit);
    }

    private static int convertStringToInt(String selectedEntryToEdit) {
        try {
            return Character.getNumericValue(selectedEntryToEdit.charAt(0));
        }catch(InputMismatchException exception){
            display("** Please enter a number **");
            userInput.nextLine();
            return convertStringToInt(selectedEntryToEdit);
        }
    }

    private static void createAnEntry() {
        int ID  = rdDiary.generateID_forNewEntry();
        display("Entry ID: "+ ID);
        String entryTitle = takeUserInput("Title: ");
        String entryBody = takeUserInput("Entry Body: ");
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
        return userInput.next();
    }

    private static void display(String welcomeMessage) {
        System.out.println(welcomeMessage);
    }

}
