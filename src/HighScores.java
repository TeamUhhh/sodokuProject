import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class HighScores extends JFrame implements ActionListener{
	public static final int WIDTHHIGH = 400;
	public static final int HEIGHTHIGH = 400;
	
	Scanner readHighScores = null;
	JTextArea highScoreScreen;
	
	String name = null, time = null, moves = null, level = null;
	
	HighScores(){
		super();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHHIGH/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTHIGH/2);
		
		setSize(WIDTHHIGH, HEIGHTHIGH);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		try{
			readHighScores = new Scanner(new FileInputStream("highscores.txt"));
			name = readHighScores.next();
			time = readHighScores.next();
			moves = readHighScores.next();
			level = readHighScores.next();
			
			highScoreScreen = new JTextArea("Name: " + name + "   Your Time: " + time + "   Moves: " + moves + "   Levels: " + level);	
		}
		catch (FileNotFoundException e){
			System.out.println("HighScores file not found");
		}
		
		add(highScoreScreen, BorderLayout.CENTER);
		
		JPanel submitButton = new JPanel(new FlowLayout());
		JButton closeWindow = new JButton("OK");
		closeWindow.addActionListener(this);
		submitButton.add(closeWindow);
		add(submitButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand();
		
		if(getAction.equals("OK")){
			SettingsLayoutPage newSettings = new SettingsLayoutPage(false);
			newSettings.setVisible(true);
			dispose();
		}
		
	}

}