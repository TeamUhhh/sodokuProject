
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartMenu extends JFrame implements ActionListener{

	public static final int WIDTHSTART = 500;
	public static final int HEIGHTSTART = 500;
	
	Font buttonFont = new Font("Arial", Font.BOLD, 20);
	Font headerFont = new Font("Arial", Font.BOLD, 60);
	
<<<<<<< HEAD
	Boolean checkDemovar = false; // variable to check if "Demo" was pressed
	
	public StartMenu(Boolean demoCheck){
		
		super();
		
		// checks if the "Demo" button was pressed and carries it through to the Grid Page
		checkDemovar = demoCheck;
		
=======
	TimerClass gameTime = null;
	RGBColor theColors = new RGBColor(255, 255, 255);
	
	private Image backgroundImage;
	
	Boolean dropDownCheck = false; // variable to check if "Demo" was pressed
	Boolean buttonSelectCheck = false;
	Boolean defaultSelect = false;
	Boolean checkTimeHide = false;
	Boolean checkMoveHide = false;
	Boolean hideGuess = false;
	Boolean hideGive = false;
	
	public StartMenu(Boolean defaultInput, Boolean checkDropDown, Boolean checkButtonSelect, Boolean checkHideTime, Boolean checkHideMoves, Boolean guessHide, Boolean giveHide, TimerClass gameTimer){
		
		super();
		
		gameTime = gameTimer;
		
		// checks if the "Demo" button was pressed and carries it through to the Grid Page
		hideGuess = guessHide;
		hideGive = giveHide;
		dropDownCheck = checkDropDown;
		buttonSelectCheck = checkButtonSelect;
		defaultSelect = defaultInput;
		checkTimeHide = checkHideTime;
		checkMoveHide = checkHideMoves;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		
		// gets the resolution of the screen to position the frame in the center
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHSTART/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTSTART/2);
		
		
		// sets the properties of the frame
		setSize(WIDTHSTART, HEIGHTSTART);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		
		// uses a Panel in order to make a new layout(Grid) in a "layer" of the Border Layout
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setLayout(new GridLayout(5, 1));
		
		
		// Creates the header
		JLabel header = new JLabel("Sudoko", JLabel.CENTER);
		header.setFont(headerFont);
		buttonPanel.add(header);
		
		
		// creates a new Panel to set the button on top of. Used to span the whole width w/o the button spanning the whole width (will open a new window if pressed)
		JPanel easyPanel = new JPanel();
		JButton easyButton = new JButton("Easy");
<<<<<<< HEAD
=======
		easyButton.setBackground(Color.WHITE);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		easyButton.setFont(buttonFont);
		easyButton.addActionListener(this); // listens to the button being pressed, "listener" defined below
		easyPanel.add(easyButton);
		easyPanel.setBackground(Color.darkGray);
		buttonPanel.add(easyPanel); // adds the easyPanel to the bigger Button panel to be shown
		
		
		// same for the next 3 buttons as above (will open a new window if pressed)
		JPanel hardPanel = new JPanel();
		JButton hardButton = new JButton("Hard");
		hardButton.setBackground(Color.WHITE);
		hardButton.setFont(buttonFont);
		hardButton.addActionListener(this);
		hardPanel.add(hardButton);
		hardPanel.setBackground(Color.darkGray);
		buttonPanel.add(hardPanel);
		
		
		// creates a Panel for the Settings button and changes the background to Dark Gray (will open a new window if pressed)
		JPanel settingsPanel = new JPanel();
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBackground(Color.WHITE);
		settingsButton.setFont(buttonFont);
		settingsButton.addActionListener(this);
		settingsPanel.add(settingsButton);
		settingsPanel.setBackground(Color.darkGray);
		buttonPanel.add(settingsPanel);
		
		
		// creates a Panel for the Exit button to exit the program
		JPanel exitPanel = new JPanel();
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(buttonFont);
		exitButton.addActionListener(this);
		exitPanel.add(exitButton);
		exitPanel.setBackground(Color.darkGray);
		buttonPanel.add(exitPanel);
		
		
		add(buttonPanel, BorderLayout.CENTER); // adds the "bigger" panel to the base Border Layout in the center1 (to the frame)

	}
	public void actionPerformed(ActionEvent e) {
		
		this.dispose(); // this will get rid of the current window when a button is pressed but not shut down the program
		
		String getAction = e.getActionCommand();
		
		// creates a new "Easy" GridLayout
		if(getAction.equals("Easy")){
<<<<<<< HEAD
			GridLayoutPage nineGrid = new GridLayoutPage(9, 9, "Easy", checkDemovar); // checkDemovar to check if "Demo" has been selected
			nineGrid.setVisible(true);
		}
		// creates a new "Hard" GridLayout
		else if(getAction.equals("Hard")){
			GridLayoutPage settings = new GridLayoutPage(9, 9, "Hard", checkDemovar); // checkDemovar to check if "Demo" has been selected
			settings.setVisible(true);
		}
		// creates a new Settings Page
		else if(getAction.equals("Settings")){
			SettingsLayoutPage settings = new SettingsLayoutPage(false); 
=======
			if(dropDownCheck){
				GridDropDown nineGrid = new GridDropDown(9, 9, "Easy", true, 1, checkTimeHide, checkMoveHide, hideGuess, hideGive); // checkDemovar to check if "Demo" has been selected
				nineGrid.setVisible(true);
			}
			else if(buttonSelectCheck){
				System.out.println("DOES NOTHING");
			}
			else{
				GridLayoutPage nineGrid = new GridLayoutPage(9, 9, "Easy", false, false, null, false, null, gameTime, theColors, 0, false, 0, checkTimeHide, checkMoveHide, null, null, hideGuess, hideGive); // checkDemovar to check if "Demo" has been selected
				nineGrid.setVisible(true);
			}
		}
		// creates a new "Hard" GridLayout
		else if(getAction.equals("Hard")){
			if(dropDownCheck){
				GridDropDown nineGrid = new GridDropDown(9, 9, "Hard", true, 1, checkTimeHide, checkMoveHide, hideGuess, hideGive); // checkDemovar to check if "Demo" has been selected
				nineGrid.setVisible(true);
			}
			else if(buttonSelectCheck){
				System.out.println("DOES NOTHING");
			}
			else{
				GridLayoutPage nineGrid = new GridLayoutPage(9, 9, "Hard", false, false, null, false, null, gameTime, theColors, 0, false, 0, checkTimeHide, checkMoveHide, null, null, hideGuess, hideGive); // checkDemovar to check if "Demo" has been selected
				nineGrid.setVisible(true);
			}
		}
		// creates a new Settings Page
		else if(getAction.equals("Settings")){
			SettingsLayoutPage settings = new SettingsLayoutPage(defaultSelect, dropDownCheck, buttonSelectCheck, checkTimeHide, checkMoveHide, hideGuess, hideGive); 
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
			settings.setVisible(true);
		}
		// will exit program
		else if(getAction.equals("Exit")){
			System.exit(0);
		}
		else
			System.out.println("Error");
	}

}
