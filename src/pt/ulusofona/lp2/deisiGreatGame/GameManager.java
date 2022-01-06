package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;

public class GameManager {

    private int tamanhoTab;
    private ArrayList<Programmer> programadores = new ArrayList<>();
    private Turn turno;
    private final ArrayList<BoardApps> boardApps = new ArrayList<>();
    private ArrayList<Position> positions = new ArrayList<>();

    public GameManager() {
    }

    public GameManager(ArrayList<Programmer> programadores) {
        this.programadores = programadores;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public List<String> getGameResults() {
        ArrayList<String> results = new ArrayList<>();
        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + this.turno.getNrTurnos());
        results.add("");
        results.add("VENCEDOR");
        programadores.sort(Comparator.comparingInt(Programmer::getPos).reversed().thenComparing(Programmer::getName));
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
        painel.setBounds(40, 80, 300, 300);
        JLabel texto = new JLabel("Trabalho realizado por;");
        JLabel texto2 = new JLabel("                                                                          " +
                "                                            ");
        JLabel texto3 = new JLabel("Gonçalo Nunes (a22005787)");
        JLabel texto4 = new JLabel("Rafael Simões (a22005793)");
        JLabel texto5 = new JLabel("                                                                           " +
                "                                            ");
        JLabel texto6 = new JLabel("\"何人でも負けても生き続けるしかない。どん");
        JLabel texto7 = new JLabel("なに壊滅的であっても、打撃は多分\"");
        JLabel texto8 = new JLabel("- 竈門 炭治郎");
        JLabel texto9 = new JLabel("\"No matter how many people, you may lose,");
        JLabel texto10 = new JLabel("you have no choice but to go on living.");
        JLabel texto11 = new JLabel("No matter how devastating, the blows maybe\"");
        JLabel texto12 = new JLabel("- Tanjiro Kamado");
        painel.add(texto);
        painel.add(texto2);
        painel.add(texto3);
        painel.add(texto4);
        painel.add(texto5);
        painel.add(texto6);
        painel.add(texto7);
        painel.add(texto8);
        painel.add(texto9);
        painel.add(texto10);
        painel.add(texto11);
        painel.add(texto12);
        return painel;
    }

    public String getProgrammersInfo() {
        ArrayList<Programmer> temp = new ArrayList<>(turno.getProgramadores());
        temp.sort(Comparator.comparingInt(Programmer::getId));
        StringBuilder resultado = new StringBuilder();
        for (Programmer p : temp) {
            resultado.append(p.getName());
            resultado.append(" : ");
            resultado.append(p.toStringTools());
            resultado.append(" | ");
        }
        return resultado.substring(0, resultado.length() - 3);
    }

    public Turn getTurno() {
        return turno;
    }

    public String getImagePng(int position) {
        if (position == tamanhoTab) {
            return "finishLine50x50.png";
        }
        for (BoardApps boardApp : getBoardApps()) {
            if (position == boardApp.getPosicao()) {
                return boardApp.getImagem();
            }
        }

        return null;
    }

    public String getTitle(int position) {
        if (position < 0 || position == tamanhoTab) {
            return null;
        }
        for (BoardApps boardApp : getBoardApps()) {
            if (position == boardApp.getPosicao()) {
                return boardApp.getTitulo();
            }
        }
        return null;
    }

    public ArrayList<BoardApps> getBoardApps() {
        return boardApps;
    }

    public ArrayList<Programmer> getProgrammers() {
        return programadores;
    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        ArrayList<Programmer> programmers = new ArrayList<>();
        if (includeDefeated) {
            return programadores;
        }
        for (Programmer p : programadores) {
            if (p.getEstado()) {
                programmers.add(p);
            }
        }
        return programmers;

    }

    public List<Programmer> getProgrammers(int position) {
        if (position < 0 || position > tamanhoTab) {
            return null;
        }
        ArrayList<Programmer> programadoresPorPosicao = new ArrayList<>();
        for (Programmer p : programadores) {
            if (p.getPos() == position && p.getEstado()) {
                programadoresPorPosicao.add(p);
            }
        }
        return programadoresPorPosicao;
    }

    public int getCurrentPlayerID() {
        return turno.getProgramadorAtual().getId();
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

    public void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        programadores.clear();
        boardApps.clear();
        if (playerInfo == null || playerInfo.length == 0) {
            throw new InvalidInitialBoardException("Valor de playerInfo inválido");
        }
        setTamanhoTab(worldSize);
        this.positions = makePositions();
        int nJogadores = playerInfo.length;
        if (nJogadores < 2 || nJogadores > 4) {
            throw new InvalidInitialBoardException("Número de jogadores inválido");
        }
        if (worldSize < (nJogadores * 2)) {
            throw new InvalidInitialBoardException("Tamanho do tabuleiro inválido");
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
            case 2 -> {
                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0])) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                if (id1 < 0 || id2 < 0) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1])) {
                    throw new InvalidInitialBoardException("Nome do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2])) {
                    throw new InvalidInitialBoardException("Cor do jogador inválida");
                }
                if (!HelpfullFunctions.verificarColor(playerInfo) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3])) {
                    throw new InvalidInitialBoardException("Linguagem de programação do jogador inválida");
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
                }
            }
            case 3 -> {
                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][0])) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                id3 = Integer.parseInt(playerInfo[2][0]);
                if (id1 < 0 || id2 < 0 || id3 < 0) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][1])) {
                    throw new InvalidInitialBoardException("Nome do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][2])) {
                    throw new InvalidInitialBoardException("Cor do jogador inválida");
                }
                if (!HelpfullFunctions.verificarColor(playerInfo) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][3])) {
                    throw new InvalidInitialBoardException("Linguagem de programação do jogador inválida");
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
                }
            }
            case 4 -> {
                if (!HelpfullFunctions.verificarString(playerInfo[0][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][0]) ||
                        !HelpfullFunctions.verificarString(playerInfo[3][0])) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                id1 = Integer.parseInt(playerInfo[0][0]);
                id2 = Integer.parseInt(playerInfo[1][0]);
                id3 = Integer.parseInt(playerInfo[2][0]);
                id4 = Integer.parseInt(playerInfo[3][0]);
                if (id1 < 0 || id2 < 0 || id3 < 0 || id4 < 0) {
                    throw new InvalidInitialBoardException("Id do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][1]) ||
                        !HelpfullFunctions.verificarString(playerInfo[3][1])) {
                    throw new InvalidInitialBoardException("Nome do jogador inválido");
                }
                if (!HelpfullFunctions.verificarString(playerInfo[0][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][2]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][2])) {
                    throw new InvalidInitialBoardException("Cor do jogador inválida");
                }
                if (!HelpfullFunctions.verificarColor(playerInfo) ||
                        !HelpfullFunctions.verificarString(playerInfo[1][3]) ||
                        !HelpfullFunctions.verificarString(playerInfo[2][3])) {
                    throw new InvalidInitialBoardException("Linguagem de programação do jogador inválida");
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
                }
            }
            default -> throw new InvalidInitialBoardException("Número de jogadores inválido");
        }
    }

    public void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools)
            throws InvalidInitialBoardException {
        createInitialBoard(playerInfo, worldSize);
        if (abyssesAndTools == null) {
            throw new InvalidInitialBoardException("Valor de abyssesAndTools inválido");
        }
        for (String[] abyssesAndTool : abyssesAndTools) {
            if (!HelpfullFunctions.verificarString(abyssesAndTool[0]) ||
                    !HelpfullFunctions.verificarString(abyssesAndTool[1])) {
                throw new InvalidInitialBoardException("Dados do Abismo/Ferramenta inválidos");
            }

            int app = Integer.parseInt(abyssesAndTool[0]);
            int appType = Integer.parseInt(abyssesAndTool[1]);
            int appPosicion = 0;

            if (HelpfullFunctions.verificarString(abyssesAndTool[2])) {
                appPosicion = Integer.parseInt(abyssesAndTool[2]);
            }


            if (appPosicion < 0 || appPosicion > worldSize) {
                throw new InvalidInitialBoardException("Posição do Abismo/Ferramenta inválida");
            }
            BoardApps boardApp = switch (app) {
                case 0 -> switch (appType) {
                    case 0 -> new SyntaxError(appPosicion);
                    case 1 -> new LogicError(appPosicion);
                    case 2 -> new Exception(appPosicion);
                    case 3 -> new FileNotFoundException(appPosicion);
                    case 4 -> new Crash(appPosicion);
                    case 5 -> new DuplicatedCode(appPosicion);
                    case 6 -> new SideEffects(appPosicion);
                    case 7 -> new BlueScreenOfDeath(appPosicion);
                    case 8 -> new InfiniteCicle(appPosicion);
                    case 9 -> new SegmentationFault(appPosicion, programadores);
                    default -> throw new InvalidInitialBoardException("Tipo do Abismo inválido");
                };
                case 1 -> switch (appType) {
                    case 0 -> new Heritage(appPosicion);
                    case 1 -> new FunctionalProgramming(appPosicion);
                    case 2 -> new UnityTests(appPosicion);
                    case 3 -> new ExceptionHandling(appPosicion);
                    case 4 -> new IDE(appPosicion);
                    case 5 -> new TeacherHelp(appPosicion);
                    default -> throw new InvalidInitialBoardException("Tipo da Ferramenta inválida");
                };
                default -> throw new InvalidInitialBoardException("Tipo inexistente");
            };
            if (appPosicion == 0) {
                throw new InvalidInitialBoardException("Erro no Abismo/Ferramenta com o id:", boardApp);

            }
            boardApps.add(boardApp);
        }
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (gameIsOver()) {
            return false;
        }
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        }
        if (turno.getProgramadorAtual().isCicloInfinito()) {
            return false;
        }

        if (!turno.getProgramadorAtual().getEstado()) {
            return false;
        }

        turno.getProgramadorAtual().moverPos(nrPositions, tamanhoTab);
        aumentarNrStepsPos();

        return true;
    }

    public void mudarTurno() {
        turno.alterarTurno(turno.getProgramadorAtual());
        turno.playersInGame();
        turno.mudarJogador(turno.getProgramadorAtual());
        turno.aumentarTurno();
    }

    public String reactToAbyssOrTool() {
        String mensagem = "";
        for (BoardApps boardApp : boardApps) {
            if (turno.getProgramadorAtual().getPos() == boardApp.getPosicao()) {
                if (boardApp.getIdentificadorAT().equals("T")) {
                    turno.getProgramadorAtual().adicionarTool((Tool) boardApp);
                    mensagem = boardApp.react(turno.getProgramadorAtual());
                    mudarTurno();
                    return mensagem;
                }
                abyssUsed();
                mensagem = boardApp.react(turno.getProgramadorAtual());
                mudarTurno();
                return mensagem;
            }
        }
        mudarTurno();
        return null;
    }

    public boolean gameIsOver() {
        if (turno.getProgramadores().size() == 1) {
            return true;
        }
        for (Programmer p : programadores) {
            if (p.getPos() == tamanhoTab) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Position> makePositions() {
        ArrayList<Position> posicoes = new ArrayList<>();
        for (int a = 0; a < tamanhoTab; a++) {
            Position position = new Position(a);
            posicoes.add(position);
        }
        return posicoes;
    }

    public void aumentarNrStepsPos() {
        for (Position p : positions) {
            if (p.getNumPosition() == turno.getProgramadorAtual().getPos()) {
                p.increaseFootSteps();
            }
        }
    }

    public void abyssUsed() {
        for (BoardApps app : boardApps) {
            if (app.isAbyss()) {
                if (app.getPosicao() == turno.getProgramadorAtual().getPos()) {
                    ((Abyss) app).aumentarTimesUsed();
                }
            }
        }
    }

    public boolean posicaoOcupada(int posicao) {
        for (BoardApps app : boardApps) {
            if (app.getPosicao() == posicao) {
                if (app.isAbyss() || app.isTool()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addAbyss(int pos, String id) {
        if (!posicaoOcupada(pos)) {
            int identificador = Integer.parseInt(id);
            BoardApps app = switch (identificador) {
                case 0 -> new SyntaxError(pos);
                case 1 -> new LogicError(pos);
                case 2 -> new Exception(pos);
                case 3 -> new FileNotFoundException(pos);
                case 4 -> new Crash(pos);
                case 5 -> new DuplicatedCode(pos);
                case 6 -> new SideEffects(pos);
                case 7 -> new BlueScreenOfDeath(pos);
                case 8 -> new InfiniteCicle(pos);
                case 9 -> new SegmentationFault(pos, programadores);
                default -> new LogicError(pos);
            };
            boardApps.add(app);
        }
    }

    public boolean saveGame(File file) {
        try {
            PrintWriter ps = new PrintWriter(file);
            ps.println(tamanhoTab);
            ps.println(programadores.size());
            for (Programmer p : programadores) {
                String result = "" + p.getId() + "/" + p.getName() + "/" + p.getColor().toString() + "/" +
                        p.getLinguagensProg().trim() + "/" + p.getPos() + "/" + p.getCicloInfToInt() +
                        "/" + p.toStringTools() + "/" + p.getNrJogadasToString() + "/" + p.getEstadoToInt();
                ps.println(result);
            }
            ps.println(boardApps.size());
            for (BoardApps app : boardApps) {
                String result = "" + app.getTypeOfBoradApp() + "/" + app.getId() + "/" + app.getPosicao();
                if (app.isAbyss()) {
                    result += "/" + ((Abyss) app).getTimesUsed();
                }
                ps.println(result);

            }
            ps.println(turno.getNrTurnos());
            ps.println(turno.getProgramadorAtual().getName());
            ps.close();
            return true;
        } catch (java.io.FileNotFoundException e) {
            return false;
        }
    }

    public boolean loadGame(File file) {
        programadores.clear();
        boardApps.clear();
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (java.io.FileNotFoundException e) {
            return false;
        }
        Scanner scan = new Scanner(fis);
        String line = scan.nextLine();
        tamanhoTab = Integer.parseInt(line);

        line = scan.nextLine();
        int nrJogadores = Integer.parseInt(line);

        for (int g = 0; g < nrJogadores; g++) {
            line = scan.nextLine();
            String[] data = line.split("/");
            Programmer p = new Programmer(Integer.parseInt(data[0]),
                    data[1],
                    ProgrammerColor.valueOf(data[2].toUpperCase()),
                    HelpfullFunctions.linguagensDeProg(data[3]),
                    Integer.parseInt(data[4]),
                    HelpfullFunctions.stringToBoolean(data[5]),
                    HelpfullFunctions.tools(data[6]),
                    HelpfullFunctions.pos(data[7]),
                    HelpfullFunctions.stringToBoolean(data[8]));
            programadores.add(p);
        }

        line = scan.nextLine();
        if (line == null || line.equals("")) {

            line = scan.nextLine();
            int nrTurnos = Integer.parseInt(line);

            line = scan.nextLine();
            Programmer atual = new Programmer();
            for (Programmer p : programadores) {
                if (p.getName().equals(line)) {
                    atual = p;
                }
            }
            turno = new Turn(programadores, atual);
            turno.setNrTurnos(nrTurnos);

            return true;
        }

        int boardAppsSize = Integer.parseInt(line);

        for (int g = 0; g < boardAppsSize; g++) {
            line = scan.nextLine();
            String[] data = line.split("/");
            BoardApps boardApp = switch (Integer.parseInt(data[0])) {
                case 0 -> switch (Integer.parseInt(data[1])) {
                    case 0 -> new SyntaxError(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 1 -> new LogicError(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 2 -> new Exception(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 3 -> new FileNotFoundException(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 4 -> new Crash(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 5 -> new DuplicatedCode(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 6 -> new SideEffects(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 7 -> new BlueScreenOfDeath(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 8 -> new InfiniteCicle(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    case 9 -> new SegmentationFault(Integer.parseInt(data[2]), Integer.parseInt(data[3]), programadores);
                    default -> new SegmentationFault(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                };
                case 1 -> switch (Integer.parseInt(data[1])) {
                    case 0 -> new Heritage(Integer.parseInt(data[2]));
                    case 1 -> new FunctionalProgramming(Integer.parseInt(data[2]));
                    case 2 -> new UnityTests(Integer.parseInt(data[2]));
                    case 3 -> new ExceptionHandling(Integer.parseInt(data[2]));
                    case 4 -> new IDE(Integer.parseInt(data[2]));
                    case 5 -> new TeacherHelp(Integer.parseInt(data[2]));
                    default -> new TeacherHelp(Integer.parseInt(data[2]));
                };
                default -> new TeacherHelp(Integer.parseInt(data[2]));
            };
            boardApps.add(boardApp);
        }

        line = scan.nextLine();
        int nrTurnos = Integer.parseInt(line);

        line = scan.nextLine();
        Programmer atual = new Programmer();
        ArrayList<Programmer> temp = new ArrayList<>();
        for (Programmer p : programadores) {
            if (p.getName().equals(line)) {
                atual = p;
            }
        }
        programadores.remove(atual);
        temp.add(atual);
        temp.addAll(programadores);
        programadores.clear();
        programadores.addAll(temp);

        turno = new Turn(programadores, atual);
        turno.setNrTurnos(nrTurnos);

        return true;
    }

}