package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abyss{
    public FileNotFoundException(int posicao) {
        super(posicao);
        id = 3;
        titulo = "File Not Found Exception";
        imagem = "JAVALI.png";
    }

    @Override
    public String message() {
        return "Deste de cara com um humano com cara de Javali e recuaste 3 casas";
    }

    @Override
    public void react(Programmer p) {
        p.recuar(3);
    }
}
