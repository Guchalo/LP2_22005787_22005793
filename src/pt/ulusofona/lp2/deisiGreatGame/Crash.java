package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abyss {

    public Crash(int posicao) {
        super(posicao);
        id = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "tanjiroInjured.png";
    }

    public Crash(int posicao, int timesUsed) {
        super(posicao, timesUsed);
        id = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "tanjiroInjured.png";
    }

    @Override
    public String react(Programmer p) {
        p.voltarPracasa();
        return "Depois de uma grande batalha, perdeste todas as forças e foste levado para a casa da Shinobu para" +
                "recuperar";
    }
}
