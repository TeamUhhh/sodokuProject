
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GridLayoutPage extends JFrame implements ActionListener{
	
	public static final int WIDTHGRID = 500;
	public static final int HEIGHTGRID = 500;
	private int counterPress = 0, timeCount = 0, delay = 1000;
	private JPanel topPanel = null, gridPanel = null;
	private JLabel timeClock = null;
	private JLabel moveCounter = null;
	private JLabel levelView = null;
	private JTextField[] input = new JTextField[81];
	private String constantArray[] = new String[81];
	private String answerArray[] = new String[81];
	private int indexArray[] = new int[50];
	private int indexCounter = 0;
	private Boolean[] checkIfAnswered = new Boolean[81];
	Font inputFont = new Font("Arial", Font.BOLD, 30);
	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
        public void actionPerformed(ActionEvent e) {
            timeUpdate();
        }
     });
	

	public GridLayoutPage(int x, int y, String level) {
		super();
		
		Arrays.fill(checkIfAnswered, false);
		getNumbers();
		getAnswers();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHGRID/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTGRID/2);
		
		setSize(WIDTHGRID, HEIGHTGRID);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); // sets the base layout to Border Layout to add multiple frames
		
		// creates a new Grid Layout to add the top pane
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3));
		
		// creates a "Time" label to keep track of time
		timeClock = new JLabel("Time: " + timeCount, JLabel.CENTER);
		timeClock.setFont(new Font("Verdana", Font.BOLD, 13));
		topPanel.add(timeClock);
		
		// creates a "Total Moves" to keep track of the total moves
		moveCounter = new JLabel("Total Moves: " + counterPress, JLabel.CENTER);
		moveCounter.setFont(new Font("Verdana", Font.BOLD, 13));
		topPanel.add(moveCounter);
		
		// creates a new "Level" label to inform user of the Level
		levelView = new JLabel("Level: " + level, JLabel.CENTER);
		levelView.setFont(new Font("Verdana", Font.BOLD, 13));
		topPanel.add(levelView);
		
		add(topPanel, BorderLayout.NORTH); // adds the pane to the top of the base Border Layout
		
		// creates a new 9x9 Grid Layout
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(x, y));
		
		// used as a test input
		// used as a test input
		for (int i = 0; i < (9*9); i++){
			input[i] = new JTextField(1);
			input[i].setFont(inputFont);
			input[i].setHorizontalAlignment(JTextField.CENTER);
			int moveConstant = 0;
			for (int j = 0; j < indexCounter; j++){
				if(i == indexArray[j]){
					input[i].setText(constantArray[indexArray[j]]);
					input[i].setEditable(false);
					moveConstant++;
				}
				else
					input[i].addActionListener(this);
				
			}
			
			if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
			{                                                     //top left bottom right color
				input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));
			}
			else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
			{
				input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));
			}
			else if (i == 20 || i == 47 || i == 23 || i == 50)
			{
				input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.black));
			}
			else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
			{
				input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.black));
			}
			else
			{
				input[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			
			gridPanel.add(input[i]);
		}
		
		add(gridPanel, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);
		
		JButton exitButton = new JButton("Quit to Home");
		exitButton.addActionListener(this);
		bottomPanel.add(exitButton);
		
		JButton guessButton = new JButton("Guess");
		guessButton.addActionListener(this);
		bottomPanel.add(guessButton);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		gridPanel.setVisible(true);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonCheck = e.getActionCommand();
		if (buttonCheck.equals("Submit")){
			dispose();
			StartMenu newStart = new StartMenu();
			newStart.setVisible(true);
		}
		else if (buttonCheck.equals("Quit to Home")){
			dispose();
			StartMenu newStart = new StartMenu();
			newStart.setVisible(true);
		}
		else if (buttonCheck.equals("Guess")){
			checkCorrectNumbers();
		}
		else{
			moveCounter.setText("Total Moves: " + (++counterPress - 35)); 
			checkCorrectFormat(e);
		}
	//	gridPanel.add(input);
		//gridPanel.setVisible(true);
		
		
	}

	public void checkCorrectFormat(ActionEvent e) {
		
		for (int i = 0; i<(9*9); i++)
		{
				String inputCheck = input[i].getText();
				{
					if (!inputCheck.equals(""))
					{
						try{
							int number = Integer.parseInt(inputCheck);
							if(number>9||number<0)
							{
								input[i].setText("");
								ErrorNumberWindow ew = new ErrorNumberWindow();
								ew.setVisible(true);
								break;
							}
							else if(!checkIfAnswered[i])
								input[i].setForeground(Color.BLACK);
						}
						catch(NumberFormatException nfe)
						{
							ErrorWindow ew = new ErrorWindow();
							ew.setVisible(true);
							input[i].setText("");
						}
					}
				}
		}
	}
	
	public void timeUpdate()
	{
		timeClock.setText("Time: " + ++timeCount);
	}
	public void getNumbers(){
		
		Scanner inputNumbers = null;
		int constantCounter = 0;
		String readInNumbers = "";
		
		try{
			inputNumbers = new Scanner(new FileInputStream("samplesudoku1.txt"));
			
		}
		catch (Exception e){
			System.out.println("File Error");
			System.exit(0);
		}
		while(inputNumbers.hasNextLine() || constantCounter < 81){
			if (constantCounter == 81)
				break;
			
			readInNumbers = inputNumbers.next();
			if(readInNumbers.equals("0")){
				constantArray[constantCounter] = "0";
				constantCounter++;
			}
			else{
				constantArray[constantCounter] = readInNumbers;
				indexArray[indexCounter] = constantCounter;
				indexCounter++;
				constantCounter++;
			}
		}
		inputNumbers.close();
			
	}
	public void getAnswers(){
		
		Scanner inputNumbers = null;
		int constantCounter = 0;
		String readInNumbers = "";
		
		try{
			inputNumbers = new Scanner(new FileInputStream("samplesudoku1ans.txt"));
			
		}
		catch (Exception e){
			System.out.println("File Error");
			System.exit(0);
		}
		while(inputNumbers.hasNextLine() || constantCounter < 81){
			if (constantCounter == 81)
				break;
			
			readInNumbers = inputNumbers.next();
			answerArray[constantCounter] = readInNumbers;
			constantCounter++;
		}

		inputNumbers.close();
	}
	public void checkCorrectNumbers(){
		String getInput = "";
		int indexCounter = 0;
		
		for(int i = 0; i< 81; i++){
			getInput = input[i].getText();
			
			if(getInput.equals(answerArray[i])){
				input[i].setText(answerArray[i]);
				
				if(i == indexArray[indexCounter]){
					input[i].setForeground(Color.BLACK);
					indexCounter++;
				}
				else{
					checkIfAnswered[i] = true;
					input[i].setForeground(Color.BLUE);
					input[i].setEditable(false);
					
				}

			}
			else if(!getInput.equals(""))
				input[i].setForeground(Color.RED);

		}
	}

}


