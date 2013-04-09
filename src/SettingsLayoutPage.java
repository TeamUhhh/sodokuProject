
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SettingsLayoutPage extends JFrame implements ActionListener{
	public static final int WIDTHSETTINGS = 500;
	public static final int HEIGHTSETTINGS = 500;

	public SettingsLayoutPage() {
		super();
		setSize(WIDTHSETTINGS, HEIGHTSETTINGS);
		setTitle("Team Uhhhh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		
		add(backPanel, BorderLayout.NORTH);
		
		
		JButton CHANGELATTER = new JButton("Coming Soon! (Press to exit)");
		CHANGELATTER.addActionListener(this);
		add(CHANGELATTER);
	}
	public void actionPerformed(ActionEvent e) {
		
		this.dispose();
		
		String getAction = e.getActionCommand();
		
		if(getAction.equals("Back")){
			dispose();
			StartMenu newStart = new StartMenu();
			newStart.setVisible(true);
		}
		else if(getAction.equals("Coming Soon! (Press to exit)")){
			System.exit(0);
		}
		else
			System.out.println("Error");
	}
}
