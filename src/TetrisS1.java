/**
	 * Inherits from abstract class TetrisPiece 
	 * Creates a S1 shaped piece
	 * @author amnaaftab
	 *
	 */
public class TetrisS1 extends TetrisPiece {
	/*
	 * Constructor
	 */
	public TetrisS1()
	{
		//initialize filled squares boolean
		filledSquares = new boolean [][][]
				{						
					//Original
					//0000 
					//0xx0
					//xx00 
					//0000
					{ 
						{false, false, false, false}, //0000
						{false, true, true, false},    //0xx0
						{true, true, false, false},    //xx00
						{false, false, false, false}  //0000 
					},
					
					//90 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},   //0x00 
						{false, true, true, false},    //0xx0 
						{false, false, true, false}    //00x0 
					},
			
					//180 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, true, false},   //0xx0
						{true, true, false, false},	  //xx00
						{false, false, false, false}  //0000 
					},
			
					//270 degrees
					{ 
						{false, false, false, false}, //0000
						{false, true, false, false},  //0x00
						{false, true, true, false},	  //0xx0
						{false, false, true, false}   //00x0 
					}
				};
				
	}
}
