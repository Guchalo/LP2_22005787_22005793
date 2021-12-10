package pt.ulusofona.lp2.deisiGreatGame;

public abstract class BoardApps {
    int id;
    String titulo;

    public BoardApps() {
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract String message();

    public abstract void react();
}
