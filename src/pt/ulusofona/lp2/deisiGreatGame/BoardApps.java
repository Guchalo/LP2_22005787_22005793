package pt.ulusofona.lp2.deisiGreatGame;

public abstract class BoardApps {
    int id;
    String titulo;
    int posicao;
    String imagem;


    public BoardApps(int posicao) {
        this.posicao = posicao;
    }

    public BoardApps() {
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

    public abstract String message();

    public abstract void react();
}
