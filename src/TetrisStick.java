/**
 * 
 */

/**
 * Inherits from abstract class TetrisPiece 
 * Creates a stick shaped piece
 * @author amnaaftab
 *
 */
public class TetrisStick extends TetrisPiece {
	/*
	 * Constructor
	 */
	public TetrisStick() 
	{
		//initialize filled squares boolean
		filledSquares = new boolean [][][]
				{						
					// Original
					//x000 
					//x000
					//x000
					//x000
					{ 
						{true, false, false, false}, //x000
						{true, false, false, false}, //x000
						{true, false, false, false}, //x000
						{true, false, false, false}  //x000 
					},
					
					//90 degrees
					{ 
						{false, false, false, false},//0000
						{false, false, false, false},//0000 
						{true, true, true, true},    //xxxx 
						{false, false, false, false} //0000 
					},
			
					//180 degrees
					{ 
						{true, false, false, false}, //x000
						{true, false, false, false}, //x000
						{true, false, false, false}, //x000
						{true, false, false, false}  //x000 
					},
			
					//270 degrees
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false}, //0000 
						{true, true, true, true}, 	  //xxxx
						{false, false, false, false}  //0000 
					}
				};
	}
}
