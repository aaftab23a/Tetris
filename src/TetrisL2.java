/**
	 * Inherits from abstract class TetrisPiece 
	 * Creates a L2 shaped piece
	 * @author amnaaftab
	 *
	 */
public class TetrisL2 extends TetrisPiece {
	//constructor
	public TetrisL2()
	{
		//initialize filled squares
		filledSquares = new boolean [][][]
				{
						//original
						//0000
						//xxx0
						//00x0
						//0000
						{
							{false, false, false, false},//0000
							{true, true, true, false},   //xxx0
							{false, false, true, false}, //00x0
							{false, false, false, false} //0000
						},
						
						{ 
							{false, false, true, false}, //00x0
							{false, false, true, false}, //00x0
							{false, true, true, false},  //0xx0
							{false, false, false, false} //0000
						},
						
						{ 
							{false, false, false, false},//0000
							{false, true, false, false}, //0x00
							{false, true, true, true},   //0xxx 
							{false, false, false, false} //0000
						},  
							
						{ 
							{false, false, false, false}, //0000
							{false, true, true, false},   //0xx0
							{false, true, false, false},  //0x00
							{false, true, false, false}   //0x00
						} 
				};
	}
	
}
