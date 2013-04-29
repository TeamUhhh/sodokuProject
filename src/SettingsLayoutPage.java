import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
<<<<<<< HEAD
=======
import java.awt.Font;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


<<<<<<< HEAD
public class SettingsLayoutPage extends JFrame implements ActionListener{
	
=======
public class SettingsLayoutPage extends JFrame implements ActionListener, ItemListener{

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
	public static final int WIDTHSETTINGS = 500;
	public static final int HEIGHTSETTINGS = 500;
	
	Boolean demoCheckvar = false; // variable to check if the "Demo" button was press

<<<<<<< HEAD
	public SettingsLayoutPage(Boolean DemoCheck) {
		
		super();
		
		// used to check if the user pressed the "Demo" button (the boolean value will carry through the program)
		demoCheckvar = DemoCheck;
		
		
=======
	private Font labelFont = new Font("Arial", Font.BOLD, 14);

	private Boolean dropDownCheck = false, buttonSelectCheck = false, defaultInput = false, hideTime = false, hideTimeNo = true, hideMove = false, 
			setTime = false, hideGuess = false, hideGive = false;

	private JCheckBox boxButtons = null, dropDownSelect = null, defaultSelect = null, yesTime = null, noTime = null, yesMove = null, noMove = null, 
			yesSetTime = null, noSetTime = null, yesGuess = null, noGuess = null, yesGive = null, noGive = null;

	TimerClass gameTime = new TimerClass();

	public SettingsLayoutPage(Boolean defaultSelectCheck, Boolean checkDropDown, Boolean checkButtonSelect, Boolean hideTimeSelect, Boolean hideMoveSelect, Boolean guessHide, Boolean giveHide) {

		super();

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// gets the screen resolution to display the frame in the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHSETTINGS/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTSETTINGS/2);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// set the properties of the frame
		setSize(WIDTHSETTINGS, HEIGHTSETTINGS);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
<<<<<<< HEAD
		
		
		// creates a top grid panel for spacing 
		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 2));
		
		
		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel = new JPanel();
		topBackPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
=======


		// gets info from other frames
		hideGuess = guessHide;
		hideGive = giveHide;
		dropDownCheck = checkDropDown;
		buttonSelectCheck = checkButtonSelect;
		defaultInput = defaultSelectCheck;
		hideTime = hideTimeSelect;
		hideTimeNo = !hideTimeSelect;
		hideMove = hideMoveSelect;


		// creates a top grid panel for spacing 
		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 2));


		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel = new JPanel();
		topBackPanel.setLayout(new FlowLayout(FlowLayout.LEADING));


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// Back button made to move back to the Start Screen (placed on the top left of screen)
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		topBackPanel.add(backButton);
<<<<<<< HEAD
		
		
		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel1 = new JPanel();
		topBackPanel1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
=======


		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel1 = new JPanel();
		topBackPanel1.setLayout(new FlowLayout(FlowLayout.TRAILING));


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// Advanced button made to move back to the Start Screen (placed on the right left of screen)
		JButton advanceButton = new JButton("Advanced");
		advanceButton.addActionListener(this);
		topBackPanel1.add(advanceButton);
<<<<<<< HEAD
		
		
		// adds both panels to the base grid panel
		topGrid.add(topBackPanel);
		topGrid.add(topBackPanel1);
		
		
		add(topGrid, BorderLayout.NORTH); // adds the grid panel to the top (NORTH) of the screen
		
		
		// creates a 3 - row, 1- column grid to be used to display button top to bottom
		JPanel lowerGrid = new JPanel();
		lowerGrid.setLayout(new GridLayout(3, 1));
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid1 = new JPanel();
		panelOnGrid1.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		// creates a HighScore button to be pressed and check/pop up a new window to show previous high scores (if exists)
		JButton highScore = new JButton("HighScores");
		highScore.addActionListener(this);
		panelOnGrid1.add(highScore);
		
		
		// Button to be replaced later
		JButton NEWBUTTON = new JButton("NEW BUTTON");
		NEWBUTTON.addActionListener(this);
		panelOnGrid1.add(NEWBUTTON);
		
		lowerGrid.add(panelOnGrid1); // adds the buttons to the first row of the base "grid" layout
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid2 = new JPanel();
		panelOnGrid2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		// Button to be replaced later
		JButton NEWBUTTON1 = new JButton("NEW BUTTON");
		NEWBUTTON1.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON1);
		
		
		// Button to be replaced later
		JButton NEWBUTTON2 = new JButton("NEW BUTTON");
		NEWBUTTON2.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON2);
		
		lowerGrid.add(panelOnGrid2); // adds the buttons to the second row of the base "grid" layout
		
		
		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid3 = new JPanel();
		panelOnGrid3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		// Button to be replaced later
		JButton NEWBUTTON3 = new JButton("NEW BUTTON");
		NEWBUTTON3.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON3);
		
		
		// Button to be replaced later
		JButton NEWBUTTON4 = new JButton("NEW BUTTON");
		NEWBUTTON4.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON4);
		
		lowerGrid.add(panelOnGrid3); // adds the buttons to the third row of the base "grid" layout
		
		
=======


		// adds both panels to the base grid panel
		topGrid.add(topBackPanel);
		topGrid.add(topBackPanel1);

		add(topGrid, BorderLayout.NORTH); // adds the grid panel to the top (NORTH) of the screen


		// creates a 3 - row, 1- column grid to be used to display button top to bottom
		JPanel lowerGrid = new JPanel();
		lowerGrid.setLayout(new GridLayout(9, 1));


		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel highScoreLabel = new JPanel();
		highScoreLabel.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel highScoreText = new JLabel("HIGHSCORE _______________________________________________");
		highScoreText.setFont(labelFont);
		highScoreLabel.add(highScoreText);
		lowerGrid.add(highScoreLabel);

		JPanel panelOnGrid1 = new JPanel();
		panelOnGrid1.setLayout(new FlowLayout(FlowLayout.CENTER));


		// creates a HighScore button to be pressed and check/pop up a new window to show previous high scores (if exists)
		JButton highScore = new JButton("     HighScores     ");
		highScore.addActionListener(this);
		panelOnGrid1.add(highScore, BorderLayout.NORTH);


		// Button to be replaced later
		JButton NEWBUTTON = new JButton("Delete HighScores");
		NEWBUTTON.addActionListener(this);
		panelOnGrid1.add(NEWBUTTON);

		lowerGrid.add(panelOnGrid1); // adds the buttons to the first row of the base "grid" layout


		JPanel inputLabel = new JPanel();
		inputLabel.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel inputText = new JLabel("INPUT ____________________________________________________");
		inputText.setFont(labelFont);
		inputLabel.add(inputText);
		lowerGrid.add(inputLabel);

		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)
		JPanel panelOnGrid2 = new JPanel();
		panelOnGrid2.setLayout(new FlowLayout(FlowLayout.CENTER));

		ButtonGroup group = new ButtonGroup();	

		// Button to be replaced later
		defaultSelect = new JCheckBox("Default Type        ");
		defaultSelect.addItemListener(this);
		defaultSelect.setMnemonic(KeyEvent.VK_C);
		if(!defaultInput){
			defaultSelect.setSelected(false);
		}
		else if(defaultInput){
			defaultSelect.setSelected(true);
		}
		panelOnGrid2.add(defaultSelect);
		group.add(defaultSelect);

		// Button to be replaced later
		dropDownSelect = new JCheckBox("Drop Down        ");
		dropDownSelect.addItemListener(this);
		dropDownSelect.setMnemonic(KeyEvent.VK_C);

		if(!dropDownCheck){
			dropDownSelect.setSelected(false);
		}
		else if(dropDownCheck){
			dropDownSelect.setSelected(true);
		}
		panelOnGrid2.add(dropDownSelect);
		group.add(dropDownSelect);

		lowerGrid.add(panelOnGrid2); // adds the buttons to the second row of the base "grid" layout


		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)

		JPanel otherLabel = new JPanel();
		otherLabel.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel otherText = new JLabel("HIDE LABELS ______________________________________________");
		otherText.setFont(labelFont);
		otherLabel.add(otherText);
		lowerGrid.add(otherLabel);

		JPanel panelOnGrid3 = new JPanel();
		panelOnGrid3.setLayout(new FlowLayout(FlowLayout.CENTER));

		ButtonGroup group1 = new ButtonGroup();
		// Button to be replaced later
		JPanel hideTimePanel = new JPanel(new GridLayout(2, 1));
		JPanel timeFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel hideTimeLabel = new JLabel("Hide Time:");
		timeFlow.add(hideTimeLabel);

		yesTime = new JCheckBox("Yes");
		yesTime.addItemListener(this);
		yesTime.setMnemonic(KeyEvent.VK_C);
		if(!hideTime){
			yesTime.setSelected(false);
		}
		else if(hideTime){
			yesTime.setSelected(true);
		}
		timeFlow.add(yesTime);
		group1.add(yesTime);

		noTime = new JCheckBox("No");
		noTime.addItemListener(this);
		noTime.setMnemonic(KeyEvent.VK_C);
		if(hideTimeNo){
			noTime.setSelected(true);
		}
		else if(!hideTimeNo){
			noTime.setSelected(false);
		}
		timeFlow.add(noTime);
		group1.add(noTime);

		hideTimePanel.add(timeFlow);
		panelOnGrid3.add(hideTimePanel);

		JPanel hideMovePanel = new JPanel(new GridLayout(2, 1));
		JPanel moveFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel hideMoveLabel = new JLabel("   Hide Move:");
		moveFlow.add(hideMoveLabel);

		ButtonGroup group2 = new ButtonGroup();

		yesMove = new JCheckBox("Yes");
		yesMove.addItemListener(this);
		yesMove.setMnemonic(KeyEvent.VK_C);
		if(hideMove){
			yesMove.setSelected(true);
		}
		moveFlow.add(yesMove);
		group2.add(yesMove);

		noMove = new JCheckBox("No");
		noMove.addItemListener(this);
		noMove.setMnemonic(KeyEvent.VK_C);
		if(!hideMove){
			noMove.setSelected(true);
		}
		moveFlow.add(noMove);
		group2.add(noMove);
		hideMovePanel.add(moveFlow);
		panelOnGrid3.add(hideMovePanel);


		lowerGrid.add(panelOnGrid3); // adds the buttons to the third row of the base "grid" layout

		JPanel hideGuessLabelPan = new JPanel();
		hideGuessLabelPan.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel hideText = new JLabel("HIDE BUTTONS _____________________________________________");
		hideText.setFont(labelFont);
		hideGuessLabelPan.add(hideText);
		lowerGrid.add(hideGuessLabelPan);

		JPanel panelOnGrid4 = new JPanel();
		panelOnGrid4.setLayout(new FlowLayout(FlowLayout.CENTER));

		ButtonGroup group3 = new ButtonGroup();
		// Button to be replaced later
		JPanel hideGuessPanel = new JPanel(new GridLayout(2, 1));
		JPanel guessFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel hideGuessLabel = new JLabel("Hide Guess Button:");
		guessFlow.add(hideGuessLabel);

		yesGuess = new JCheckBox("Yes");
		yesGuess.addItemListener(this);
		yesGuess.setMnemonic(KeyEvent.VK_C);
		if(hideGuess){
			yesGuess.setSelected(true);
		}
		guessFlow.add(yesGuess);
		group3.add(yesGuess);

		noGuess = new JCheckBox("No");
		noGuess.addItemListener(this);
		noGuess.setMnemonic(KeyEvent.VK_C);
		if(!hideGuess){
			noGuess.setSelected(true);
		}
		guessFlow.add(noGuess);
		group3.add(noGuess);

		hideGuessPanel.add(guessFlow);
		panelOnGrid4.add(hideGuessPanel);

		JPanel hideGivePanel = new JPanel(new GridLayout(2, 1));
		JPanel giveFlow = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel hideGiveLabel = new JLabel("   Hide Give Up Button:");
		giveFlow.add(hideGiveLabel);

		ButtonGroup group4 = new ButtonGroup();

		yesGive = new JCheckBox("Yes");
		yesGive.addItemListener(this);
		yesGive.setMnemonic(KeyEvent.VK_C);
		if(hideGive){
			yesGive.setSelected(true);
		}
		giveFlow.add(yesGive);
		group4.add(yesGive);

		noGive = new JCheckBox("No");
		noGive.addItemListener(this);
		noGive.setMnemonic(KeyEvent.VK_C);
		if(!hideGive){
			noGive.setSelected(true);
		}
		giveFlow.add(noGive);
		group4.add(noGive);
		hideGivePanel.add(giveFlow);
		panelOnGrid4.add(hideGivePanel);

		lowerGrid.add(panelOnGrid4); // adds the buttons to the third row of the base "grid" layout


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// adds everything to the frame
		add(lowerGrid, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		
		String getAction = e.getActionCommand(); // used to get the command of the button
		
		
		// if the button says "Back" then the current window will be disposed and a new Start Screen will be created
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu(demoCheckvar);
			newStart.setVisible(true);
		}
		// if the button says "High Scores" then a new window will pop up and display any high scores
		else if(getAction.equals("HighScores")){
=======

		String getAction = e.getActionCommand(); // used to get the command of the button


		// if the button says "Back" then the current window will be disposed and a new Start Screen will be created
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu(defaultInput, dropDownCheck, buttonSelectCheck, hideTime, hideMove, hideGuess, hideGive, gameTime);
			newStart.setVisible(true);
		}
		else if(getAction.equals("Delete HighScores")){
			ErrorWindow ew = new ErrorWindow("Delete", null, 0);
			ew.setVisible(true);
		}
		// if the button says "High Scores" then a new window will pop up and display any high scores
		else if(getAction.equals("     HighScores     ")){
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
			Scanner checkSettingsExist = null;
			try{
				// used to check if the highscores file exists, if not then an error will be caught and a new window will say that no file exist
				checkSettingsExist = new Scanner(new FileInputStream("highscores.txt"));
				checkSettingsExist.close();
				HighScores highScorePage = new HighScores();
				highScorePage.setVisible(true);
			}
			catch(FileNotFoundException ex){
<<<<<<< HEAD
				ErrorWindow noScores = new ErrorWindow("No Scores");
=======
				ErrorWindow noScores = new ErrorWindow("No Scores", null, 0);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
				noScores.setVisible(true);
			}
		}
		// if the button says "Advanced" then the current window will be disposed and a new "AdvancedSettings" window will appear
		else if(getAction.equals("Advanced")){
<<<<<<< HEAD
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
		}
		else if(getAction.equals("NEW BUTTON")){
=======
			dispose();
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		}
		else
			System.out.println("Error No Label Found");
	}
	public void itemStateChanged(ItemEvent e) {

		Object source = e.getItemSelectable();

		if (e.getStateChange() == ItemEvent.SELECTED){
			if (source == dropDownSelect) {
				dropDownCheck = true;
				buttonSelectCheck = false;
				defaultInput = false;
			} 
			else if (source == boxButtons) {
				buttonSelectCheck = true;
				dropDownCheck = false;
				defaultInput = false;
			}
			else if (source == defaultSelect){
				defaultInput = true;
				dropDownCheck = false;
				buttonSelectCheck = false;
			}
			else if (source == yesTime){
				hideTime = true;
				//noTime.setSelected(false);
				hideTimeNo = false;
			}
			else if (source == noTime){
				hideTime = false;
				//yesTime.setSelected(false);
				hideTimeNo = true;
			}
			else if (source == yesMove){
				hideMove = true;
			}
			else if (source == noMove){
				hideMove = false;
			}
			else if (source == yesSetTime){
				setTime = true;
			}
			else if (source == noSetTime){
				setTime = false;
			}
			else if (source == noGuess){
				hideGuess = false;
			}
			else if (source == yesGuess){
				hideGuess = true;
			}
			else if (source == noGive){
				hideGive = false;
			}
			else if (source == yesGive){
				hideGive = true;
			}
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED){
			if(source == dropDownSelect){
				dropDownCheck = false;
			}
			else if(source == boxButtons){
				buttonSelectCheck = false;
			}
			else if(source == yesTime){
				hideTime = false;
			}
			else if(source == noTime){
				hideTimeNo = false;
			}
			else if(source == noMove){
				hideMove = true;
				//yesMove.setSelected(true);
			}
			else if(source == yesMove){
				//noMove.setSelected(true);
				hideMove = false;
			}
			else if (source == yesSetTime){
				setTime = false;
			}
			else if (source == noSetTime){
				setTime = true;
			}
			else if (source == noGuess){
				hideGuess = true;
			}
			else if (source == yesGuess){
				hideGuess = false;
			}
			else if (source == noGive){
				hideGive = true;
			}
			else if (source == yesGive){
				hideGive = false;
			}
		}

	}
}
