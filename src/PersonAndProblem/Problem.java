package PersonAndProblem;

public class Problem {
    private String name;
    private Type problemType;

    public Problem(String name, Type problemType) {
        this.name = name;
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        return name +" of type "+ problemType;
    }
}
