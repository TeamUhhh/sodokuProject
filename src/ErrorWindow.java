import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ErrorWindow extends JFrame implements ActionListener{

	TimerClass gameTime = null;
	
	ErrorWindow(String errorMessage, TimerClass time, int number){
		
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
		
		// info from other screens
		gameTime = time;
		
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
		else if(errorMessage.equals("You Lose")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("Sorry, you have used all your remaining guess. Try again", JLabel.CENTER);
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
		
		
		// creates an "OK" button to be pressed and dismiss window
		JPanel submitButton = new JPanel(new FlowLayout());
		JButton closeWindow = new JButton("OK");
		closeWindow.addActionListener(this);
		submitButton.add(closeWindow);
		add(submitButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e){
		dispose(); // gets rid of the current window
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
			JLabel errorStatement = new JLabel("THIS CAN NOT BE UNDONE", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		else if(errorMessage.equals("No Solve")){
			setLayout(new BorderLayout());
			JLabel errorStatement = new JLabel("The file you choose (samplesudoku" + number + ".txt) can not be solved, Please delete that file.", JLabel.CENTER);
			add(errorStatement, BorderLayout.CENTER);
		}
		
		if(errorMessage.equals("No Solve")){
			JPanel submitButton = new JPanel(new FlowLayout());
			JButton closeWindow = new JButton("EXIT NOW");
			closeWindow.addActionListener(this);
			submitButton.add(closeWindow);
			add(submitButton, BorderLayout.SOUTH);
		}
		else if(!(errorMessage.equals("Delete"))){
			// creates an "OK" button to be pressed and dismiss window
			JPanel submitButton = new JPanel(new FlowLayout());
			JButton closeWindow = new JButton("OK");
			closeWindow.addActionListener(this);
			submitButton.add(closeWindow);
			add(submitButton, BorderLayout.SOUTH);
		} 
		else{
			JPanel submitButton = new JPanel(new FlowLayout());
			JButton closeWindow = new JButton("I Understand");
			closeWindow.addActionListener(this);
			submitButton.add(closeWindow);

			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(this);
			submitButton.add(cancel);

			add(submitButton, BorderLayout.SOUTH);


		}
	}

	public void actionPerformed(ActionEvent e){
		
		String getMessage = e.getActionCommand();
		
		if(getMessage.equals("I Understand")){
			try{
				File filed = new File("highscores.txt");
				filed.delete();
				dispose();
			}catch(Exception er){
				System.out.println("Can not open HighScore file");
			}
		}
		else if(getMessage.equals("Exit Now")){
			Runtime.getRuntime().halt(0);
		}
		else if(getMessage.equals("Cancel")){
			dispose();
		}
		else{
			//gameTime.startTimer(false);
			dispose(); // gets rid of the current window
		}
		//need gameTimer here if not win
	}
}
