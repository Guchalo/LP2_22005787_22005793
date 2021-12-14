package pt.ulusofona.lp2.deisiGreatGame;

public class SideEffects extends Abyss {
    public SideEffects(int posicao) {
        super(posicao);
        id = 6;
        titulo = "Efeitos secundários";
        imagem = "muzan.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temFP()) {
            p.removerTool("Programação Funcional");
            return "Graças à técnica da Respiração Total, foste capaz de usar Hinokami Kagura(dança do Deus do fogo)" +
                    " e conseguiste bater te de frente com o Muzan. Mas ficaste demasiado fraco para continuar" +
                    " e Muzan fugiu.";
        }
        return "Deste de caras com o Muzan mas perdeste a oportunidade de o apanhar," +
                " por isso voltaste para onde estavas á 2 jogadas atrás";
    }
}
