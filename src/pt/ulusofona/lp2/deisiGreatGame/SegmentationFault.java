package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class SegmentationFault extends Abyss {

    private final List<Programmer> programadores = new ArrayList<>();

    public SegmentationFault(int posicao, List<Programmer> programadores) {
        super(posicao);
        id = 9;
        titulo = "Segmentation Fault";
        imagem = "train.png";
        this.programadores.addAll(programadores);
    }

    @Override
    public String react(Programmer p) {
        ArrayList<Programmer> temp = new ArrayList<>();
        for (Programmer pg : programadores) {
            if (pg.posicaoValidaSF(this.posicao)) {
                temp.add(pg);
            }
        }
        if (temp.size() < 2) {
            return "Os teus companheiros deixaram-te pendurado, continua sem eles";
        }
        for (Programmer pg : temp) {
            pg.recuar(3);
        }
        return "Depois de esperares pelos teus companheiros vocês reparam que não estão na estação do " +
                "Mugen Train e recuam 3 casas";
    }
}
