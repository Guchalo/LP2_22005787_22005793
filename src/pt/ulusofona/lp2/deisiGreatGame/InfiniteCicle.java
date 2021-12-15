package pt.ulusofona.lp2.deisiGreatGame;

public class InfiniteCicle extends Abyss {

    Programmer player;

    public InfiniteCicle(int posicao) {
        super(posicao);
        id = 8;
        titulo = "Ciclo infinito";
        imagem = "pedra.png";
    }

    @Override
    public String react(Programmer p) {
        if (p.temFP()){
            p.removerTool("Programação Funcional");
            return "Como dominaste a tecnica de Respiração Total, partir a pedra foi uma tarefa fácil";
        }
        if(this.player == null){
            this.player = p;
            this.player.ativarCicloInfinito();
            return "Só precisas de partir a pedra para te tornares num caçador mas a pedra nem racha, será que vais ter " +
                    "ajuda?";
        }else{
            this.player.desativarCicloInfinito();
            p.ativarCicloInfinito();
            this.player = p;
            return "Ajudas-te o caçador que estava preso a partir a pedra, porem tu ficaste para a partir sozinho, " +
                    "ou até alguem te vir ajudar";
        }

    }
}
