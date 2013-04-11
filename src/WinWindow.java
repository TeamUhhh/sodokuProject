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
	Font headerFont = new Font("Arial", Font.BOLD, 50);
	JTextField inputName;
	int timeVar = 0, movesVar = 0;
	String levelVar = null;
	
	WinWindow(int time, int moves, String level){
		super();
		
		timeVar = time;
		movesVar = moves;
		levelVar = level;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHWIN/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTWIN/2);
		
		setSize(WIDTHWIN, HEIGHTWIN);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		// uses a Panel in order to make a new layout(Grid) in a "layer" of the Border Layout
		JPanel infoPanel = new JPanel(); 
		infoPanel.setLayout(new GridLayout(2, 1));
		
		JLabel header = new JLabel("You WON", JLabel.CENTER);
		header.setFont(headerFont);
		infoPanel.add(header);
		
		JTextArea textInfo = new JTextArea("Level You Were Playing: " + level + "\nYour Time: " + time + "\nHow many moves it took: " + moves);
		infoPanel.add(textInfo, BorderLayout.CENTER);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		inputName = new JTextField("Please enter in your name...");
		namePanel.add(inputName);
		
		JButton okayName = new JButton("OK");
		okayName.addActionListener(this);
		namePanel.add(okayName);
		
		infoPanel.add(namePanel, BorderLayout.CENTER);
		
		JPanel exitButtonPanel = new JPanel();
		exitButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton exitStart = new JButton("Exit to Home");
		exitStart.addActionListener(this);
		exitButtonPanel.add(exitStart);
		
		
		add(infoPanel, BorderLayout.CENTER);
		add(exitButtonPanel, BorderLayout.SOUTH);
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		String getInput = e.getActionCommand();
		String getName = null;
		if(getInput.equals("OK")){
			getName = inputName.getText();
			HighScoreFile(getName, timeVar, movesVar, levelVar);
			ErrorWindow ew = new ErrorWindow("Win Screen");
			ew.setVisible(true);
			
		}
		else if(getInput.equals("Exit to Home")){
			StartMenu newStart = new StartMenu(false);
			newStart.setVisible(true);
			dispose();
		}
	}
	public void HighScoreFile(String name, int time, int moves, String level){
		PrintWriter highScoreFile = null;
		
		try{
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
