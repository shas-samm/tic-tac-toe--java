package LLD.TicTacToe;

public class Player {
    private int playerId;
    private String playerName;
    private Symbol playerSymbol;

    public Player(int playerId , String playerName, Symbol playerSymbol) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }
}
