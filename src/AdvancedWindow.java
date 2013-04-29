import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AdvancedWindow extends JFrame implements ActionListener{
<<<<<<< HEAD
	
	public static final int HEIGHTADVACNED = 500;
	public static final int WIDTHADVANCED = 500;
	
	Boolean demoOn = false; // a variable used to test if a "Demo" button is pressed
	
	AdvancedWindow(){	
		
		super();
		
		
=======

	public static final int HEIGHTADVACNED = 500;
	public static final int WIDTHADVANCED = 500;

	private Boolean demoOn = false; // a variable used to test if a "Demo" button is pressed
	private TimerClass gameTime = new TimerClass();
	private RGBColor theColors = null;

	AdvancedWindow(){	

		super();


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// gets the dimension of screen to center window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHADVANCED/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTADVACNED/2);
<<<<<<< HEAD
		
=======

>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		setSize(WIDTHADVANCED, HEIGHTADVACNED);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
<<<<<<< HEAD
		
		
		// creates a new Panel to set buttons on
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		
=======


		// creates a new Panel to set buttons on
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a back button in the top left area of frame
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		add(backPanel, BorderLayout.NORTH); // addes the button Panel to the top of the screen
<<<<<<< HEAD
		
		
		// creates a new Panel to place buttons on the center of the screen
		JPanel buttonLayout = new JPanel();
		buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
=======


		// creates a new Panel to place buttons on the center of the screen
		JPanel buttonLayout = new JPanel();
		buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER));


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a demo button 
		JButton demoButton = new JButton("Demo");
		demoButton.addActionListener(this);
		buttonLayout.add(demoButton);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// adds all panels to the frame
		add(buttonLayout, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand();
<<<<<<< HEAD
		
		if(getAction.equals("Demo")){
			demoOn = true; // if demo is pressed then the value true is carried through the program to the grid page
=======

		if(getAction.equals("Demo")){
			dispose();
			demoOn = true; // if demo is pressed then the value true is carried through the program to the grid page
			GridLayoutPage nineGrid = new GridLayoutPage(9, 9, "Easy", demoOn, false, null, false, null, gameTime, theColors, 0, false, 0, false, false, null, null, false, false);
			nineGrid.setVisible(true);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		}
		// if "Back" button pressed the the current window will be disposed and a new Settings Frame will be created with the value of demoOn passed through
		else if(getAction.equals("Back")){
			dispose();
<<<<<<< HEAD
			SettingsLayoutPage demoOnSettings = new SettingsLayoutPage(demoOn);
=======
			SettingsLayoutPage demoOnSettings = new SettingsLayoutPage(false, false, false, false, false, false, false);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
			demoOnSettings.setVisible(true);
		}
	}
}
