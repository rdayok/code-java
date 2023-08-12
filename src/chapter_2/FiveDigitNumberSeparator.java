package chapter_2;

public class FiveDigitNumberSeparator {
    private boolean isFiveDigits;
    private String separatedDigits = "";

    public void separateDigits(int fiveDigitNumber) {
        isFiveDigits(fiveDigitNumber);
        if(isFiveDigits){
            int digit, startValue = 1, endValue = 5, ten = 10;
            for(int count = startValue; count <= endValue; count++){
                digit = fiveDigitNumber % ten;
                fiveDigitNumber /= ten;
                concatenateDigitsWithSpace(digit, count);
            }
        }
        reverseSeparatedDigits(separatedDigits);
    }

    private void concatenateDigitsWithSpace(int digit, int counter) {
        int fifthInteger = 5;
        if (counter == fifthInteger) separatedDigits += digit;
        else {separatedDigits += digit +"   ";}
    }

    private void reverseSeparatedDigits(String separatedDigits) {
        StringBuilder reverseDigitObject = new StringBuilder(separatedDigits);
        this.separatedDigits = reverseDigitObject.reverse().toString();
    }

    private void isFiveDigits(int fiveDigitNumber) {
        if (fiveDigitNumber >= 10_000 && fiveDigitNumber < 100_000) isFiveDigits = true;
        else errorPrompt();
    }

    private void errorPrompt() {
        System.out.println("Please enter a five digit number");
    }

    public String getSeparatedDigits() {
        return separatedDigits;
    }
}

