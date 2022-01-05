package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends BoardApps {

    private int timesUsed = 0;

    public Abyss(int posicao) {
        super(posicao);
        identificadorAT = "A";
    }

    public abstract String react(Programmer p);

    public int getTimesUsed() {
        return timesUsed;
    }

    public void aumentarTimesUsed(){
        timesUsed++;
    }

}

