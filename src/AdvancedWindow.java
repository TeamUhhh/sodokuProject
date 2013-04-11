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
	Boolean demoOn = false;
	
	AdvancedWindow(){	
		super();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHADVANCED/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTADVACNED/2);
		
		setSize(WIDTHADVANCED, HEIGHTADVACNED);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		
		add(backPanel, BorderLayout.NORTH);
		
		JPanel buttonLayout = new JPanel();
		buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton demoButton = new JButton("Demo");
		demoButton.addActionListener(this);
		buttonLayout.add(demoButton);
		
		add(buttonLayout, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand();
		
		if(getAction.equals("Demo")){
			demoOn = true;
		}
		else if(getAction.equals("Back")){
			dispose();
			SettingsLayoutPage demoOnSettings = new SettingsLayoutPage(demoOn);
			demoOnSettings.setVisible(true);
		}
		
	}

}
