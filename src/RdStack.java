import java.util.Arrays;

public class RdStack {

    private boolean isEmpty;
    private boolean isFull;
    private int elementCounter;
    private final int stackMemoryBlockSize;

    private final Object[] stackMemoryBlock;


    public RdStack(int stackMemoryBlockSize) {
        this.stackMemoryBlockSize = stackMemoryBlockSize;
        stackMemoryBlock = new Object[stackMemoryBlockSize];
    }

    public <T> void push(T element) {
        validateIfStackIsFull();
        stackMemoryBlock[elementCounter++] = element;
        tellIfStackIsFull();
        tellIfStackIsEmpty();
    }

    public void pop() {
        validateIfStackIsEmpty("Stack is Empty and you can't pop");
        elementCounter--;
        tellIfStackIsEmpty();
    }

    public Object peek() {
        validateIfStackIsEmpty("You can't peek an empty stack");
        int lastElementInStack = elementCounter - 1;
        return stackMemoryBlock[lastElementInStack];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return isFull;
    }

    public int size() {
        return elementCounter;
    }

    private void tellIfStackIsEmpty() {
        isEmpty = elementCounter == 0;
    }

    private void tellIfStackIsFull() {
        isFull = elementCounter == 5;
    }

    private void validateIfStackIsFull() {
        if(isFull) throwError("Stack is full and you can't push");
    }

    private void validateIfStackIsEmpty(String errorMessage) {
        if (isEmpty) throwError(errorMessage);
    }

    private void throwError(String message) throws Error{
        throw new Error(message);
    }
}
