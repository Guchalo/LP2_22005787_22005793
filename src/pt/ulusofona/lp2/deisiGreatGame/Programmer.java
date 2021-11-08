package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class Programmer {
    int id;
    String name;
    ProgrammerColor color;
    int pos;
    ArrayList<String> linguagensProg = new ArrayList<>();
    boolean estado = true;

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

    public String getLinguagensProg(){
        return "";
    }

    @Override
    public String toString() {
        return "" + id + " | " + name + " | " + pos + " | " + getLinguagensProg() + " | " + getEstado();
    }
}
