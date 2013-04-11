import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class WinWindow extends JFrame implements ActionListener{
	
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
		
		
		// gets the dimensions to set frame in center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHWIN/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTWIN/2);
		
		
		// creates the frame with certain properties
		setSize(WIDTHWIN, HEIGHTWIN);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		
		// uses a Panel in order to make a new layout(Grid) in a "layer" of the Border Layout
		JPanel infoPanel = new JPanel(); 
		infoPanel.setLayout(new GridLayout(3, 1));
		
		
		// create a label to display at the top of the frame
		JLabel header = new JLabel("YOU WON", JLabel.CENTER);
		header.setFont(headerFont);
		infoPanel.add(header);
		
		
		// creates a Text Area to display user info
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		JTextArea textInfo = new JTextArea("Level You Were Playing: " + level + "\nYour Time: " + time + "\nHow many moves it took: " + moves);
		textPanel.add(textInfo, BorderLayout.CENTER);
		infoPanel.add(textPanel);
		
		
		// creates a new Panel to Enter name
		JPanel namePanelBorder = new JPanel();
		namePanelBorder.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		inputName = new JTextField("Please enter in your name...");
		namePanel.add(inputName);
		
		// creates a button (on the same Panel above) to "submit" your name
		JButton okayName = new JButton("OK");
		okayName.addActionListener(this);
		namePanel.add(okayName);
		namePanelBorder.add(namePanel);
		infoPanel.add(namePanelBorder);
		
		
		// creates a new button used to exit to the Start Screen
		JPanel exitButtonPanel = new JPanel();
		exitButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton exitStart = new JButton("Exit to Home");
		exitStart.addActionListener(this);
		exitButtonPanel.add(exitStart);
		add(exitButtonPanel, BorderLayout.SOUTH);
		
		
		// add the "base" grid panel to the frame
		add(infoPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		
		String getInput = e.getActionCommand(); // used to obtain what the button when pressed
		String getName = null; 
		
		// if the button said "OK" then a new screen will pop up and the user info will be put to a file
		if(getInput.equals("OK")){
			getName = inputName.getText();
			HighScoreFile(getName, timeVar, movesVar, levelVar);
			ErrorWindow ew = new ErrorWindow("Win Screen");
			ew.setVisible(true);
		}
		// if the button said "Exit to Home" then all screens will dispose and a new Start Screen will show
		else if(getInput.equals("Exit to Home")){
			StartMenu newStart = new StartMenu(false);
			newStart.setVisible(true);
			dispose();
		}
	}
	public void HighScoreFile(String name, int time, int moves, String level){
		PrintWriter highScoreFile = null;
		
		try{
			// opens up a file called "highscores" and outputs the info to the file
			highScoreFile = new PrintWriter("highscores.txt");
			highScoreFile.print(name + " " + time + " " + moves + " " + level);
		}
		catch (Exception e){
			System.out.println("Error making file");
		}
		highScoreFile.flush();
		highScoreFile.close();
	}

}
