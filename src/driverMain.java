
public class driverMain {
	public static void main(String[] args){
		// makes a new Start Window
		TimerClass gameTime = new TimerClass();
		StartMenu frameOne = new StartMenu(true, false, false, false, false, false, false, gameTime);
		frameOne.setVisible(true);
		
	}

}
