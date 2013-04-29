
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ErrorWindow extends JFrame implements ActionListener{
	ErrorWindow(String errorMessage){
		
		super();
		
		
		// gets the dimensions to set frame in center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - 450/2);
		int sHeight = (((int)screenSize.getHeight()/2) - 150/2);
		
		
		// sets the properties of the frame
		setSize(400, 150);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// creates a new Border Layout to display certain Error Messages (displays a label with the corresponding error message)
		if(errorMessage.equals("Not Number")){
				setLayout(new BorderLayout());
				JLabel errorStatement = new JLabel("Enter Numbers Only!", JLabel.CENTER);
				add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("Not Win")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("Sorry, not a Winning Combination", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("Bad Number")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("Enter numbers less than 9 and greater than 0 only!", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("Win Screen")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("Please Check 'Settings -> HighScrore' To Check Your Scores!", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("No Scores")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("You have no High Scores, Play a game and come back later", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("Your score was not saved.")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("Your score was not saved.", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("Delete")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("This Can NOT be un-done", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		
		if(!(errorMessage.equals("Delete"))){
		// creates an "OK" button to be pressed and dismiss window
			JPanel submitButton = new JPanel(new FlowLayout());
			JButton closeWindow = new JButton("OK");
			closeWindow.addActionListener(this);
			submitButton.add(closeWindow);
			add(submitButton, BorderLayout.SOUTH);
		}
		else{
			JPanel submitButton = new JPanel(new FlowLayout());
			JButton closeWindow = new JButton("I UnderStand");
			closeWindow.addActionListener(this);
			submitButton.add(closeWindow);
			add(submitButton, BorderLayout.SOUTH);
		}
	}

	public void actionPerformed(ActionEvent e){
		String getCommand = e.getActionCommand();
		
		if(getCommand.equals("I UnderStand")){
			System.out.println("hello");
			File deleteFile = null;
			try{
				deleteFile = new File("highscores.txt");
				deleteFile.delete();
			}
			catch(Exception er){
				System.out.println("Error");
			}
		}
		dispose(); // gets rid of the current window
	}
}
