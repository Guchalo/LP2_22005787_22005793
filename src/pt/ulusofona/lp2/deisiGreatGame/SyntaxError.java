package pt.ulusofona.lp2.deisiGreatGame;

public class SyntaxError extends Abyss {
    public SyntaxError(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Erro de sintaxe";
    }

    @Override
    public String message() {
        return null;
    }

    @Override
    public void react() {

    }
}
