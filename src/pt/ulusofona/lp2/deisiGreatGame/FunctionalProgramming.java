package pt.ulusofona.lp2.deisiGreatGame;

public class FunctionalProgramming extends Tool{

    public FunctionalProgramming(int posicao) {
        super(posicao);
        id = 1;
        titulo = "Programação Funcional";
        imagem = "respiracaoDoSol.png";
    }

    @Override
    public String message() {
        return "Agora que conseguiste dominar a Respiração total, já tens capacidade e poder " +
                "para enfrentar diversos perigos";
    }

    @Override
    public void react() {

    }
    @Override
    public void adicionarGM(GameManager p){

    }
}
