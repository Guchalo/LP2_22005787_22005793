package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenOfDeath extends Abyss {

    public BlueScreenOfDeath(int posicao) {
        super(posicao);
        id = 7;
        titulo = "Blue Screen of Death";
        imagem = "haganezuka.png";
    }

    public BlueScreenOfDeath(int posicao, int timesUsed) {
        super(posicao, timesUsed);
        id = 7;
        titulo = "Blue Screen of Death";
        imagem = "haganezuka.png";
    }

    @Override
    public String react(Programmer p) {
        p.derrotado();
        return "Perdeste a tua espada pela 2ª vez, Haganezuka não te perdoou e executou-te, acabou o jogo";
    }
}
