package pt.ulusofona.lp2.deisiGreatGame;

public class FunctionalProgramming extends Tool {

    public FunctionalProgramming(int posicao) {
        super(posicao);
        id = 1;
        titulo = "Programação Funcional";
        imagem = "respiracaoDoSol.png";
    }

    public FunctionalProgramming() {
        super();
        id = 1;
        titulo = "Programação Funcional";
        imagem = "respiracaoDoSol.png";
    }

    @Override
    public String react(Programmer p) {
        return "Agora que conseguiste dominar a Respiração total, já tens capacidade e poder " +
                "para enfrentar diversos perigos";
    }
}
