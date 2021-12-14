package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss{
    public Exception(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }



    @Override
    public String react(Programmer p) {
        p.recuar(2);
        return "Levaste uma cabeçada do Tanjiro e voltaste duas casas para trás";
    }
}
