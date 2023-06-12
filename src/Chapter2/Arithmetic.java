package Chapter2;
/*2.15 (Arithmetic) Write an application that asks the user to enter two integers,
obtains them from the user and prints the square of each, the sum of their squares,
and the difference of the squares (first number squared minus the second number squared).
Use the techniques shown in Fig. 2.7.*/

public class Arithmetic {
    private String result;
    public void squareRoots(int firstNumber, int secondNumber) {
        int firstNumberSquareRoot = firstNumber * firstNumber;
        int secondNumberSquareRoot = secondNumber * secondNumber;
        result = "Square root of first integer is : "+ firstNumberSquareRoot
                +" and for second integer is : "+ secondNumberSquareRoot;
    }

    public String getResult() {
        return result;
    }

    public void sumOfSquareRoots(int firstNumber, int secondNumber) {
        int sumOfSquareRoots = (firstNumber * firstNumber) + (secondNumber * secondNumber);
        result = "The sum of the square roots of the two integers is: "+ sumOfSquareRoots;
    }

    public void differenceOfSquareRoots(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber){
            int differenceOfSquareRoots = (firstNumber * firstNumber) - (secondNumber * secondNumber);
            result = "The difference of the square roots of the two integers is: "+ differenceOfSquareRoots;
        }else { errorPrompt();}
    }

    private void errorPrompt() {
        result = "You entered a second integer less than the first";
    }
}
