package pt.ulusofona.lp2.deisiGreatGame;

public class UnityTests extends Tool{

    public UnityTests(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Testes unitários";
        imagem = "nezuko.png";
    }

    @Override
    public String message() {
        return "A Nezuko saiu da caixa para te ajudar na luta ";
    }

    @Override
    public void react(Programmer p) {

    }


}
