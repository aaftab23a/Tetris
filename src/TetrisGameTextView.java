/**
 * 
 */

/**
 * Displays board
 * @author amnaaftab
 *
 */
public class TetrisGameTextView {

	//Instance Methods
	private TetrisGame game; 
	private TetrisBoard board; 
	private TetrisPiece piece; 
	
	/*
	 * Constructor requires the board to display
	 */
	public TetrisGameTextView(TetrisGame g)
	{
		game = g; //initialize game as TetrisGame
		board = game.getTetrisBoard(); //initialize board as a new tetrisBoard
	}
	
	/*
	*Get current view as a string.
	*/
	public String getView()
	{
		//Print string view of the game 
		//Display the 'score board' (number of cleared lines and number of tetrises)
		String s =  "Number of Tetrises: " + game.getNumTetrises() + "\n"; 
		String s1 = "Number of Cleared Lines:  " + game.getNumLines() + "\n"; 
		String s2 = "-----------" + "\n" + getBoardView() + "\n" + "-----------"; 
	
		//return string
		return s + s1 + s2; 

		
	}

	/*
	*prints out the blocks on the board
	*use x to represent a block 
	*/
	private String getBoardView()
	{
		String printBlocks = ""; //set a empty string to hold the board view
		piece = board.getCurrentPiece(); //get current piece
		int[] coordinates = board.getGridPosition(); //get coordinates
		int row = coordinates[0]; //row value
		int col = coordinates[1]; //column value
		int rot = piece.getPieceRotation(); //get piece rotation
		
		//if game.hasBlock(), print x
		for(int i = 0; i < board.getNumRows(); i++)
		{
			for(int j= 0; j< board.getNumCols(); j++)
			{	//if a filled block is present at the position
				if(board.hasBlock(i, j))
				{
					printBlocks += "x"; //add an x representing a filled block
				}
				else //if block not present, check inside each piece to mark the blocks filled with an x
				{
					//while i & j are within the range of a possible piece 
					if(i >= row && i < row+4 && j >= col && j< col+4)
					{
						//if the piece is filled, 
						if(piece.isFilled(rot, i-row, j-col))
						{
							printBlocks += "x"; //set an x representing that block
						}
						else 
						{
							printBlocks += " "; //set an empty string
						}
					}
					else //if not in the range of a possible piece
					{
						printBlocks += " "; //set empty string 
					}
				}
			}
			printBlocks = printBlocks + "\n"; 
		}
		//return a string representing the board view
		return printBlocks; 
	}

}
