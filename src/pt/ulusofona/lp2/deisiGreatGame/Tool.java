package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Tool extends BoardApps {

    public Tool(int posicao) {
        super(posicao);
        identificadorAT = "T";
    }

    public abstract String react(Programmer p);

}
