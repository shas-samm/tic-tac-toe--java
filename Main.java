package LLD.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter board size:");
        int boardSize = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter name for Player 1:");
        String player1Name = scanner.nextLine();

        System.out.println("Enter name for Player 2:");
        String player2Name = scanner.nextLine();

        Symbol xSymbol = new Symbol('X');
        Symbol oSymbol = new Symbol('O');

        Player player1 = new Player(1, player1Name, xSymbol);
        Player player2 = new Player(2, player2Name, oSymbol);

        System.out.println("Player 1: " + player1.getPlayerName() + " (ID: " + player1.getPlayerId() + "), Symbol: " + player1.getPlayerSymbol().getSymbol());
        System.out.println("Player 2: " + player2.getPlayerName() + " (ID: " + player2.getPlayerId() + "), Symbol: " + player2.getPlayerSymbol().getSymbol());

        Board board = new Board(boardSize);
        Game game = new Game(board, player1, player2 , scanner);
        game.initializeGame(boardSize);

        scanner.close();
    }
}
