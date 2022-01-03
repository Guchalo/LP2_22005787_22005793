package pt.ulusofona.lp2.deisiGreatGame;

public enum CommandType {

    GET("GET"),POST("POST");

    private final String type;

    CommandType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type.toString();
    }

    @Override
    public String toString() {
        return type;
    }
}
