package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Tool {

    public IDE(int posicao) {
        super(posicao);
        id = 4;
        titulo = "IDE";
        imagem = "passou.png";
    }


    @Override
    public String react(Programmer p) {
        return "Passaste em todos os testes do Urokodaki";
    }


}
