package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Abyss {
    public DuplicatedCode(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Duplicated Code";
        imagem = "zenitsu.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temHeranca()) {
            p.removerTool("Herança");
            return "Com a ajuda do Inosuke e do Zenitsu, foram capazes de derrotar o demónio, mas eles foram feridos na " +
                    " batalha e ficaram para trás para recuperarem.";
        } if (p.temFP()) {
            p.removerTool("Programação Funcional");
            return "Graças à técnica da Respiração Total, foste capaz de usar Hinokami Kagura(dança do Deus do fogo) para" +
                    " derrotar o demónio, porém ficaste demasiado fraco para usares a técnica novamente.";
        }
        p.voltarOndeEstava();
        return "Viste um demonio que estava completamente fora do teu alcance, acobardaste-te e voltas-te para trás";
    }
}
