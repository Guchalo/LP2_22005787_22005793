package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abyss {

    public Exception(int posicao) {
        super(posicao);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }

    public Exception(int posicao, int timesUsed) {
        super(posicao, timesUsed);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }

    @Override
    public String react(Programmer p) {
        if (p.temTH()) {
            p.removerTool("Ajuda Do Professor");
            return "Tanjiro ao ver que estavas com o Rengoku, assumiu que eras de confiança e deixou te continuar. " +
                    "Mas o Rengoku ficou á conversa com o Tanjiro e tiveste de continuar sem ele.";
        }
        if (p.temEA()) {
            p.removerTool("Tratamento de Excepções");
            return "O Tanjiro reconheceu-te como aluno do Urokodaki e deixou-te continuar a tua jornada";
        }
        p.recuar(2);
        return "Levaste uma cabeçada do Tanjiro e voltaste duas casas para trás";
    }
}