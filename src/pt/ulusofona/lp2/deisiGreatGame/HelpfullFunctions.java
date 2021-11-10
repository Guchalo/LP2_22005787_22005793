package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HelpfullFunctions {

    public static boolean verificarString(String lp){
        return lp != null && lp.length() != 0;
    }

    public static boolean verificarColor(String lp){
        return lp.equals("Purple") || lp.equals("Blue") || lp.equals("Green") || lp.equals("Brown");
    }

    public static boolean verificarProgrammer(Programmer p1, Programmer p2){
        if(p1 == p2){
            return false;
        }
        if(p1.getId() == p2.getId() ||  p1.getColor() == p2.getColor()){
            return false;
        }
        return true;
    }

    public static ArrayList<String> linguagensDeProg(String lp){
        String[] lP = lp.split(";");
        ArrayList<String> listaLinguagens = new ArrayList<>(Arrays.asList(lP));
        Collections.sort(listaLinguagens);
        return listaLinguagens;
    }

}
