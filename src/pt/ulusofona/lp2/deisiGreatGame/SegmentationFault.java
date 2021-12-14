package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abyss{
    public SegmentationFault(int posicao) {
        super(posicao);
        id = 9;
        titulo = "Segmentation Fault";
        imagem = "train.png";
    }

    @Override
    public String message() {
        return "Depois de esperares pelos teus companheiros voces reparam que não estão na estação do " +
                "Mugen Train e recuam 3 casas";
    }

    @Override
    public void react(Programmer p) {

    }
}
