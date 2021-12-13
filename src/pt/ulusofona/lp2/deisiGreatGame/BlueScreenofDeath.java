package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenofDeath extends Abyss{
    public BlueScreenofDeath(int posicao) {
        super(posicao);
        id = 7;
        titulo = "Blue Screen of Death";
        imagem = "haganezuka.png";
    }

    @Override
    public String message() {
        return "Perdeste a tua espada pela 2ª vez, Haganezuka não te perdoou e executou-te, acabou o jogo";
    }

    @Override
    public void react() {
        manager.moveCurrentPlayer(-1);
    }
}
