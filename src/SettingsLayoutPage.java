
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SettingsLayoutPage extends JFrame implements ActionListener{
	public static final int WIDTHSETTINGS = 500;
	public static final int HEIGHTSETTINGS = 500;
	Boolean demoCheckvar = false;

	public SettingsLayoutPage(Boolean DemoCheck) {
		super();
		
		demoCheckvar = DemoCheck;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHSETTINGS/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTSETTINGS/2);
		
		setSize(WIDTHSETTINGS, HEIGHTSETTINGS);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		
		JButton advanceButton = new JButton("Advanced");
		advanceButton.addActionListener(this);
		backPanel.add(advanceButton);
		
		add(backPanel, BorderLayout.NORTH);
		
		JPanel lowerGrid = new JPanel();
		lowerGrid.setLayout(new GridLayout(3, 1));
		
		JPanel panelOnGrid1 = new JPanel();
		panelOnGrid1.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton highScore = new JButton("HighScores");
		highScore.addActionListener(this);
		panelOnGrid1.add(highScore);
		
		JButton NEWBUTTON = new JButton("NEW BUTTON");
		NEWBUTTON.addActionListener(this);
		panelOnGrid1.add(NEWBUTTON);
		
		lowerGrid.add(panelOnGrid1);
		
		JPanel panelOnGrid2 = new JPanel();
		panelOnGrid2.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton NEWBUTTON1 = new JButton("NEW BUTTON");
		NEWBUTTON1.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON1);
		
		JButton NEWBUTTON2 = new JButton("NEW BUTTON");
		NEWBUTTON2.addActionListener(this);
		panelOnGrid2.add(NEWBUTTON2);
		
		lowerGrid.add(panelOnGrid2);
		
		
		JPanel panelOnGrid3 = new JPanel();
		panelOnGrid3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton NEWBUTTON3 = new JButton("NEW BUTTON");
		NEWBUTTON3.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON3);
		
		JButton NEWBUTTON4 = new JButton("NEW BUTTON");
		NEWBUTTON4.addActionListener(this);
		panelOnGrid3.add(NEWBUTTON4);
		
		lowerGrid.add(panelOnGrid3);
		
		add(lowerGrid, BorderLayout.CENTER);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
		this.dispose();
		
		String getAction = e.getActionCommand();
		
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu(demoCheckvar);
			newStart.setVisible(true);
		}
		else if(getAction.equals("HighScores")){
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
		}
		else if(getAction.equals("Advanced")){
			AdvancedWindow aw = new AdvancedWindow();
			aw.setVisible(true);
		}
		else if(getAction.equals("NEW BUTTON")){
		}
		else
			System.out.println("Error");
	}
}
