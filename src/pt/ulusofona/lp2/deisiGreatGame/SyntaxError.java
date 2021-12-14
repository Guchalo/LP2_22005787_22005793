package pt.ulusofona.lp2.deisiGreatGame;

public class SyntaxError extends Abyss {
    public SyntaxError(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Erro de sintaxe";
        imagem = "armadilha.png";
    }

    @Override
    public String message() {
        return "Caiste numa das armadilhas do Urokodaki, recuas 1 casa";
    }

    @Override
    public void react(Programmer p) {
        p.recuar(1);
    }
}
