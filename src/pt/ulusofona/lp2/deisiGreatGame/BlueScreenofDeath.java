package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreenofDeath extends Abyss {
    public BlueScreenofDeath(int posicao) {
        super(posicao);
        id = 7;
        titulo = "Blue Screen of Death";
        imagem = "haganezuka.png";
    }

    @Override
    public String react(Programmer p) {
        if (p.temTH()) {
            p.removerTool("Ajuda Do Professor");
            return "O Rengoku impediu que o Haganezuka te executasse, porem ele tive de ir comprar dango para ele, " +
                    "deixando-te sozinho";
        }
        p.derrotado();
        return "Perdeste a tua espada pela 2ª vez, Haganezuka não te perdoou e executou-te, acabou o jogo";
    }
}
