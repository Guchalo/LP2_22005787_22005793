package pt.ulusofona.lp2.deisiGreatGame;

public class InfiniteCicle extends Abyss{
    public InfiniteCicle(int posicao) {
        super(posicao);
        id = 8;
        titulo = "Ciclo infinito";
    }

    @Override
    public String message() {
        return "Foste preso wi, tens o direito de permanecer calado e quieto até o teu tropa chegar";
    }

    @Override
    public void react() {

    }
}
