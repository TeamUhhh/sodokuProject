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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class GridDropDown extends JFrame implements ActionListener{


	public static final int WIDTHGRID = 800;
	public static final int HEIGHTGRID = 700;

	private String getLevel = null, constantArray[] = new String[81], answerArray[] = new String[81];
	private int counterPress = 0, timeCount = 0, delay = 1000, indexCounter = 0, randomFile = 0, indexArray[] = new int[81], findIndex[] = {0}, constantCounter = 0;;

	private JPanel topPanel = null, gridPanel = null, bottomPanel = null, grid2[] = null;
	private JLabel timeClock = null, moveCounter = null, levelView = null, inputLabel[] = new JLabel[81];
	private JButton playAgain = null, exitButton = null;
	private JComboBox[] comboBox = null;

	private Boolean hideGuess = false, ckDropDown = false, hideGive = false, checkIfAnswered[] = new Boolean[81], checkHideTime = false, checkHideMove = false;

	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Font inputFont = new Font("Arial", Font.BOLD, 30);


	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
		public void actionPerformed(ActionEvent e) {
			timeUpdate();
		}
	});

	public GridDropDown(final int x, final int y, String level, Boolean checkDropDown, int select, Boolean checkTimeHide, Boolean checkMoveHide, Boolean guessHide, Boolean giveHide) {

		super();

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

		// gets info from other frames
		hideGive = giveHide;
		hideGuess = guessHide;
		checkHideTime = checkTimeHide;
		checkHideMove = checkMoveHide;
		getLevel = level; // gets level
		Arrays.fill(checkIfAnswered, false); // fills the "check if answered" to all false
		Arrays.fill(indexArray, 0); // fills the index array to all 0
		getRandom();
		getConstantNumbers(); // opens an input .txt file to input "constant" numbers
		getAnswers(); // opens the corresponding answers .txt file to get "answers"


		// creates a new Grid Layout to add the top pane (indicator, grid for game, check buttons)
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3));


		if(!checkHideTime){
			timeClock = new JLabel("Time: " + timeCount, JLabel.CENTER);
		}
		else{
			timeClock = new JLabel("Time: 0", JLabel.CENTER);
			timeClock.setForeground(new Color(200, 200, 200));
		}
		timeClock.setFont(new Font("Verdana", Font.BOLD, 13));
		topPanel.add(timeClock);


		// creates a "Total Moves" to keep track of the total moves
		if(checkHideMove){
			moveCounter = new JLabel("Total Moves: 0", JLabel.CENTER);
			moveCounter.setForeground(new Color(200, 200, 200));
		}
		else{
			moveCounter = new JLabel("Total Moves: " + counterPress, JLabel.CENTER);
		}
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
		grid2 = new JPanel[81];
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
			grid2[i].add(inputLabel[i]);

			if(i == indexArray[k]){ // if the index i is equal to a cell that should have a constant value then the cell will show the constant and remain un-editble
				inputLabel[i].setText("  " + constantArray[indexArray[k]] + "  ");
				inputLabel[i].setForeground(new Color(132, 132, 132, 255));
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
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));


		// submit button to check if answers are correct
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);


		// quit to home to exit and go back to Start Screen
		exitButton = new JButton("Quit to Home");
		exitButton.addActionListener(this);
		bottomPanel.add(exitButton);


		// the user can guess if what they have is correct
		JButton guessButton = new JButton("Guess");
		if(!guessHide){
			guessButton.addActionListener(this);	
		}
		else{
			guessButton.setBackground(new Color(204,204,204));
			guessButton.setEnabled(false);
		}
		bottomPanel.add(guessButton);

		JButton giveUp = new JButton("Give Up");
		if(!hideGive){
			giveUp.addActionListener(this);
		}
		else{
			giveUp.setEnabled(false);
			giveUp.setBackground(new Color(204,204,204));
		}
		bottomPanel.add(giveUp);

		add(bottomPanel, BorderLayout.SOUTH); // adds all buttons to frame

		//gridPanel.setVisible(true);

		time.start(); // starts time
	}
	private JMenuItem makeMenuItem(String name){
		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}
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
				StartMenu newStart = new StartMenu(false, true, false, checkHideTime, checkHideMove, hideGuess, hideGive, null);
				newStart.setVisible(true);
			}
			// check the current numbers for correct/incorrect values
			else if (buttonCheck.equals("Guess")){
				checkGuessNumbers();
			}
			else if(buttonCheck.equals("Give Up")){
				showAnswers();
				bottomPanel.removeAll();
				playAgain = new JButton("Play Again");
				playAgain.addActionListener(this);
				bottomPanel.add(playAgain);
				bottomPanel.add(exitButton);
				bottomPanel.revalidate();
				bottomPanel.repaint();
				time.stop();
			}
			else if(buttonCheck.equals("Play Again")){
				randomFile = 1;
				timeCount = 0;
				counterPress = 0;
				dispose();
				GridDropDown g1 = new GridDropDown(9, 9, getLevel, true, 1, checkHideTime, checkHideMove, hideGuess, hideGive);
				g1.setVisible(true);
			}
		}
		else{
			if(!checkHideMove){
				moveCounter.setText("Total Moves: " + (++counterPress));
			}

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
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("2")){
				inputLabel[labelIndex].setText("  2  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("3")){
				inputLabel[labelIndex].setText("  3  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("4")){
				inputLabel[labelIndex].setText("  4  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("5")){
				inputLabel[labelIndex].setText("  5  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("6")){
				inputLabel[labelIndex].setText("  6  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("7")){
				inputLabel[labelIndex].setText("  7  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("8")){
				inputLabel[labelIndex].setText("  8  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
			else if(dropDown.equals("9")){
				inputLabel[labelIndex].setText("  9  ");
				comboBox[getIndex].setSelectedIndex(0);
				inputLabel[labelIndex].setForeground(Color.BLACK);
			}
		}

	}
	public void timeUpdate(){
		// starts the clock
		if(!checkHideTime){
			timeClock.setText("Time: " + ++timeCount);
		}
	}
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
	public void getAnswers(){

		Scanner inputNumbers = null;
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
					inputLabel[i].setForeground(new Color(132, 132, 132, 255));
					indexCounter++;
				}
				// if all holds then the number guessed is correct and will turn blue and will not be editable
				else{
					checkIfAnswered[i] = true;
					inputLabel[i].setForeground(new Color(0, 172, 0, 255));
					for (int j = 0; j < 81; j++){
						if(findIndex[j] == i){
							grid2[i].remove(comboBox[j]);
							grid2[i].revalidate();
							grid2[i].repaint();
							break;
						}
					}
				}
			}
			// if the number was guessed and it wrong it will turn red
			else if(!getInput.equals("     ")){
				inputLabel[i].setForeground(new Color(204, 0, 0, 255));
			}
		}
	}
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
	public void checkWinWindow(Boolean win){

		// if the user did not win then an error will be thrown by a window
		if(!win){
			ErrorWindow ew = new ErrorWindow("Not Win", null, 0);
			ew.setVisible(true);
			time.start();
		}
		// if user did win then a new "WinWindow" will pop up
		else{
			WinWindow ww = new WinWindow(timeCount, counterPress, getLevel);
			ww.setVisible(true);
		}
	}
	public void getRandom(){
		Random random = new Random();
		randomFile = random.nextInt(2) + 1;
	}
	public void showAnswers(){
		int j = 0;
		for(int i = 0; i < 81; i++){
			inputLabel[i].setText(answerArray[i]);
		}
		System.out.println(indexCounter);
		for(int i = 0; i < 81; i++){
			if(findIndex[j] == i){
				grid2[i].remove(comboBox[j]);
				grid2[i].revalidate();
				grid2[i].repaint();
				j++;
			}
		}
	}
}

