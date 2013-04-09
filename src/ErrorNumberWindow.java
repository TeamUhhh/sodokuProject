
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ErrorNumberWindow extends JFrame implements ActionListener{
	ErrorNumberWindow(){
		//test
		super();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - 400/2);
		int sHeight = (((int)screenSize.getHeight()/2) - 150/2);
		
		setSize(400, 150);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// creates a new Border Layout 
		setLayout(new BorderLayout());
		JLabel errorStatement = new JLabel("Enter numbers less than 9 and greater than 0 only!", JLabel.CENTER);
		add(errorStatement, BorderLayout.CENTER);
		
		// creates a button to be pressed to dismiss window
		JPanel submitButton = new JPanel(new FlowLayout());
		JButton closeWindow = new JButton("OK");
		closeWindow.addActionListener(this);
		submitButton.add(closeWindow);
		add(submitButton, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		dispose(); // gets rid of the current window
	}
	

}