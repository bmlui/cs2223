public class Stones {
    private int numStones;
    private String name;
    public Stones (int i, String n) {
        this.numStones = i;
        this.name =n;
    }
    public int getNumStones() {
        return this.numStones;
    }
    public void subNumStones(int i) throws InvalidInputException{
        if ((i > numStones) | i == 0) {
            throw new InvalidInputException();
        }
        this.numStones = this.numStones-i;
    }

    public String getName() {
        return this.name;
    }
}
