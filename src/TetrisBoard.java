

/**
 * 
 */

/**
 * @author amnaaftab
 *
 */
public class TetrisBoard {
	
	//instance fields
	private boolean[][] board; 
	private int[] currentGridPosition; 
	private TetrisPiece currentPiece; 
	public static int NUM_COLS = 10; 
	public static int NUM_ROWS = 18; 
	private int formedLines; 
	
	public TetrisBoard() 
	{
		//initialize board 
		initBoard(); 
		//initialize currentGridPositions as (0,3)
		initCurrentGP(); 
		//add a new tetris piece to the board to start the game
		addNewPiece(); 
	}
	/*
	*Create a tetris board boolean arary with dimensions: NUM_ROWS x NUM_COLS  
	*set all grid values as false
	*/
	private void initBoard()
	{
		//initialize board array 
		board = new boolean[NUM_ROWS][NUM_COLS]; 
		//loop through all values of the grid 
		for (int i = 0; i < board.length - 1; i++)
			for(int j = 0; j < board[0].length; j++)
			{
				//initialize all values of the board as false
				board[i][j] = false; 
			}

	}
	/*
	*initialize an int array of length two to keep track of grid position 
	*set initial coordinates as (0,3)
	*/
	private void initCurrentGP()
	{
		currentGridPosition = new int[2]; //initialize an array of length 2
		currentGridPosition[0] = 0; //set x value as 0
		currentGridPosition[1] = 0; //set y value as 3
	}
	/*
	*Add a random tetris piece to the board at grid position
	*/
	public void addNewPiece() 
	{
		//get a random number between 0-6
		int i = (int)(Math.random()*7);
		//switch functions goes through all possible values of i (0-6)
		//each value is calls a different tetris piece
		
		if(i == 0) //if random number is 0
		{
			//set current piece as a new L1 piece
			currentPiece = new TetrisL1();
		}
			
		if(i == 1) //if random number i is 1
		{
			//set current piece as a new L2 piece
			currentPiece = new TetrisL2();
		}
		if(i == 2)//if random number i is 2
		{
			//set currentpiece as new S1 piece
			currentPiece = new TetrisS1();
		}
		if(i == 3)//if random number i is 3
		{
			//set currentpiece as new S2 piece
			currentPiece = new TetrisS2();
		}
		if(i == 4) //if random number i is 4
		{
			//set currentpiece as new TetrisSquare
			currentPiece = new TetrisSquare();
		}
		if(i == 5)//if random number i is 5
		{
			//set currentpiece as new TetrisStick
			currentPiece = new TetrisStick();
		}
		if(i == 6)//if random number i is 6
		{
			//set currentpiece as new TetrisT
			currentPiece = new TetrisT();
		}
		
		//set currentGridPosition for the new piece at (0,3)
		initCurrentGP();  
	}

	/*
	 * Checks if placing the piece at grid positon with rotation value rot would cause 
	 * a collision (ie. if there would be a block on an already filled grid square
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int row, int col)
	{
		//for all rows less than 4 (max length of piece)
		for (int i = 0; i < 4; i++)
		{
			//for all columns less than 4 (max height of piece)
			for(int j = 0; j < 4; j++)
			{
				//if there would be a block on an already filled square
				if(piece.isFilled(rot, i, j) && board[row + i][j + col]) 
					return true; //collision detected
			}
		}
		
		return false; //no collision
	}
	/*
	 * Checks if placing the piece at grid position (row, col) with the 
	 * rotation rot (values can be 0, 90, 180, 270) would cause an 
	 * out of bounds condition (i.e., if there would be a block falling off the board).
	 */
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int row, int col)
	{
		//for all r less than 4 (the max length of the piece)
		for (int r = 0; r < 4; r++)
		{
			//for all c less than 4 (the max height of the piece)
			for(int c = 0; c < 4; c++)
			{
				//if there is a filled piece at (r,c) with rotation value rot
				if(piece.isFilled(rot, r, c))
				{
					//check if any square of the tetris piece is out of bounds by checking
					//if new row value is negative or greater than the rows available on the board 
					//or if the new column value is negative or greater than columns available
					if((r+row < 0) || (r+row >= NUM_ROWS) || (c+col >= NUM_COLS) || (c+col < 0)) 
					{
						return true; //the piece is out of bounds of the board
					}
				}
			}
		}
		return false;//the piece is not out of bounds
	}
	/*
	 * checks if there is a full line at the row
	 */
	public boolean fullLine(int row)
	{
		//loop through all the columns
		for(int i = 0; i < board[i].length; i++)
		{
			//if there is any false value in the row
			if(board[row][i] != true)
			{
				//there is an unfilled gap in the row 
				//ther is not a full line present
				return false;
			}
		}
		//there are no full values (all values in a single row are true)
		//return true - there is a full line at row 
		return true; 
	}

	//getter function for the board
	public boolean[][] getBoard()
	{
		return board; //returs board
	}
	//getter function for the grid position
	public int[] getGridPosition()
	{
		return currentGridPosition; //returns grid position
	}
	//getter function for the current tetris piece
	public TetrisPiece getCurrentPiece()
	{
		return currentPiece; //returns current tetris piece
	}
	//gets number of columns in the board
	public int getNumCols()
	{
		return NUM_COLS;
	}
	//gets number of rows in the board
	public int getNumRows()
	{
		return NUM_ROWS; 
	}
	
	/*
	 * Check is a block is present at a particular grid position
	 */
	public boolean hasBlock(int row, int col)
	{	
		//return true if there is a block present at position
		//and false if there isn't
		return board[row][col]; 
	}

	/*
	*Update the board array to reflect the newly landed piece's filled squares using
	*the currentGridPositon values and the currentPieceRotation values
	*/
	public void landPiece() 
	{
		//set rotation as the current rotation of the piece
		int rotation = currentPiece.getPieceRotation(); 

		for(int r = 0; r < 4; r++)
		{
			for(int c = 0; c < 4; c++)
			{
				//if the current piece is filled at the specified coordinates/rotation
				if(currentPiece.isFilled(rotation, r, c))
					{
						//increment current row value by r
						int x = currentGridPosition[0] + r; 
						//increment current column value by c
						int y = currentGridPosition[1] + c; 
						//set new x and y values in the board as true
						board[x][y] = true; 
					}
			}
		}
		//check if any new lines have been formed
		numFormedLines(); 
	}
	/*
	 * check if moving down is valid
	 */
	public boolean moveDown()
	{
		//row value of the currentGridPositon is currentGridPosition[0]
		//if piece is moved down, the row value will increment by 1
		//therefore, set new row position as the current row value + 1
		int newRowPosition = currentGridPosition[0]+1; 
		//if moving down is a valid move
		if(validMove(currentPiece, currentPiece.getPieceRotation(), newRowPosition, currentGridPosition[1]))
		{
			//increment the current row value by 1, thereby moving the piece one step down
			currentGridPosition[0] = newRowPosition; 
			//moving down is a valid move
			return true;
		}
		
		return false; //moving down is not a valid move
		
	}
	/*
	 * check if moving left is valid
	 */
	public boolean moveLeft()
	{
		//column value of the currentGridPositon is currentGridPosition[1]
		//if piece is moved left, the column value will decrement by 1
		//therefore, set new column position as the current column value - 1

		int newColumnPosition = currentGridPosition[1] - 1; 
		//if moving left is a valid move
		if(validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], newColumnPosition))
		{
			//decrement the current column value by 1, thereby moving the piece one step to the left
			currentGridPosition[1] = newColumnPosition; 
			//moving left is a valid move
			return true;
		}
		else 
		{
			//moving left is not a valid move
			return false; 
		}
		
		
	} 

	/*
	 * Check if moving right is valid
	 */
	public boolean moveRight()
	{
		//column value of the currentGridPositon is currentGridPosition[1]
		//if piece is moved right, the column value will increment by 1
		//therefore, set new column position as the current column value + 1
		int newColumnPosition = currentGridPosition[1]+1;

		//if moving right is a valid move 
		if(validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], newColumnPosition))
		{
			//increment the current column value by 1, thereby moving the piece one step to the right
			currentGridPosition[1] = newColumnPosition; 
			//return true to say that moving right is a valid move
			return true;
		}
		else 
		{
			//moving right is not a valid move
			return false; 
		}
	}
	/*
	 * Detect any formed lines; update score accordingly
	 * Remove any lines formed
	 */
	public int numFormedLines()
	{
		//formedLines = 0; 
		//loop through each row in the board
		for(int i = 0; i < NUM_ROWS; i++)
		{
			//if a row is filled with x's 
			if(fullLine(i))
			{
				//increment formedLines by 1
				formedLines++; 
				//remove this filled line
				removeLine(i); 
			}
		}
		//return the number of formed lines
		return formedLines; 
	}
	/*
	 * Remove the line at row in the model.
	 */
	private void removeLine(int row)
	{
		//remove row at 'row'
		for(int col = 0; col <NUM_COLS; col++)
		{
			board[row][col] = false; //set all columns in the particular row false
		}
		//set all squares at row 0 as false 
		for(int i = 0; i <NUM_COLS; i++)
		{
			//set all values at row 0 to be false
			board[0][i] = false; 
		}
		//adjust other rows in the board to accomodate the removed line 
		//by moving each row above the removed row to a lower index
		for(int r = row-1; r >= 0 ; r--)
		{
			for(int c = 0; c < NUM_COLS; c++) 
			{
				board[r+1][c] = board[r][c]; //shift all row values to be one row lower
			}
		}
		
	}
	
	/*
	 * Check is rotating counter clockwise is valid
	 */
	public boolean rotateCCW()
	{
		//get value of piece rotation after rotation 
		int r = currentPiece.getPieceRotation(); 
		if (r == 0) //if current rotation is 0 degress
		{
			//set peice rotation as = 3 
			//because rotating a piece CCW currently at 0 degrees by 90 degrees 
			//will give a new rotation of 270 (aka. 3) 
			r = 3; 
		}
		else //if r is !=0
		{
			//rotating CCW is the same as subtracting 90 degrees from its current rotation value 
			r = currentPiece.getPieceRotation() - 1; 
		}
				
		//check if rotating CW is a valid move
		if(validMove(currentPiece, r, currentGridPosition[0], currentGridPosition[1]))
		{
			//if it is a valid move, set r as the new rotation value to the current piece
			currentPiece.rotateCCW();  
			return true; //return true because rotating CW is possible
		}
		else //if rotating cw is not possible
		{
			return false; //return false
		}		
				
	}
	

	/*
	 * check if rotating clockwise is valid
	 */
	public boolean rotateCW()
	{
		//get value of piece rotation after rotation 
		int r = currentPiece.getPieceRotation(); 
		
		if (r == 3) //if current piece rotation is 3
		{
			r = 0; //set piece rotation = 0
		}
		else //if r is !=3
		{
			r = currentPiece.getPieceRotation() + 1; //increment current rotation by 1 (aka. rotate by 90º)
		}
		
		//check if rotating CW is a valid move
		if(validMove(currentPiece, r, currentGridPosition[0], currentGridPosition[1]))
		{
			//if it is a valid move, set a new rotation value to the current piece
			currentPiece.rotateCW();  
			return true; //return true because rotating CW is possible
		}
		else //if rotating cw is not possible
		{
			return false; //return false
		}
		
	}
	
	/*
	 * Checks if placing the piece at grid position (row, col) 
	 * with the rotation rot (values can be 0, 90, 180, 270) is a valid move.
	 */
	private boolean validMove(TetrisPiece piece, int rot, int row, int col)
	{
		//if move is either out of bounds or if there is a collision 
		if(detectOutOfBounds(piece, rot, row, col) || detectCollision(piece, rot, row, col))
		{
			return false; //move is not valid
		}
		
		return true; //move is valid
	}

	
}
