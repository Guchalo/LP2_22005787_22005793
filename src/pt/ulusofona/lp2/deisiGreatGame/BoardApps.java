package pt.ulusofona.lp2.deisiGreatGame;

public abstract class BoardApps {

    protected int id;
    protected String titulo;
    protected int posicao;
    protected String imagem;
    protected String identificadorAT;

    public BoardApps(int posicao) {
        this.posicao = posicao;
    }

    public String getIdentificadorAT() {
        return identificadorAT;
    }

    public String getImagem() {
        return imagem;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPosicao() {
        return posicao;
    }

    public abstract String react(Programmer p);
}
