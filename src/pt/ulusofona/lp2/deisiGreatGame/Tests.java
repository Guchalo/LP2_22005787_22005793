package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class Tests {


    @Test
    public void testMoveCurrentPlayer1() {
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
        manager.createInitialBoard(playerInfo, 15);
        assertTrue(manager.moveCurrentPlayer(5));
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
        manager.createInitialBoard(playerInfo, 15);
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
        manager.createInitialBoard(playerInfo, 4);
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
        manager.createInitialBoard(playerInfo, 5);
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
        assertTrue(manager.createInitialBoard(playerInfo, 15));
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
        assertFalse(manager.createInitialBoard(playerInfo, 3));
    }

    @Test
    public void testAddProgrammer1() {
        GameManager manager = new GameManager();
        ArrayList<String> lp = new ArrayList<>();
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

    }

    @Test
    public void testGetProgrammer() {

        ArrayList<String> lp = new ArrayList<>();
        lp.add("Java");
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
        assertEquals(4,manager.getProgrammers(true).size());
        assertEquals(3,manager.getProgrammers(false).size());

    }

    @Test
    public void testBSD(){
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
        manager.createInitialBoard(playerInfo, 15,tools);
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        System.out.println(manager.getProgrammers());
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        System.out.println(manager.getProgrammers());
    }

    @Test
    public void testBSOD02(){
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
        manager.createInitialBoard(playerInfo, 15,tools);
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        System.out.println(manager.getProgrammers(true));
    }
}
