package pt.ulusofona.lp2.deisiGreatGame;

public class LogicError extends Abyss {
    public LogicError(int posicao) {
        super(posicao);
        id = 1;
        titulo = "Erro de lógica";
        imagem = "bicho.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temTH()){
            p.removerTool("Erro de lógica");
            return "Graças a ajuda do Regonku vocês conseguiram derrotar o demónio, pórem o Rengoku não sobreviveu ;-;";
        }
        if (p.temUT()){
            p.removerTool("Testes unitários");
            return "Graças a ajuda da Nezuko foste capaz de derrotar o demónio, porem ela ficou muito ferida e teve " +
                    "de voltar para a caixa para recuperar";
        }
        p.erroDeLogica();
        return "Deparaste-te com um demonio cujo o poder não consegues identificar, por isso " +
                "recuaste metade das casas que avançaste";
    }
}