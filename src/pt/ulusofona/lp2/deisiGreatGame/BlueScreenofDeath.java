package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenofDeath extends Abyss{
    public BlueScreenofDeath(int posicao) {
        super(posicao);
        id = 7;
        titulo = "Blue Screen of Death";
    }

    @Override
    public String message() {
        return "Foste ao Cacém e perdeste tudo...";
    }

    @Override
    public void react() {

    }
}
