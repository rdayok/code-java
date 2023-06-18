package play;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryAndCatch {
    static Scanner input = new Scanner (System.in);
    public static void main(String[] args) {
        myMethod();
    }

    private static void myMethod() {
        String promptMessage = "please enter a number";
        int number = myTyAndCatch(promptMessage);
        System.out.println("this cycle is now complete and your number is now "+ number );
    }

    private static int myTyAndCatch(String promptMessage) {
        try {
            System.out.println(promptMessage);
            return input.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            input.nextLine();
            return myTyAndCatch(promptMessage);
        }
    }
}
