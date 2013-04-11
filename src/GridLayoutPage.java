
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class GridLayoutPage extends JFrame implements ActionListener{
	
	public static final int WIDTHGRID = 500;
	public static final int HEIGHTGRID = 500;
	
	private String getLevel = null;
	private String constantArray[] = new String[81];
	private String answerArray[] = new String[81];
	
	private int counterPress = 0, timeCount = 0, delay = 1000, indexCounter = 0;
	private int indexArray[] = new int[81];
	
	private JPanel topPanel = null, gridPanel = null;
	private JLabel timeClock = null;
	private JLabel moveCounter = null;
	private JLabel levelView = null;
	private JTextField[] input = new JTextField[81];


	private Boolean[] checkIfAnswered = new Boolean[81];
	Boolean checkDemovar;
	
	Font inputFont = new Font("Arial", Font.BOLD, 30);
	
	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
        public void actionPerformed(ActionEvent e) {
            timeUpdate();
        }
     });
	
	public GridLayoutPage(int x, int y, String level, Boolean checkDemo) {
		
		super();
		
		
		// gets info need to make certain "check"s 
		getLevel = level; // gets level
		checkDemovar = checkDemo; // checks if "Demo" has been pressed
		Arrays.fill(checkIfAnswered, false); // fills the "check if answered" to all false
		Arrays.fill(indexArray, 0); // fills the index array to all 0
		getConstantNumbers(); // opens an input .txt file to input "constant" numbers
		getAnswers(); // opens the corresponding answers .txt file to get "answers"
		
		
		// check if "Demo" is ON, if 'ON' then will fill every array position but 1 to the answer
		if(checkDemovar){
			indexCounter = 81;
			int i = 0, lastIndex = 0;
			while(indexArray[i] > 0){
				lastIndex = indexArray[i];
				i++;
			}
			for (i = 0; i < 81; i++){
				if(i == lastIndex){
					continue;
				}
				else{
					constantArray[i] = answerArray[i];
					indexArray[i] = i;
				}
			}
		}
		
		
		// sets screen to pop up in middle of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHGRID/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTGRID/2);
		
		
		// sets properties of frame
		setSize(WIDTHGRID, HEIGHTGRID);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // sets the base layout to Border Layout to add multiple frames
		
		
		// creates a new Grid Layout to add the top pane (indicator, grid for game, check buttons)
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
		
		add(topPanel, BorderLayout.NORTH); // adds the pane to the top of the base Border Layout (to frame)
		
		
		// creates a new 9x9 Grid Layout
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(x, y));
		
		
		// will fill in or leave blank the text fields in the grid
		for (int i = 0; i < (9*9); i++){
			input[i] = new JTextField(1);
			input[i].setFont(inputFont);
			input[i].setHorizontalAlignment(JTextField.CENTER);
			int moveConstant = 0;
			for (int j = 0; j < indexCounter; j++){ // 
				if(i == indexArray[j]){ // if the index i is equal to a cell that should have a constant value then the cell will show the constant and remain un-editble
					input[i].setText(constantArray[indexArray[j]]);
					input[i].setEditable(false);
					moveConstant++;
				}
				else
					input[i].addActionListener(this); // else the cell becomes "actionable"
				
			}
			
			// used to make the layout look nice
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
		
		add(gridPanel, BorderLayout.CENTER); // adds the game grid to frame
		
		
		// creates a new Panel to place buttons (centered and spread 50px apart)
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));
		
		
		// submit button to check if answers are correct
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);
		
		
		// quit to home to exit and go back to Start Screen
		JButton exitButton = new JButton("Quit to Home");
		exitButton.addActionListener(this);
		bottomPanel.add(exitButton);
		 
		
		// the user can guess if what they have is correct
		JButton guessButton = new JButton("Guess");
		guessButton.addActionListener(this);
		bottomPanel.add(guessButton);
		
		add(bottomPanel, BorderLayout.SOUTH); // adds all buttons to frame
		
		gridPanel.setVisible(true);
		
		time.start(); // starts time
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonCheck = e.getActionCommand();
		Boolean checkWin;
		
		if (buttonCheck.equals("Submit")){
			time.stop(); // stops time momentarily to check for win
			
			// if the user hits "Submit" then the program will check if they have the correct answers
			checkWin = checkIfWin(); // returns true if correct, false if wrong
			checkWinWindow(checkWin); // will either throw an error if wrong or diplay a "Win Screen" if right
		}
		// will get rid of current window and go back to home
		else if (buttonCheck.equals("Quit to Home")){
			dispose();
			StartMenu newStart = new StartMenu(false);
			newStart.setVisible(true);
		}
		// check the current numbers for correct/incorrect values
		else if (buttonCheck.equals("Guess")){
			checkGuessNumbers();
		}
		else{
			moveCounter.setText("Total Moves: " + (++counterPress - 35)); 
			checkCorrectFormat(e);
		}	
	}

	public void checkCorrectFormat(ActionEvent e) {
		
		for (int i = 0; i<(9*9); i++){
			String inputCheck = input[i].getText(); // reads in the input from the grid

			if (!inputCheck.equals("")){
				try{
					int number = Integer.parseInt(inputCheck); // trys to parse the string to an integer (only numbers allowed)
					
					// if it is a number then will check for: less then 9 and greater then 0
					if(number>9||number<0){
						
						// if all it is an incorrect number it will get removed and an error window will pop up
						input[i].setText("");
						ErrorWindow ew = new ErrorWindow("Bad Number");
						ew.setVisible(true);
						break;
					}
					// if all conditions hold true and the number has been "answered" before through guess then it will be set back to black (if red)
					else if(!checkIfAnswered[i])
						input[i].setForeground(Color.BLACK);
				}
				// if not a number entered then an error window will pop up informing the user
				catch(NumberFormatException nfe){
					ErrorWindow ew = new ErrorWindow("Not Number");
					ew.setVisible(true);
					input[i].setText("");
				}
			}
		}
	}
	
	public void timeUpdate(){
		// starts the clock
		timeClock.setText("Time: " + ++timeCount);
	}
	public void getConstantNumbers(){
		
		Scanner inputNumbers = null;
		int constantCounter = 0;
		String readInNumbers = "";
		
		try{
			inputNumbers = new Scanner(new FileInputStream("samplesudoku1.txt")); // trys to open the "constant" number file
		}
		catch (Exception e){
			System.out.println("File Error");
			System.exit(0);
		}
		// reads in each number until it has reached the 81st number
		while(inputNumbers.hasNextLine() || constantCounter < 81){
			if (constantCounter == 81)
				break;
			
			readInNumbers = inputNumbers.next();
			
			// if the number equals 0 then the program will record and move on
			if(readInNumbers.equals("0")){
				constantArray[constantCounter] = "0";
				constantCounter++;
			}
			// if the number is not 0 then the program will record the index in the graph, take the constant value for later use and record how many constant there are
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
			inputNumbers = new Scanner(new FileInputStream("samplesudoku1ans.txt")); // trys to open the answers file
			
		}
		catch (Exception e){
			System.out.println("File Error");
			System.exit(0);
		}
		
		// reads in each number until it has reached the 81st number
		while(inputNumbers.hasNextLine() || constantCounter < 81){
			if (constantCounter == 81)
				break;
			
			
			// will read in each number until the parameters are meet
			readInNumbers = inputNumbers.next();
			answerArray[constantCounter] = readInNumbers;
			constantCounter++;
		}
		inputNumbers.close();
	}
	public void checkGuessNumbers(){
		
		String getInput = "";
		int indexCounter = 0;
		
		for(int i = 0; i< 81; i++){
			getInput = input[i].getText(); // obtain the text from the user input
			
			
			// used to check if the number is correct and if the number is not a predefined "constant"
			if(getInput.equals(answerArray[i])){
				input[i].setText(answerArray[i]);
				
				// checks for constant
				if(i == indexArray[indexCounter]){
					input[i].setForeground(Color.BLACK);
					indexCounter++;
				}
				// if all holds then the number guessed is correct and will turn blue and will not be editable
				else{
					checkIfAnswered[i] = true;
					input[i].setForeground(Color.BLUE);
					input[i].setEditable(false);	
				}
			}
			// if the number was guessed and it wrong it will turn red
			else if(!getInput.equals(""))
				input[i].setForeground(Color.RED);

		}
	}
	public boolean checkIfWin(){
		
		String inputCheck = null;
		
		for(int i = 0; i < 81; i++){
			
			inputCheck = input[i].getText(); // gets user input
			
			// if any single answer is wrong then the whole board is wrong as well
			if(!inputCheck.equals(answerArray[i])){
				return false;
			}
		}
		return true; // if everything is right then the user won and will return true;
	}
	public void checkWinWindow(Boolean win){
		
		// if the user did not win then an error will be thrown by a window
		if(!win){
			ErrorWindow ew = new ErrorWindow("Not Win");
			ew.setVisible(true);
			time.start();
		}
		// if user did win then a new "WinWindow" will pop up
		else{
			WinWindow ww = new WinWindow(timeCount, counterPress, getLevel);
			ww.setVisible(true);
		}
	}
}


