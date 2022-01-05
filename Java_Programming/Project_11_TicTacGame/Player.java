import java.util.Scanner;

/**
 * Player class is a part of Tic Tac Toe game! Its methods make the players move and
 * check the board during the game to determine which player wins.
 * @author Arman Sarraf
 */

public class Player {

    private String name;
    private Board board;
    private Player opponent;
    private char mark;

    /**
     * Constructs an object of player whenever it is called, it gets player name, its mark and initiates player.
     * It also set the players opponent.
     *
     * @param name   player's name
     * @param letter Player's mark
     */
    public Player(String name, char letter) {
        this.name = name;
        this.mark = letter;
        this.opponent = getOpponent();
    }

    /**
     * play() method makes the players keep playing as long as the board is not full or none of them is winner of the game.
     */
    public void play() {
        while (!board.isFull() && !board.oWins() && !board.xWins()) {
            makeMove(); // Player one makes a move
            board.display(); // board is updated and shown again

            // check to see player one wins
            if (board.xWins()) {
                System.out.println("THE GAME IS OVER: " + getName() + " is the winner!\nGame Ended...");
                break;
                // check to see if the board is full for next movement
            } else if (board.isFull()) {
                System.out.println("Game ended in a tie");
                break;
            }
            opponent.makeMove(); // Player two makes a move
            board.display(); // board is updated and shown again

            // check to see player two wins
            if (board.oWins()) {
                System.out.println("THE GAME IS OVER: " + opponent.getName() + " is the winner!\nGame Ended...");
                break;
                // check to see if the board is full for next movement
            } else if (board.isFull()) {
                System.out.println("Game ended in a tie");
                break;
            }

        }

    }

    /**
     * makeMove() method wants the player to choose the location it wants to leave their mark, and adds the mark to that block
     */
    public void makeMove() {
    	while (true) {
        System.out.println(getName() + ", what row should your next " + getMark() + " be placed in?");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        System.out.println(getName() + ", what column should your next " + getMark() + " be placed in?");
        int column = scanner.nextInt();
        if(board.getMark(row,column) == ' ') {
        board.addMark(row, column, getMark());
        break;
        }
        else
        	System.out.println("The chosen location is already marked! Please choose another location");
    	}
    }

    public String getName() {
        return name;
    }

    public Player getOpponent() {
        return opponent;
    }

    public char getMark() {
        return mark;
    }

    /**
     * setOpponent() gets the opponent as an argument sets player's opponent
     * @param player Player's opponent
     */
    public void setOpponent(Player player) {
        this.opponent = player;
    }

    /**
     * setBoard() gets the board as an argument and sets the board
     * @param theBoard boardGame
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }
}
