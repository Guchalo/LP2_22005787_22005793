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
        "PLAYERS_BY_LANGUAGE" -> return players(manager,list[1])
        "POLYGLOTS" -> return players(manager,list[1])
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
    return "Inexistent player"
}
