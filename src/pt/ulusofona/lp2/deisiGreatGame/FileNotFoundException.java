package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abyss{
    public FileNotFoundException(int posicao) {
        super(posicao);
        id = 3;
        titulo = "File Not Found Exception";
        imagem = "file-not-found-exception.png";
    }

    @Override
    public String message() {
        return "Wi te banharam";
    }

    @Override
    public void react() {

    }
}
