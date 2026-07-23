package LLD.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;
    private Scanner scanner;
    List<WinningStrategy> winningStrategies = new ArrayList<>();

    public Game(Board board, Player player1, Player player2, Scanner scanner) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = scanner;

        // Initialize the winning strategies
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new PrimaryDiagonalWinningStrategy());
        winningStrategies.add(new SecondaryDiagonalWinningStrategy());
    }

    public void initializeGame(int boardSize) {

        Player currentPlayer = player1;

        while (gameStatus == GameStatus.IN_PROGRESS) {

            board.displayBoard();

            if (board.isBoardFull()) {
                gameStatus = GameStatus.DRAW;
                break;
            }

            while (true) {
                try {
                    System.out.println(currentPlayer.getPlayerName() + ", enter row:");
                    int row = scanner.nextInt();

                    System.out.println(currentPlayer.getPlayerName() + ", enter column:");
                    int col = scanner.nextInt();

                    board.placeSymbol(row, col, currentPlayer.getPlayerSymbol());

                    // Move was successful, now check for winner
                    for (WinningStrategy strategy : winningStrategies) {
                        if (strategy.checkWin(board, row, col, currentPlayer.getPlayerSymbol())) {
                            gameStatus = GameStatus.WIN;
                            board.displayBoard();
                            System.out.println(currentPlayer.getPlayerName() + " wins!");
                            return;
                        }
                    }

                    // Exit the retry loop because the move was valid
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please enter another position.\n");
                }
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

    }

}
