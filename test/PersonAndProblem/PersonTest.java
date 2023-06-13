package PersonAndProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {
    Person person;
    @BeforeEach public void beforeEach(){
        person = new Person();
    }

    @Test public void testPersonClassExist(){
        assertNotNull(person);
    }

    @Test public void testPersonCanAddToThereProblem(){
        person.addProblem("babe hair", Type.FINANCIAL);
    }
}
