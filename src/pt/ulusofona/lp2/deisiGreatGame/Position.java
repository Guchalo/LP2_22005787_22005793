package pt.ulusofona.lp2.deisiGreatGame;

public class Position {

    private final int numPosition;
    private int nrFootSteps = 0;
    private Abyss abyss;

    public Position(int numPosition) {
        this.numPosition = numPosition;
    }

    public int getNumPosition() {
        return numPosition;
    }

    public int getNrFootSteps() {
        return nrFootSteps;
    }

    public void setAbyss(Abyss abyss) {
        this.abyss = abyss;
    }

    public void increaseFootSteps(){
        nrFootSteps++;
    }

    @Override
    public String toString() {
        return "Position{" +
                "numPosition=" + numPosition +
                ", nrFootSteps=" + nrFootSteps +
                '}';
    }
}
