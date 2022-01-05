import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Player {

	private String name;
	private Board board;
	private Player opponent;
	private char mark;
	private PrintWriter socketOut;
	private BufferedReader socketIn;

	public Player(String name, char letterX) {
		this.name = name;
		this.mark = letterX;
	}


	public void play() throws IOException {
		makeMove();
		board.display();
		if (board.xWins()) {
			socketOut.println("THE GAME IS OVER! "+ getName() + " is the winner!");
			opponent.socketOut.println("THE GAME IS OVER! "+ getName() + " is the winner!");
		} else if (board.oWins()) {
			socketOut.println("THE GAME IS OVER! "+ getName() + " is the winner!");
			opponent.socketOut.println("THE GAME IS OVER! "+ getName() + " is the winner!");
		} else if (board.isFull()) {
			socketOut.println("THE GAME IS OVER! it's a tie, you both lost!");
			opponent.socketOut.println("THE GAME IS OVER! it's a tie, you both lost");
		} else {
			opponent.play();
		}
	}


	public void makeMove() throws IOException {

		int row;
		int col;
		while (true) {
			socketOut.println(getName() + ", what row should your next " + mark + " be placed in? Enter an integer: \n");
			String rowString = socketIn.readLine();
			row = Integer.parseInt(rowString);
			socketOut.println(getName() + ", what column should your next " + mark + " be placed in? Enter an integer: \n");
			String colString = socketIn.readLine();
			col = Integer.parseInt(colString);
			if (board.getMark(row, col) == ' ') {
				board.addMark(row, col, mark);
			break;
			}
			else socketOut.println("The chosen location is already marked! Please choose another location");
		}
		
	}


	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}


	public void setBoard(Board theBoard) {
		this.board = theBoard;

	}

	public void setSocket(PrintWriter socketOut, BufferedReader socketIn) {
		this.socketOut = socketOut;
		this.socketIn = socketIn;
	}
	
	public String getName() {
		return name;
	}
}
