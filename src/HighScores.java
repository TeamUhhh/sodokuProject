import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class HighScores extends JFrame implements ActionListener{
	public static final int WIDTHHIGH = 400;
	public static final int HEIGHTHIGH = 400;
	
	HighScores(){
		super();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHHIGH/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTHIGH/2);
		
		setSize(WIDTHHIGH, HEIGHTHIGH);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
