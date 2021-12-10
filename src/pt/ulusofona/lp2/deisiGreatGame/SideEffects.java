package pt.ulusofona.lp2.deisiGreatGame;

public class SideEffects extends Abyss{
    public SideEffects(int posicao) {
        super(posicao);
        id = 6;
        titulo = "Efeitos secundários";
    }

    @Override
    public String message() {
        return "Porra wi tou bem lavado ehehe";
    }

    @Override
    public void react() {

    }
}
