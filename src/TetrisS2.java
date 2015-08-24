/**
 * 
 */

/**
 * Inherits from abstract class TetrisPiece 
 * Creates a S2 shaped piece
 * @author amnaaftab
 *
 */
public class TetrisS2 extends TetrisPiece {
	/*
	 * Constructor
	 */
	public TetrisS2()
	{
		//initialize filled squares boolean
		filledSquares = new boolean [][][]
				{						
					//Original
					//0000 
					//0000
					//xx00 
					//0xx0
					{ 
						{false, false, false, false},  //0000
						{false, false, false, false},  //0000
						{true, true, false, false},    //xx00
						{false, true, true, false}     //0xx0 
					},
					
					//90 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00 
						{true, true, false, false},   //xx00 
						{true, false, false, false}   //x000 
					},
			
					//180 degrees
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false}, //0000
						{true, true, false, false},	  //xx00
						{false, true, true, false}    //0xx0 
					},
			
					//270 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00
						{true, true, false, false},	  //xx00
						{true, false, false, false}   //x000 
					}
				};
				
	}
}
