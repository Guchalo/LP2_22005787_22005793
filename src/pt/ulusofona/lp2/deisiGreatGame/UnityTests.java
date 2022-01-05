package pt.ulusofona.lp2.deisiGreatGame;

public class UnityTests extends Tool {

    public UnityTests(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Testes unitários";
        imagem = "nezuko.png";
    }

    public UnityTests() {
        super();
        id = 2;
        titulo = "Testes unitários";
        imagem = "nezuko.png";
    }

    @Override
    public String react(Programmer p) {
        return "A Nezuko saiu da caixa para te ajudar na luta";
    }


}
