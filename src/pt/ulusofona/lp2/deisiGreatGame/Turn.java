package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Turn {

    private ArrayList<Programmer> programadores = new ArrayList<>();
    private Programmer programadorAtual;
    private int nrTurnos;

    public Turn(ArrayList<Programmer> programadores, Programmer programadorAtual) {
        this.programadores.addAll(programadores);
        this.programadorAtual = programadorAtual;
        this.nrTurnos = 1;
    }

    public Turn(ArrayList<Programmer> programadores, Programmer programadorAtual, int nrTurnos) {
        this.programadores = programadores;
        this.programadorAtual = programadorAtual;
        this.nrTurnos = nrTurnos;
    }

    public Programmer getProgramadorAtual() {
        return programadorAtual;
    }

    public int getNrTurnos() {
        return nrTurnos;
    }

    public void setNrTurnos(int nrTurnos) {
        this.nrTurnos = nrTurnos;
    }

    public void aumentarTurno() {
        nrTurnos++;
    }

    public ArrayList<Programmer> getProgramadores() {
        return programadores;
    }

    public void alterarTurno(Programmer atual) {
        ArrayList<Programmer> temp = new ArrayList<>();
        for (int g = 1; g < programadores.size(); g++) {
            temp.add(programadores.get(g));
        }
        temp.add(programadores.get(0));
        programadores.clear();
        programadores = temp;
        programadorAtual = programadores.get(0);

    }

    public boolean mudarJogador(Programmer atual) {
        programadorAtual = atual;
        return true;
    }

    public void playersInGame() {
        programadores.removeIf(p -> !p.getEstado());
    }
}
