package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelpfullFunctions {

    public static boolean verificarString(String lp) {
        return lp != null && lp.length() != 0;
    }

    public static boolean verificarColor(String[][] inf) {
        for (String[] strings : inf) {
            if (!strings[3].equalsIgnoreCase("Purple") && !strings[3].equalsIgnoreCase("Blue") &&
                    !strings[3].equalsIgnoreCase("Green") && !strings[3].equalsIgnoreCase("Brown")) {
                return false;
            }
        }
        return true;
    }

    public static boolean compararProgrammer(Programmer p1, Programmer p2) {
        if (p1 == p2) {
            return false;
        }
        return p1.getId() != p2.getId() && p1.getColor() != p2.getColor();
    }

    public static ArrayList<String> linguagensDeProg(String lp) {
        String[] lP = lp.split(";");
        ArrayList<String> listaLinguagens = new ArrayList<>(Arrays.asList(lP));
        Collections.sort(listaLinguagens);
        return listaLinguagens;
    }

    public static String firstName(String nome) {

        String[] name = nome.split(" ");
        return name[0];

    }

    public static boolean existeLinguagem(String linguagens, String linguagemPretendida) {

        ArrayList<String> listaLinguagens = linguagensDeProg(linguagens);
        for (String linguagem : listaLinguagens) {
            if (linguagem.trim().equals(linguagemPretendida.trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean stringToBoolean(String s) {
        return !s.equals("0");
    }

    public static List<Tool> tools(String lp) {
        List<Tool> listaLinguagens = new ArrayList<>();
        if (lp.equals("No tools")) {
            return listaLinguagens;
        }
        String[] lP = lp.split(";");
        for (String s : lP) {
            BoardApps app = switch (s) {
                case "Tratamento de Excepções" -> new ExceptionHandling();
                case "Herança" -> new Heritage();
                case "Programação Funcional" -> new FunctionalProgramming();
                case "Testes unitários" -> new UnityTests();
                case "IDE" -> new IDE();
                case "Ajuda Do Professor" -> new TeacherHelp();
                default -> new TeacherHelp();
            };
            listaLinguagens.add((Tool) app);
        }
        return listaLinguagens;
    }

    public static ArrayList<Integer> pos(String lp) {
        String[] lP = lp.split(";");
        ArrayList<Integer> lista = new ArrayList<>();
        for (String s : lP) {
            lista.add(Integer.parseInt(s));
        }
        return lista;
    }
}
