package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Tests {


    @Test
    public void testeMoveCurrentPlayer1(){
       GameManager manager = new GameManager();
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
       manager.createInitialBoard(playerInfo,15);
       assertTrue(manager.moveCurrentPlayer(5));
    }

    @Test
    public void testeMoveCurrentPlayer2(){
        GameManager manager = new GameManager();
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        manager.createInitialBoard(playerInfo,15);
        assertFalse(manager.moveCurrentPlayer(8));
    }

    @Test
    public void testeMoveCurrentPlayer3(){
        GameManager manager = new GameManager();
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        manager.createInitialBoard(playerInfo,4);
        assertTrue(manager.moveCurrentPlayer(5));
    }

    @Test
    public void testeMoveCurrentPlayer4(){
        GameManager manager = new GameManager();
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "3";
        playerInfo[0][1] = "Boda";
        playerInfo[0][2] = "Python;SQL";
        playerInfo[0][3] = "PURPLE";
        playerInfo[1][0] = "2735";
        playerInfo[1][1] = "JJ";
        playerInfo[1][2] = "Kotlin;C";
        playerInfo[1][3] = "GREEN";
        manager.createInitialBoard(playerInfo,5);
        assertFalse(manager.moveCurrentPlayer(-5));

    }



}
