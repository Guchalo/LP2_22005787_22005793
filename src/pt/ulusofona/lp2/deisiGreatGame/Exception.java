package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss {
    public Exception(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temTH()){
            p.removerTool("Exception");
            return "Tanjiro ao ver que estavas com o Rengoku , assumiu que eras de confiança e deixou te continuar." +
                    "Mas o Rengoku ficou á conversa com o Tanjiro e tiveste de continuar sem ele.";
        }
        if (p.temFP()) {
            p.removerTool("Programação Funcional");
            return "Graças à técnica da Respiração Total, foste capaz de usar Hinokami Kagura(dança do Deus do fogo) para" +
                    " derrotar o demónio, porém ficaste demasiado fraco para usares a técnica novamente.";
        }
        if (p.temEA()) {
            p.removerTool("Tratamento de Excepções");
            return "O Tanjiro reconheceu-te como aluno do Urokodaki e deixou-te continuar a tua jornada.";
        }
        p.recuar(2);
        return "Levaste uma cabeçada do Tanjiro e voltaste duas casas para trás";
    }
}