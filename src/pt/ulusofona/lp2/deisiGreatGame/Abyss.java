package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abyss extends BoardApps {
    GameManager manager;

    public Abyss(int posicao) {
        super(posicao);
        identificadorAT = "A";
    }

    public void adicionarGM(GameManager p){
        this.manager = p;
    }

    public abstract String message();

    public abstract void react();
}

