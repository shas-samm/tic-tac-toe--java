package LLD.TicTacToe;

public class Cell {
    private int row;
    private int col;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Symbol getCellSymbol() {
        return symbol;
    }

    public boolean isEmpty() {
        return symbol == null;
    }

    public void setSymbol(Symbol symbol) {
        if(this.isEmpty()) {
            this.symbol = symbol;
        } else {
            throw new IllegalArgumentException("Cell is already occupied");
        }
    }
}
