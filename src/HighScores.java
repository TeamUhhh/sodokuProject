import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.FlowLayout;
=======
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class HighScores extends JFrame implements ActionListener{
	
	public static final int WIDTHHIGH = 400;
	public static final int HEIGHTHIGH = 400;
	
	Scanner readHighScores = null;
	JTextArea highScoreScreen;
	
	String name = null, time = null, moves = null, level = null;
	
	HighScores(){
		
		super();
		
		
=======
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HighScores extends JFrame implements ActionListener{

	public static final int WIDTHHIGH = 400;
	public static final int HEIGHTHIGH = 400;

	private Scanner readHighScores = null;

	private JPanel scoreList = null, dropDown = null, flowListArray[] = null;
	private JLabel highScoreScreen, scoreListHighScoreScreen, listOrder;
	private JComboBox dropDownSelector = null;
	private Component highScoreListTime[] = new Component[100], highScoreListMoves[] = new Component[100], highScoreListScore[] = new Component[100];

	private String highScoreListString[] = new String[100], timeSort[] = new String[100], moveSort[] = new String[100], scoreSort[] = new String[100];

	private int timeIndex[] = new int[100], timeIndexVal = 0, countList = 0;
	private double totalScore = 0, timeScore = 0, moveScore = 0;

	private String name = null, time = null, moves = null, level = null, score = null;
	private Font headerFont = new Font("Arial", Font.BOLD, 24);

	HighScores(){

		super();


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// gets the dimensions to set frame in center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHHIGH/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTHIGH/2);
<<<<<<< HEAD
		
		
=======


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// sets the properties of the frame
		setSize(WIDTHHIGH, HEIGHTHIGH);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
<<<<<<< HEAD
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		
		// reads in the from the file and inputs them into a corresponding variable 
		try{
			readHighScores = new Scanner(new FileInputStream("highscores.txt"));
			name = readHighScores.next();
			time = readHighScores.next();
			moves = readHighScores.next();
			level = readHighScores.next();
			
			highScoreScreen = new JTextArea("Name: " + name + "   Your Time: " + time + "   Moves: " + moves + "   Levels: " + level); // creates a TextArea to display results
=======
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout

		JLabel header = new JLabel("Top 10 Players", JLabel.CENTER);
		header.setFont(headerFont);
		add(header, BorderLayout.NORTH);


		//trying to add grid to borderLayout
		scoreList = new JPanel(); 
		scoreList.setLayout(new GridLayout(11, 1));

		dropDown = new JPanel();
		dropDown.setLayout(new FlowLayout(FlowLayout.TRAILING));

		dropDownSelector = new JComboBox();
		dropDownSelector.addItem("Select Sort Methods");
		dropDownSelector.addItem("Score");
		dropDownSelector.addItem("Time");
		dropDownSelector.addItem("Moves");
		//dropDownSelector.setSelectedIndex(4);
		dropDownSelector.addActionListener(this);
		dropDown.add(dropDownSelector);

		scoreList.add(dropDown);

		flowListArray= new JPanel[10];


		// reads in the from the file and inputs them into a corresponding variable 
		try{
			readHighScores = new Scanner(new FileInputStream("highscores.txt"));

			Boolean checkTime = false;

			while(readHighScores.hasNext())
			{
				name = readHighScores.next();
				time = readHighScores.next();


				for(int i = 0; i < 9; i++){
					if(time.contains(Integer.toString(i))){
						checkTime = true;
						break;
					}
					else{
						checkTime = false;
					}
				}

				if(!checkTime){
					name  = name + " " + time;
					time = readHighScores.next();
				}

				timeSort[countList] = time;

				moves = readHighScores.next();
				moveSort[countList] = moves;
				level = readHighScores.next();

				try{

					totalScore = Math.ceil((((1/Math.sqrt(Double.parseDouble(time))) + (1/Math.pow(Double.parseDouble(moves), 2))) * 1000));
					System.out.println(totalScore);

				} catch (NumberFormatException nfe){
					System.out.println("Math error (highscore)");
				}

				scoreSort[countList] = Double.toString(totalScore);

				highScoreScreen = new JLabel(name + "    Time: " + time + "    Moves: " + moves + "    Score: " + totalScore + "    Level: " + level); // creates a TextArea to display results
				highScoreListTime[countList] = highScoreScreen;				
				highScoreListMoves[countList] = highScoreScreen; 	
				highScoreListScore[countList] = highScoreScreen;
				countList++;
			}

			//sorts highScoreList in order by fastest time
			try{
				JLabel tempValLab;
				JLabel labValue;
				String tempMin;
				String minValue;
				for (int i=0; i<countList; i++){
					labValue = (JLabel) highScoreListTime[i];
					minValue = timeSort[i];
					for(int j=i+1; j<countList; j++){
						if (Integer.parseInt(timeSort[j]) < Integer.parseInt(minValue)){
							tempValLab = labValue;
							labValue = (JLabel)highScoreListTime[j];
							highScoreListTime[j] = tempValLab;
							tempMin = minValue;
							minValue = timeSort[j];
							timeSort[j] = tempMin;
						}//else if (Integer.parseInt(timeSort[j]) > Integer.parseInt(minValue)){

						//}
					}
					highScoreListTime[i] = labValue;


				}
			} catch (NumberFormatException nfe){
				//ErrorWindow ew = new ErrorWindow("There was an error in converting String to Integer in timeSort.");
				//ew.setVisible(true);
			}

			try{
				JLabel tempValLab;
				JLabel labValue;
				String tempMin;
				String minValue;
				for (int i=0; i<countList; i++){
					labValue = (JLabel) highScoreListMoves[i];
					minValue = moveSort[i];
					for(int j=i+1; j<countList; j++){
						if (Integer.parseInt(moveSort[j]) < Integer.parseInt(minValue)){
							tempValLab = labValue;
							labValue = (JLabel)highScoreListMoves[j];
							highScoreListMoves[j] = tempValLab;
							tempMin = minValue;
							minValue = moveSort[j];
							moveSort[j] = tempMin;
						}
					}
					highScoreListMoves[i] = labValue;
					moveSort[i] = minValue;

				}
			} catch (NumberFormatException nfe){
				//ErrorWindow ew = new ErrorWindow("There was an error in converting String to Integer in timeSort.");
				//ew.setVisible(true);
			}

			try{
				JLabel tempValLab;
				JLabel labValue;
				String tempMin;
				String maxValue;
				for (int i=0; i<countList; i++){
					labValue = (JLabel) highScoreListScore[i];
					maxValue = scoreSort[i];
					for(int j=i+1; j<countList; j++){
						if (Double.parseDouble(scoreSort[j]) > Double.parseDouble(maxValue)){
							tempValLab = labValue;
							labValue = (JLabel)highScoreListScore[j];
							highScoreListScore[j] = tempValLab;
							tempMin = maxValue;
							maxValue = scoreSort[j];
							scoreSort[j] = tempMin;
						}
					}
					highScoreListScore[i] = labValue;
					scoreSort[i] = maxValue;

				}
			} catch (NumberFormatException nfe){
				//ErrorWindow ew = new ErrorWindow("There was an error in converting String to Integer in timeSort.");
				//ew.setVisible(true);
			}
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		}
		catch (FileNotFoundException e){
			System.out.println("HighScores file not found");
		}
<<<<<<< HEAD
		
		
		// adds the highScoreScreen Panel to the center of the frame
		add(highScoreScreen, BorderLayout.CENTER);
		
		
=======

		for (int i=0; i<countList; i++){
			listOrder = new JLabel((i+1) + ":    ");
			flowListArray[i] = new JPanel();
			flowListArray[i].setLayout(new FlowLayout(FlowLayout.LEADING));
			flowListArray[i].add(listOrder);
			flowListArray[i].add(highScoreListTime[i]);
			scoreList.add(flowListArray[i]);
			if(countList == 10){
				break;
			}
		}

		// adds the highScoreScreen Panel to the center of the frame
		add(scoreList, BorderLayout.CENTER);


>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
		// creates a new Panel and Button to allow the user exit the High-Score Screen
		JPanel submitButton = new JPanel(new FlowLayout());
		JButton closeWindow = new JButton("OK");
		closeWindow.addActionListener(this);
		submitButton.add(closeWindow);
		add(submitButton, BorderLayout.SOUTH);
	}

<<<<<<< HEAD
	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand(); // gets the label on the button
		
		
		// if the button says "OK" then a new settings page will be created and the current High-Scores Screen will be disposed
		if(getAction.equals("OK")){
			SettingsLayoutPage newSettings = new SettingsLayoutPage(false);
			newSettings.setVisible(true);
			dispose();
		}
=======
	private void add(JLabel[] highScoreScreen2, String center) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand(); // gets the label on the button
		String dropDowns = null;

		if(getAction.equals("comboBoxChanged")){
			JComboBox cb = (JComboBox)e.getSource();
			dropDowns = (String)cb.getSelectedItem();
		}

		// if the button says "OK" then a new settings page will be created and the current High-Scores Screen will be disposed
		if(getAction.equals("OK")){
			dispose();
		}
		else if(getAction.equals("comboBoxChanged")){
			if(dropDowns.equals("Score")){

				scoreList.removeAll();
				scoreList.revalidate();
				scoreList.repaint();

				dropDown.add(dropDownSelector);
				scoreList.add(dropDown);
				for (int i=0; i<countList; i++){
					listOrder = new JLabel((i+1) + ":    ");
					flowListArray[i] = new JPanel();
					flowListArray[i].setLayout(new FlowLayout(FlowLayout.LEADING));
					flowListArray[i].add(listOrder);
					flowListArray[i].add(highScoreListScore[i]);
					scoreList.add(flowListArray[i]);
					if(countList == 10){
						break;
					}
				}
				add(scoreList, BorderLayout.CENTER);

			}
			else if(dropDowns.equals("Time")){
				scoreList.removeAll();
				scoreList.revalidate();
				scoreList.repaint();

				dropDown.add(dropDownSelector);
				scoreList.add(dropDown);
				//places it to scoreList Grid
				for (int i=0; i<countList; i++){
					listOrder = new JLabel((i+1) + ":    ");
					flowListArray[i] = new JPanel();
					flowListArray[i].setLayout(new FlowLayout(FlowLayout.LEADING));
					flowListArray[i].add(listOrder);
					flowListArray[i].add(highScoreListTime[i]);
					scoreList.add(flowListArray[i]);
					if(countList == 10){
						break;
					}
				}
				add(scoreList, BorderLayout.CENTER);
			}
			else if(dropDowns.equals("Moves")){

				scoreList.removeAll();
				scoreList.revalidate();
				scoreList.repaint();

				dropDown.add(dropDownSelector);
				scoreList.add(dropDown);
				for (int i=0; i<countList; i++){
					listOrder = new JLabel((i+1) + ":    ");
					flowListArray[i] = new JPanel();
					flowListArray[i].setLayout(new FlowLayout(FlowLayout.LEADING));
					flowListArray[i].add(listOrder);
					flowListArray[i].add(highScoreListMoves[i]);
					scoreList.add(flowListArray[i]);
					if(countList == 10){
						break;
					}
				}

				add(scoreList, BorderLayout.CENTER);

			}
		}
>>>>>>> 246594c5645d8e24990eaa0ac913df68c054c328
	}
}
