import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class HighScores extends JFrame implements ActionListener{
	
	public static final int WIDTHHIGH = 400;
	public static final int HEIGHTHIGH = 400;
	
	Scanner readHighScores = null;
	JLabel highScoreScreen;
	Component[] highScoreList = new Component[100];
	String[] highScoreListString = new String[100];
	String[] timeSort = new String[100];
	int[] timeIndex = new int[100];
	int timeIndexVal;
	
	
	String name = null, time = null, moves = null, level = null;
	int countList = 0;
	Font headerFont = new Font("Arial", Font.BOLD, 24);
	
	HighScores(){
		
		super();
		
		
		// gets the dimensions to set frame in center of screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int sWidth = (((int)screenSize.getWidth()/2) - WIDTHHIGH/2);
		int sHeight = (((int)screenSize.getHeight()/2) - HEIGHTHIGH/2);
		
		
		// sets the properties of the frame
		setSize(WIDTHHIGH, HEIGHTHIGH);
		setTitle("Team Uhhhh");
		setLocation(sWidth, sHeight);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout()); // creates a "bottom" Border Layout
		
		JLabel header = new JLabel("Top 10 Players", JLabel.CENTER);
		header.setFont(headerFont);
		add(header, BorderLayout.NORTH);
		
		
		//trying to add grid to borderLayout
		JPanel scoreList = new JPanel(); 
		scoreList.setLayout(new GridLayout(11, 1));
		
		JPanel dropDown = new JPanel();
		dropDown.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		JComboBox dropDownSelector = new JComboBox();
		dropDownSelector.addItem("Select Sort Methods");
		dropDownSelector.addItem("Score");
		dropDownSelector.addItem("Time");
		dropDownSelector.addItem("Moves");
		//dropDownSelector.setSelectedIndex(4);
		dropDownSelector.addActionListener(this);
		dropDown.add(dropDownSelector);
		
		scoreList.add(dropDown);
		
		JPanel[] flowListArray= new JPanel[10];
		
		
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
				level = readHighScores.next();
				
				
				highScoreScreen = new JLabel(name + "    Time: " + time + "    Moves: " + moves + "    Levels: " + level); // creates a TextArea to display results
				highScoreList[countList] = highScoreScreen;
				highScoreListString[countList] = (name + "    Time: " + time + "    Moves: " + moves + "    Levels: " + level); 	
				countList++;
			}
			
			//sorts highScoreList in order by fastest time
			try{
				JLabel tempValLab;
				JLabel labValue;
				String minValue;
					for (int i=0; i<countList; i++){
						labValue = (JLabel) highScoreList[i];
						minValue = timeSort[i];
						for(int j=i+1; j<countList; j++){
							if (Integer.parseInt(timeSort[j]) < Integer.parseInt(minValue)){
								tempValLab = labValue;
								labValue = (JLabel)highScoreList[j];
								highScoreList[j] = tempValLab;
							}//else if (Integer.parseInt(timeSort[j]) > Integer.parseInt(minValue)){
								
							//}
						}
						highScoreList[i] = labValue;
						
						
					}
			} catch (NumberFormatException nfe){
				//ErrorWindow ew = new ErrorWindow("There was an error in converting String to Integer in timeSort.");
				//ew.setVisible(true);
			}
			
			
			JLabel listOrder;
			//places it to scoreList Grid
			for (int i=0; i<countList; i++){
				listOrder = new JLabel((i+1) + ":    ");
				flowListArray[i] = new JPanel();
				flowListArray[i].setLayout(new FlowLayout(FlowLayout.LEADING));
				flowListArray[i].add(listOrder);
				flowListArray[i].add(highScoreList[i]);
				scoreList.add(flowListArray[i]);
				if(countList == 10){
					break;
				}
				
			}
			
		}
		catch (FileNotFoundException e){
			System.out.println("HighScores file not found");
		}
	
	
		// adds the highScoreScreen Panel to the center of the frame
		add(scoreList, BorderLayout.CENTER);
		
		
		// creates a new Panel and Button to allow the user exit the High-Score Screen
		JPanel submitButton = new JPanel(new FlowLayout());
		JButton closeWindow = new JButton("OK");
		closeWindow.addActionListener(this);
		submitButton.add(closeWindow);
		add(submitButton, BorderLayout.SOUTH);
	}

	private void add(JLabel[] highScoreScreen2, String center) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		String getAction = e.getActionCommand(); // gets the label on the button
		String dropDown = null;
		
		if(getAction.equals("comboBoxChanged")){
			JComboBox cb = (JComboBox)e.getSource();
		    dropDown = (String)cb.getSelectedItem();
		}
		
		// if the button says "OK" then a new settings page will be created and the current High-Scores Screen will be disposed
		if(getAction.equals("OK")){
			dispose();
		}
		else if(getAction.equals("comboBoxChanged")){
			if(dropDown.equals("Score")){
				System.out.println("Score");
			}
			else if(dropDown.equals("Time")){
				System.out.println("Time");
			}
			else if(dropDown.equals("Moves")){
				System.out.println("Moves");
			}
		}
	}
}
