/**
 * 
 */
package proj1;

import java.util.Scanner;
import java.lang.Integer;
/**
 * @author eliot2
 *
 */
public class Project1 {
	public static boolean DEBUG = true;

	static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void debug(String message,boolean toDebug){
		if(toDebug){
			say("\t~~"+"("+ message+")\n");
		}
	}
	
	final static int minGridSize = 5;
	
	public static void say(String string){
		System.out.printf(string);
	}
	
	
	private static int getNumber(int maxNum, int minNum) {
		//if max or min is -1, it won't test for that.
		int numInput;
		boolean validInput = false;
		do
		{
			debug("Starting getNumber's do-while loop", DEBUG);
			numInput = (input.nextInt());
			//test for max
			if(maxNum != -1){
				debug("Testing maxNum", DEBUG);
				if(numInput <= maxNum){
					debug("maxNum testing passed successfully", DEBUG);
					validInput = true;
				} else {
					debug("maxNum testing did not pass successfully", DEBUG);
					say("Please enter a number lower than or equal to " 
							+ maxNum + "\n");
				}
				
			}
			// won't run if the maxNum pass failed, or if we don't want to w/ -1
			else if(minNum != -1 && validInput != true){
				debug("Testing minNum", DEBUG);
				if(numInput >= minNum){
					debug("minNum testing passed successfully", DEBUG);
					validInput = true;
				} else {
					debug("minNum testing did not pass successfully", DEBUG);
					say("Please enter a number higher than or equal to "
							+ minNum + "\n");
				}
			}
		debug("validInput variable for getNumber: " + validInput, DEBUG);
		}while(validInput != true);
		debug("Leaving the getNumber method.", DEBUG);
		return numInput;
	}
	
	public static ConnectFour getBoard(){
		say("This is Connect Four! Now, please give # of rows:\n");
		int rows = getNumber(-1, minGridSize);
		say("Please give # of columbs:\n");
		int columns= getNumber(-1, minGridSize);
		say("\nRow: " + rows+ "\tColumn: "+  columns+ "\n");
		 
		//the column size the actually the number of rows, etc.
		ConnectFour gameBoard = new ConnectFour(columns, rows );
		//print the gameBoard
		say("\nHere is your new game board!!\n");
		
		gameBoard.printBoard();
		return gameBoard;
	}
	
	private static boolean playGame(ConnectFour gameBoard) {
		String winner = null;
		boolean playing = true;
		while(playing){
			String moveInput;
			int moveA;
			int moveB;
			if(playing){
				say("\nPlayer 1, please enter a move: ");
				// need to subtract 1 since column 1 is the 0th column.
				moveInput = input.next();
				if(moveInput.equals("q")){
					say("Game is quitting!!\n");
					System.exit(0);
				}
				moveA = Integer.parseInt(moveInput) - 1;
				gameBoard.addPiece(moveA, 0, "x");
				gameBoard.printBoard();
				if(gameBoard.hasWinnner()){
					playing = false;
					winner = "Player 1";
				}
			}
			
			if(playing){
				say("\nPlayer 2, please enter a move: ");
				moveInput = input.next();
				if(moveInput.equals("q")){
					say("Game is quitting!!\n");
					System.exit(0);
				}
				moveB = Integer.parseInt(moveInput) - 1;
				gameBoard.addPiece(moveB, 0, "o");
				gameBoard.printBoard();
				if(gameBoard.hasWinnner()){
					playing = false;
					winner = "Player 2";
				}
			}
		}
		String playChoice;
		gameBoard.printBoard();
		say("\n"+winner+" is the winner!");
		say("\nWould you like to play again?");
		playChoice = input.next();
		if(playChoice.equals("n")){
			say("Okay, quitting game\n");
			return false;
		}
		else if(playChoice.equals("y")){
			return true;
			}
		return false;
		}
		
	
	public static void main(String[] args) {
		boolean playAgain=true;
		ConnectFour gameBoard;
		do{
			gameBoard = getBoard();
		
			playAgain = playGame(gameBoard);
		}while(playAgain);
	}
}



