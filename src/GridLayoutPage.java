
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GridLayoutPage extends JFrame implements ActionListener, DocumentListener{
	
	public static final int WIDTHGRID = 500;
	public static final int HEIGHTGRID = 500;
	private int counterPress = 0, timeCount = 0, delay = 1000;
	private JPanel topPanel = null, gridPanel = null;
	private JLabel timeClock = null;
	private JLabel moveCounter = null;
	private JLabel levelView = null;
	private JTextField input, input11;
	Font inputFont = new Font("Arial", Font.BOLD, 30);
	//private JComponent textArray[] = new JComponent[81];
	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
        public void actionPerformed(ActionEvent e) {
            timeUpdate();
        }
     });
	

	public GridLayoutPage(int x, int y, String level) {
		super();
		
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
		input11 = new JTextField(1);
		input11.setFont(inputFont);
		input11.setHorizontalAlignment(JTextField.CENTER);
		input11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input11.addActionListener(this);
		gridPanel.add(input11);
		
		
		for (int i = 1; i < (9*9); i++){
			input = new JTextField(1);
			input.setFont(inputFont);
			input.setHorizontalAlignment(JTextField.CENTER);
			if (i % 3 == 0){
				input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			else{
				input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			
			input.addActionListener(this);
			gridPanel.add(input);
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
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		gridPanel.setVisible(true);
		time.start();
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		StartMenu newStart = null;
		String action = e.getActionCommand();
		
		if(action.equals("Submit")){
			--counterPress;
			dispose();
			newStart = new StartMenu();
			newStart.setVisible(true);
		}
		else if(action.equals("Quit to Home")){
			--counterPress;
			dispose();
			newStart = new StartMenu();
			newStart.setVisible(true);
		}
		else{
			moveCounter.setText("Total Moves: " + ++counterPress);
			checkCorrectFormat(e);
		}
	//	gridPanel.add(input);
		//gridPanel.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e, JTextField jtf) {
		
		moveCounter.setText("Total Moves: " + ++counterPress);
		//input11.setText("");
	//	gridPanel.add(input);
		//gridPanel.setVisible(true);
		
	}

	public void changedUpdate(DocumentEvent e) {
		//actionPerformed(this);
		//moveCounter.setText("Total Moves: " + ++counterPress);
		//checkCorrectFormat(e);
		//input.setText("");
		
	}

	public void insertUpdate(DocumentEvent e) {
		//actionPerformed(this);
		//moveCounter.setText("Total Moves: " + ++counterPress);
		//input.setText("");
		//checkCorrectFormat(e);
		
		
	}

	public void removeUpdate(DocumentEvent e) {
		//input = "":
		//moveCounter.setText("Total Moves: " + ++counterPress);
		
	}

	public void checkCorrectFormat(ActionEvent e) {
		String inputCheck = input11.getText();
		try{
			int number = Integer.parseInt(inputCheck);
		}
		catch(NumberFormatException nfe){
			ErrorWindow ew = new ErrorWindow();
			ew.setVisible(true);
			System.out.println("Error");
			input11.setText("");
		}
	}
	
	public void timeUpdate()
	{
		timeClock.setText("Time: " + ++timeCount);
	}
}


