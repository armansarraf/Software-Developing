import java.io.*;


public class Game implements Constants, Runnable {

	private Board theBoard;
	private Referee theRef;
	private PrintWriter socketOut1, socketOut2;
	private BufferedReader socketIn1, socketIn2;

	public Game(PrintWriter socketOut1, BufferedReader socketIn1, PrintWriter socketOut2, BufferedReader socketIn2) {
		this.socketIn1 = socketIn1;
		this.socketOut1 = socketOut1;
		this.socketIn2 = socketIn2;
		this.socketOut2 = socketOut2;
		theBoard = new Board();
	}

	public void appointReferee(Referee r) throws IOException {
		theRef = r;
		theRef.runTheGame();
	}

	@Override
	public void run() {
		Referee theRef;
		Player xPlayer = null, oPlayer = null;
		String name1, name2;

		socketOut1.println(
				"\nYou are player 'X', Now enter your name: ");
		try {
			name1 = socketIn1.readLine();

			while (name1 == null) {
				socketOut1.println("Please try again: ");
				name1 = socketIn1.readLine();
			}
			xPlayer = new Player(name1, LETTER_X);
			xPlayer.setBoard(this.theBoard);

			socketOut2.println(
					"\nYou are player 'O', Now enter your name: ");

			name2 = socketIn2.readLine();
			while (name2 == null) {
				socketOut2.println("Please try again: ");
				name2 = socketIn2.readLine();
			}

			oPlayer = new Player(name2, LETTER_O);
			oPlayer.setBoard(this.theBoard);

			theRef = new Referee();
			theRef.setBoard(this.theBoard);
			theRef.setoPlayer(oPlayer);
			theRef.setxPlayer(xPlayer);
			theRef.setSocket(socketOut1, socketIn1, socketOut2, socketIn2);

			this.appointReferee(theRef);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}