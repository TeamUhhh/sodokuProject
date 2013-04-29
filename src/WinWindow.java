import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.io.PrintWriter;
=======
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.JTextArea;
=======
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
import javax.swing.JTextField;


public class WinWindow extends JFrame implements ActionListener{
<<<<<<< HEAD
	
	public static final int WIDTHWIN = 400;
	public static final int HEIGHTWIN = 400;
	
	JTextField inputName = null;
	int timeVar = 0, movesVar = 0;
	String levelVar = null;
	
	Font headerFont = new Font("Arial", Font.BOLD, 50);

	WinWindow(int time, int moves, String level){
		
		super();
		
		
		// imports the user info to be used later
		timeVar = time;
		movesVar = moves;
		levelVar = level;
		
		
=======

	public static final int WIDTHWIN = 400;
	public static final int HEIGHTWIN = 400;

	private JTextField inputName = null;
	private int timeVar = 0, movesVar = 0;
	private String levelVar = null;

	private Font headerFont = new Font("Arial", Font.BOLD, 50);

	WinWindow(int time, int moves, String level){

		super();

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// gets the dimensions to set frame in center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHWIN/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTWIN/2);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates the frame with certain properties
		setSize(WIDTHWIN, HEIGHTWIN);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
<<<<<<< HEAD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		
		// uses a Panel in order to make a new layout(Grid) in a "layer" of the Border Layout
		JPanel infoPanel = new JPanel(); 
		infoPanel.setLayout(new GridLayout(3, 1));
		
		
=======
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new BorderLayout()); // creates a "bottom" Border Layout

		// get info from other frames
		timeVar = time;
		movesVar = moves;
		levelVar = level;

		if(levelVar.equals("easy")){
			levelVar = "Easy";
		}
		else
			levelVar = "Hard";


		// uses a Panel in order to make a new layout(Grid) in a "layer" of the Border Layout
		JPanel infoPanel = new JPanel(); 
		infoPanel.setLayout(new GridLayout(3, 1));


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// create a label to display at the top of the frame
		JLabel header = new JLabel("YOU WON", JLabel.CENTER);
		header.setFont(headerFont);
		infoPanel.add(header);
<<<<<<< HEAD
		
		
		// creates a Text Area to display user info
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		JTextArea textInfo = new JTextArea("Level You Were Playing: " + level + "\nYour Time: " + time + "\nHow many moves it took: " + moves);
		textPanel.add(textInfo, BorderLayout.CENTER);
		infoPanel.add(textPanel);
		
		
=======


		// creates a Text Area to display user info
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3,1));


		JPanel centerInfoLevel = new JPanel();
		centerInfoLevel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel levelInfo = new JLabel("Level You Were Playing: " + levelVar);
		centerInfoLevel.add(levelInfo);
		textPanel.add(centerInfoLevel);


		JPanel centerInfoTime = new JPanel();
		centerInfoTime.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel timeInfo = new JLabel("Your Time: " + time);
		centerInfoTime.add(timeInfo);
		textPanel.add(centerInfoTime);


		JPanel centerInfoMoves = new JPanel();
		centerInfoMoves.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel movesInfo = new JLabel("How many moves it took: " + moves);
		centerInfoMoves.add(movesInfo);
		textPanel.add(centerInfoMoves);


		infoPanel.add(textPanel);


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a new Panel to Enter name
		JPanel namePanelBorder = new JPanel();
		namePanelBorder.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		inputName = new JTextField("Please enter in your name...");
<<<<<<< HEAD
		namePanel.add(inputName);
		
=======

		inputName.addKeyListener(new KeyAdapter(){
			public int x = 0;
			public void keyPressed(KeyEvent e){
				if (x == 0){
					inputName.setText("");
					x++;
				}
			}
		});

		inputName.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				inputName.setText("");
			}
		});
		namePanel.add(inputName);

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a button (on the same Panel above) to "submit" your name
		JButton okayName = new JButton("OK");
		okayName.addActionListener(this);
		namePanel.add(okayName);
		namePanelBorder.add(namePanel);
		infoPanel.add(namePanelBorder);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a new button used to exit to the Start Screen
		JPanel exitButtonPanel = new JPanel();
		exitButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton exitStart = new JButton("Exit to Home");
		exitStart.addActionListener(this);
		exitButtonPanel.add(exitStart);
		add(exitButtonPanel, BorderLayout.SOUTH);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// add the "base" grid panel to the frame
		add(infoPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		
		String getInput = e.getActionCommand(); // used to obtain what the button when pressed
		String getName = null; 
		
=======

		String getInput = e.getActionCommand(); // used to obtain what the button when pressed
		String getName = null; 

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// if the button said "OK" then a new screen will pop up and the user info will be put to a file
		if(getInput.equals("OK")){
			getName = inputName.getText();
			HighScoreFile(getName, timeVar, movesVar, levelVar);
<<<<<<< HEAD
			ErrorWindow ew = new ErrorWindow("Win Screen");
			ew.setVisible(true);
		}
		// if the button said "Exit to Home" then all screens will dispose and a new Start Screen will show
		else if(getInput.equals("Exit to Home")){
			StartMenu newStart = new StartMenu(false);
			newStart.setVisible(true);
=======
			dispose();
			ErrorWindow ew = new ErrorWindow("Win Screen", null, 0);
			ew.setVisible(true);

		}
		// if the button said "Exit to Home" then all screens will dispose and a new Start Screen will show
		else if(getInput.equals("Exit to Home")){
			ErrorWindow notSavePrompt = new ErrorWindow("Your score was not saved.", null, 0);
			notSavePrompt.setVisible(true);
			//StartMenu newStart = new StartMenu(false);
			//newStart.setVisible(true);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
			dispose();
		}
	}
	public void HighScoreFile(String name, int time, int moves, String level){
<<<<<<< HEAD
		PrintWriter highScoreFile = null;
		
		try{
			// opens up a file called "highscores" and outputs the info to the file
			highScoreFile = new PrintWriter("highscores.txt");
			highScoreFile.print(name + " " + time + " " + moves + " " + level);
=======
		BufferedWriter highScoreFile = null;
		try{
			// opens up a file called "highscores" and outputs the info to the file
			highScoreFile = new BufferedWriter(new FileWriter("highscores.txt", true));
			highScoreFile.write(name + " " + time + " " + moves + " " + levelVar + "\n");
			highScoreFile.flush();
			highScoreFile.close();
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		}
		catch (Exception e){
			System.out.println("Error making file");
		}
<<<<<<< HEAD
		highScoreFile.flush();
		highScoreFile.close();
=======
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
	}

}
