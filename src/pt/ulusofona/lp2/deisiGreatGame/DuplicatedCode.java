package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Abyss{
    public DuplicatedCode(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Duplicated Code";
        imagem = "zenitsu.png";
    }



    @Override
    public String react(Programmer p) {
        if(p.temHeranca()){
            p.removerTool("Herança");
            return "Recebeste ajuda para derrotar o demonio";
        }
        p.voltarOndeEstava();
        return "Viste um demonio que estava completamente fora do teu alcance, acobardaste-te e voltas-te para trás";

    }
}
