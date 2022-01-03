package pt.ulusofona.lp2.deisiGreatGame;

public class Position {

    private int numPosition;
    private int nrFootSteps = 1;

    public Position(int numPosition) {
        this.numPosition = numPosition;
    }

    public int getNumPosition() {
        return numPosition;
    }

    public int getNrFootSteps() {
        return nrFootSteps;
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
