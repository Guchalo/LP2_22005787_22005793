package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abyss {

    public FileNotFoundException(int posicao) {
        super(posicao);
        id = 3;
        titulo = "File Not Found Exception";
        imagem = "JAVALI.png";
    }

    public FileNotFoundException(int posicao, int timesUsed) {
        super(posicao, timesUsed);
        id = 2;
        titulo = "Exception";
        imagem = "tanjiroH.png";
    }

    @Override
    public String react(Programmer p) {
        if (p.temTH()) {
            p.removerTool("Ajuda Do Professor");
            return "O Rengoku reconheceu que o javali era o Inosuke, ficando lá para o treinar enquanto tu segues" +
                    " a tua jornada";
        }
        if (p.temEA()) {
            p.removerTool("Tratamento de Excepções");
            return "Graças ao teu treino, conseguiste-te evitar o javali sem o ferir, prosseguindo assim com a tua" +
                    " jornada";
        }
        p.recuar(3);
        return "Deste de cara com um humano com cara de Javali e recuaste 3 casas";
    }
}
