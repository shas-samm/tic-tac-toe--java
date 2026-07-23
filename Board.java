package LLD.TicTacToe;

public class Board {
    private int size;
    private Cell[][] cells;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }
    
    public void placeSymbol(int row, int col , Symbol symbol) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid Cell Position");
        }
        if(!cells[row][col].isEmpty()) {
            throw new IllegalArgumentException("Cell is already Occupied");
        }
        cells[row][col].setSymbol(symbol); // we used setter method to restore the metadata integrity of the cell class.
    }

    public boolean isBoardFull() {
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                if(cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                if(cells[i][j].isEmpty()) {
                    System.out.print("- ");
                } else {
                    System.out.print(cells[i][j].getCellSymbol().getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid Cell Position");
        }
        return cells[row][col];
    }

}
