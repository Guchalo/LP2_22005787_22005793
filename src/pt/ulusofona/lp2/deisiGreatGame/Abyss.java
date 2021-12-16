package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends BoardApps {

    public Abyss(int posicao) {
        super(posicao);
        identificadorAT = "A";
    }

    public abstract String react(Programmer p);
}

