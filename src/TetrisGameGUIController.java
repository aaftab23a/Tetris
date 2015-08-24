import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * 
 */

/**
 * @author amnaaftab
 *
 */
@SuppressWarnings("serial")
public class TetrisGameGUIController extends JPanel implements KeyListener
{

	/**
	 * Instance Fields 
	 */
	private static final int DEFAULT_DROP_RATE = 2000; 
	private int dropRate; 
	private TetrisGame game; 
	private Timer gameTimer; 
	private JLabel linesLabel;
	private JLabel tetrisesLabel; 
	private TetrisBoardGUIView view; 
	/*
	 * Controller initializes game
	 */
	public TetrisGameGUIController(boolean keysFromApplet) 
	{
		//create a new TetrisGame
		game = new TetrisGame(); 
		
		//create a new TetrisBoardGUIView
		view = new TetrisBoardGUIView(game.getTetrisBoard()); 
		
		//initialize dropRate as the constant
		dropRate = DEFAULT_DROP_RATE; 
		
		//set a border layout for the main panel 
		setLayout(new BorderLayout()); 
		
		//add view to main panel
		createView();
		//add score panel to the main panel
		createScore(); 
		//set up a timer to move the pieces down the board
		setupTimer(); 

		// listen for keystrokes -- this only works for the JFrame holding it
		// for the applet, the applet must add the key listener
		if(!keysFromApplet)
		{
			setFocusable(true); 
			addKeyListener(this); 
		}
		 	
		
	}
	/*
	 * Creates a panel tracking the scores 
	 * 
	 */
	private void createScore()
	{
		JPanel scoreBoard = new JPanel(); 
		//set layout of the scoreboard panel as a 2, 1 gridlayout
		scoreBoard.setLayout(new GridLayout(2,1));
		linesLabel = new JLabel();  
		tetrisesLabel = new JLabel(); 
		//add a label which will track the number of lines cleared
		scoreBoard.add(linesLabel);
		//add a label which will track the number of tetrises cleared
		scoreBoard.add(tetrisesLabel); 
		//add scoreboard to the top of the tetris panel
		add(scoreBoard, BorderLayout.NORTH); 
	}
	/*
	 * Add TetrisGameGUIView to the main panel 
	 */
	private void createView()
	{
		//add GUIView to the center of the panel 
		//this will be main tetris game 
		add(view, BorderLayout.CENTER); 
		//add a key listener to the view 
		view.addKeyListener(this);
		
	}
	
	/*
	 * Listens to key (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_DOWN: //if the key pressed is the down key
				game.attemptMove(TetrisGame.DOWN); //move piece down
				break;
			case KeyEvent.VK_LEFT: //if key pressed is left
				game.attemptMove(TetrisGame.LEFT);//move left
				break; 
				//move left
			case KeyEvent.VK_RIGHT://if keypressed if right
				game.attemptMove(TetrisGame.RIGHT);//move right
				break;
				//move right
			case KeyEvent.VK_X: //if keypressed is 'x'
				game.attemptMove(TetrisGame.CW);//move clockwise
				break; 
				//cw
			case KeyEvent.VK_Z: //if keypressed is 'w'
				game.attemptMove(TetrisGame.CCW);//move anticlockwise
				break; 
				//ccw
			default: //default case in case non of the above are true
				System.out.println("Key Pressed: " + e.getKeyCode());  
				//default 
		}
	}

	public void keyReleased(KeyEvent e)
	{}
	
	public void keyTyped(KeyEvent e)
	{}
	/*
	 * Updates board to reflect changes in the game
	 */
	public void refreshDisplay()
	{
		view.repaint(); //update board
		//update lines cleared
		linesLabel.setText("Lines cleared: " + game.getNumLines()); 
		//update tetrises cleared
		tetrisesLabel.setText("Tetrises cleared: " + game.getNumTetrises()); 
	}
	/*
	 * Sets up the timer
	 * Controls the movement of pieces by forcing piece to move down after some time
	 */
	private void setupTimer()
	{
		//set up timer; add actionlistener
		gameTimer = new Timer(dropRate, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//move the piece down
				game.attemptMove(TetrisGame.DOWN);
				//update the view
				refreshDisplay(); 
			}
		}); 
		//start the simulation
		gameTimer.start(); 
	}
}
