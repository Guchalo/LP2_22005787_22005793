package pt.ulusofona.lp2.deisiGreatGame

import org.junit.Test
import kotlin.test.assertEquals

class TestsKotlin {

    @Test
    fun testRouter(){
        val manager = GameManager()
        val playerInfo = Array(2) {
            arrayOfNulls<String>(4)
        }
        val tools = Array(3) {
            arrayOfNulls<String>(3)
        }
        tools[0][0] = "0"
        tools[0][1] = "5"
        tools[0][2] = "10"
        tools[1][0] = "0"
        tools[1][1] = "5"
        tools[1][2] = "5"
        tools[2][0] = "1"
        tools[2][1] = "0"
        tools[2][2] = "6"
        playerInfo[0][0] = "3"
        playerInfo[0][1] = "Boda"
        playerInfo[0][2] = "Python;SQL;C"
        playerInfo[0][3] = "PURPLE"
        playerInfo[1][0] = "2735"
        playerInfo[1][1] = "JJ"
        playerInfo[1][2] = "Kotlin;C"
        playerInfo[1][3] = "GREEN"
        try {
            manager.createInitialBoard(playerInfo, 15, tools)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }
        manager.moveCurrentPlayer(4)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(2)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(5)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(4)
        manager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val commandPostFn = routerFn.invoke(CommandType.POST)
        var result = commandGetFn.invoke(manager, listOf("PLAYER", "Boda"))
        assertEquals(result,"3 | Boda | 6 | Herança | C; Python; SQL | Em Jogo")

        result = commandGetFn.invoke(manager, listOf("PLAYER", "Jesus"))
        assertEquals(result,"Inexistent player")

        result = commandGetFn.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "C"))
        assertEquals(result,"Boda,JJ")

        result = commandGetFn.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "Java"))
        assertEquals(result,"")

        result = commandGetFn.invoke(manager, listOf("POLYGLOTS"))
        assertEquals(result,"JJ:2\n" + "Boda:3")

        result = commandGetFn.invoke(manager, listOf("MOST_USED_POSITIONS", "2"))
        assertEquals(result,"3:1\n" + "5:1")

        result = commandGetFn.invoke(manager, listOf("MOST_USED_ABYSSES", "2"))
        assertEquals(result,"Duplicated Code:1")

        result = commandPostFn.invoke(manager, listOf("MOVE", "2"))
        assertEquals(result,"OK")

        result = commandPostFn.invoke(manager, listOf("ABYSS", "2", "2"))
        assertEquals(result,"OK")

        result = commandPostFn.invoke(manager, listOf("ABYSS", "2", "6"))
        assertEquals(result,"Position is occupied.")
    }
}