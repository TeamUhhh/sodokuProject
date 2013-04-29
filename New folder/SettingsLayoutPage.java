import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SettingsLayoutPage extends JFrame implements ActionListener, ItemListener{

	public static final int WIDTHSETTINGS = 500;
	public static final int HEIGHTSETTINGS = 500;

	Boolean dropDownCheck = false;
	Boolean buttonSelectCheck = false;
	Boolean defaultInput = false;

	JCheckBox boxButtons = null, dropDownSelect = null, defaultSelect = null;

	public SettingsLayoutPage(Boolean defaultSelectCheck, Boolean checkDropDown, Boolean checkButtonSelect) {

		super();

		dropDownCheck = checkDropDown;
		buttonSelectCheck = checkButtonSelect;
		defaultInput = defaultSelectCheck;

		// gets the screen resolution to display the frame in the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHSETTINGS/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTSETTINGS/2);


		// set the properties of the frame
		setSize(WIDTHSETTINGS, HEIGHTSETTINGS);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());


		// creates a top grid panel for spacing 
		JPanel topGrid = new JPanel();
		topGrid.setLayout(new GridLayout(1, 2));


		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel = new JPanel();
		topBackPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		
		// Back button made to move back to the Start Screen (placed on the top left of screen)
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		topBackPanel.add(backButton);


		// creates a "Top Back Panel" to add everything on top 
		JPanel topBackPanel1 = new JPanel();
		topBackPanel1.setLayout(new FlowLayout(FlowLayout.TRAILING));

		
		// Advanced button made to move back to the Start Screen (placed on the right left of screen)
		JButton advanceButton = new JButton("Advanced");
		advanceButton.addActionListener(this);
		topBackPanel1.add(advanceButton);


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

		JLabel highScoreText = new JLabel("HIGHSCORE _________________________________________________");
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

		JLabel inputText = new JLabel("INPUT ______________________________________________________");
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

		// Button to be replaced later
		boxButtons = new JCheckBox("Box Buttons");
		boxButtons.addItemListener(this);
		boxButtons.setMnemonic(KeyEvent.VK_C);
		if(!buttonSelectCheck){
			boxButtons.setSelected(false);
		}
		else if(buttonSelectCheck){
			boxButtons.setSelected(true);
		}
		panelOnGrid2.add(boxButtons);
		group.add(boxButtons);
		
		lowerGrid.add(panelOnGrid2); // adds the buttons to the second row of the base "grid" layout


		// creates a new Panel for the buttons to sit on (used to center buttons and prevent from spanning whole frame)

		JPanel otherLabel = new JPanel();
		otherLabel.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel otherText = new JLabel("OTHER ______________________________________________________");
		otherLabel.add(otherText);
		lowerGrid.add(otherLabel);

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

		JPanel other1Label = new JPanel();
		other1Label.setLayout(new FlowLayout(FlowLayout.LEADING));

		JLabel other1Text = new JLabel("OTHER ______________________________________________________");
		other1Label.add(other1Text);
		lowerGrid.add(other1Label);

		JPanel panelOnGrid4 = new JPanel();
		panelOnGrid4.setLayout(new FlowLayout(FlowLayout.CENTER));


		// Button to be replaced later
		JButton NEWBUTTON5 = new JButton("NEW BUTTON");
		NEWBUTTON5.addActionListener(this);
		panelOnGrid4.add(NEWBUTTON5);


		// Button to be replaced later
		JButton NEWBUTTON6 = new JButton("NEW BUTTON");
		NEWBUTTON6.addActionListener(this);
		panelOnGrid4.add(NEWBUTTON6);

		lowerGrid.add(panelOnGrid4); // adds the buttons to the third row of the base "grid" layout


		// adds everything to the frame
		add(lowerGrid, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {

		String getAction = e.getActionCommand(); // used to get the command of the button


		// if the button says "Back" then the current window will be disposed and a new Start Screen will be created
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu(defaultInput, dropDownCheck, buttonSelectCheck);
			newStart.setVisible(true);
		}
		else if(getAction.equals("Delete HighScores")){
			ErrorWindow ew = new ErrorWindow("Delete");
			ew.setVisible(true);
		}
		// if the button says "High Scores" then a new window will pop up and display any high scores
		else if(getAction.equals("     HighScores     ")){
			Scanner checkSettingsExist = null;
			try{
				// used to check if the highscores file exists, if not then an error will be caught and a new window will say that no file exist
				checkSettingsExist = new Scanner(new FileInputStream("highscores.txt"));
				checkSettingsExist.close();
				HighScores highScorePage = new HighScores();
				highScorePage.setVisible(true);
			}
			catch(FileNotFoundException ex){
				ErrorWindow noScores = new ErrorWindow("No Scores");
				noScores.setVisible(true);
			}
		}
		// if the button says "Advanced" then the current window will be disposed and a new "AdvancedSettings" window will appear
		else if(getAction.equals("Advanced")){
			dispose();
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
		}
		else if(getAction.equals("NEW BUTTON")){
		}
		else
			System.out.println("Error");
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
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED){
			if(source == dropDownSelect){
				dropDownCheck = false;
			}
			else if(source == boxButtons){
				buttonSelectCheck = false;
			}
		}

	}
}
