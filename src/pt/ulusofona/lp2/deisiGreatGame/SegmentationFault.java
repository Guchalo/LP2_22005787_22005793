package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abyss{
    public SegmentationFault(int posicao) {
        super(posicao);
        id = 9;
        titulo = "Segmentation Fault";
        imagem = "core-dumped.png";
    }

    @Override
    public String message() {
        return "Não vais dar pull up na zona dos opps sem o teu tropa wi";
    }

    @Override
    public void react() {

    }
}
