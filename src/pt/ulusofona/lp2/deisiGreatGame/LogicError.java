package pt.ulusofona.lp2.deisiGreatGame;

public class LogicError extends Abyss {
    public LogicError(int posicao) {
        super(posicao);
        id = 1;
        titulo = "Erro de lógica";
        imagem = "logic.png";
    }

    @Override
    public String message() {
        return "Wi pipino di novo";
    }

    @Override
    public void react() {

    }
}
