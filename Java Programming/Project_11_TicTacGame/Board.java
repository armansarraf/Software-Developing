/**
	Board class is a part of Tic Tac Toe game!
 	It creates and displays the board when players start the game and also updates itself whenever each player leaves a mark.
 	@author Arman Sarraf
 */
public class Board implements Constants {
	private char theBoard[][]; // board itself is a 2D array of chars.
	private int markCount; // board should have 9 small blocks. this counter keep follows the position of current block.

	/**
	 * Creates the empty board with 3 rows which each row has 3 columns.
	 * It fills each block with a space.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];

		// using nested for-loop to fill the blocks in the board.
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * getMark method gets the location of a block (its row and column) and returns the value of that block.
	 * @param row row of where it wants to point
	 * @param col column of where it wants to point
	 * @return mark (value of that location in the board)
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * returns true when the position passes the last block of the board. true means the board is full.
	 * @return boolean
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * returns true when player x wins the game. It calls the checkWinner method and passes 'x' to the method to see if player x is winner.
	 * @return boolean
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * returns true when player o wins the game. It calls the checkWinner method and passes 'o' to the method to see if player o is winner.
	 * @return boolean
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * display() method shows the completed board to the user. It calls displayColumnHeaders() to draw headers, addHyphens() to add hyphens to board,
	 * draws the rows and columns and their characters, and finally calls addSpaces() and addHyphens() method to complete the drawing the board.
	 */
	public void display() {

		// all necessary methods for showing the correct shape of board is called in this method
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * addMark() method adds a mark to a designated block of the board. it gets row, column, and mark as argument.
	 * @param row row of where it wants to point
	 * @param col column of where it wants to point
	 * @param mark the character it wants to add to the mentioned location
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++; // shifting to next block in board
	}

	/**
	 * clear() method fills the blocks in the board with just a space to make it clean from any mark.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * This method gets a new mark every time and checks to see if after adding the mark, the win situation happens.
	 * @param mark X or O from user
	 * @return zero or one to show user wins.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		// for-loops check the situations with given mark to see if the user wins
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This method loops over the one dimension of the 2D-array which is the board and prints the required characters.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * This method loops over the one dimension of the 2D-array which is the board and prints the required characters.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * This method loops over the one dimension of the 2D-array which is the board and prints the required characters.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
