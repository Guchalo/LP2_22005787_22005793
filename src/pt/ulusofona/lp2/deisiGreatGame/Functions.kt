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
    when (list[0]){
        "PLAYER" -> return players(manager,list[1])
        "PLAYERS_BY_LANGUAGE" -> return playerByLanguage(manager,list[1])
        "POLYGLOTS" -> return polyglots(manager)
        "MOST_USED_POSITIONS" -> return players(manager,list[1])
        "MOST_USED_ABYSSES" -> return players(manager,list[1])
        else -> return null
    }
}

fun getFunsPost (manager : GameManager, list : List<String>) : String?{
    when (list[0]){
        "MOVE" -> return players(manager,list[1])
        "ABYSS" -> return players(manager,list[1])
        else -> return null
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

    return playerFound.replace("[","").replace("]","").replace(", ",",")
}

fun polyglots(manager : GameManager) : String{

    val player = manager.getProgrammers(true)
    val playerFound : String = player.filter{ it.numeroLinguagens >= 2 }
        .sortedWith{ i1,i2 -> i1.numeroLinguagens - i2.numeroLinguagens }
        .map { it.name + ":" + it.numeroLinguagens }
        .joinToString ("\n")

    return playerFound;
}

fun mostUsedPositions(){



}


