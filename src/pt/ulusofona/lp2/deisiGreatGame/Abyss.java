package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends BoardApps {

    public Abyss(int posicao) {
        super(posicao);
    }

    public abstract String message();

    public abstract void react();
}

