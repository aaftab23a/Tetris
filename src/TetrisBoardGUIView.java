import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * 
 */

/**
 * @author amnaaftab
 *
 */
public class TetrisBoardGUIView extends JComponent

{	
	private TetrisBoard board; 
	/*
	 * Constructor initializes tetris board and updates display
	 */
	public TetrisBoardGUIView(TetrisBoard b)
	{
		//initialize tetris board
		board = b; 
		//update viewer to reflect changes
		repaint(); 
	}
	/*
	 * paint the game
	 */
	public void paint(Graphics g)
	{
		//get current piece 
		TetrisPiece b = board.getCurrentPiece(); 
		//get coordinates for current piece
		int[] coordinates = board.getGridPosition(); 
		//get row index for current piece
		int row = coordinates[0]; 
		//get column index for current piece 
		int col = coordinates[1];
		
		//loop through board 
		for(int i = 0; i < board.getNumRows(); i++)
		{
			for(int j = 0; j <board.getNumCols(); j++)
			{	//if there is a block at position i, j
				if(board.hasBlock(i, j))
				{
					//paint block
					paintBlock(g, i, j, computeBlockSize()); 
				}
				
				else //if there is not a block at i,j; check within piece for filled blocks
				{
					//if i and j are within the bounds of a piece 
					if (i >= row && i < row+4 && j >=col && j < col+4)
					{  
						//check if block is filled in that piece 
						if(b.isFilled(b.getPieceRotation(), i-row, j-col))
						{
							//paint block 
							paintBlock(g, i, j, computeBlockSize()); 
							
						}
					}
				}
			}
		}
		//paint the outline of the board.
		paintBoardOutline(g, computeBlockSize()); 
		
		
	}
	/*
	 * Paints the outline of the board using the size of the block
	 */
	private void paintBoardOutline(Graphics g, int blockSize)
	{
		//let row length be the number of rows in the game * the size of each block
		int rowLength = blockSize*(board.getNumRows()); 
		//let column length be the number of columns in the game * the size of each block
		int colLength = blockSize*(board.getNumCols()); 
		//set the color of the outline as black 
		g.setColor(Color.BLACK);
		//draw a rectangle with column length and row length as the height/width
		g.drawRect(0, 0,  colLength, rowLength);
	}
	/*
	 * paint block at grid row, grid col
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize)
	{
		//paint the block at grid row, grid col
		//loop through board
		//set color of the block outline as pink
		g.setColor(Color.PINK);
		//draw block outline 
		g.drawRect(col* blockSize, row* blockSize, blockSize, blockSize); 
		//paint the inside of the block yellow  
		g.setColor(Color.YELLOW);	
		//fill the rectangle 
		g.fillRect(col* blockSize, row* blockSize,blockSize, blockSize);

	}
	/*
	 * compute the best block size for the current width and height
	 */
	private int computeBlockSize()
	{
		//return size (for a square block in pixels)
		return 40; 
	}
}
