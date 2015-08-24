/**
 * 
 */

/**
 * Inherits from abstract class TetrisPiece 
 * Creates a T shaped piece
 * @author amnaaftab
 *
 */
public class TetrisT extends TetrisPiece {
	/*
	 * Constructor
	 */
	public TetrisT()
	{
		//initialize filled squares
		filledSquares = new boolean [][][]
				{

					// Original
					//0000 
					//0000
					//xxx0
					//0x00
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false}, //0000
						{true, true, true, false},    //xxx0
						{false, true, false, false}   //0x00 
					},
					
					//90 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00 
						{true, true, false, false},   //xx00 
						{false, true, false, false}   //0x00 
					},
			
					//180 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00
						{true, true, true, false},	  //xxx0
						{false, false, false, false}  //0000 
					},
			
					//270 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00
						{false, true, true, false},	  //0xx0
						{false, true, false, false}   //0x00 
					}
				};
				
	}

}
