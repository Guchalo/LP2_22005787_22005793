package pt.ulusofona.lp2.deisiGreatGame;

public class TeacherHelp extends Tool{

    public TeacherHelp(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Ajuda Do Professor";
        imagem = "rengoku.png";
    }

    @Override
    public String message() {
        return "O Rengoku chegou para te ajudar";
    }

    @Override
    public void react() {

    }

    @Override
    public void adicionarGM(GameManager p){

    }
}
