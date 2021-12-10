package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Tool extends BoardApps {

    public Tool(int posicao) {
        super(posicao);
    }

    public abstract String message();

    public abstract void react();

}
