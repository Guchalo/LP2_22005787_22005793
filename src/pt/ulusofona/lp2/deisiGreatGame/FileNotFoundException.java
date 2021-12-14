package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abyss {
    public FileNotFoundException(int posicao) {
        super(posicao);
        id = 3;
        titulo = "File Not Found Exception";
        imagem = "JAVALI.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temTH()){
            p.removerTool("File Not Found Exception");
            return "O Rengoku reconheceu que o javali era o Inosuke, ficando lá para o treinar enquanto tu segues" +
                    " a tua jornada";
        }
        p.recuar(3);
        return "Deste de cara com um humano com cara de Javali e recuaste 3 casas";
    }
}
