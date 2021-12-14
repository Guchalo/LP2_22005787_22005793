package pt.ulusofona.lp2.deisiGreatGame;

public class InfiniteCicle extends Abyss{
    public InfiniteCicle(int posicao) {
        super(posicao);
        id = 8;
        titulo = "Ciclo infinito";
        imagem = "pedra.png";
    }



    @Override
    public String  react(Programmer p) {
        return "Só precisas de partir a pedra para te tornares num caçador mas a pedra nem racha, será que vais ter " +
                "ajuda?";
    }
}
