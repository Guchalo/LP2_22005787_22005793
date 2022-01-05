package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends BoardApps {

    private int timesUsed;

    public Abyss(int posicao) {
        super(posicao);
        identificadorAT = "A";
    }

    public Abyss(int posicao, int timesUsed) {
        super(posicao);
        identificadorAT = "A";
        this.timesUsed = timesUsed;
    }

    public abstract String react(Programmer p);

    public int getTimesUsed() {
        return timesUsed;
    }

    public void aumentarTimesUsed(){
        timesUsed++;
    }

}

