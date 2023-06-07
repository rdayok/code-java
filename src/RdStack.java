public class RdStack {

    private boolean isEmpty;
    private int elementCounter;
    private final int stackMemoryBlockSize;

    private final Object[] stackMemoryBlock;

    public RdStack(int stackMemoryBlockSize) {
        this.stackMemoryBlockSize = stackMemoryBlockSize;
        stackMemoryBlock = new Object[stackMemoryBlockSize];
    }

    public <T> void push(T element) {
        validateStackCapacity();
        stackMemoryBlock[elementCounter++] = element;
        tellStackIsEmptyOrNot();
    }

    public void pop() {
        elementCounter--;
        validateStackCapacity();
        tellStackIsEmptyOrNot();
    }

    private void tellStackIsEmptyOrNot() {
        isEmpty = elementCounter == 0;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return elementCounter == stackMemoryBlockSize;
    }

    public int size() {
        return elementCounter;
    }

    public Object peek() {
        int lastElementInStack = elementCounter - 1;
        return stackMemoryBlock[lastElementInStack];
    }

    private void validateStackCapacity() {
        boolean stackIsEmpty = elementCounter < 0;
        boolean stackIsFull = elementCounter > stackMemoryBlockSize;
        if (stackIsFull) throwArrayOutOfBoundException("Stack is full and you can't push");
        if (stackIsEmpty) throwArrayOutOfBoundException("Stack is Empty and you can't pop");
    }

    private void throwArrayOutOfBoundException(String message) throws IndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException(message);
    }
}
