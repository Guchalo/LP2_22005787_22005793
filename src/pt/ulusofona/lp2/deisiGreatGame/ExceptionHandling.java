package pt.ulusofona.lp2.deisiGreatGame;

public class ExceptionHandling extends Tool{

    public ExceptionHandling(int posicao) {
        super(posicao);
        id = 3;
        titulo = "Tratamento de Excepções";
        imagem = "mister.png";
    }

    @Override
    public String message() {
        return "Treinaste durante 2 anos com o Urokodaki e melhoraste as tuas habilidades de caçador";
    }

    @Override
    public void react() {

    }

    @Override
    public void adicionarGM(GameManager p){

    }
}
