package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Tool{

    public IDE(int posicao) {
        super(posicao);
        id = 4;
        titulo = "IDE";
        imagem = "IDE.png";
    }

    @Override
    public String message() {
        return "Ganhaste acesso temporario ao WiTraficante.com";
    }

    @Override
    public void react() {

    }

    @Override
    public void adicionarGM(GameManager p){

    }
}
