
public class driverMain {
	public static void main(String[] args){
		// makes a new Start Window
<<<<<<< HEAD
		StartMenu frameOne = new StartMenu(false);
=======
		TimerClass gameTime = new TimerClass();
		StartMenu frameOne = new StartMenu(true, false, false, false, false, false, false, gameTime);
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		frameOne.setVisible(true);
		
	}

}
