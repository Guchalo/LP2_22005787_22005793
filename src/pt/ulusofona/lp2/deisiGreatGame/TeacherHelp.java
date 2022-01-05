package pt.ulusofona.lp2.deisiGreatGame;

public class TeacherHelp extends Tool {

    public TeacherHelp(int posicao) {
        super(posicao);
        id = 5;
        titulo = "Ajuda Do Professor";
        imagem = "rengoku.png";
    }

    public TeacherHelp() {
        super();
        id = 5;
        titulo = "Ajuda Do Professor";
        imagem = "rengoku.png";
    }

    @Override
    public String react(Programmer p) {
        return "O Rengoku chegou para te ajudar";
    }

}
