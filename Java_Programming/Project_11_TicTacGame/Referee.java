/**
 * Referee class is a part of Tic Tac Toe game! It runs the game (shows the board and makes player play)
 * check the board during the game to determine which player wins.
 * @author Arman Sarraf
 */
public class Referee {
    private Player playerx;
    private Player playero;
    private Board board;

    /**
     * prints a sentence to show the game is started
     */
    public Referee() {
        System.out.println("Referee started the game");
    }

    /**
     * runTheGame() method sets each player's opponent and begins the game.
     */
    public void runTheGame() {
        playero.setOpponent(playerx);
        playerx.setOpponent(playero);

        board.display();
        playerx.play();
    }

    /**
     * gets a board object and assign the board with it.
     * @param board the Board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * gets playerX as argument and assign it to playerx
     * @param playerx first player
     */
    public void setxPlayer(Player playerx) {
        this.playerx = playerx;
    }

    /**
     * gets playerX as argument and assign it to playero
     * @param playero second player
     */
    public void setoPlayer(Player playero) {
        this.playero = playero;
    }
}
