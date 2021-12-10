package pt.ulusofona.lp2.deisiGreatGame;

public class UnityTests extends Tool{

    public UnityTests(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Testes unitários";
    }

    @Override
    public String message() {
        return "Ganhaste imunidade a todos os testes de substancias ilicitas";
    }

    @Override
    public void react() {

    }

}
