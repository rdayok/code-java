package StudentGrade;

public class GradeBook {
    private int numberOfStudents;
    private int numberOfSubjects;
    private double[][] gradeBook;
    private final int ZERO = 0, ONE = 1, TWO = 2, THREE = 3, TEN = 10, HUNDRED = 100;

    public GradeBook(int numberOdStudents, int numberOfSubjects) {
        this.numberOfStudents = numberOdStudents;
        this.numberOfSubjects = numberOfSubjects;
        gradeBook = new double[numberOdStudents][numberOfSubjects + THREE];

    }


    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getNumberOfSubjects() {
        return numberOfSubjects;
    }

    public void takeGradeInput(int studentNumber,  int subjectNumber, int grade) {
        validateInputtedGrade(grade);
        gradeBook[studentNumber][subjectNumber] = grade;
    }

    private void validateInputtedGrade(int grade) {
        boolean gradeIsNotValid = grade < ZERO || grade > HUNDRED;
        if (gradeIsNotValid) throw new IllegalArgumentException("You entered an invalid grade");
    }

    public Object[] getGradeBook() {
        return gradeBook;
    }

    public void calculateTotalScoreForEachStudent() {
        for (int row = ZERO; row < numberOfStudents; row++){
            int totalScoreOfAllSubjectForAStudent = ZERO;
            for(int column = ZERO; column < numberOfSubjects; column++){
                totalScoreOfAllSubjectForAStudent += gradeBook[row][column];
            }
            gradeBook[row][numberOfSubjects] = totalScoreOfAllSubjectForAStudent;
        }
    }

    public void calculateAverageForEachStudent() {
        for(int student = ZERO; student < numberOfStudents; student++){
            double averageForEachStudent = (gradeBook[student][numberOfSubjects] / numberOfSubjects);
            double averageRoundedToTwoDecimalPlaces = (Math.round(averageForEachStudent * (Math.pow(TEN, TWO))) / Math.pow(TEN, TWO));
            gradeBook[student][numberOfSubjects + ONE] =  averageRoundedToTwoDecimalPlaces;
        }

    }

    public void calculateStudentsPositions() {
        double[] averagesOfAllStudents = new double[numberOfStudents];
        copyAveragesOfStudents(averagesOfAllStudents);
        arrangeAveragesInAscendingOrder(averagesOfAllStudents);
        assignStudentsPositions(averagesOfAllStudents);
    }

    private void assignStudentsPositions(double[] averagesOfAllStudents) {
        for(int index = 0; index < numberOfStudents; index++){
            for(int indexTwo = 0; indexTwo < numberOfStudents; indexTwo++){
                if(averagesOfAllStudents[index] == gradeBook[indexTwo][numberOfSubjects + ONE]){
                    gradeBook[indexTwo][numberOfSubjects + TWO] = index + ONE;
                    break;
                }
            }
        }
    }

    private void arrangeAveragesInAscendingOrder(double[] averagesOfAllStudents) {
        for (int index = 0; index < numberOfStudents; index++){
            for(int indexTwo = index + 1; indexTwo < numberOfStudents; indexTwo++){
                if( averagesOfAllStudents[index] < averagesOfAllStudents[indexTwo]){
                    double lesserAverage = averagesOfAllStudents[index];
                    averagesOfAllStudents[index] = averagesOfAllStudents[indexTwo];
                    averagesOfAllStudents[indexTwo] = lesserAverage;
                }
            }
        }
    }

    private void copyAveragesOfStudents(double[] averagesOfAllStudents) {
        for(int student = ZERO; student < numberOfStudents; student++){
            averagesOfAllStudents[student] = gradeBook[student][numberOfSubjects + ONE];
        }
    }

    public double calculateHighestScoreInASubject(int subject) {
        double highestScore = gradeBook[ZERO][subject];
        for(int index = ONE; index < numberOfStudents; index++ ){
           if(highestScore < gradeBook[index][subject]) highestScore = gradeBook[index][subject];
        }
        return highestScore;
    }

    public double calculateLowestScoreInASubject(int subject) {
        double LowestScore = gradeBook[ZERO][subject];
        for(int index = ONE; index < numberOfStudents; index++ ){
            if(LowestScore > gradeBook[index][subject]) LowestScore = gradeBook[index][subject];
        }
        return LowestScore;
    }

    public double findTheStudentWithTheHighestScoreInASubject(int subject) {
        double studentWithTheHighestScore = ONE;
        double highestScore = gradeBook[ZERO][subject];
        for ( int index = ONE; index < numberOfStudents; index++){
            boolean foundNewHighScore = highestScore < gradeBook[index][subject];
            if(foundNewHighScore){
                highestScore = gradeBook[index][subject];
                studentWithTheHighestScore = index + ONE;
            }
        }
        return studentWithTheHighestScore;
    }

    public double findTheStudentWithTheLowestScoreInASubject(int subject) {
        double studentWithTheLowestScore = ONE;
        double lowestScore = gradeBook[ZERO][subject];
        for ( int index = ONE; index < numberOfStudents; index++){
            boolean foundNewLowScore = lowestScore > gradeBook[index][subject];
            if(foundNewLowScore){
                lowestScore = gradeBook[index][subject];
                studentWithTheLowestScore = index + ONE;
            }
        }
        return studentWithTheLowestScore;
    }

    public double calculateTheTotalGradeOfASubject(int subject) {
        double totalScoreOfSubject = 0;
        for(int index = 0; index < numberOfStudents; index++){
            totalScoreOfSubject += gradeBook[index][subject];
        }
        return totalScoreOfSubject;
    }

    public double calculateTheAverageOfTotalGradeOfASubject(int subjectOne) {
        double totalScoreOfSubject = calculateTheTotalGradeOfASubject(subjectOne);
        return totalScoreOfSubject / numberOfStudents;
    }

    public int calculateTheNumberOfPassesInASubject(int subject) {
        int totalNumberOfPasses = 0;
        for (int index = 0; index < numberOfStudents; index++){
            if (gradeBook[index][subject] >= 50) totalNumberOfPasses += ONE;
        }
        return totalNumberOfPasses;
    }

    public int calculateTheNumberOfFailsInASubject(int subject) {
        return numberOfStudents - calculateTheNumberOfPassesInASubject(subject);
    }

    public void setGradeBook(double[][] gradeTable) {
        this.gradeBook = gradeTable;
    }
}
