package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class Turn {
    ArrayList<Programmer> programadores;
    Programmer programadorAtual;
    int nrTurnos = 1;

    public Turn(ArrayList<Programmer> programadores, Programmer programadorAtual) {
        this.programadores = programadores;
        this.programadorAtual = programadorAtual;
    }

    public Programmer getProgramadorAtual() {
        return programadorAtual;
    }

    public int getNrTurnos() {
        return nrTurnos;
    }

    public void aumentarTurno(){
        nrTurnos++;
    }

    public ArrayList<Programmer> alterarTurno(Programmer atual){
        ArrayList<Programmer> temp = new ArrayList<>();
        for(int g = 1; g < programadores.size(); g++ ){
            temp.add(programadores.get(g));
        }
        temp.add(programadores.get(0));
        programadores.clear();
        programadores = temp;
        programadorAtual = programadores.get(0);
        return programadores;
    }

    public boolean mudarJogador(Programmer atual){
        programadorAtual = atual;
        return true;
    }

}
