package pt.ulusofona.lp2.deisiGreatGame;


import javax.swing.*;
import java.util.*;

public class GameManager {
    private int tamanhoTab;
    private ArrayList<Programmer> programadores = new ArrayList<>();
    private Turn turno;
    private ArrayList<Programmer> boardApps = new ArrayList<>();

    public GameManager() {
    }

    public boolean createInitialBoard(String[][] playerInfo, int worldSize) {
        programadores.clear();
        setTamanhoTab(worldSize);
        int nJogadores = playerInfo.length;
        if (nJogadores < 2 || nJogadores > 4) {
            return false;
        }
        if (worldSize < (nJogadores * 2)) {
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

                if (!HelpfullFunctions.verificarColor(playerInfo) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3])) {
                    return false;
                }

                p1 = new Programmer(id1, playerInfo[0][1], ProgrammerColor.valueOf(playerInfo[0][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[0][2]));
                p2 = new Programmer(id2, playerInfo[1][1], ProgrammerColor.valueOf(playerInfo[1][3].toUpperCase()),
                        HelpfullFunctions.linguagensDeProg(playerInfo[1][2]));

                if (HelpfullFunctions.compararProgrammer(p1, p2)) {
                    addProgrammer(p1);
                    addProgrammer(p2);
                    ordenarProgId();
                    turno = new Turn(programadores, programadores.get(0));
                    return true;
                }

                break;


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

                if (!HelpfullFunctions.verificarColor(playerInfo) ||
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

                if (HelpfullFunctions.compararProgrammer(p1, p2) || HelpfullFunctions.compararProgrammer(p1, p3) ||
                        HelpfullFunctions.compararProgrammer(p2, p3)) {
                    addProgrammer(p1);
                    addProgrammer(p2);
                    addProgrammer(p3);
                    ordenarProgId();
                    turno = new Turn(programadores, programadores.get(0));
                    return true;
                }

                break;

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

                if (!HelpfullFunctions.verificarColor(playerInfo) ||
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

                if (HelpfullFunctions.compararProgrammer(p1, p2) || HelpfullFunctions.compararProgrammer(p1, p3) ||
                        HelpfullFunctions.compararProgrammer(p1, p4) || HelpfullFunctions.compararProgrammer(p2, p3) ||
                        HelpfullFunctions.compararProgrammer(p2, p4) || HelpfullFunctions.compararProgrammer(p3, p4)) {
                    addProgrammer(p1);
                    addProgrammer(p2);
                    addProgrammer(p3);
                    addProgrammer(p4);
                    ordenarProgId();
                    turno = new Turn(programadores, programadores.get(0));
                    return true;
                }

                break;

            default:
                return false;
        }
        return false;

    }

    boolean createInitialBoard(String[][] playerInfo, int worldSize,String[][] abyssesAndTools){
        createInitialBoard(playerInfo, worldSize);
        for(int r = 0; r < abyssesAndTools.length; r++){
            if (!HelpfullFunctions.verificarString(abyssesAndTools[r][0]) ||
                    !HelpfullFunctions.verificarString(abyssesAndTools[r][1]) ||
                    !HelpfullFunctions.verificarString(abyssesAndTools[r][2])) {
                return false;
            }

            int app = Integer.parseInt(abyssesAndTools[r][0]);
            int appType = Integer.parseInt(abyssesAndTools[r][1]);
            int appPosicion = Integer.parseInt(abyssesAndTools[r][2]);

            if(appPosicion < 0 || appPosicion > worldSize){
                return false;
            }
            BoardApps boardApp;

            switch (app){
                case 0:
                    switch (appType){
                        case 0:
                            boardApp = new SyntaxError();
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        default:
                            return false;
                    }
                    break;
                case 1:
                    switch (appType){
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        default:
                            return false;
                    }
                    break;
                default:
                    return false;

            }



        }
        return true;
    }

    public void setTamanhoTab(int tamanhoTab) {
        this.tamanhoTab = tamanhoTab;
    }

    public boolean addProgrammer(Programmer p) {
        if (p == null || p.getName() == null) {
            return false;
        }
        programadores.add(p);
        return true;
    }

    public void ordenarProgId() {
        if (programadores.size() == 0) {
            return;
        }
        programadores.sort(Comparator.comparingInt(Programmer::getId));
    }

    public String getImagePng(int position) {
        if (position == tamanhoTab) {
            return "finishLine50x50.png";
        }
        if (position < tamanhoTab && position > 0) {
            return "blank.png";
        }
        return null;
    }

    public String getTitle(int position){
        return "";
    }

    public ArrayList<Programmer> getProgrammers() {
        return programadores;
    }

    public List<Programmer> getProgrammers(boolean includeDefeated){
        return new ArrayList<>();
    }

    public List<Programmer> getProgrammers(int position) {
        if (position < 0 || position > tamanhoTab) {
            return null;
        }
        ArrayList<Programmer> programadoresPorPosicao = new ArrayList<>();
        for (Programmer p : programadores) {
            if (p.getPos() == position) {
                programadoresPorPosicao.add(p);
            }
        }
        return programadoresPorPosicao;
    }

    public int getCurrentPlayerID() {
        return turno.getProgramadorAtual().getId();
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (gameIsOver()) {
            return false;
        }
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        turno.getProgramadorAtual().moverPos(nrPositions, tamanhoTab);
        programadores = turno.alterarTurno(turno.getProgramadorAtual());
        turno.mudarJogador(turno.getProgramadorAtual());
        turno.aumentarTurno();
        return true;
    }

    public boolean gameIsOver() {
        for (Programmer p : programadores) {
            if (p.getPos() == tamanhoTab) {
                return true;
            }
        }
        return false;
    }

    public List<String> getGameResults() {
        ArrayList<String> results = new ArrayList<>();
        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + this.turno.getNrTurnos());
        results.add("");
        results.add("VENCEDOR");
        programadores.sort(Comparator.comparingInt(Programmer::getPos).reversed());
        results.add("" + this.programadores.get(0).getName());
        results.add("");
        results.add("RESTANTES");
        for (int u = 1; u < programadores.size(); u++) {
            results.add("" + programadores.get(u).getName() + " " + programadores.get(u).getPos());
        }
        return results;
    }

    public JPanel getAuthorsPanel() {

        JPanel painel = new JPanel();
        painel.setBounds(40, 80, 200, 200);
        JLabel texto = new JLabel("Trabalho realizado por;");
        painel.add(texto);
        JLabel texto2 = new JLabel("                                                                          " +
                "                                            ");
        JLabel texto3 = new JLabel("Gonçalo Nunes (a22005787)");
        JLabel texto4 = new JLabel("Rafael Simões (a22005793)");
        JLabel texto5 = new JLabel("                                                                           " +
                "                                            ");
        JLabel texto6 = new JLabel("May the odds be ever in your favor");
        painel.add(texto2);
        painel.add(texto3);
        painel.add(texto4);
        painel.add(texto5);
        painel.add(texto6);
        return painel;
    }

    public String getProgrammersInfo(){
        return "";
    }

    public String reactToAbyssOrTool(){
        return ";_;";
    }



}

