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
	
	public static final int HEIGHTADVACNED = 500;
	public static final int WIDTHADVANCED = 500;
	
	Boolean demoOn = false; // a variable used to test if a "Demo" button is pressed
	
	AdvancedWindow(){	
		
		super();
		
		
		// gets the dimension of screen to center window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHADVANCED/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTADVACNED/2);
		
		setSize(WIDTHADVANCED, HEIGHTADVACNED);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		// creates a new Panel to set buttons on
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		
		// creates a back button in the top left area of frame
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		add(backPanel, BorderLayout.NORTH); // addes the button Panel to the top of the screen
		
		
		// creates a new Panel to place buttons on the center of the screen
		JPanel buttonLayout = new JPanel();
		buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		// creates a demo button 
		JButton demoButton = new JButton("Demo");
		demoButton.addActionListener(this);
		buttonLayout.add(demoButton);
		
		
		// adds all panels to the frame
		add(buttonLayout, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand();
		
		if(getAction.equals("Demo")){
			dispose();
			demoOn = true; // if demo is pressed then the value true is carried through the program to the grid page
			GridLayoutPage nineGrid = new GridLayoutPage(9, 9, "easy", demoOn, false, null, false, null);
			nineGrid.setVisible(true);
		}
		// if "Back" button pressed the the current window will be disposed and a new Settings Frame will be created with the value of demoOn passed through
		else if(getAction.equals("Back")){
			dispose();
			SettingsLayoutPage demoOnSettings = new SettingsLayoutPage(false, false, false);
			demoOnSettings.setVisible(true);
		}
	}
}
