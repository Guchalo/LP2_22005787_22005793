package pt.ulusofona.lp2.deisiGreatGame;

public class ExceptionHandling extends Tool{

    public ExceptionHandling(int posicao) {
        super(posicao);
        id = 3;
        titulo = "Tratamento de Excepções";
        imagem = "catch.png";
    }

    @Override
    public String message() {
        return "Apanhaste um colete á prova di tiru e imunidade á ressaca";
    }

    @Override
    public void react() {

    }

    @Override
    public void adicionarGM(GameManager p){

    }
}
