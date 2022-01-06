package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class Tests {

    @Test
    public void testMoveCurrentPlayerAndPosicions() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(3, manager.getCurrentPlayerID());
        assertEquals(0, manager.getBoardApps().size());
        assertTrue(manager.moveCurrentPlayer(2));
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertEquals(manager.getPositions().get(3).getNumPosition(), 3);
        assertEquals(manager.getPositions().get(3).getNrFootSteps(), 2);
        assertEquals(manager.getPositions().get(3).toString(), "3:2");

    }

    @Test
    public void testMoveCurrentPlayer2() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertFalse(manager.moveCurrentPlayer(8));
    }

    @Test
    public void testMoveCurrentPlayer3() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 4);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(manager.moveCurrentPlayer(5));
    }

    @Test
    public void testMoveCurrentPlayer4() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 5);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(1, manager.getTurno().getNrTurnos());
        assertFalse(manager.moveCurrentPlayer(-5));

    }

    @Test
    public void testCreateInitialBoard1() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testCreateInitialBoard2() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 3);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testCreateInicialBoard3() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "8";
        tools[0][2] = null;
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testAddProgrammer1() {
        GameManager manager = new GameManager();
        ArrayList<String> lp = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        lp.add("Java");
        Programmer pTest = new Programmer(10, "Testador", ProgrammerColor.BROWN, lp);
        assertTrue(manager.addProgrammer(pTest));
    }

    @Test
    public void testAddProgrammer2() {
        GameManager manager = new GameManager();
        Programmer pTest = new Programmer();
        assertFalse(manager.addProgrammer(pTest));
    }

    @Test
    public void testVerificarString() {
        String g = "";
        String r = "NHAAAAAA";
        assertFalse(HelpfullFunctions.verificarString(g));
        assertTrue(HelpfullFunctions.verificarString(r));
    }

    @Test
    public void testVerificarColor() {
        String[][] playerInfoT = new String[2][4];
        playerInfoT[0][0] = "3";
        playerInfoT[0][1] = "Boda";
        playerInfoT[0][2] = "Python;SQL";
        playerInfoT[0][3] = "PURPLE";
        playerInfoT[1][0] = "2735";
        playerInfoT[1][1] = "JJ";
        playerInfoT[1][2] = "Kotlin;C";
        playerInfoT[1][3] = "GREEN";
        assertTrue(HelpfullFunctions.verificarColor(playerInfoT));

        String[][] playerInfoF = new String[2][4];
        playerInfoF[0][0] = "3";
        playerInfoF[0][1] = "Boda";
        playerInfoF[0][2] = "Python;SQL";
        playerInfoF[0][3] = "ORANGE";
        playerInfoF[1][0] = "2735";
        playerInfoF[1][1] = "JJ";
        playerInfoF[1][2] = "Kotlin;C";
        playerInfoF[1][3] = "GREEN";
        assertFalse(HelpfullFunctions.verificarColor(playerInfoF));
    }

    @Test
    public void testVerificarProgrammer() {
        ArrayList<String> lp = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        lp.add("Java");
        Programmer p1 = new Programmer(12, "Joaquim", ProgrammerColor.GREEN, lp);
        Programmer p2 = new Programmer(1, "António", ProgrammerColor.PURPLE, lp);
        Programmer p3 = new Programmer(10, "Fernando", ProgrammerColor.BROWN, lp);
        Programmer p4 = new Programmer(10, "Armando", ProgrammerColor.PURPLE, lp);


        assertTrue(HelpfullFunctions.compararProgrammer(p1, p2));
        /* Teste para cores iguais */
        assertFalse(HelpfullFunctions.compararProgrammer(p4, p2));
        /* Teste para id's iguais */
        assertFalse(HelpfullFunctions.compararProgrammer(p3, p4));
        /* Teste para programadores iguais */
        assertFalse(HelpfullFunctions.compararProgrammer(p4, p4));
    }

    @Test
    public void testGetProgrammer() {

        ArrayList<String> lp = new ArrayList<>();
        lp.add("Java");
        ArrayList<Position> positions = new ArrayList<>();
        Programmer p1 = new Programmer(12, "Joaquim", ProgrammerColor.GREEN, lp);
        Programmer p2 = new Programmer(1, "António", ProgrammerColor.PURPLE, lp);
        Programmer p3 = new Programmer(10, "Fernando", ProgrammerColor.BROWN, lp);
        Programmer p4 = new Programmer(10, "Armando", ProgrammerColor.PURPLE, lp);
        p1.derrotado();
        ArrayList<Programmer> programadores = new ArrayList<>();
        programadores.add(p1);
        programadores.add(p2);
        programadores.add(p3);
        programadores.add(p4);
        GameManager manager = new GameManager(programadores);
        assertEquals(4, manager.getProgrammers(true).size());
        assertEquals(3, manager.getProgrammers(false).size());

    }

    @Test
    public void testBSD() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "7";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertEquals(manager.getProgrammersInfo(),"JJ : No tools");
        assertFalse(manager.getProgrammers(true).get(0).getEstado());
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertFalse(manager.getProgrammers(true).get(0).getEstado());
        assertEquals(manager.getProgrammers(true).get(0).getPos(), 3);
        assertNull(manager.getTitle(-1));
        assertEquals(manager.getImagePng(15),"finishLine50x50.png");
        assertEquals(manager.getImagePng(3),"haganezuka.png");
        assertNull(manager.getImagePng(1));

    }

    @Test
    public void testBSOD02() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[3][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "7";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        playerInfo[2][0] = "2";
        playerInfo[2][1] = "Antonio";
        playerInfo[2][2] = "Java";
        playerInfo[2][3] = "BLUE";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        System.out.println(manager.getProgrammers(true));
    }

    @Test
    public void testCicloInfinito() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "8";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        assertEquals("Só precisas de partir a pedra para te tornares num caçador mas a pedra nem racha, será que vais ter " +
                "ajuda?", manager.reactToAbyssOrTool());
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        assertFalse(manager.moveCurrentPlayer(2));
        manager.moveCurrentPlayer(1);
        assertEquals("Ajudas-te o caçador que estava preso a partir a pedra, porem tu ficaste para a partir sozinho, " +
                "ou até alguem te vir ajudar", manager.reactToAbyssOrTool());
    }

    @Test
    public void testSegmetacion() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "9";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        assertEquals("Os teus companheiros deixaram-te pendurado, continua sem eles"
                , manager.reactToAbyssOrTool());
        manager.moveCurrentPlayer(2);
        assertEquals("Depois de esperares pelos teus companheiros vocês reparam que não estão na estação do " +
                "Mugen Train e recuam 3 casas", manager.reactToAbyssOrTool());
    }

    @Test
    public void testSegmentacion2() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[3][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "9";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        playerInfo[2][0] = "2";
        playerInfo[2][1] = "Antonio";
        playerInfo[2][2] = "Java";
        playerInfo[2][3] = "BLUE";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        assertEquals(5, manager.getProgrammers(true).get(0).getPos());
        assertEquals(1, manager.getProgrammers(true).get(1).getPos());
        assertEquals(1, manager.getProgrammers(true).get(2).getPos());

    }

    @Test
    public void testCrash() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "4";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testDuplicatedCode() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "5";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testException() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "2";
        tools[0][2] = "4";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(2, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testFileNotFoundException() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "3";
        tools[0][2] = "5";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(2, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testLogicError() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "1";
        tools[0][2] = "5";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(3, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testSideEffects() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "6";
        tools[0][2] = "5";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testSyntaxError() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[1][3];
        tools[0][0] = "0";
        tools[0][1] = "0";
        tools[0][2] = "5";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(4, manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testBoardApps() {
        BoardApps apps = new TeacherHelp(3);
        assertEquals(3, apps.getPosicao());
        assertEquals("T", apps.getIdentificadorAT());
        assertEquals(5, apps.getId());
        assertEquals("rengoku.png", apps.getImagem());
        assertEquals("Ajuda Do Professor", apps.getTitulo());
    }

    @Test
    public void testIDE() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[2][3];
        tools[1][0] = "0";
        tools[1][1] = "0";
        tools[1][2] = "4";
        tools[0][0] = "1";
        tools[0][1] = "4";
        tools[0][2] = "3";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(4, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());
        assertTrue(manager.getBoardApps().get(0).isTool());
        assertEquals(manager.getBoardApps().get(0).getTypeOfBoradApp(), "1");
    }

    @Test
    public void testHeranca() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "5";
        tools[0][2] = "10"; //
        tools[1][0] = "0";
        tools[1][1] = "5";
        tools[1][2] = "5"; //
        tools[2][0] = "1";
        tools[2][1] = "0";
        tools[2][2] = "6"; //
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(5);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();

        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());
    }

    @Test
    public void testTestesUnitarios() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[2][3];
        tools[1][0] = "0";
        tools[1][1] = "1";
        tools[1][2] = "10";
        tools[0][0] = "1";
        tools[0][1] = "2";
        tools[0][2] = "5";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(5);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());
    }

    @Test
    public void testProgrammerColor() {
        ProgrammerColor cor = ProgrammerColor.valueOf("PURPLE");
        assertEquals("Purple", cor.toString());
    }

    @Test
    public void testTeacherHelp() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "3";
        tools[0][2] = "10"; //
        tools[1][0] = "0";
        tools[1][1] = "3";
        tools[1][2] = "5"; //
        tools[2][0] = "1";
        tools[2][1] = "5";
        tools[2][2] = "6"; //
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());
    }

    @Test
    public void testExceptionHandlingTeacherHelp() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "3";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "3";
        tools[1][2] = "4";
        tools[2][0] = "0";
        tools[2][1] = "3";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());

    }

    @Test
    public void sideEffectsFunctionalprogramming() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "6";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "1";
        tools[1][2] = "4";
        tools[2][0] = "0";
        tools[2][1] = "6";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());
    }

    @Test
    public void testExceptionHandling_Exception() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "2";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "3";
        tools[1][2] = "4";
        tools[2][0] = "0";
        tools[2][1] = "2";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());

    }

    @Test
    public void testTeacherHelp_Exception() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "2";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "5";
        tools[1][2] = "4";
        tools[2][0] = "0";
        tools[2][1] = "2";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getTurno().getProgramadorAtual().toStringTools());

    }

    @Test
    public void FunctionalProgramming_InfinteCicle() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[3][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "8";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "1";
        tools[1][2] = "6";
        tools[2][0] = "1";
        tools[2][1] = "1";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        playerInfo[2][0] = "2";
        playerInfo[2][1] = "Antonio";
        playerInfo[2][2] = "Java";
        playerInfo[2][3] = "BLUE";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(5);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(6);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10, manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools", manager.getProgrammers().get(2).toStringTools());

        ArrayList<String> lp = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        lp.add("Java");
        List<Tool> tools1 = new ArrayList<>();
        tools1.add(new FunctionalProgramming());
        Programmer p = new Programmer(3, "Anibal",
                ProgrammerColor.BROWN, lp, 3, false, tools1, positions, true);
        InfiniteCicle ic = new InfiniteCicle(2);
        assertEquals(ic.react(p), "Como dominaste a tecnica de Respiração Total, partir a pedra foi uma tarefa fácil");

    }

    @Test
    public void testAuthorsPanel() {
        GameManager manager = new GameManager();
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

        assertEquals(painel.getComponentCount(), manager.getAuthorsPanel().getComponentCount());

    }

    @Test
    public void testBoardApps2() {
        BlueScreenOfDeath BSD = new BlueScreenOfDeath(2, 0);
        assertEquals(BSD.getTimesUsed(), 0);
        assertEquals(BSD.getIdentificadorAT(), "A");
        assertEquals(BSD.getTypeOfBoradApp(), "0");
        BSD.aumentarTimesUsed();
        assertEquals(BSD.getTimesUsed(), 1);
        IDE ide = new IDE();
        assertEquals(ide.getIdentificadorAT(), "T");
    }

    @Test
    public void constructorAbyss() {
        Crash crash = new Crash(1, 1);
        DuplicatedCode dP = new DuplicatedCode(2, 2);
        Exception exception = new Exception(3, 3);
        LogicError logicError = new LogicError(9, 9);
        FileNotFoundException fileNotFoundException = new FileNotFoundException(4, 4);
        InfiniteCicle infiniteCicle = new InfiniteCicle(5, 5);
        SegmentationFault segmentationFault = new SegmentationFault(6, 6);
        SegmentationFault sFWithProgrammers = new SegmentationFault(6, 6, new ArrayList<>());
        SideEffects sideEffects = new SideEffects(7, 7);
        SyntaxError syntaxError = new SyntaxError(8, 8);
        assertTrue(crash.isAbyss());
        assertTrue(dP.isAbyss());
        assertTrue(exception.isAbyss());
        assertTrue(fileNotFoundException.isAbyss());
        assertTrue(infiniteCicle.isAbyss());
        assertTrue(segmentationFault.isAbyss());
        assertTrue(sFWithProgrammers.isAbyss());
        assertTrue(sideEffects.isAbyss());
        assertTrue(syntaxError.isAbyss());
        assertTrue(logicError.isAbyss());
    }

    @Test
    public void testConstructorTools() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        FunctionalProgramming functionalProgramming = new FunctionalProgramming();
        Heritage heritage = new Heritage();
        IDE ide = new IDE();
        TeacherHelp teacherHelp = new TeacherHelp();
        UnityTests unityTests = new UnityTests();
        assertTrue(exceptionHandling.isTool());
        assertTrue(functionalProgramming.isTool());
        assertTrue(heritage.isTool());
        assertTrue(ide.isTool());
        assertTrue(teacherHelp.isTool());
        assertTrue(unityTests.isTool());
    }

    @Test
    public void testCommandType() {
        CommandType get = CommandType.GET;
        assertEquals(get.name(), "GET");
    }

    @Test
    public void testTurn() {
        ArrayList<String> lp = new ArrayList<>();
        lp.add("Java");
        ArrayList<Position> positions = new ArrayList<>();
        Programmer p1 = new Programmer(12, "Joaquim", ProgrammerColor.GREEN, lp);
        Programmer p2 = new Programmer(1, "António", ProgrammerColor.PURPLE, lp);
        Programmer p3 = new Programmer(10, "Fernando", ProgrammerColor.BROWN, lp);
        Programmer p4 = new Programmer(10, "Armando", ProgrammerColor.PURPLE, lp);
        ArrayList<Programmer> programadores = new ArrayList<>();
        programadores.add(p1);
        programadores.add(p2);
        programadores.add(p3);
        programadores.add(p4);

        Turn turno = new Turn(programadores, p1, 0);
        turno.setNrTurnos(2);
        assertEquals(turno.getProgramadorAtual(), p1);
        assertEquals(turno.getNrTurnos(), 2);
    }

    @Test
    public void testSyntaxErrorTeacherHelp() {
        ArrayList<String> lp = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();
        lp.add("Java");
        List<Tool> tools1 = new ArrayList<>();
        tools1.add(new TeacherHelp());
        Programmer p = new Programmer(3, "Anibal",
                ProgrammerColor.BROWN, lp, 3, false, tools1, positions, true);
        SyntaxError se = new SyntaxError(1);
        assertEquals(se.react(p), "Como tens o Rengoku do teu lado, ele avisa te da armadilha e consegues evitá-la," +
                " mas como tu falhaste ao detetar uma armadilha muito óbvia e ele abandonou-te.");
    }

    @Test
    public void testGetTitleAndGetImage() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[3][4];
        String[][] tools = new String[3][3];
        tools[0][0] = "0";
        tools[0][1] = "8";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "1";
        tools[1][2] = "6";
        tools[2][0] = "1";
        tools[2][1] = "1";
        tools[2][2] = "10";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        playerInfo[2][0] = "2";
        playerInfo[2][1] = "Antonio";
        playerInfo[2][2] = "Java";
        playerInfo[2][3] = "BLUE";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull(manager.getTitle(0));
        assertNull(manager.getTitle(17));
        assertEquals(manager.getTitle(10), "Programação Funcional");
    }

    @Test
    public void testInvalidInicialBoardException() {
        InvalidInitialBoardException e = new InvalidInitialBoardException("Teste", new Exception(1));
        InvalidInitialBoardException b = new InvalidInitialBoardException("Teste");
        InvalidInitialBoardException a = new InvalidInitialBoardException("Teste", new TeacherHelp());
        assertFalse(e.isInvalidTool());
        assertTrue(e.isInvalidAbyss());
        assertTrue(a.isInvalidTool());
        assertFalse(a.isInvalidAbyss());
        assertEquals(e.getTypeId(), "2");
        assertFalse(b.isInvalidAbyss());
        assertFalse(b.isInvalidTool());
    }

    @Test
    public void testProgrammer() {
        ArrayList<String> lp = new ArrayList<>();
        lp.add("Java");
        Programmer p = new Programmer(3, "Anibal", ProgrammerColor.BROWN, lp);
        assertFalse(p.temFP());
        FunctionalProgramming fp = new FunctionalProgramming();
        p.adicionarTool(fp);
        assertFalse(p.temIDE());
        p.adicionarTool(new IDE());
        p.adicionarTool(new FunctionalProgramming());
        assertFalse(p.temHeranca());
        assertFalse(p.temTH());
        assertFalse(p.temUT());
        assertFalse(p.temEA());
        assertEquals(p.toStringTools(),"Programação Funcional;IDE");
        assertEquals(p.getTools().get(0),fp);
        assertEquals(p.getNumeroLinguagens(),1);
        assertEquals(p.getNrJogadas().toString(),"[]");
        assertEquals(p.getImage(),"Brown");
        assertEquals(p.getEstadoToInt(),1);
        assertEquals(p.getCicloInfToInt(),0);
        assertEquals(p.getNrJogadasToString(),"0");

        ArrayList<Integer> positions = new ArrayList<>();
        positions.add(2);
        positions.add(2);
        List<Tool> tools1 = new ArrayList<>();
        tools1.add(new FunctionalProgramming());
        Programmer p1 = new Programmer(3, "Anibal",
                ProgrammerColor.BROWN, lp, 3, true, tools1, positions, false);
        assertEquals(p1.getEstadoToInt(),0);
        assertEquals(p1.getCicloInfToInt(),1);
        assertEquals(p1.getNrJogadasToString(),"2;2");
    }

    @Test
    public void testeExisteLinguagem() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";


        assertTrue(HelpfullFunctions.existeLinguagem(playerInfo[1][2],"Kotlin"));
    }

    @Test
    public void sideEffectsFunctionalprogrammingToStringTools() {
        GameManager manager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String[][] tools = new String[4][3];
        tools[0][0] = "0";
        tools[0][1] = "6";
        tools[0][2] = "5";
        tools[1][0] = "1";
        tools[1][1] = "1";
        tools[1][2] = "4";
        tools[2][0] = "0";
        tools[2][1] = "6";
        tools[2][2] = "10";
        tools[3][0] = "1";
        tools[3][1] = "5";
        tools[3][2] = "7";
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        try {
            manager.createInitialBoard(playerInfo, 15, tools);
        } catch (InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        assertEquals("Programação Funcional;Ajuda Do Professor",manager.getTurno().getProgramadorAtual().toStringTools());
    }


    @Test
    public void testeTools(){

        List<Tool> tools = HelpfullFunctions.tools("Programação Funcional;Ajuda Do Professor;Tratamento de Excepções;" +
                "Herança;Testes unitários;IDE");
        assertEquals("Programação Funcional",tools.get(0).getTitulo());

    }

    @Test
    public void pos(){

        ArrayList<Integer> teste = new ArrayList<>();
        teste.add(1);
        teste.add(2);
        teste.add(3);
        teste.add(4);
        teste.add(5);

        ArrayList<Integer> teste2 = HelpfullFunctions.pos("1;2;3;4;5");

        assertEquals(teste,teste2);



    }

    @Test
    public void firstName(){

        String nome = "Tanjiro";

        String teste2 = HelpfullFunctions.firstName("Tanjiro Kamado");

        assertEquals(nome,teste2);



    }

}