package pt.ulusofona.lp2.deisiGreatGame;

public class Heritage extends Tool {

    public Heritage(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Herança";
        imagem = "inEze.png";
    }


    @Override
    public String message() {
        return "Zenitsu e Inosuke juntam se a ti para a proxima batalha";
    }

    @Override
    public void react(Programmer p) {

    }


}
