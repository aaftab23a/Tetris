import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * TetrisGameTextController plays Tetris from the command line,
 * printing the game after each move.
 * @author Amna Aftab
 */
public class TetrisGameTextController
{

	/* the game (model) */
	private TetrisGame game;
	
	/* the view */
	private TetrisGameTextView view;

	/*
	 * Constructor for a new tetris game for the command line.
	 */
	public TetrisGameTextController()
	{
		// create a tetris game
		game = new TetrisGame(); 
		// create its view
		view = new TetrisGameTextView(game); 
		//read user show the initial game
		readInput(); 
		//print tetris display
		refreshDisplay(); 
	}
	
	/**
	 * Get input from the user, looping until the user types "Quit".
	 **/
	private void readInput()
	{
		// wrap input stream read input from user
		// you do not need to understand what is going on here
		// for now, just take it as is
		BufferedReader in = 
		new BufferedReader( new InputStreamReader( System.in ) );
  
		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;
 
			// loop until the user types "Quit"
			do {
				// prompt the user for input
				System.out.println( "Please enter a move (l,r,d,z,x) or type Quit to end." ); 

				// try to read a line
				// this function potentially throws an IOException
				line = in.readLine(); 
 
				// enter the move
				moveEntered( line );
				
				// refresh the view
				refreshDisplay();
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	/**
	 *  Print text view of the game.
	 */
	private void refreshDisplay()
	{
		//print out view
		System.out.println(view.getView()); 
		
	}

	/**
	 * r: right
	 * l: left
	 * d: down
	 * z: cw
	 * x: ccw
	 * @param move
	 */
	private void moveEntered( String move )
	{
		//if move typed is r, 
		if(move.equals("r"))
		{
			//attempt to move right
			game.attemptMove(TetrisGame.RIGHT); 
		}
		//if move typed is l 
		else if(move.equals("l"))
		{
			//attempt to move left
			game.attemptMove(TetrisGame.LEFT);
		}
		//if move typed is d
		else if(move.equals("d"))
		{
			//attempt to move down
			game.attemptMove(TetrisGame.DOWN);
		}
		//if move typed is z
		else if(move.equals("z"))
		{
			//attempt to move CW
			game.attemptMove(TetrisGame.CW);
		}
		//if move ytped is x
		else if(move.equals("x"))
		{
			//attempt to move CCW
			game.attemptMove(TetrisGame.CCW); 
		}

	}
	
	/**
	 * Start the game!
	 * @param args
	 */
	public static void main( String[] args )
	{
		// make a new controller instance
		new TetrisGameTextController(); 
		
	}
	
}