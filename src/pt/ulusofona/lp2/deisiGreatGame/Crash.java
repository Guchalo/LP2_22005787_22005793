package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abyss{
    public Crash(int posicao) {
        super(posicao);
        id = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "crash.png";
    }

    @Override
    public String message() {
        return "Wi foste de cana, volta pro inicio";
    }

    @Override
    public void react() {

    }
}
