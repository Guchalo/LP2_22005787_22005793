package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType (private val type: String) {
    GET("GET"),POST("POST");

    fun getType(): String {
        return type
    }

    override fun toString(): String {
        return type
    }
}

