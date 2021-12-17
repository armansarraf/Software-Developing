import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Referee {

	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	private PrintWriter socketOut1;
	private PrintWriter socketOut2;
	private BufferedReader socketIn1;
	private BufferedReader socketIn2;


	public void runTheGame() throws IOException {
		xPlayer.setSocket(socketOut1, socketIn1);
		oPlayer.setSocket(socketOut2, socketIn2);
		board.setSocket(socketOut1, socketOut2);
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		socketOut1.println("Referee started the game...");
		socketOut2.println("Referee started the game...");
		board.display();
		xPlayer.play();
		socketOut1.println("Game Ended ...");
		socketOut2.println("Game Ended ...");
	}


	public void setBoard(Board theBoard) {
		this.board = theBoard;
	}


	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}


	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}


	public void setSocket(PrintWriter socketOut1, BufferedReader socketIn1, PrintWriter socketOut2,
			BufferedReader socketIn2) {
		this.socketOut1 = socketOut1;
		this.socketIn1 = socketIn1;
		this.socketOut2 = socketOut2;
		this.socketIn2 = socketIn2;
	}

}