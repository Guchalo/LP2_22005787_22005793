package pt.ulusofona.lp2.deisiGreatGame;

public class LetsDoCounts extends Abyss {

    public LetsDoCounts(int posicao) {
        super(posicao);
        id = 10;
        titulo = "Vamos Fazer Contas";
    }

    public LetsDoCounts(int posicao, int timesUsed) {
        super(posicao, timesUsed);
        id = 10;
        titulo = "Vamos Fazer Contas";
    }

    @Override
    public String react(Programmer p) {
        p.media3CasasAnteriores();
        return "Testeeeeee";
    }
}
