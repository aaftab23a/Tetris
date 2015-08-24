
/**
 * @author Amna Aftab
 *
 */
public abstract class TetrisPiece {

	/*
	*Instance Fields
	*/
	//3D boolean array maintaining grid squars which are filled. 
	//first dimension stores rotation value (0 -> 0º, 1 -> 90º, 2 -> 180º, 3 -> 270º)
	//the second and thurst dimensions store the 4x4 grid indicating a filled square
	protected boolean[][][] filledSquares; 
	//maintains current rotation
	private int pieceRotation; 
	
	//constructor
	public TetrisPiece() 
	{
		//initializes piece rotation to 0º
		pieceRotation = 0; 
	}
	/*
	*gets the rotation of the piece
	*/
	public int getPieceRotation()
	{
		return pieceRotation; 
	}

	/*
	*checks if there is a tetris block at the (row, col) position for the rotation
	*rot where rot is 0, 90, 180 or 270 degrees
	*/
	public boolean isFilled(int rot, int row, int col)
	{
		//if the the square is filled at (row, col) for the rotation
		if(filledSquares[rot][row][col])
		{
			return true; 
		}
		else //if the square is not filled 
		{
			return false; 
		}
	}
	/*
	*Rotate the piece counter-clockwise by 90 degrees
	*/
	public void rotateCCW() 
	{
		//if the piece rotation is already 0
		//we cannot -1 from the rotation value without getting a negative value 
		if(pieceRotation == 0)
		{
			//set rotation as 3, or 270 degrees
			pieceRotation = 3; 
		}
		else //if piece rotation has a non zero value
		{
			//decrement the rotation value by 1
			pieceRotation = pieceRotation -1; 
		}
	}
	/*
	*Rotate the piece clockwise by 90 degrees
	*/
	public void rotateCW() 
	{
		//rotate piece clockwise
		//to ensure piece rotation does not go out of bounds
		//we only increment the rotation value if it is less than 3
		if (pieceRotation == 3) 
		{
			//we set it back to zero, it has rotated 360 degrees and it back to its original position
			pieceRotation = 0; 
		}
		else //if piece rotation !=3
		{
			//increment the rotation value by 1
			pieceRotation++; 
		}
	}
}