package pt.ulusofona.lp2.deisiGreatGame;

public class SyntaxError extends Abyss {
    public SyntaxError(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Erro de sintaxe";
        imagem = "syntax.png";
    }

    @Override
    public String message() {
        return "Olha o boda";
    }

    @Override
    public void react() {

    }
}
