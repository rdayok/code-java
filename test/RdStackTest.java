import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RdStackTest {
     RdStack rdStack;
    @BeforeEach public void beforeEach(){
        rdStack = new RdStack(5);
        rdStack.push("retnaa");
    }

    @Test public void testStackExist(){
        assertNotNull(rdStack);
    }

    @Test public void testStackIsNotEmptyAfterAPush(){
        assertFalse(rdStack.isEmpty());
    }

    @Test public void testStackIsEmpty_whenIPopAfterPushingAnElement(){
        rdStack.pop();
        assertTrue(rdStack.isEmpty());
    }

    @Test public void testPushXYZ_stackShouldNotBeEmptyAfterPop(){
        rdStack.push("segun");
        rdStack.push("ebuka");

        rdStack.pop();

        assertFalse(rdStack.isEmpty());
    }

    @Test public void testStackIsFullAfterPushingElementsToStackCapacity(){
        rdStack.push("segun");
        rdStack.push("ebuka");
        rdStack.push("oyi");
        rdStack.push("ashlame");

        assertTrue(rdStack.isFull());
    }

    @Test public void testStackIsNotFullAfterPushingXY(){
        rdStack.push("segun");

        assertFalse(rdStack.isFull());
    }
    @Test public void testGettingStackSize(){
        assertEquals(1, rdStack.size());
    }

    @Test public void testStackSizeAfterPushingZY(){
        rdStack.push("segun");

        assertEquals(2, rdStack.size());
    }

    @Test public void testStackPeakMethodToSeeTheLastPushedElement(){
        assertEquals("retnaa", rdStack.peek());
    }

    @Test public void testPeakAfterPushingXYZ_elements(){
        rdStack.push("segun");
        rdStack.push("oyi");

        assertEquals("oyi", rdStack.peek());
    }

    @Test public void testPeakAfterAPop(){
        rdStack.push("segun");
        rdStack.push("oyi");

        rdStack.pop();

        assertEquals("segun", rdStack.peek());
    }

    @Test public void testPushingMoreThanStackMemoryBlockCanContain(){
        rdStack.push("segun");
        rdStack.push("oyi");
        rdStack.push("ebuka");
        rdStack.push("ashlame");

        assertThrows(IndexOutOfBoundsException.class, () -> rdStack.push("dayok"));
    }

    @Test public void testPopWhenStackIsEmpty(){
        rdStack.pop();
        assertThrows(IndexOutOfBoundsException.class, () -> rdStack.pop());
    }

}
