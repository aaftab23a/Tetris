/**
	 * Inherits from abstract class TetrisPiece 
	 * Creates a L1 shaped piece
	 * @author amnaaftab
	 *
	 */
public class TetrisL1 extends TetrisPiece {
	/*
	 * Constructor
	 */
	public TetrisL1()
	{ //Constructor sets up inherited field filledSquares.
		filledSquares = new boolean [][][]
		{
				//Original 
				//0000
				//x000
				//xxx0
				//0000
				{ 
					{false, false, false, false}, //top is empty
					{true, false, false, false}, //one square on the 2nd
					{true, true, true, false}, //three sqaures on the 3rd
					{false, false, false, false} //4th row is empty
				},
		
				//90 degrees
				//0000
				//0xx0
				//0x00
				//0x00
				{ 
					{false, false, false, false}, 
					{false, true, true, false},
					{false, true, false, false}, 
					{false, true, false, false} 
				},
		
				//180 degrees
				//0000
				//0000
				//xxx0
				//00x0
				{ 
					{false, false, false, false}, 
					{false, false, false, false},
					{true, true, true, false}, 
					{false, false, true, false} 
				},
		
				//270 degrees
				//0000
				//0x00
				//0x00
				//xx00
				{ 
					{false, false, false, false},
					{false, true, false, false},
					{false, true, false, false}, 
					{true, true, false, false} 
				}
		};
	}
	
}
