package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss{
    public Exception(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }

    @Override
    public String message() {
        return "Levaste uma cabeçada do Tanjiro e voltaste duas casas para trás";
    }

    @Override
    public void react(Programmer p) {

    }
}
