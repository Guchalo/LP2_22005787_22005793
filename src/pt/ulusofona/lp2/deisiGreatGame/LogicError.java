package pt.ulusofona.lp2.deisiGreatGame;

public class LogicError extends Abyss {
    public LogicError(int posicao) {
        super(posicao);
        id = 1;
        titulo = "Erro de lógica";
        imagem = "bicho.png";
    }

    @Override
    public String message() {
        return "Deparaste-te com um demonio cujo o poder não consegues identificar, por isso " +
                "recuaste metade das casas que avançaste";
    }

    @Override
    public void react() {

    }
}
