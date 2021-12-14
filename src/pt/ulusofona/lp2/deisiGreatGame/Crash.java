package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abyss {
    public Crash(int posicao) {
        super(posicao);
        id = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "tanjiroInjured.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temEA()) {
            p.removerTool("Tratamento de Excepções");
            return "Graças ao teu treino, foste capaz de suportar os danos da batalha e não precisas de descansar.";
        }
        p.voltarPracasa();
        return "Depois de uma grande batalha, perdeste todas as forças e foste levado para a casa da Shinobu para" +
                "recuperar";
    }
}
