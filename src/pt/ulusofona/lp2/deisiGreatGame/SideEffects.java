package pt.ulusofona.lp2.deisiGreatGame;

public class SideEffects extends Abyss{
    public SideEffects(int posicao) {
        super(posicao);
        id = 6;
        titulo = "Efeitos secundários";
        imagem = "muzan.png";
    }

    @Override
    public String message() {
        return "Deste de caras com o Muzan mas perdeste a oportunidade de o apanhar," +
                " por isso voltaste para onde estavas á 2 jogadas atrás";
    }

    @Override
    public void react(Programmer p) {

    }
}
