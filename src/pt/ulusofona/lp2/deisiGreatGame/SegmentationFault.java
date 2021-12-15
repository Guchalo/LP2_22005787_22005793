package pt.ulusofona.lp2.deisiGreatGame;

public class SegmentationFault extends Abyss {
    public SegmentationFault(int posicao) {
        super(posicao);
        id = 9;
        titulo = "Segmentation Fault";
        imagem = "train.png";
    }


    @Override
    public String react(Programmer p) {
        if (p.temIDE()){
            p.removerTool("IDE");
            return "Como já és um caçador experiente, conseguiste apanhar o Mugen Train a tempo";
        }
        return "Depois de esperares pelos teus companheiros vocês reparam que não estão na estação do " +
                "Mugen Train e recuam 3 casas";
    }
}
