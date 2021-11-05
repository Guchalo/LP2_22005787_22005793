package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class Programmer {
    int id;
    String name;
    ProgrammerColor color;
    int pos;
    ArrayList<String> linguagensProg = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Programmer{" + "id=" + id +
                ",name='" + name  +
                ",color=" + color +
                '}';
    }
}
