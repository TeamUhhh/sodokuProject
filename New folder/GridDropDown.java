import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class GridDropDown extends JFrame implements ActionListener{

	
	public static final int WIDTHGRID = 500;
	public static final int HEIGHTGRID = 500;
	
	private String getLevel = null;
	private String constantArray[] = new String[81];
	private String answerArray[] = new String[81];
	
	private int counterPress = 0, timeCount = 0, delay = 1000, indexCounter = 0, randomFile = 0;
	private int indexArray[] = new int[81];
	
	private JPanel topPanel = null, gridPanel = null;
	private JLabel timeClock = null;
	private JLabel moveCounter = null;
	private JLabel levelView = null;
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	JLabel inputLabel[] = new JLabel[81];
	JComboBox[] comboBox = null;
	int[] findIndex = {0};
	Boolean ckDropDown = false;
	


	private Boolean[] checkIfAnswered = new Boolean[81];
	Boolean checkDemovar;
	
	Font inputFont = new Font("Arial", Font.BOLD, 30);
	
	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
        public void actionPerformed(ActionEvent e) {
            timeUpdate();
        }
     });

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public GridDropDown(final int x, final int y, String level, Boolean checkDropDown, int select) {
		
		super();
		
		// gets info need to make certain "check"s 
		getLevel = level; // gets level
		Arrays.fill(checkIfAnswered, false); // fills the "check if answered" to all false
		Arrays.fill(indexArray, 0); // fills the index array to all 0
		getRandom();
		getConstantNumbers(); // opens an input .txt file to input "constant" numbers
		getAnswers(); // opens the corresponding answers .txt file to get "answers"

		System.out.println(indexCounter);
		
		// sets screen to pop up in middle of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHGRID/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTGRID/2);
		
		
		// sets properties of frame
		setSize(800, 700);
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
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(9,9));
		JPanel grid2[] = new JPanel[81];
		int k = 0, b = 0;
		comboBox = new JComboBox[(81 - indexCounter)];
		findIndex = new int[(81 - indexCounter)];
		
		for(int i = 0; i < 81; i++){
			grid2[i] = new JPanel(new GridBagLayout());
			//grid2.setBorder(blackline);
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 3;
			
			
			inputLabel[i] = new JLabel("     ");
			inputLabel[i].setFont(inputFont);
			//inputLabel[i].setBorder(blackline);
			grid2[i].add(inputLabel[i]);
			
			if(i == indexArray[k]){ // if the index i is equal to a cell that should have a constant value then the cell will show the constant and remain un-editble
				inputLabel[i].setText("  " + constantArray[indexArray[k]] + "  ");
				inputLabel[i].setForeground(Color.RED);
				//inputLabel[i].setBackground(Color.DARK_GRAY);
				//inputLabel[i].setOpaque(true);
				k++;
			}
			else{
				comboBox[b] = new JComboBox();
				//comboBox[i].setSelectedIndex(4);
				c.gridwidth = 1;
				comboBox[b].addItem(" ");
				comboBox[b].addItem("1");
				comboBox[b].addItem("2");
				comboBox[b].addItem("3");
				comboBox[b].addItem("4");
				comboBox[b].addItem("5");
				comboBox[b].addItem("6");
				comboBox[b].addItem("7");
				comboBox[b].addItem("8");
				comboBox[b].addItem("9");
				comboBox[b].addActionListener(this);
				grid2[i].add(comboBox[b]);
				findIndex[b] = i; 
				b++;
				
			}
			grid.add(grid2[i]);
		}

		for (int j = 0; j < 81; j++){ // 

			// used to make the layout look nice
			if (j == 2 || j == 11 || j == 29 || j == 38 || j == 56 || j == 65 || j == 74)
			{                                                     //top left bottom right color
				grid2[j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));
			}
			else if (j == 5 || j == 14  || j == 32 || j == 41 || j == 59 || j == 68 || j == 77)
			{
				grid2[j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));
			}
			else if (j == 20 || j == 47 || j == 23 || j == 50)
			{
				grid2[j].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.black));
			}
			else if ((j >= 18 && j <= 26) || (j >= 45 && j <= 53))
			{
				grid2[j].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.black));
			}
			else
			{
				grid2[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}
		
		
		add(grid, BorderLayout.CENTER); // adds the game grid to frame
		
		
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
		
		//gridPanel.setVisible(true);
		
		time.start(); // starts time
	}
	private JMenuItem makeMenuItem(String name){
		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) {
		String buttonCheck = e.getActionCommand();
		Boolean checkWin;
		int dropDown1 = 0;
		String dropDown = null;
		int getIndex = 0;

		if(!buttonCheck.equals("comboBoxChanged")){
			if (buttonCheck.equals("Submit")){
				time.stop(); // stops time momentarily to check for win

				// if the user hits "Submit" then the program will check if they have the correct answers
				checkWin = checkIfWin(); // returns true if correct, false if wrong
				checkWinWindow(checkWin); // will either throw an error if wrong or diplay a "Win Screen" if right
			}
			// will get rid of current window and go back to home
			else if (buttonCheck.equals("Quit to Home")){
				dispose();
				StartMenu newStart = new StartMenu(false, true, false);
				newStart.setVisible(true);
			}
			// check the current numbers for correct/incorrect values
			else if (buttonCheck.equals("Guess")){
				checkGuessNumbers();
			}
		}
		else{
			moveCounter.setText("Total Moves: " + (++counterPress));

			for(int i = 0; i < 81; i++){
				dropDown1 = comboBox[i].getSelectedIndex();
				if (dropDown1 > 0){
					getIndex = i;
					break;
				}
			}

			int labelIndex = findIndex[getIndex];
			System.out.println(labelIndex);

			JComboBox cb = (JComboBox)e.getSource();
			dropDown = (String)cb.getSelectedItem();

			if(dropDown.equals("1")){
				inputLabel[labelIndex].setText("  1  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("2")){
				inputLabel[labelIndex].setText("  2  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("3")){
				inputLabel[labelIndex].setText("  3  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("4")){
				inputLabel[labelIndex].setText("  4  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("5")){
				inputLabel[labelIndex].setText("  5  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("6")){
				inputLabel[labelIndex].setText("  6  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("7")){
				inputLabel[labelIndex].setText("  7  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("8")){
				inputLabel[labelIndex].setText("  8  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
			else if(dropDown.equals("9")){
				inputLabel[labelIndex].setText("  9  ");
				comboBox[getIndex].setSelectedIndex(0);
			}
		}
			
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void timeUpdate(){
		// starts the clock
		timeClock.setText("Time: " + ++timeCount);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void getConstantNumbers(){
		
		Scanner inputNumbers = null;
		int constantCounter = 0;
		String readInNumbers = "";
		
		try{
			inputNumbers = new Scanner(new FileInputStream("samplesudoku" + randomFile + ".txt")); // trys to open the "constant" number file
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void getAnswers(){
		
		Scanner inputNumbers = null;
		int constantCounter = 0;
		String readInNumbers = "";
		
		try{
			inputNumbers = new Scanner(new FileInputStream("samplesudoku"  + randomFile + "ans.txt")); // trys to open the answers file
			
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void checkGuessNumbers(){
		
		String getInput = "";
		int indexCounter = 0;
		
		for(int i = 0; i< 81; i++){
				getInput = inputLabel[i].getText(); // obtain the text from the user input
				
				// used to check if the number is correct and if the number is not a predefined "constant"
				if((getInput.equals("  " + answerArray[i] + "  ")) || getInput.equals(answerArray[i])){
					inputLabel[i].setText(answerArray[i]);

					// checks for constant
					if(i == indexArray[indexCounter]){
						inputLabel[i].setForeground(Color.RED);
						indexCounter++;
					}
					// if all holds then the number guessed is correct and will turn blue and will not be editable
					else{
						checkIfAnswered[i] = true;
						inputLabel[i].setForeground(Color.BLUE);
						for (int j = 0; j < 81; j++){
							if(findIndex[j] == i){
								comboBox[j].disable();
								break;
							}
						}
					}
				}
				// if the number was guessed and it wrong it will turn red
				else if(!getInput.equals("     "))
					inputLabel[i].setForeground(Color.GREEN);
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean checkIfWin(){
		
		String inputCheck = null;

		for(int i = 0; i < 81; i++){

			inputCheck = inputLabel[i].getText(); // gets user input

			// if any single answer is wrong then the whole board is wrong as well
			if((!(inputCheck.equals("  " + answerArray[i] + "  "))) && !(inputCheck.equals(answerArray[i]))){
				return false;
			}
		}
		return true; // if everything is right then the user won and will return true;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void getRandom(){
		Random random = new Random();
		randomFile = random.nextInt(2) + 1;
	}
}

