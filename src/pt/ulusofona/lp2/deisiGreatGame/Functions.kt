package pt.ulusofona.lp2.deisiGreatGame

fun router() : Function1<CommandType,Function2<GameManager,List<String>,String?>> {
    return :: getCommandType
}

fun getCommandType(type: CommandType) : Function2<GameManager,List<String>,String?> {
    return when (type){
        CommandType.GET -> :: getFunsGet
        CommandType.POST -> :: getFunsPost
    }
}

fun getFunsGet (manager : GameManager, list : List<String>) : String?{
    return when (list[0]){
        "PLAYER" -> players(manager,list[1])
        "PLAYERS_BY_LANGUAGE" -> playerByLanguage(manager,list[1])
        "POLYGLOTS" -> polyglots(manager)
        "MOST_USED_POSITIONS" -> mostUsedPositions(manager,list[1])
        "MOST_USED_ABYSSES" -> mostUsedAbyss(manager,list[1])
        else -> null
    }
}

fun getFunsPost (manager : GameManager, list : List<String>) : String?{
    return when (list[0]){
        "MOVE" -> postMove(manager,list[1])
        "ABYSS" -> postAbyss(manager,list[1],list[2])
        else -> null
    }
}

fun players (manager : GameManager, nome : String) : String?{

    val player = manager.getProgrammers(true)
    val playerFound : String = player.filter{ HelpfullFunctions.firstName( it.name ) == nome }
        .map { it.toString() }
        .distinct().toString()

    if(playerFound == "[]"){
        return "Inexistent player"
    }
    return playerFound.replace("[" , "").replace("]","")
}

fun playerByLanguage (manager : GameManager, linguagem : String) : String?{

    val player = manager.getProgrammers(true)
    val playerFound : String = player.filter { HelpfullFunctions.existeLinguagem(it.linguagensProg, linguagem) }
        .map { it.name }.toString()

    if(playerFound == "[]"){
        return ""
    }

    return playerFound.replace("[","").replace("]","").replace(", ",",")
}

fun polyglots(manager: GameManager): String {

    val player = manager.getProgrammers(true)

    return player.filter { it.numeroLinguagens >= 2 }
        .sortedWith { i1, i2 -> i1.numeroLinguagens - i2.numeroLinguagens }
        .joinToString("\n") { it.name + ":" + it.numeroLinguagens };
}

fun mostUsedPositions(manager: GameManager, nrResults : String): String{
    val player = manager.positions
    val results = nrResults.toInt()


    return player.filter { it.nrFootSteps > 0 }
        .sortedWith { i1, i2 -> i2.nrFootSteps - i1.nrFootSteps }
        .take(results)
        .joinToString("\n") { it.numPosition.toString() + ":" + it.nrFootSteps }
}

fun mostUsedAbyss(manager: GameManager, nrResults : String): String{
    val player = manager.boardApps
    val results = nrResults.toInt()


    return player.filter { it.isAbyss }
        .sortedWith { i1, i2 -> (i2 as Abyss).timesUsed - (i1 as Abyss).timesUsed }
        .take(results)
        .joinToString("\n") { it.getTitulo().toString() + ":" + (it as Abyss).timesUsed }
}

fun postMove(manager : GameManager, nrCasas : String): String?{

   var result : String? = ""
   manager.moveCurrentPlayer(nrCasas.toInt())
    result = manager.reactToAbyssOrTool()
    return result ?: "OK"
}

fun postAbyss(manager : GameManager, abyssTypeId : String, position : String) : String?{

    if (manager.posicaoOcupada(position.toInt())){
        return "Position is occupied."
    }
    manager.addAbyss(position.toInt(),abyssTypeId);
    return "OK";
}


