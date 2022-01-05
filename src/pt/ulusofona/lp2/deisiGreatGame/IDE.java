package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Tool {

    public IDE(int posicao) {
        super(posicao);
        id = 4;
        titulo = "IDE";
        imagem = "passou.png";
    }

    public IDE() {
        super();
        id = 4;
        titulo = "IDE";
        imagem = "passou.png";
    }

    @Override
    public String react(Programmer p) {
        return "Ao passar todos os testes do Urokodaki, ele finalmente reconheceu-te" +
                "como caçador";
    }
}
