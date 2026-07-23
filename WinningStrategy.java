package LLD.TicTacToe;

public interface WinningStrategy {
    boolean checkWin(Board board, int row, int col, Symbol symbol);
}

class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        for (int j = 0; j < board.getSize(); j++) {
            Cell cell = board.getCell(row, j);
            if (cell.getCellSymbol() == null || !cell.getCellSymbol().equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}

class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        for (int i = 0; i < board.getSize(); i++) {
            Cell cell = board.getCell(i, col);
            if (cell.getCellSymbol() == null || !cell.getCellSymbol().equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}

class PrimaryDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        if (row != col) {
            return false; 
        }
        for (int i = 0; i < board.getSize(); i++) {
            Cell cell = board.getCell(i, i);
            if (cell.getCellSymbol() == null || !cell.getCellSymbol().equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}

class SecondaryDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, int row, int col, Symbol symbol) {
        if (row + col != board.getSize() - 1) {
            return false; 
        }
        for (int i = 0; i < board.getSize(); i++) {
            Cell cell = board.getCell(i, board.getSize() - 1 - i);
            if (cell.getCellSymbol() == null || !cell.getCellSymbol().equals(symbol)) {
                return false;
            }
        }
        return true;
    }
}
