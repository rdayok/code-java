package StudentGrade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    GradeBook rdGradeBook;
    double[][] gradeTable;
    int subjectOne = 0;
    int subjectTwo  = 1;
    int subjectThree = 2;

    @BeforeEach
    void beforeEach(){
            rdGradeBook = new GradeBook(4, 3);
        gradeTable = new double[][]{{67, 21, 49, 137, 45.67, 4}, {98, 62, 56, 216, 72.00, 2}, {93, 34, 27, 154, 51.33, 3}, {78, 83, 66, 227, 75.67, 1}};
        rdGradeBook.setGradeBook(gradeTable);
    }
    @Test
    void testGradeBookExist(){
        assertNotNull(rdGradeBook);
    }

    @Test
    void gradeBookTableDimensionShouldBeNumberOfStudentByNumberOfSubjectsPlusThree(){
        rdGradeBook = new GradeBook(4, 3);
        double[][] expectedTable = new double[4][6];

        assertArrayEquals(expectedTable, rdGradeBook.getGradeBook());
    }

    @Test
    void gradeBookTableDimensionIfNumberOfStudentsAndSubjectsChange(){
        rdGradeBook = new GradeBook(2, 2);
        double[][] expectedTable = new double[2][5];

        assertArrayEquals(expectedTable, rdGradeBook.getGradeBook());
    }

    @Test
    void whenGradeBookIsCreated_gradeBookShouldNotBeNull(){
        assertEquals(4, rdGradeBook.getNumberOfStudents());
    }

    @Test
    void givenFiveNumberOfStudents_whenNumberOfStudentsIsChecked_shouldBeEqualsFive(){
        GradeBook rdGradeBook = new GradeBook(5, 3);
        assertEquals(5, rdGradeBook.getNumberOfStudents());
    }

    @Test
    void givenThreeNumberOfSubjects_whenNumberOfSubjectsIsChecked_shouldBeEqualsThree(){
        assertEquals(3, rdGradeBook.getNumberOfSubjects());
    }

    @Test
    void givenFiveNumberOfSubjects_whenNumberOfSubjectsIsChecked_shouldBeFive(){
        GradeBook rdGradeBook = new GradeBook(4, 4);
        assertEquals(4, rdGradeBook.getNumberOfSubjects());
    }

    @Test
    void givenAGradeBook_gradeCanBeInputtedTest(){
        rdGradeBook = new GradeBook(4, 3);
        int studentOne = 0;
        int grade = 50;
        double[][] expectedTable = new double[4][6];
        expectedTable[studentOne][subjectOne] = grade;

        rdGradeBook.takeGradeInput(studentOne, subjectOne, grade);

        assertArrayEquals(expectedTable, rdGradeBook.getGradeBook());
    }

    @Test
    void givenAGradeBook_gradeCanBeInputtedTestTwo(){
        rdGradeBook = new GradeBook(2, 2);
        int studentTwo = 1;
        int grade = 70;
        double[][] expectedTable = new double[2][5];
        expectedTable[studentTwo][subjectTwo] = grade;

        rdGradeBook.takeGradeInput(studentTwo, subjectTwo, grade);

        assertArrayEquals(expectedTable, rdGradeBook.getGradeBook());
    }

    @Test
    void givenGradeLessThanZero_gradeInputShouldThrowIllegalArgumentException(){
        int studentTwo = 1;
        int grade = -5;
        assertThrows(IllegalArgumentException.class, () -> rdGradeBook.takeGradeInput(studentTwo, subjectOne, grade));
        try{
            rdGradeBook.takeGradeInput(studentTwo, subjectOne, grade);
        }catch (Exception exception){
            assertEquals("You entered an invalid grade", exception.getMessage());
            assertEquals(IllegalArgumentException.class, exception.getClass());
        }
    }

    @Test
    void givenGradeGreaterThanHundred_gradeInputShouldThrowIllegalArgumentException(){
        int studentTwo = 1;
        int grade = 111;
        assertThrows(IllegalArgumentException.class, () -> rdGradeBook.takeGradeInput(studentTwo, subjectOne, grade));
        try{
            rdGradeBook.takeGradeInput(studentTwo, subjectOne, grade);
        }catch (Exception exception){
            assertEquals("You entered an invalid grade", exception.getMessage());
            assertEquals(IllegalArgumentException.class, exception.getClass());
        }
    }

    @Test
    void givenATableOfGrades_gradeBookShouldReturnTableWithTotalForEachStudent(){
        double[][] givenGradeTable = {{67, 21, 49, 0, 0, 0}, {98, 62, 56, 0, 0, 0}, {93, 34, 27, 0, 0, 0}, {78, 83, 66, 0, 0, 0}};
        rdGradeBook.setGradeBook(givenGradeTable);
        double[][] expectedTableWithTotalForEachStudent = {{67, 21, 49, 137, 0, 0}, {98, 62, 56, 216, 0, 0}, {93, 34, 27, 154, 0, 0}, {78, 83, 66, 227, 0, 0}};

        rdGradeBook.calculateTotalScoreForEachStudent();

        assertArrayEquals(expectedTableWithTotalForEachStudent, rdGradeBook.getGradeBook());
    }

    @Test
    void givenTableOfGradesWithTotalForEachStudent_whenGradeBookCalculatesAverage_tableShouldUpdateWithAverageForEachStudent(){
        double[][] givenGradeTable = {{67, 21, 49, 137, 0, 0}, {98, 62, 56, 216, 0, 0}, {93, 34, 27, 154, 0, 0}, {78, 83, 66, 227, 0, 0}};
        rdGradeBook.setGradeBook(givenGradeTable);
        double[][] expectedTableWithTotalForEachStudent = {{67, 21, 49, 137, 45.67, 0}, {98, 62, 56, 216, 72.00, 0}, {93, 34, 27, 154, 51.33, 0}, {78, 83, 66, 227, 75.67, 0}};

        rdGradeBook.calculateAverageForEachStudent();

        assertArrayEquals(expectedTableWithTotalForEachStudent, rdGradeBook.getGradeBook());
    }

    @Test
    void givenTableOfGradesWithTotalScoreAndAverages_whenGradeBookCalculateStudentPositions_tableShouldUpdateWithStudentsPositions(){
        double[][] givenGradeTable = {{67, 21, 49, 137, 45.67, 0}, {98, 62, 56, 216, 72.00, 0}, {93, 34, 27, 154, 51.33, 0}, {78, 83, 66, 227, 75.67, 0}};
        rdGradeBook.setGradeBook(givenGradeTable);
        double[][] expectedTableWithTotalForEachStudent = {{67, 21, 49, 137, 45.67, 4}, {98, 62, 56, 216, 72.00, 2}, {93, 34, 27, 154, 51.33, 3}, {78, 83, 66, 227, 75.67, 1}};

        rdGradeBook.calculateStudentsPositions();

        assertArrayEquals(expectedTableWithTotalForEachStudent, rdGradeBook.getGradeBook());
    }

    @Test
    void givenTableOfGrades_calculateHighestScoreInSubjectOne_returnsTheHighestScore(){
        int highestScoreInSubjectOne = 98;

         assertEquals(highestScoreInSubjectOne, rdGradeBook.calculateHighestScoreInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateHighestScoreInSubjectTwo_returnsTheHighestScore(){
        int highestScoreInSubjectTwo = 83;

        assertEquals(highestScoreInSubjectTwo, rdGradeBook.calculateHighestScoreInASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_calculateLowestScoreInSubjectOne_returnsTheLowestScore(){
        int lowestScoreInSubjectOne = 67;

        assertEquals(lowestScoreInSubjectOne, rdGradeBook.calculateLowestScoreInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateLowestScoreInSubjectTwo_returnsTheLowestScore(){
        int lowestScoreInSubjectTwo = 21;

        assertEquals(lowestScoreInSubjectTwo, rdGradeBook.calculateLowestScoreInASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_findTheStudentThatScoredTheHighestGradeInSubjectOne(){
        int secondStudent = 2;

        assertEquals(secondStudent, rdGradeBook.findTheStudentWithTheHighestScoreInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_findTheStudentThatScoredTheHighestGradeInSubjectTwo(){
        int fourthStudent = 4;

        assertEquals(fourthStudent, rdGradeBook.findTheStudentWithTheHighestScoreInASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_findTheStudentThatScoredTheLowestGradeInSubjectOne(){
        int firstStudent = 1;

        assertEquals(firstStudent, rdGradeBook.findTheStudentWithTheLowestScoreInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_findTheStudentThatScoredTheLowestGradeInSubjectTwo(){
        int thirdStudent = 3;

        assertEquals(thirdStudent, rdGradeBook.findTheStudentWithTheLowestScoreInASubject(subjectThree));
    }

    @Test
    void givenTableOfGrades_calculateTheTotalScoreOfASubjectOne(){
        int totalOfSubjectScore = 336;

        assertEquals(totalOfSubjectScore, rdGradeBook.calculateTheTotalGradeOfASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateTheTotalScoreOfASubjectTwo(){
        int totalOfSubjectScore = 200;

        assertEquals(totalOfSubjectScore, rdGradeBook.calculateTheTotalGradeOfASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_calculateTheAverageOfTotalScoreOfASubjectOne(){
        int averageOfSubjectScores = 84;

        assertEquals(averageOfSubjectScores, rdGradeBook.calculateTheAverageOfTotalGradeOfASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateTheAverageOfTotalScoreOfASubjectTwo(){
        int averageOfSubjectScores = 50;

        assertEquals(averageOfSubjectScores, rdGradeBook.calculateTheAverageOfTotalGradeOfASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_calculateTheNumberOfPassesOfASubjectOne(){
        int numberOfPassesInSubjectOne = 4;

        assertEquals(numberOfPassesInSubjectOne, rdGradeBook.calculateTheNumberOfPassesInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateTheNumberOfPassesOfASubjectTwo(){
        int numberOfPassesInSubjectTwo = 2;

        assertEquals(numberOfPassesInSubjectTwo, rdGradeBook.calculateTheNumberOfPassesInASubject(subjectTwo));
    }

    @Test
    void givenTableOfGrades_calculateTheNumberOfFailsOfASubjectOne(){
        int numberOfFailsInSubjectOne = 0;

        assertEquals(numberOfFailsInSubjectOne, rdGradeBook.calculateTheNumberOfFailsInASubject(subjectOne));
    }

    @Test
    void givenTableOfGrades_calculateTheNumberOfFailsOfASubjectTwo(){
        int numberOfFailsInSubjectTwo = 2;

        assertEquals(numberOfFailsInSubjectTwo, rdGradeBook.calculateTheNumberOfFailsInASubject(subjectTwo));
    }



}

