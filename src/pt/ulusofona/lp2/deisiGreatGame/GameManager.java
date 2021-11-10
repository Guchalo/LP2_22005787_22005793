package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager {


    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        int nJogadores = playerInfo.length;
        if (nJogadores < 2 || nJogadores > 4) {
            return false;
        }
        if (boardSize < (nJogadores * 2)) {
            return false;
        }
        Programmer p1;
        Programmer p2;
        Programmer p3;
        Programmer p4;

        int id1;
        int id2;
        int id3;
        int id4;
        switch (nJogadores) {
            case 2:
                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0])) {
                    return false;
                }
                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                if (id1 < 0 || id2 < 0) {
                    return false;
                }

                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarColor(playerInfo[0][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3])) {
                    return false;
                }

                p1 = new Programmer(id1, playerInfo[0][1], ProgrammerColor.valueOf(playerInfo[0][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[0][2]));
                p2 = new Programmer(id2, playerInfo[1][1], ProgrammerColor.valueOf(playerInfo[1][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[1][2]));

                return HelpfullFunctions.verificarProgrammer(p1, p2);


            case 3:
                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][0])) {
                    return false;
                }

                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                id3 = Integer.parseInt(playerInfo[2][0]);

                if (id1 < 0 || id2 < 0 || id3 < 0) {
                    return false;
                }

                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][1])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][2])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarColor(playerInfo[0][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][3])) {
                    return false;
                }

                p1 = new Programmer(id1, playerInfo[0][1], ProgrammerColor.valueOf(playerInfo[0][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[0][2]));
                p2 = new Programmer(id2, playerInfo[1][1], ProgrammerColor.valueOf(playerInfo[1][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[1][2]));
                p3 = new Programmer(id3, playerInfo[2][1], ProgrammerColor.valueOf(playerInfo[2][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[2][2]));

                return HelpfullFunctions.verificarProgrammer(p1, p2) || HelpfullFunctions.verificarProgrammer(p1, p3) ||
                        HelpfullFunctions.verificarProgrammer(p2, p3);

            case 4:

                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[3][0])) {
                    return false;
                }
                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                id3 = Integer.parseInt(playerInfo[2][0]);
                id4 = Integer.parseInt(playerInfo[3][0]);
                if (id1 < 0 || id2 < 0 || id3 < 0 || id4 < 0) {
                    return false;
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[3][1])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][2])) {
                    return false;
                }

                if (!HelpfullFunctions.verificarColor(playerInfo[0][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][3])) {
                    return false;
                }

                p1 = new Programmer(id1, playerInfo[0][1], ProgrammerColor.valueOf(playerInfo[0][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[0][2]));
                p2 = new Programmer(id2, playerInfo[1][1], ProgrammerColor.valueOf(playerInfo[1][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[1][2]));
                p3 = new Programmer(id3, playerInfo[2][1], ProgrammerColor.valueOf(playerInfo[2][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[2][2]));
                p4 = new Programmer(id4, playerInfo[3][1], ProgrammerColor.valueOf(playerInfo[3][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[3][2]));

                return HelpfullFunctions.verificarProgrammer(p1, p2) || HelpfullFunctions.verificarProgrammer(p1, p3) ||
                        HelpfullFunctions.verificarProgrammer(p1, p4) || HelpfullFunctions.verificarProgrammer(p2, p3) ||
                        HelpfullFunctions.verificarProgrammer(p2, p4) || HelpfullFunctions.verificarProgrammer(p3, p4);
            default:
                return false;
        }

    }

    public String getImagePng(int position){
        return "";
    }

    public ArrayList<Programmer> getProgrammers(){
        return new ArrayList<>();
    }

    public ArrayList<Programmer> getProgrammers(int position){
        return new ArrayList<>();
    }

    public int getCurrentPlayerID(){

        return 1;
    }

    public boolean moveCurrentPlayer(int nrPositions){
        return false;
    }

    public boolean gameIsOver(){
        return true;
    }

    public ArrayList<String> getGameResults(){
        return new ArrayList<>();
    }

    public JPanel getAuthorsPanel(){
        return new JPanel();
    }
}
