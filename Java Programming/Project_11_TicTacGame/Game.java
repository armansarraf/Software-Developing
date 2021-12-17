import java.io.*;

/**
 Game class is the main and runnable class of Tic Tac Toe game!
 It builds and displays the board, creates objects of players and referee, calls methods related to start and play the game.
 @author Arman Sarraf
 */

public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;

	/**
	 * Constructs an object of Board
	 */
    public Game( ) {
        theBoard  = new Board();
	}

	/**
	 * appointReferee() method initiates the referee object with its argument 'r' and calls runTheGame() method from Referee class.
	 * @param r an object of Referee
	 * @throws IOException
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }

	/**
	 * main method which runs the program.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer; // Defining two players
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X); // Creating playerX
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O); // Creating playerO
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
}
