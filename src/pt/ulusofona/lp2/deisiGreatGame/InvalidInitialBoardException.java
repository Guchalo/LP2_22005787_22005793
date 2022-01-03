package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends java.lang.Exception {

    String mensagem;
    BoardApps boardApp;


    public InvalidInitialBoardException(String mensagem) {
        this.mensagem = mensagem;
    }

    public InvalidInitialBoardException(String mensagem, BoardApps boardApp) {
        this.mensagem = mensagem;
        this.boardApp = boardApp;
    }


    public String getMessage() {
        return mensagem;
    }

    public boolean isInvalidAbyss() {
        if (boardApp == null) {
            return false;
        }
        return boardApp.isAbyss();
    }

    public boolean isInvalidTool() {
        if (boardApp == null) {
            return false;
        }
        return boardApp.isTool();
    }

    public String getTypeId() {
        return "" + boardApp.getId();
    }
}
