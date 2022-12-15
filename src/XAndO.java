import java.util.Scanner;

/**
 * 
 */

/**
 * @author LAP-3
 *
 */
public class XAndO {

	public static int i;
	public static int j;
	public static char symbol;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//// initialize array with its element .. char [][] gBoard = new char[][]; or
		char[][] gBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		/*
		 * H-check"Row1" {{ 'X', 'X', 'X' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' }};
		 * 
		 * H-check"Row2" {{ ' ', ' ', ' ' }, { 'X', 'X', 'X' }, { ' ', ' ', ' ' }};
		 * 
		 * H-check"Row3" {{ ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { 'X', 'X', 'X' }};
		 * 
		 * V-check"Column1" {{ 'X', ' ', ' ' }, { 'X', ' ', ' ' }, { 'X', ' ', ' ' }};
		 * 
		 * V-check"Column2" {{ ' ', 'X', ' ' }, { ' ', 'X', ' ' }, { ' ', 'X', ' ' }};
		 * 
		 * V-check"Column3" {{ ' ', ' ', 'X' }, { ' ', ' ', 'X' }, { ' ', ' ', 'X' }};
		 * 
		 * Diagonal-Check {{ 'X', ' ', ' ' }, { ' ', 'X', ' ' }, { ' ', ' ', 'X' }};
		 * 
		 * Diagonal-Check {{ ' ', ' ', 'X' }, { ' ', 'X', ' ' }, { 'X', ' ', ' ' }};
		 * 
		 * 
		 */

		printBoard(gBoard);// Printing Game Board

		while (true) { // Checking if player1 or player2 is win!
			// here
			playerTurn1(gBoard, sc);
			if (gameIsOver(gBoard)) {
				break;// if one player is win while loop will break.
			}
			printBoard(gBoard);

			playerTurn2(gBoard, sc);

			if (gameIsOver(gBoard)) {
				break;
			}

			printBoard(gBoard);
		}

		sc.close();// if one statement true scanner will close
	}

	/*
	 * player 1 Turn -accept input from user and save it in userInput -Doing Check
	 * for userInput if it is Valid or Not by checking validMove method -If
	 * userInput is valid it will store 'X' in that position If userInput is Invalid
	 * it will display a message "Invalid Number"
	 */
	private static void playerTurn1(char[][] gBoard, Scanner sc) {
		int userInput1;
		while (true) {
			System.out.print("Player1 .. select number(0-8): ");
			userInput1 = sc.nextInt();
			
			if (validMove(gBoard, userInput1)) {
				break;
			} else {
				System.out.println(userInput1 + " Invalid Number.");
			}
		}
		move(gBoard, userInput1, 'X');// Any number 0-8 which selected by player1 will placed as X
	}

	
	
	/*
	- player 2 Turn
	-accept input from user and store that input in userInput
	-Doing Check for userInput if it is Valid or Not by checking validMove method
	-If userInput is valid it will store 'X' in that position
    -If userInput is Invalid it will display a message "Invalid Number"
 */
	private static void playerTurn2(char[][] gBoard, Scanner sc) {
		int userInput2;
		while (true) {
			System.out.print("Player2 .. select number(0-8): ");
			userInput2 = sc.nextInt();
			
			if (validMove(gBoard, userInput2)) {
				break;
			} else {
				System.out.println(userInput2 + " Invalid Number.");
			}
		}
		move(gBoard, userInput2, 'O');// Any number 0-8 which selected by player1 will placed as X
	}

	static boolean checkWinner(char[][] gBoard, char symbol) {
		if (gBoard[0][0] == symbol && gBoard[0][1] == symbol && gBoard[0][2] == symbol) {
			return true;

		} else if (gBoard[1][0] == symbol && gBoard[1][1] == symbol && gBoard[1][2] == symbol) {
			return true;

		} else if (gBoard[2][0] == symbol && gBoard[2][1] == symbol && gBoard[2][2] == symbol) {
			return true;

		} else if (gBoard[0][0] == symbol && gBoard[1][0] == symbol && gBoard[2][0] == symbol) {
			return true;

		} else if (gBoard[0][1] == symbol && gBoard[1][1] == symbol && gBoard[2][1] == symbol) {
			return true;

		} else if (gBoard[0][2] == symbol && gBoard[1][2] == symbol && gBoard[2][2] == symbol) {
			return true;

		} else if (gBoard[0][0] == symbol && gBoard[1][1] == symbol && gBoard[2][2] == symbol) {
			return true;

		} else if (gBoard[0][2] == symbol && gBoard[1][1] == symbol && gBoard[2][0] == symbol) {
			return true;

		} else {
			return false;
		}
	}

	private static void move(char[][] gBoard, int move, char symbol) {
		if (move == 0) {
			gBoard[0][0] = symbol; // if player enter 1 symbol will store in row 0 & column0
		} else if (move == 1) {
			gBoard[0][1] = symbol;// if player enter 1 symbol will store in row 0 & column1
		} else if (move == 2) {
			gBoard[0][2] = symbol;// if player enter 1 symbol will store in row 0 & column2
		} else if (move == 3) {
			gBoard[1][0] = symbol;// if player enter 1 symbol will store in row 1 & column0
		} else if (move == 4) {
			gBoard[1][1] = symbol;// if player enter 1 symbol will store in row 1 & column1
		} else if (move == 5) {
			gBoard[1][2] = symbol;// if player enter 1 symbol will store in row 1 & column2
		} else if (move == 6) {
			gBoard[2][0] = symbol;// if player enter 1 symbol will store in row 2 & column0
		} else if (move == 7) {
			gBoard[2][1] = symbol;// if player enter 1 symbol will store in row 2 & column1
		} else {
			gBoard[2][2] = symbol;// if player enter 1 symbol will store in row 2 & column2
		}
	}

	// method for checking if the place which selected by user is valid/empty or not
	private static boolean validMove(char[][] gBoard, int move) {
		if (move == 0) {
			return (gBoard[0][0] == ' ');// if user enter 1 & that place gBoard[0][0] is empty ==> valid place
		} else if (move == 1) {
			return (gBoard[0][1] == ' ');
		} else if (move == 2) {
			return (gBoard[0][2] == ' ');
		} else if (move == 3) {
			return (gBoard[1][0] == ' ');
		} else if (move == 4) {
			return (gBoard[1][1] == ' ');
		} else if (move == 5) {
			return (gBoard[1][2] == ' ');
		} else if (move == 6) {
			return (gBoard[2][0] == ' ');
		} else if (move == 7) {
			return (gBoard[2][1] == ' ');
		} else if (move == 8) {
			return (gBoard[2][2] == ' ');
		} else {
			return false;
		}
	}

	private static boolean gameIsOver(char[][] gBoard) {

		if (checkWinner(gBoard, 'X')) {// gBoard[0][0] == X && gBoard[0][1] == X && gBoard[0][2] == X
			printBoard(gBoard);
			System.out.println("Player X wins!");
			return true;
		}

		if (checkWinner(gBoard, 'O')) {// gBoard[0][0] == O && gBoard[0][1] == O && gBoard[0][2] == O
			printBoard(gBoard);
			System.out.println("Player O wins!");
			return true;
		}

		for (int i = 0; i < gBoard.length; i++) {// for loop for do checking each row and cloumn
			for (int j = 0; j < gBoard[i].length; j++) {
			if (gBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(gBoard);
		System.out.println("No Winner");
		return true;
		}
	
		
	// This method for printing Game Board
	private static void printBoard(char[][] gBoard) {
			
		
		System.out.println(" ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gBoard[i][j]+"  | ");
				System.out.print(" ");

			}
			System.out.println();
			System.out.println("-----------------");
		}
	}

}
