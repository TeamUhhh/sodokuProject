
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.Timer;
=======
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328


public class GridLayoutPage extends JFrame implements ActionListener{

	public static final int WIDTHGRID = 500;
	public static final int HEIGHTGRID = 500;
<<<<<<< HEAD
	
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
=======

	private String getLevel = null, constantArray[] = new String[81], answerArray[] = new String[81], numberArray[] = new String[81];
	private int counterPress = 0, indexCounter = 0, randomFile = 01, moveConstant = 0, guessCountDown = 3, indexArray[] = new int[81], indexNumberArray[] = new int[81];

	TimerClass gameTime = null;

	private JPanel topPanel = null, gridPanel = null, bottomPanel = null;
	private JLabel moveCounter = null, levelView = null;
	private JTextField[] input = new JTextField[81];
	private JMenuBar menuBar = null;
	private JMenu menu = null, color = null, colorNumber = null;
	private JButton guessButtonHard = null, submitButton = null, playAgain = null, exitButton = null;


	private RGBColor theColors = null;
	private Color getColor = null, getNumColor = null, gameColor = null; 
	private Boolean checkBackColor = false, checkNumColor = false, constant = false, checkStateChange = false, isWrong = false, isChanged = false, checkDemovar = false, checkHideTime = false, checkHideMove = false, isRight = true, 
			hideGuess = false, hideGive = false;;
			private boolean[] checkIfAnswered = new boolean[81];

			private Font inputFont = new Font("Arial", Font.BOLD, 30);

			public GridLayoutPage(final int x, final int y, String level, Boolean checkDemo, Boolean checkColor, Color setColor, Boolean checkNumberColor, Color numberColor, TimerClass gTime, RGBColor colorsOfBoard, int randomKeep, boolean checkChange, int counter, Boolean checkTimeHide, Boolean checkMoveHide, String[] cArray, boolean[] ifAnswered, Boolean guessHide, Boolean giveHide) {
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


				// sets all proper checks
				hideGuess = guessHide;
				hideGive = giveHide;
				checkHideMove = checkMoveHide;
				checkHideTime = checkTimeHide;
				checkStateChange = checkChange;
				gameTime = gTime;
				theColors = colorsOfBoard;
				// gets info need to make certain "check"s 
				getLevel = level; // gets level
				checkDemovar = checkDemo; // checks if "Demo" has been pressed
				checkBackColor = checkColor;
				getColor = setColor;
				getNumColor = numberColor;
				checkNumColor = checkNumberColor;
				Arrays.fill(checkIfAnswered, false); // fills the "check if answered" to all false
				Arrays.fill(indexArray, 0); // fills the index array to all 0

				if(checkChange){
					randomFile = randomKeep;
					counterPress = counter;
					getInputNumbers();
					for(int i = 0; i<(x*y); i++){
						checkIfAnswered[i] = ifAnswered[i];
					}
				}
				else{
					getRandom();
				}

				startSolver();
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
						if(!(i == lastIndex)){
							constantArray[i] = answerArray[i];
							indexArray[i] = i;
						} 
					}
				}


				menuBar = new JMenuBar();

				JPanel changeBackGrid = new JPanel();
				changeBackGrid.setLayout(new BorderLayout());

				JPanel colorGrid = new JPanel();
				colorGrid.setLayout(new GridLayout(3,3));
				colorGrid.setPreferredSize(new Dimension(50, 70));

				JButton test = new JButton(" RED ");
				test.addActionListener(this);
				test.setBackground(new Color(255, 60, 60, 255));
				test.setForeground(new Color(255, 60, 60, 255));
				test.setOpaque(true);
				colorGrid.add(test);

				JButton test1 = new JButton(" BLUE ");
				test1.addActionListener(this);
				test1.setBackground(new Color(173, 216, 230, 255));
				test1.setForeground(new Color(173, 216, 230, 255));
				test1.setOpaque(true);
				colorGrid.add(test1);

				JButton test2 = new JButton(" GREEN ");
				test2.addActionListener(this);
				test2.setBackground(new Color(152, 251, 152, 255));
				test2.setForeground(new Color(152, 251, 152, 255));
				test2.setOpaque(true);
				colorGrid.add(test2);

				JButton test3 = new JButton(" BLACK ");
				test3.addActionListener(this);
				test3.setBackground(Color.BLACK);
				test3.setForeground(Color.BLACK);
				test3.setOpaque(true);
				colorGrid.add(test3);

				JButton test4 = new JButton(" GRAY ");
				test4.addActionListener(this);
				test4.setBackground(new Color(220, 220, 220, 255));
				test4.setForeground(new Color(220, 220, 220, 255));
				test4.setOpaque(true);
				colorGrid.add(test4);

				JButton test5 = new JButton(" ORANGE ");
				test5.addActionListener(this);
				test5.setBackground(new Color(255, 205, 0, 255));
				test5.setForeground(new Color(255, 205, 0, 255));
				test5.setOpaque(true);
				colorGrid.add(test5);

				JButton test6 = new JButton(" CYAN ");
				test6.addActionListener(this);
				test6.setBackground(new Color(0, 255, 255, 255));
				test6.setForeground(new Color(0, 255, 255, 255));
				test6.setOpaque(true);
				colorGrid.add(test6);

				JButton test7 = new JButton(" PINK ");
				test7.addActionListener(this);
				test7.setBackground(new Color(255, 182, 193, 255));
				test7.setForeground(new Color(255, 182, 193, 255));
				test7.setOpaque(true);
				colorGrid.add(test7);

				JButton test8 = new JButton(" YELLOW ");
				test8.addActionListener(this);
				test8.setBackground(Color.YELLOW);
				test8.setForeground(Color.YELLOW);
				test8.setOpaque(true);
				colorGrid.add(test8);


				changeBackGrid.add(colorGrid, BorderLayout.CENTER);

				JPanel defaultButtonPanel1 = new JPanel();
				defaultButtonPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton defaultButton1 = new JButton("Default Board Color");
				defaultButton1.addActionListener(this);
				defaultButtonPanel1.add(defaultButton1);
				colorGrid.add(defaultButtonPanel1);

				changeBackGrid.add(defaultButtonPanel1, BorderLayout.SOUTH);



				color = new JMenu("Background Color");
				color.add(changeBackGrid);
				menuBar.add(color);

				JPanel changeNumberGrid = new JPanel();
				changeNumberGrid.setLayout(new BorderLayout());

				JPanel colorGridNumbers = new JPanel();
				colorGridNumbers.setLayout(new GridLayout(3,3));
				colorGridNumbers.setPreferredSize(new Dimension(50, 70));

				JButton numberRed = new JButton(" red ");
				numberRed.addActionListener(this);
				numberRed.setBackground(new Color(204, 0, 0, 255));
				numberRed.setForeground(new Color(204, 0, 0, 255));
				numberRed.setOpaque(true);
				colorGridNumbers.add(numberRed);

				JButton numberBlue = new JButton(" blue ");
				numberBlue.addActionListener(this);
				numberBlue.setBackground(Color.BLUE);
				numberBlue.setForeground(Color.BLUE);
				numberBlue.setOpaque(true);
				colorGridNumbers.add(numberBlue);

				JButton numberGreen = new JButton(" green ");
				numberGreen.addActionListener(this);
				numberGreen.setBackground(new Color(0, 170, 0, 255));
				numberGreen.setForeground(new Color(0, 170, 0, 255));
				numberGreen.setOpaque(true);
				colorGridNumbers.add(numberGreen);

				JButton numberBlack = new JButton(" black ");
				numberBlack.addActionListener(this);
				numberBlack.setBackground(Color.BLACK);
				numberBlack.setForeground(Color.BLACK);
				numberBlack.setOpaque(true);
				colorGridNumbers.add(numberBlack);

				JButton numberGray = new JButton(" gray ");
				numberGray.addActionListener(this);
				numberGray.setBackground(Color.GRAY);
				numberGray.setForeground(Color.GRAY);
				numberGray.setOpaque(true);
				colorGridNumbers.add(numberGray);

				JButton numberOrange = new JButton(" orange ");
				numberOrange.addActionListener(this);
				numberOrange.setBackground(Color.ORANGE);
				numberOrange.setForeground(Color.ORANGE);
				numberOrange.setOpaque(true);
				colorGridNumbers.add(numberOrange);

				JButton numberCyan = new JButton(" cyan ");
				numberCyan.addActionListener(this);
				numberCyan.setBackground(Color.CYAN);
				numberCyan.setForeground(Color.CYAN);
				numberCyan.setOpaque(true);
				colorGridNumbers.add(numberCyan);

				JButton numberPink = new JButton(" pink ");
				numberPink.addActionListener(this);
				numberPink.setBackground(Color.pink);
				numberPink.setForeground(Color.pink);
				numberPink.setOpaque(true);
				colorGridNumbers.add(numberPink);

				JButton numberYellow = new JButton(" yellow ");
				numberYellow.addActionListener(this);
				numberYellow.setBackground(Color.YELLOW);
				numberYellow.setForeground(Color.YELLOW);
				numberYellow.setOpaque(true);
				colorGridNumbers.add(numberYellow);

				changeNumberGrid.add(colorGridNumbers, BorderLayout.CENTER);

				JPanel defaultButtonPanel = new JPanel();
				defaultButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton defaultButton = new JButton("Default Number Color");
				defaultButton.addActionListener(this);
				defaultButtonPanel.add(defaultButton);
				colorGridNumbers.add(defaultButtonPanel);

				changeNumberGrid.add(defaultButtonPanel, BorderLayout.SOUTH);

				colorNumber = new JMenu("Number Color");
				colorNumber.add(changeNumberGrid);
				menuBar.add(colorNumber);

				setJMenuBar(menuBar);


				setJMenuBar(menuBar);








				// creates a new Grid Layout to add the top pane (indicator, grid for game, check buttons)
				topPanel = new JPanel();
				topPanel.setLayout(new GridLayout(1, 3));


				// creates a "Time" label to keep track of time
				if(!checkHideTime){
					gameTime.timeClock = new JLabel("Time: " + gameTime.getTime(), JLabel.CENTER);
				}
				else{
					gameTime.timeClock = new JLabel("Time: 0", JLabel.CENTER);
					gameTime.setTimerColor(new Color(200, 200, 200));
				}
				gameTime.timeClock.setFont(new Font("Verdana", Font.BOLD, 13));
				topPanel.add(gameTime.timeClock);


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
				gridPanel = new JPanel();
				gridPanel.setLayout(new GridLayout(x, y));


				// will fill in or leave blank the text fields in the grid
				for (int i = 0; i < (9*9); i++){
					if(checkBackColor){
						input[i] = new JTextField(1);
						input[i].setFont(inputFont);
						input[i].setHorizontalAlignment(JTextField.CENTER);
						input[i].setBackground(getColor);
						if(checkNumColor){
							input[i].setForeground(getNumColor);
						}
						else if((theColors.getRedColor() == 0 && theColors.getGreenColor() == 0 && theColors.getBlueColor() ==0) || (theColors.getRedColor() == 204 && theColors.getGreenColor() == 0 && theColors.getBlueColor() ==0)){
							input[i].setForeground(Color.white);
						}
					}
					else{
						input[i] = new JTextField(1);
						input[i].setFont(inputFont);
						input[i].setHorizontalAlignment(JTextField.CENTER);
						if(checkNumColor){
							if((theColors.getRedColor() == 0 && theColors.getGreenColor() == 0 && theColors.getBlueColor() ==0) || (theColors.getRedColor() == 204 && theColors.getGreenColor() == 0 && theColors.getBlueColor() ==0)){
								input[i].setForeground(Color.white);
							}
							else{
								input[i].setForeground(getNumColor);
							}
						}
					}

					moveConstant = 0;

					for (int j = 0; j < indexCounter; j++){ // 
						if(i == indexArray[j]){ // if the index i is equal to a cell that should have a constant value then the cell will show the constant and remain un-editble
							input[i].setText(constantArray[indexArray[j]]);
							input[i].setEditable(false);
							input[i].selectAll();
							moveConstant++;

							if(checkChange){
								if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
									input[i].setBackground(gridPanel.getBackground());
								} //red
								else if ((theColors.getRedColor() == 204 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(164, 0, 0, 255));
								} //blue 
								else if ((theColors.getRedColor() == 173 && theColors.getGreenColor() == 216 && theColors.getBlueColor() == 230)){
									input[i].setBackground(new Color(143, 186, 200, 255));
								} //green
								else if ((theColors.getRedColor() == 152 && theColors.getGreenColor() == 251 && theColors.getBlueColor() == 152)){
									input[i].setBackground(new Color(122, 221, 122, 255));
								} //black
								else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(75, 75, 75, 255));
								} //gray
								else if ((theColors.getRedColor() == 220 && theColors.getGreenColor() == 220 && theColors.getBlueColor() == 220)){
									input[i].setBackground(new Color(190, 190, 190, 255));
								} //orange
								else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 205 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(225, 175, 0, 255));
								} //cyan
								else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
									input[i].setBackground(new Color(0, 215, 215, 255));
								} //pink
								else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 182 && theColors.getBlueColor() == 193)){
									input[i].setBackground(new Color(225, 152, 163, 255));
								} //yellow
								else if (getColor == Color.YELLOW){
									input[i].setBackground(new Color(225, 225, 0, 255));
								}
							}
							break;
						}
						else if(i == indexNumberArray[j]){ // if the index i is equal to a cell that should have a constant value then the cell will show the constant and remain un-editble
							if(checkDemovar){
								input[i].setText(constantArray[indexNumberArray[j]]);
							}
							else{
								input[i].setText(numberArray[indexNumberArray[j]]);
								input[i].addActionListener(this);
							}
						}
						else if(checkIfAnswered[i]){
							input[i].setText(numberArray[i]);
							input[i].setEditable(false);
							if(checkChange){
								if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
									input[i].setBackground(gridPanel.getBackground());
								} //red
								else if ((theColors.getRedColor() == 204 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(164, 0, 0, 255));
								} //blue 
								else if ((theColors.getRedColor() == 173 && theColors.getGreenColor() == 216 && theColors.getBlueColor() == 230)){
									input[i].setBackground(new Color(143, 186, 200, 255));
								} //green
								else if ((theColors.getRedColor() == 152 && theColors.getGreenColor() == 251 && theColors.getBlueColor() == 152)){
									input[i].setBackground(new Color(122, 221, 122, 255));
								} //black
								else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(75, 75, 75, 255));
								} //gray
								else if ((theColors.getRedColor() == 220 && theColors.getGreenColor() == 220 && theColors.getBlueColor() == 220)){
									input[i].setBackground(new Color(190, 190, 190, 255));
								} //orange
								else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 205 && theColors.getBlueColor() == 0)){
									input[i].setBackground(new Color(225, 175, 0, 255));
								} //cyan
								else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
									input[i].setBackground(new Color(0, 215, 215, 255));
								} //pink
								else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 182 && theColors.getBlueColor() == 193)){
									input[i].setBackground(new Color(225, 152, 163, 255));
								} //yellow
								else if (getColor == Color.YELLOW){
									input[i].setBackground(new Color(225, 225, 0, 255));
								}
							}
						}
						else{
							input[i].addActionListener(this); // else the cell becomes "actionable"			
						}				
					}
					//white
					if(checkChange){
						if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
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
						} //red
						else if ((theColors.getRedColor() == 204 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(192, 192, 192, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(192, 192, 192, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(192, 192, 192, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(192, 192, 192, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192, 255)));
							}
						} //blue 
						else if ((theColors.getRedColor() == 173 && theColors.getGreenColor() == 216 && theColors.getBlueColor() == 230)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //green
						else if ((theColors.getRedColor() == 152 && theColors.getGreenColor() == 251 && theColors.getBlueColor() == 152)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //black
						else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 0 && theColors.getBlueColor() == 0)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(192, 192, 192, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(192, 192, 192, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(192, 192, 192, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(192, 192, 192, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192, 255)));
							}
						} //gray
						else if ((theColors.getRedColor() == 220 && theColors.getGreenColor() == 220 && theColors.getBlueColor() == 220)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //orange
						else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 205 && theColors.getBlueColor() == 0)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //cyan
						else if ((theColors.getRedColor() == 0 && theColors.getGreenColor() == 255 && theColors.getBlueColor() == 255)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //pink
						else if ((theColors.getRedColor() == 255 && theColors.getGreenColor() == 182 && theColors.getBlueColor() == 193)){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						} //yellow
						else if (getColor == Color.YELLOW){
							if (i == 2 || i == 11 || i == 29 || i == 38 || i == 56 || i == 65 || i == 74)
							{                                                     //top left bottom right color
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 5 || i == 14  || i == 32 || i == 41 || i == 59 || i == 68 || i == 77)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, new Color(75, 75, 75, 255)));
							}
							else if (i == 20 || i == 47 || i == 23 || i == 50)
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, new Color(75, 75, 75, 255)));
							}
							else if ((i >= 18 && i <= 26) || (i >= 45 && i <= 53))
							{
								input[i].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, new Color(75, 75, 75, 255)));
							}
							else
							{
								input[i].setBorder(BorderFactory.createLineBorder(new Color(75, 75, 75, 255)));
							}
						}
					}
					else{
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
					}



					final int counterVar=i;
					input[i].addKeyListener(new KeyListener()
					{

						/** Handle the key typed event from the text field. */
						public void keyTyped(KeyEvent e) {

						}

						public void keyPressed(KeyEvent e)
						{
							if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
								if (!(counterVar == 80)){
									if (e.getModifiers() > 0) {
										input[counterVar].transferFocusBackward();
									} 
									else {
										input[counterVar].transferFocus();
									}
									e.consume();
								}
							}
							else if(e.getKeyCode()== KeyEvent.VK_LEFT)
							{
								if (!(counterVar == 0)){
									input[counterVar].transferFocusBackward();
									e.consume();
								}
							}
							else if(e.getKeyCode()==KeyEvent.VK_DOWN)
							{
								if (!(counterVar > 71)){
									input[counterVar+8].transferFocus();
									e.consume();
								}
							}
							else if(e.getKeyCode()==KeyEvent.VK_UP)
							{  
								if (!(counterVar < 10)){
									input[counterVar-8].transferFocusBackward();
									e.consume();
								}
							}
							else if(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0)
							{
								checkCorrectFormat(e, counterVar, 0);
							}
							else if(e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1)
							{
								checkCorrectFormat(e, counterVar, 1);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2)
							{
								checkCorrectFormat(e, counterVar, 2);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3)
							{
								checkCorrectFormat(e, counterVar, 3);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4)
							{
								checkCorrectFormat(e, counterVar, 4);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5)
							{
								checkCorrectFormat(e, counterVar, 5);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6)
							{
								checkCorrectFormat(e, counterVar, 6);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7)
							{
								checkCorrectFormat(e, counterVar, 7);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8)
							{
								checkCorrectFormat(e, counterVar, 8);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9)
							{
								checkCorrectFormat(e, counterVar, 9);  
							}
							else if(e.getKeyCode() == KeyEvent.VK_NUM_LOCK)
							{}
							else
							{
								checkCorrectFormat(e, counterVar, -1);
							}
						}

						public void keyReleased(KeyEvent e)
						{
							if (!((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode()==KeyEvent.VK_DOWN) || 
									(e.getKeyCode()==KeyEvent.VK_UP)|| (e.getKeyCode() == KeyEvent.VK_0) || (e.getKeyCode() == KeyEvent.VK_1) ||
									(e.getKeyCode() == KeyEvent.VK_2) || (e.getKeyCode() == KeyEvent.VK_3) || (e.getKeyCode() == KeyEvent.VK_4) || 
									(e.getKeyCode() == KeyEvent.VK_3) || (e.getKeyCode() == KeyEvent.VK_4) || (e.getKeyCode() == KeyEvent.VK_5) ||
									(e.getKeyCode() == KeyEvent.VK_6) || (e.getKeyCode() == KeyEvent.VK_7) || (e.getKeyCode() == KeyEvent.VK_8) ||
									(e.getKeyCode() == KeyEvent.VK_9) || (e.getKeyCode() == KeyEvent.VK_NUMPAD0) || (e.getKeyCode() == KeyEvent.VK_NUMPAD1) || 
									(e.getKeyCode() == KeyEvent.VK_NUMPAD2) || (e.getKeyCode() == KeyEvent.VK_NUMPAD3) || (e.getKeyCode() == KeyEvent.VK_NUMPAD4) || 
									(e.getKeyCode() == KeyEvent.VK_NUMPAD5) || (e.getKeyCode() == KeyEvent.VK_NUMPAD6) || (e.getKeyCode() == KeyEvent.VK_NUMPAD7) || 
									(e.getKeyCode() == KeyEvent.VK_NUMPAD8) || (e.getKeyCode() == KeyEvent.VK_NUMPAD9) || (e.getKeyCode() == KeyEvent.VK_NUM_LOCK)))
							{
								correctFormat(e, counterVar, -1);
							}
						}
					});

					gridPanel.add(input[i]);
					input[i].requestFocusInWindow();
				}

				add(gridPanel, BorderLayout.CENTER); // adds the game grid to frame


				// creates a new Panel to place buttons (centered and spread 50px apart)
				bottomPanel = new JPanel();
				bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));


				// submit button to check if answers are correct
				JButton submitButton = new JButton("Submit");
				submitButton.addActionListener(this);
				bottomPanel.add(submitButton);


				// quit to home to exit and go back to Start Screen
				exitButton = new JButton("Quit to Home");
				exitButton.addActionListener(this);
				bottomPanel.add(exitButton);


				// the user can guess if what they have is correct
				if(!hideGuess){
					if(level.equals("Hard")){
						guessButtonHard = new JButton("Guess (" + guessCountDown + ")");
						guessButtonHard.addActionListener(this);
						bottomPanel.add(guessButtonHard);
					}
					else{
						JButton guessButton = new JButton("Guess");
						guessButton.addActionListener(this);
						bottomPanel.add(guessButton);
					}
				}
				else{
					JButton guessButton = new JButton("Guess");
					guessButton.setEnabled(false);
					guessButton.setBackground(new Color(204,204,204));
					bottomPanel.add(guessButton);
				}

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

				gridPanel.setVisible(true);

				gameTime.startTimer(checkHideTime); // starts time

			}	
			private JMenuItem makeMenuItem(String name){
				JMenuItem m = new JMenuItem(name);
				m.addActionListener(this);
				return m;
			}

			public void actionPerformed(ActionEvent e) {
				String buttonCheck = e.getActionCommand();
				Boolean checkWin;

				if (buttonCheck.equals("Submit")){
					gameTime.stopTimer(); // stops time momentarily to check for win

					// if the user hits "Submit" then the program will check if they have the correct answers
					checkWin = checkIfWin(); // returns true if correct, false if wrong
					if(checkWin){
						bottomPanel.removeAll();
						playAgain = new JButton("Play Again");
						playAgain.addActionListener(this);
						bottomPanel.add(playAgain);
						bottomPanel.add(exitButton);
						bottomPanel.revalidate();
						bottomPanel.repaint();
						gameTime.stopTimer();
					}
					checkWinWindow(checkWin); // will either throw an error if wrong or display a "Win Screen" if right
				}
				// will get rid of current window and go back to home
				else if (buttonCheck.equals("Quit to Home")){
					dispose();
					gameTime.resetTimer();
					gameTime.stopTimer();
					StartMenu newStart = new StartMenu(true, false, false, checkHideTime, checkHideMove, hideGuess, hideGive, gameTime);
					newStart.setVisible(true);
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
					gameTime.stopTimer();
				}
				// check the current numbers for correct/incorrect values
				else if (buttonCheck.equals("Guess")){
					checkGuessNumbers();
				}
				else if(buttonCheck.equals("Guess (" + guessCountDown + ")")){
					isWrong = false;
					checkGuessNumbers();
					if(isWrong){
						if(guessCountDown > 1){
							bottomPanel.remove(guessButtonHard);
							bottomPanel.revalidate();
							bottomPanel.repaint();
							guessCountDown--;
							guessButtonHard.setLabel("Guess (" + guessCountDown + ")");
						}else if(guessCountDown == 1){
							bottomPanel.removeAll();
							playAgain = new JButton("Play Again");
							playAgain.addActionListener(this);
							bottomPanel.add(playAgain);
							bottomPanel.add(exitButton);
							guessCountDown--;
							guessButtonHard.setLabel("Guess (" + guessCountDown + ")");
							guessButtonHard.setEnabled(false);
							bottomPanel.revalidate();
							bottomPanel.repaint();
							gameTime.stopTimer();
							ErrorWindow lost = new ErrorWindow("You Lose", gameTime, 0);
							lost.setVisible(true);
						}
					}
					bottomPanel.add(guessButtonHard);
				}
				else if(buttonCheck.equals("Open")){
					System.out.println("Open");
				}
				else if(buttonCheck.equals("Play Again")){
					randomFile = 0;
					gameTime.resetTimer();
					counterPress = 0;
					dispose();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, "Hard", false, false, null, false, null, gameTime, theColors, 0, false, 0, checkHideTime, checkHideMove, constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" RED ")){
					dispose();
					passInput();
					gameColor = new Color(204, 0, 0, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove, constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" BLUE ")){
					dispose();
					passInput();
					gameColor = new Color(173, 216, 230, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove, constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" GREEN ")){
					dispose();
					passInput();
					gameColor = new Color(152, 251, 152, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" BLACK ")){
					dispose();
					passInput();
					gameColor = Color.BLACK;
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" GRAY ")){
					dispose();
					passInput();
					gameColor = new Color(220, 220, 220, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" ORANGE ")){
					dispose();
					passInput();
					gameColor = new Color(255, 205, 0, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" CYAN ")){
					dispose();
					passInput();
					gameColor = new Color(0, 255, 255, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" PINK ")){
					dispose();
					passInput();
					gameColor = new Color(255, 182, 193, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" YELLOW ")){
					dispose();
					passInput();
					gameColor = Color.YELLOW;
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, true, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" red ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, new Color(210, 0, 0, 255), gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" blue ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.BLUE, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" green ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor,  true, new Color(0, 170, 0, 255), gameTime, theColors, randomFile, true, counterPress, checkHideTime,checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" black ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.BLACK, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" gray ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.GRAY, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" orange ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.ORANGE, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" cyan ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.CYAN, gameTime, theColors, randomFile, true, counterPress, checkHideTime,checkHideMove, constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" pink ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.pink, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals(" yellow ")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, true, Color.YELLOW, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals("Default Number Color")){
					dispose();
					passInput();
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, checkBackColor, getColor, false, null, gameTime, theColors, randomFile, true, counterPress, checkHideTime, checkHideMove,constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
				else if(buttonCheck.equals("Default Board Color")){
					dispose();
					passInput();
					gameColor = new Color(255, 255, 255, 255);
					theColors.setColor(gameColor.getRed(), gameColor.getGreen(), gameColor.getBlue());
					GridLayoutPage g1 = new GridLayoutPage(9, 9, getLevel, checkDemovar, false, gameColor, checkNumColor, getNumColor, gameTime, theColors, randomFile, true, counterPress, checkHideTime,checkHideMove, constantArray, checkIfAnswered, hideGuess, hideGive);
					g1.setVisible(true);
				}
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
			}

			public void getConstantNumbers(){

				Scanner inputNumbers = null;
				int constantCounter = 0;
				String readInNumbers = "";

				try{
					inputNumbers = new Scanner(new FileInputStream("samplesudoku" + randomFile + ".txt")); // trys to open the "constant" number file
				}
				catch (Exception e){
					System.out.println("File Error Constants");
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
					inputNumbers = new Scanner(new FileInputStream("samplesudoku"  + randomFile + "ans.txt")); // trys to open the answers file

				}
				catch (Exception e){
					System.out.println("File Error Answers");
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
				int indexCounter1 = 0;

				for(int i = 0; i < 81; i++){
					getInput = input[i].getText(); // obtain the text from the user input


					// used to check if the number is correct and if the number is not a predefined "constant"
					if(getInput.equals(answerArray[i])){
						input[i].setText(answerArray[i]);
						input[i].selectAll();

						// checks for constant
						if(i == indexArray[indexCounter1]){
							input[i].setForeground(Color.BLACK);
							input[i].selectAll();
							indexCounter1++;
						}
						// if all holds then the number guessed is correct and will turn blue and will not be editable
						else if(!(checkIfAnswered[i])){
							if(!checkDemovar){
								++indexCounter;
								indexArray[indexCounter] = i;
								constantArray[i] = getInput;
								checkIfAnswered[i] = true;
							}

							input[i].setForeground(Color.BLUE);
							input[i].setEditable(false);	
							input[i].selectAll();
						}
					}
					// if the number was guessed and it wrong it will turn red
					else if(!getInput.equals("")){
						input[i].setForeground(new Color(210, 0, 0, 255));
						isWrong = true;
					}

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
					ErrorWindow ew = new ErrorWindow("Not Win", gameTime, 0);
					ew.setVisible(true);
				}
				// if user did win then a new "WinWindow" will pop up
				else{
					WinWindow ww = new WinWindow(gameTime.getTime(), counterPress, getLevel);
					ww.setVisible(true);

				}
			}
			public void getRandom(){
				Random random = new Random();
				randomFile = random.nextInt(4) + 1;
			}

			public void checkCorrectFormat(KeyEvent e, int counter, int number)
			{
				String inputCheck = input[counter].getText();
				constant = false;

				for(int i = 0; i < indexCounter; i++){
					if(counter == indexArray[i]){
						constant = true;
						break;
					}
				}

				if(!constant){
					if (number <= 9 && number >= 0)
					{
						//input[counter].addActionListener(this);
						input[counter].setText("");
						counterPress++;
						if(checkHideMove){
							moveCounter.setText("Total Moves: 0");
						}
						else{
							moveCounter.setText("Total Moves: " + counterPress);
						}
					}
					else if (number == -1)
					{
						// if all it is an incorrect number it will get removed and an error window will pop up
						input[counter].setText("");

					}
				}
			}
<<<<<<< HEAD
			
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
=======

			public void correctFormat(KeyEvent e, int counter, int number)
			{
				for(int i = 0; i < indexCounter; i++){
					if(counter == indexArray[i]){
						constant = true;
						break;
					}
				}
				if(!constant){
					if(number == -1)
					{
						input[counter].setText("");
						ErrorWindow ew = new ErrorWindow("Bad Number", gameTime, 0);
						ew.setVisible(true);
					}
				}
			}	

			public void passInput(){
				PrintWriter newfile = null;
				String getInput = "";

				try{
					newfile = new PrintWriter("input.txt");
				}
				catch (Exception e){
					System.out.println("User Input File Error");
				}

				for (int i = 0; i < 81; i++){
					getInput = input[i].getText();

					if(getInput.equals("")){
						newfile.print("0 ");
					}
					else
						newfile.print(getInput + " ");
				}

				newfile.close();
			}
			public void getInputNumbers(){
				Scanner inputNumbers = null;
				int indexCounter1 = 0;
				String readInNumbers = "";

				try{
					inputNumbers = new Scanner(new FileInputStream("input.txt")); // trys to open the "constant" number file
				}
				catch (Exception e){
					System.out.println("User Input File Error");
					System.exit(0);
				}
				// reads in each number until it has reached the 81st number
				for (int i = 0; i < 81; i++){

					readInNumbers = inputNumbers.next();

					// if the number equals 0 then the program will record and move on
					if(readInNumbers.equals("0")){
						numberArray[i] = "0";
					}
					// if the number is not 0 then the program will record the index in the graph, take the constant value for later use and record how many constant there are
					else{
						numberArray[i] = readInNumbers;
						indexNumberArray[indexCounter1] = i;
						indexCounter1++;
					}
				}
				inputNumbers.close();

			}
			public void startSolver(){
				int [][] arr= new int[9][9];
				int [][] arr2 = new int [9][9];

				int count=0, tempNum = 0;;
				String temp = null;
				Scanner s = null;

				try{
					s = new Scanner(new FileInputStream("samplesudoku" + randomFile + ".txt"));
				}
				catch(Exception e){
					System.out.println("Error");
				}

				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						temp = s.next();
						arr[i][j] = Integer.parseInt(temp);
					}
				}

				s.close();

				for(int i = 0; i < 9; i++){
					for (int j = 0; j < 9; j++){
						tempNum = arr[i][j];
						if(tempNum == 0){
							continue;
						}
						else{
							for(int z = (j+1); z < 9; z++){
								if(tempNum == arr[i][z]){
									isRight = false;
									count++;
								}
							}
						}
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
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
<<<<<<< HEAD
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
=======
				if(!isRight){
					noSolve();
				}
				else{
					solve(arr,0,0);
					if(!isRight){
						noSolve();
					}
				}
			}
			public void solve(int[][] arr,int row,int col){

				Boolean hasNext = false;

				if(row > 8){
					print(arr);
					isRight = true;
				}
				else{
					if(arr[row][col] != 0){
						nextCheck(arr,row,col);
					}
					else{
						hasNext = false;
						for(int a = 1; a < 10; a++){
							if(check(arr,row,col,a)){
								arr[row][col]=a;
								nextCheck(arr,row,col);
								hasNext = true;
							}
						}
						arr[row][col]=0;
					}
				}
			}

			public void nextCheck(int[][] arr,int row,int col){

				if(col<8){
					solve(arr,row,col+1);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
				}
				// if all holds then the number guessed is correct and will turn blue and will not be editable
				else{
<<<<<<< HEAD
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
=======
					solve(arr,row+1,0);
				}
			}


			public void print(int[][] arr){

				PrintWriter answerFile = null;

				try{
					answerFile = new PrintWriter("samplesudoku" + randomFile + "ans.txt");
				}
				catch(Exception e){
					System.out.println("Answer File Error");
				}
				for(int a = 0; a < 9; a++){
					for(int b = 0; b < 9; b++){
						answerFile.print(arr[a][b] + " ");
					}
					answerFile.println();
				}
				answerFile.close();
			}


			public static boolean check(int[][] arr ,int x ,int y ,int z){

				for(int a = 0; a < 9; a++){
					if(arr[x][a] == z) return false;
				}
				for(int b = 0; b < 9; b++){
					if(arr[b][y] == z) return false;
				}

				x = (x / 3) * 3 ;
				y = (y / 3) * 3 ;

				for( int r = 0; r < 3; r++ ){
					for( int c = 0; c < 3; c++ ){
						if( arr[x+r][y+c] == z ){
							return false ;
						}
					}
				}
				return true ;
			}
			public void showAnswers(){
				for(int i = 0; i < 81; i++){
					input[i].setText(answerArray[i]);
					input[i].setEditable(false);
				}
			}
			public void noSolve(){
				System.out.println("Your file can not be solved. Exit");
				System.exit(0);
			}
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
}



