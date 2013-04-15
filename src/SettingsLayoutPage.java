
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SettingsLayoutPage extends JFrame implements ActionListener{
	
	public static final int WIDTHSETTINGS = 500;
	public static final int HEIGHTSETTINGS = 500;
	
	Boolean demoCheckvar = false; // variable to check if the "Demo" button was press

	public SettingsLayoutPage(Boolean DemoCheck) {
		
		super();
		
		// used to check if the user pressed the "Demo" button (the boolean value will carry through the program)
		demoCheckvar = DemoCheck;
		
		
		// gets the screen resolution to display the frame in the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHSETTINGS/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTSETTINGS/2);
		
		
		// set the properties of the frame
		setSize(WIDTHSETTINGS, HEIGHTSETTINGS);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		// creates a top grid panel for spacing 
		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 2));
		
		
		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel = new JPanel();
		topBackPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		// Back button made to move back to the Start Screen (placed on the top left of screen)
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		topBackPanel.add(backButton);
		
		
		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel1 = new JPanel();
		topBackPanel1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		// Advanced button made to move back to the Start Screen (placed on the right left of screen)
		JButton advanceButton = new JButton("Advanced");
		advanceButton.addActionListener(this);
		topBackPanel1.add(advanceButton);
		
		
		// adds both panels to the base grid panel
		topGrid.add(topBackPanel);
		topGrid.add(topBackPanel1);
		
		
		add(topGrid, BorderLayout.NORTH); // adds the grid panel to the top (NORTH) of the screen
		
		
		// creates a 3 - row, 1- column grid to be used to display button top to bottom
		JPanel lowerGrid = new JPanel();
		lowerGrid.setLayout(new GridLayout(3, 1));
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid1 = new JPanel();
		panelOnGrid1.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		// creates a HighScore button to be pressed and check/pop up a new window to show previous high scores (if exists)
		JButton highScore = new JButton("HighScores");
		highScore.addActionListener(this);
		panelOnGrid1.add(highScore);
		
		
		// Button to be replaced later
		JButton NEWBUTTON = new JButton("NEW BUTTON");
		NEWBUTTON.addActionListener(this);
		panelOnGrid1.add(NEWBUTTON);
		
		lowerGrid.add(panelOnGrid1); // adds the buttons to the first row of the base "grid" layout
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid2 = new JPanel();
		panelOnGrid2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		// Button to be replaced later
		JButton NEWBUTTON1 = new JButton("NEW BUTTON");
		NEWBUTTON1.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON1);
		
		
		// Button to be replaced later
		JButton NEWBUTTON2 = new JButton("NEW BUTTON");
		NEWBUTTON2.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON2);
		
		lowerGrid.add(panelOnGrid2); // adds the buttons to the second row of the base "grid" layout
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid3 = new JPanel();
		panelOnGrid3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		// Button to be replaced later
		JButton NEWBUTTON3 = new JButton("NEW BUTTON");
		NEWBUTTON3.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON3);
		
		
		// Button to be replaced later
		JButton NEWBUTTON4 = new JButton("NEW BUTTON");
		NEWBUTTON4.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON4);
		
		lowerGrid.add(panelOnGrid3); // adds the buttons to the third row of the base "grid" layout
		
		
		// adds everything to the frame
		add(lowerGrid, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		
		String getAction = e.getActionCommand(); // used to get the command of the button
		
		
		// if the button says "Back" then the current window will be disposed and a new Start Screen will be created
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu(demoCheckvar);
			newStart.setVisible(true);
		}
		// if the button says "High Scores" then a new window will pop up and display any high scores
		else if(getAction.equals("HighScores")){
			Scanner checkSettingsExist = null;
			try{
				// used to check if the highscores file exists, if not then an error will be caught and a new window will say that no file exist
				checkSettingsExist = new Scanner(new FileInputStream("highscores.txt"));
				checkSettingsExist.close();
				HighScores highScorePage = new HighScores();
				highScorePage.setVisible(true);
			}
			catch(FileNotFoundException ex){
				ErrorWindow noScores = new ErrorWindow("No Scores");
				noScores.setVisible(true);
			}
		}
		// if the button says "Advanced" then the current window will be disposed and a new "AdvancedSettings" window will appear
		else if(getAction.equals("Advanced")){
			dispose();
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
		}
		else if(getAction.equals("NEW BUTTON")){
		}
		else
			System.out.println("Error");
	}
}
