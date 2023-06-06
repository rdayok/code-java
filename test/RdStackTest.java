import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdStackTest {
     RdStack rdStack;
    @BeforeEach public void beforeEach(){
        rdStack = new RdStack(5);
    }

    @Test public void testStackExist(){
        Assertions.assertNotNull(rdStack);
    }

    @Test public void testStackIsEmpty(){
        assertTrue(rdStack.isEmpty());
    }

    @Test public void testStackIsNotEmptyAfterPushingX(){
        rdStack.push("element");

        assertFalse(rdStack.isEmpty());
    }
}
