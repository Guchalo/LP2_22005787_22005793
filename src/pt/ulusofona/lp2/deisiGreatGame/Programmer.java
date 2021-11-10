package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    int id;
    String name;
    ProgrammerColor color;
    int pos = 0;
    ArrayList<String> linguagensProg = new ArrayList<>();
    boolean estado = true;
    boolean turno = false;


    public Programmer(int id, String name, ProgrammerColor color, ArrayList<String> linguagensProg) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.linguagensProg = linguagensProg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProgrammerColor getColor() {
        return color;
    }

    public int getPos() {
        return pos;
    }

    public String getEstado(){
        if (estado){
            return "Em Jogo";
        }else{
            return "Derrotado";
        }
    }

    public void derrotado(){
        if (estado == false){
            return;
        } else {
            estado = false;
        }
    }

    public String getLinguagensProg(){
        Collections.sort(linguagensProg);
        StringBuilder linguagens = new StringBuilder();
        for (String linguagem : linguagensProg){
            linguagens.append(linguagem);
            linguagens.append("; ");
        }
        return linguagens.substring(0,linguagens.length() - 2);
    }

    public void trocarTurno(){
        if (turno){
            turno = false;
        } else {
            turno = true;
        }
    }

    @Override
    public String toString() {
        return "" + id + " | " + name + " | " + pos + " | " + getLinguagensProg() + " | " + getEstado();
    }
}
