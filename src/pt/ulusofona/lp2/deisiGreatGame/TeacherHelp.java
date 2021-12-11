package pt.ulusofona.lp2.deisiGreatGame;

public class TeacherHelp extends Tool{

    public TeacherHelp(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Ajuda Do Professor";
        imagem = "ajuda-professor.png";
    }

    @Override
    public String message() {
        return "Wi tou num aperto, mi ajuda";
    }

    @Override
    public void react() {

    }

}
