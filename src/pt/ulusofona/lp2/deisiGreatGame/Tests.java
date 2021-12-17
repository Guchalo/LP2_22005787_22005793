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
        /* Teste para programadores iguais */
        assertFalse(HelpfullFunctions.compararProgrammer(p4, p4));
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
        manager.createInitialBoard(playerInfo, 15, tools);
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        System.out.println(manager.getProgrammers(true));
    }

    @Test
    public void testcicloInfinito() {
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        assertEquals("Só precisas de partir a pedra para te tornares num caçador mas a pedra nem racha, será que vais ter " +
                "ajuda?",manager.reactToAbyssOrTool());
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        assertFalse(manager.moveCurrentPlayer(2));
        manager.moveCurrentPlayer(1);
        assertEquals("Ajudas-te o caçador que estava preso a partir a pedra, porem tu ficaste para a partir sozinho, " +
                "ou até alguem te vir ajudar",manager.reactToAbyssOrTool());
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        assertEquals("Os teus companheiros deixaram-te pendurado, continua sem eles"
                ,manager.reactToAbyssOrTool());
        manager.moveCurrentPlayer(2);
        assertEquals("Depois de esperares pelos teus companheiros vocês reparam que não estão na estação do " +
                "Mugen Train e recuam 3 casas",manager.reactToAbyssOrTool());
    }

    @Test
    public void testSegmentacion2(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
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
        assertEquals(5,manager.getProgrammers(true).get(0).getPos());
        assertEquals(1,manager.getProgrammers(true).get(1).getPos());
        assertEquals(1,manager.getProgrammers(true).get(2).getPos());

    }

    @Test
    public void testCrash(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testDuplicatedCode(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testException(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(2,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testFileNotFoundException(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(2,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testLogicError(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(3,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testSideEffects(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(1,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testSyntaxError(){
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(3);
        manager.reactToAbyssOrTool();
        assertEquals(4,manager.getTurno().getProgramadorAtual().getPos());
    }

    @Test
    public void testBoardApps(){
        BoardApps apps = new TeacherHelp(3);
        assertEquals(3,apps.getPosicao());
        assertEquals("T",apps.getIdentificadorAT());
        assertEquals(5,apps.getId());
        assertEquals("rengoku.png",apps.getImagem());
        assertEquals("Ajuda Do Professor",apps.getTitulo());
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(1);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(4,manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools",manager.getTurno().getProgramadorAtual().toStringTools());
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
        manager.createInitialBoard(playerInfo, 15, tools);
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

        assertEquals(10,manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools",manager.getTurno().getProgramadorAtual().toStringTools());
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
        manager.createInitialBoard(playerInfo, 15, tools);
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(2);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(5);
        manager.reactToAbyssOrTool();
        manager.moveCurrentPlayer(4);
        manager.reactToAbyssOrTool();
        assertEquals(10,manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools",manager.getTurno().getProgramadorAtual().toStringTools());
    }

    @Test
    public void testProgrammerColor(){
        ProgrammerColor cor = ProgrammerColor.valueOf("PURPLE");
        assertEquals("Purple",cor.toString());
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
        manager.createInitialBoard(playerInfo, 15, tools);
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
        assertEquals(10,manager.getTurno().getProgramadorAtual().getPos());
        assertEquals("No tools",manager.getTurno().getProgramadorAtual().toStringTools());
    }

}


