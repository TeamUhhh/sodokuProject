import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;


public class TimerClass implements ActionListener {

	public int timeCount = 0, delay = 1000;
	public JLabel timeClock = null;
	Boolean checkTimeHide = false;

	Timer time = new Timer(delay, new ActionListener() {   // added javax.swing.Timer to count by time delays(1000 milliseconds or 1 second)
		public void actionPerformed(ActionEvent e) {
			timeUpdate(checkTimeHide);
		}
	});


	public void timeUpdate(Boolean checkHide){
		// updates the clock label
		if(!checkHide){
			timeClock.setText("Time: " + ++timeCount);
		}
		else{
			++timeCount;
		}
	}

	public int getTime()
	{
		return timeCount;
	}

	public void startTimer(Boolean checkHide){
		checkTimeHide = checkHide;
		time.start();
	}

	public void stopTimer(){
		time.stop();
	}
	public void resetTimer(){
		timeCount = 0;
	}

	public void setTimerColor(Color colorTime){
		timeClock.setForeground(colorTime);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
