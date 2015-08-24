/**
 * 
 */

/**
*A TetrisGame class maintains a Tetris Game
 * @author amnaaftab
 *
 */
public class TetrisGame {
	
	//instance methods
	public static final int CCW = 1; 
	public static final int CW = 2; 
	public static final int DOWN = 3; 
	public static final int LEFT = 4; 
	public static final int RIGHT = 5; 

	private int numLines; 
	private int numTetrises; 
	private TetrisBoard tBoard; 
	
	/*
	 * constructor
	 */
	public TetrisGame() 
	{
		//initialize the number of lines cleared as 0
	//	numLines = 0; 
		//initialize the number of tetrises (4+ cleared lines at a time) as 0 
	//	numTetrises = 0; 
		//create a new instance of a tetris board
		tBoard = new TetrisBoard(); 
	
	}
	/*
	*Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	*/
	public void attemptMove(int moveType)
	{
		if(moveType == CCW)//if moving CCW
		{
			//rotate the piece CCW
			tBoard.rotateCCW(); 
		}
		else if(moveType == CW)
		{
			//rotate the peice CW
			tBoard.rotateCW(); 
		}
		else if(moveType == DOWN)
		{
			//move piece down one step
			tBoard.moveDown(); 
			//if piece can move down
			if(!tBoard.moveDown())//if moving down is an invalid move
			{
				endRound(); //end round
			}
		}
		else if(moveType == LEFT)
		{
			//move the piece left one step
			tBoard.moveLeft(); 

		}
		else if(moveType == RIGHT)
		{
			//move the piece right by one step
			tBoard.moveRight(); 

		}
	}

	/*
	*Performed when piece cannot move down anymore
	*Ends the round by checking for newly formed lines and adding a new piece 
	*/
	private void endRound() 
	{
		//land piece on the board
		tBoard.landPiece(); 
		//add a new piece 
		tBoard.addNewPiece(); 
		//get number of formed lines
		//increment the running tally formed lines by the number of recently formed lines
		numLines = numLines + tBoard.numFormedLines(); 
		//Check for number of Tetrises 
		//if four lines have been cleared at once
		if(tBoard.numFormedLines() == 4) 
		{
			//increment number of tetrises by one
			numTetrises++; 
		}
	}
	
	//get the number of lines cleared
	public int getNumLines() 
	{
		//returns the number of lines
		return numLines;
	}
	//gets the number of tetrises formed
	public int getNumTetrises() 
	{
		//returns the number of tetrises
		return numTetrises; 
	}
	//gets the tetris board
	public TetrisBoard getTetrisBoard() 
	{
		//returns the teteris board
		return tBoard; 
	}

}
