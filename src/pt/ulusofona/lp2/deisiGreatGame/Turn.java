package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    private ArrayList<Programmer> programadores = new ArrayList<>();
    Programmer programadorAtual;
    int nrTurnos = 1;

    public Turn(ArrayList<Programmer> programadores, Programmer programadorAtual) {
        this.programadores.addAll(programadores);
        this.programadorAtual = programadorAtual;
    }

    public Programmer getProgramadorAtual() {
        return programadorAtual;
    }

    public int getNrTurnos() {
        return nrTurnos;
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

    public void playersInGame(){
        ArrayList<Programmer> temp = new ArrayList<>();
        for (Programmer p : programadores) {
            if (p.getEstado()) {
                temp.add(p);
            }
        }
        programadores.clear();
        programadores = temp;

    }

}
