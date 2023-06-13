package PersonAndProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProblemTest {

    Problem problem;

    @Test public void testProblemExist(){
        problem = new Problem("Provision", Type.FINANCIAL);
        assertNotNull(problem);
    }

    @Test public void testProblemCanBeCreatedKnowingJustItsNameAndType(){
        problem = new Problem("Provision", Type.FINANCIAL);
        assertEquals("Provision of type FINANCIAL", problem.toString());
    }

    @Test public void testProblemCanBeCreatedKnowingJustItsNameAndType2(){
        problem = new Problem("Village people", Type.SPIRITUAL);
        assertEquals("Village people of type SPIRITUAL", problem.toString());
    }

    @Test public void testProblemCanBeCreatedKnowingJustItsNameAndType3(){
        problem = new Problem("Tuition", Type.EDUCATION);
        assertEquals("Tuition of type EDUCATION", problem.toString());
    }

    @Test public void testProblemCanBeCreatedKnowingJustItsNameAndType4(){
        problem = new Problem("Capital", Type.BUSINESS);
        assertEquals("Capital of type BUSINESS", problem.toString());
    }

    @Test public void testProblemCanBeCreatedKnowingJustItsNameAndType5(){
        problem = new Problem("Network connectivity", Type.TECHNICAL);
        assertEquals("Network connectivity of type TECHNICAL", problem.toString());
    }

}

