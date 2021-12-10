package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss{
    public Exception(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Exception";
    }

    @Override
    public String message() {
        return "Levaste 2 balas nos canivetes wi";
    }

    @Override
    public void react() {

    }
}
