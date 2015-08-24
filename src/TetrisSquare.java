/**
 * 
 */

/**
 * @author amnaaftab
 *
 */
public class TetrisSquare extends TetrisPiece {
	public TetrisSquare()
	{
		filledSquares = new boolean [][][]
				{
				// Top point is (1, 2) for original shape
						
					// Original
					//0000 
					//0xx0
					//xx00 
					//0000
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false},  //0000
						{true, true, false, false},    //xx00
						{true, true, false, false}  //xx00 
					},
					
					//90 degrees
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false},  //0000
						{true, true, false, false},    //xx00
						{true, true, false, false}  //xx00 
					},
			
					//180 degrees
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false},  //0000
						{true, true, false, false},    //xx00
						{true, true, false, false}  //xx00 
					},
			
					//270 degrees
					{ 
						{false, false, false, false}, //0000
						{false, false, false, false},  //0000
						{true, true, false, false},    //xx00
						{true, true, false, false}  //xx00 
					}
				};
				
	}
}
