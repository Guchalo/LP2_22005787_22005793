package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Abyss{
    public DuplicatedCode(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Duplicated Code";
        imagem = "zenitsu.png";
    }

    @Override
    public String message() {
        return "Viste um demonio que estava completamente fora do teu alcance, acobardaste-te e voltas-te para trás";
    }

    @Override
    public void react() {

    }
}
