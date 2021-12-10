package pt.ulusofona.lp2.deisiGreatGame;

public class Heritage extends Tool{

    public Heritage(int posicao) {
        super(posicao);
        id = 0;
        titulo = "Herança";
    }


    @Override
    public String message() {
        return "WI ESSE FILHO NUM É MEU";
    }

    @Override
    public void react() {

    }
}
