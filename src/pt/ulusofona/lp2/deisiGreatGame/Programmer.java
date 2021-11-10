package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Collections;

public class Programmer {
    int id;
    String name;
    ProgrammerColor color;
    String image;
    int pos = 1;
    ArrayList<String> linguagensProg = new ArrayList<>();
    boolean estado = true;


    public Programmer() {
    }

    public boolean getEstado() {
        return estado;
    }


    public boolean moverPos(int nrPositions, int size){
        if(pos + nrPositions > size){
            int diferenca = (pos + nrPositions) - size;
            int alcancarSize = size - pos;
            pos += alcancarSize;
            pos -= diferenca;
            return true;
        }
        pos += nrPositions;
        return true;
    }

    public Programmer(int id, String name, ProgrammerColor color, ArrayList<String> linguagensProg) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = color.getCor();
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

    public String stringEstado(){
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


    @Override
    public String toString() {
        return "" + id + " | " + name + " | " + pos + " | " + getLinguagensProg() + " | " + stringEstado();
    }
}
