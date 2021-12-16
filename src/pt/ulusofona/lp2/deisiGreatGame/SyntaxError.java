package pt.ulusofona.lp2.deisiGreatGame;

public class SyntaxError extends Abyss {

    public SyntaxError(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Erro de sintaxe";
        imagem = "armadilha.png";
    }

    @Override
    public String react(Programmer p) {
        if (p.temTH()) {
            p.removerTool("Erro de sintaxe");
            return "Como tens o Rengoku do teu lado, ele avisa te da armadilha e consegues evitá-la, mas como tu falhaste" +
                    " ao detetar uma armadilha muito óbvia e ele abandonou-te.";
        }
        if (p.temIDE()) {
            p.removerTool("IDE");
            return "Como passaste em todos os testes, já sabias onde estavam todas as armadilhas e " +
                    "conseguiste evita-las";
        }
        p.recuar(1);
        return "Caiste numa das armadilhas do Urokodaki, recuas 1 casa";
    }
}
