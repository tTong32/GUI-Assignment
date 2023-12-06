// By Addison and Thomson
// December 6th, 2023
// A program designed to graphically show centripetal force, and the effect that certain parameters have on circular motion

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class centripedal implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ChangeListener{
	// Properties
	//The frame and the panels are listed
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	helppanel newHelpPanel = new helppanel();
	creditpanel newCreditPanel = new creditpanel();
	testpanel newTestPanel = new testpanel();
	leaderboard newLeaderboardPanel = new leaderboard();
	
	//Initializing JLabel for the credit screen
	JLabel creditLabel = new JLabel("The students Addison and Thomson");
	JLabel creditLabel2 = new JLabel("at St. Augustine CHS Computer Science");
	JLabel creditLabel3 = new JLabel("made this program");
	
	//Initalizing timer for the animation
	Timer theTimer = new Timer(1000/48, this);
	
	//The leaderboard's text area and also the leaderboard's scroll pane to initialize
	JTextArea lbTextArea = new JTextArea();
	JScrollPane testScroll = new JScrollPane(lbTextArea);
	
	//JMenuBar, JMenu, and JMenuItem to make a menu to hold Home, help, credits, test, and leaderboard
	JMenuBar menuBar = new JMenuBar();
	JMenu openMenu = new JMenu("Menu");
	JMenuItem homeItem = new JMenuItem("Home");
	JMenuItem helpItem = new JMenuItem("Help");
	JMenuItem creditItem = new JMenuItem("Credits");
	JMenuItem testItem = new JMenuItem("Test");
	JMenuItem leaderboardItem = new JMenuItem("Results");
	
	//Mass Label, slider, and textfield for the newpanel
	JLabel massLabel = new JLabel("Mass (kg)");
	JSlider massSlider = new JSlider(100, 500);
	JTextField massText = new JTextField();
	
	//Radius Label, slider, and textfield for the new panel
	JSlider radiusSlider = new JSlider(0, 50);
	JLabel radiusLabel = new JLabel("Radius (m)");
	JTextField radiusText = new JTextField();
	
	//Period label, slider, and textfield for the newpanel
	JSlider periodSlider = new JSlider(0, 160);
	JLabel periodLabel = new JLabel("Period (s)");
	JTextField periodText = new JTextField();
	
	//Force label and and textfield for the newpanel
	JLabel forceLabel = new JLabel("Force (π^2N)");
	JTextField forceText = new JTextField();
	
	//Name label and textfield for the testpanel
	JLabel nameLabel = new JLabel("Name");
	JTextField nameText = new JTextField();
	
	//Making the variables for the test Screen
	int correctAnswers = 0;
	String strCorrectAnswers = "";
	String strName = "";
	//JLabel to display how many answers you got right after you click the finish button
	JLabel answersLabel = new JLabel();
	//Question 1 combobox to go through a, b, c, d and allows you to pick a choice between the 4 options
	String[] question1Box = {"a", "b", "c", "d"};
	JComboBox question1Menu = new JComboBox(question1Box);
	//JLabels for the test question and its possible answers in the multiple choice question
	JLabel testQuestion1Label = new JLabel("1. What is the observed relationship between force and period?");
	JLabel testQuestion1AnswerA = new JLabel("a. Force is indirectly proportional to period");
	JLabel testQuestion1AnswerB = new JLabel("b. Force is directly proportional to period");
	JLabel testQuestion1AnswerC = new JLabel("c. Force is directly proportional to period cubed");
	JLabel testQuestion1AnswerD = new JLabel("d. Force is indirectly proportional to period squared."); 
	//Question 2 combobox to go through a, b, c, d and allows you to pick a choice between the 4 optinos
	String[] question2Box = {"a", "b", "c", "d"};
	JComboBox question2Menu = new JComboBox(question2Box);
	//JLabels for the test questions and its possible answers in the multiple choice question
	JLabel testQuestion2Label = new JLabel("2. Which of the following is a necessary condition for an object to move in a circular path?");
	JLabel testQuestion2AnswerA = new JLabel("a. Constant speed.");
	JLabel testQuestion2AnswerB = new JLabel("b. Constant velocity.");
	JLabel testQuestion2AnswerC = new JLabel("c. Constant acceleration");
	JLabel testQuestion2AnswerD = new JLabel("d. Constant displacement.");
	//Question e combobox to go through a, b, c, d and allows you to pick a choice between the 4 optinos
	String[] question3Box = {"a", "b", "c", "d"};
	JComboBox question3Menu = new JComboBox(question3Box);
	//JLabels for the test questions and its possible answers in the multiple choice question
	JLabel testQuestion3Label = new JLabel("3. In circular motion, what is the direction of the centripetal force?");
	JLabel testQuestion3AnswerA = new JLabel("a. Outward from the center of the circle");
	JLabel testQuestion3AnswerB = new JLabel("b. Tangential to the circle");
	JLabel testQuestion3AnswerC = new JLabel("c. Radial, toward the center of the circle");
	JLabel testQuestion3AnswerD = new JLabel("d. Opposite to the direction of motion");
	JButton finishButton = new JButton("Finish");
	JButton retryButton = new JButton("Retry");

	// The label for the rotating Fc, or centripetal force
	JLabel fcLabel = new JLabel("Fc");

	// Buttons used for the help screen
	JButton helpNextButton = new JButton("Next");
	JButton helpBackButton = new JButton("Back");

	// Methods
	public void actionPerformed(ActionEvent evt){
		// The timer used to repaint the panel
		if (evt.getSource() == theTimer){
			if (theFrame.getContentPane() == thePanel){
				thePanel.repaint();
				forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
				int intFCFontSize = thePanel.intTracerRadius/3;			
				int intFCPosX = (int)((thePanel.intTracerRadius/2)*(Math.cos(Math.toRadians(thePanel.dblDegrees)))+ 690 - intFCFontSize/2);
				int intFCPosY = (int)((thePanel.intTracerRadius/2)*(Math.sin(Math.toRadians(thePanel.dblDegrees)))+ 270 - intFCFontSize/2);
				fcLabel.setFont(new Font("Times New Roman", Font.PLAIN, intFCFontSize));
				fcLabel.setLocation(intFCPosX, intFCPosY);
			}
			if (theFrame.getContentPane() == newHelpPanel){
				newHelpPanel.repaint();
			}	
		}

		//If the user clicks on the help menu item, it will set the frame to the help panel and repaint
		if(evt.getSource() == helpItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newHelpPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		//If the user clicks on the home menu item, it will set the frame to the home panel and repaint
		} else if(evt.getSource() == homeItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(thePanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		//If the user clicks on the credit menu item, it will set the frame to the credit panel and repaint
		} else if(evt.getSource() == creditItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newCreditPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		//If the user clicks on the test menu item, it will set the frame to the test panel and repaint
		} else if(evt.getSource() == testItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newTestPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		//If user clicks on the leaderboard menu item, it will read the file from leaderboard.txt and put it inside the leaderboard text area. It will also set the frame to the leaderboard panel and repaint
		} else if(evt.getSource() == leaderboardItem){
			try{
				String strLine = "";
				BufferedReader reader = new BufferedReader(new FileReader("leaderboard.txt"));
				strLine = reader.readLine();
				while(strLine != null){
					lbTextArea.append(strLine + "\n");
					strLine = reader.readLine();
				}
				reader.close();
			}catch(IOException e){
				System.out.println("Cannot find file");
			}
			
			theFrame.setVisible(false);
			theFrame.setContentPane(newLeaderboardPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}
		//If the user clicks on the question 1 combo box in testpanel, it will get the index of your answer inside of a variable
		if(evt.getSource() == question1Menu){
			int question1Answer = question1Menu.getSelectedIndex();
		//If the user clicks on the question 2 combo box in testpanel, it will get the index of your answer inside of a variable
		} else if(evt.getSource() == question2Menu){
			int question2Answer = question2Menu.getSelectedIndex();
		//If the user clicks on the question 3 combo box in testpanel, it will get the index of your answer inside of a variable
		} else if(evt.getSource() == question3Menu){
			int question3Answer = question3Menu.getSelectedIndex();
		//If the user clicks on teh finish button, it will get the final selected index of all the comboboxes. It will then check if you got the right answers and increase the variable correctAnswers by one
		} else if(evt.getSource() == finishButton){
			int question1Answer = question1Menu.getSelectedIndex();
			int question2Answer = question2Menu.getSelectedIndex();
			int question3Answer = question3Menu.getSelectedIndex();
			if(question1Answer == 3){
				correctAnswers++;
			}if(question2Answer == 2){
				correctAnswers++;
			}if(question3Answer == 2){
				correctAnswers++;
			}
			strCorrectAnswers = Integer.toString(correctAnswers);
			strName = nameText.getText();
			//If they don't enter a name, it will make a new frame and pop up a message asking the user to enter a name
			if(strName.equals("")){
				JFrame noNameFrame = new JFrame("Message");
				JPanel noNamePanel = new JPanel();
				JLabel noNameLabel = new JLabel("Please enter a name");

				noNameLabel.setSize(300, 50);
				noNameLabel.setLocation(10, 0);
				noNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

				noNamePanel.setLayout(null);
				noNamePanel.setPreferredSize(new Dimension(290,50));
				noNamePanel.add(noNameLabel);

				noNameFrame.setContentPane(noNamePanel);
				noNameFrame.pack();
				noNameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				noNameFrame.setLocationRelativeTo(theFrame);
				noNameFrame.setResizable(false);
				noNameFrame.setVisible(true);
			}else{
				//Disables the nameText, the JComboboxes, and the finish Button. Shows teh answer label and sets the retry button to be enabled and clicked
				this.nameText.setEnabled(false);
				this.question1Menu.setEnabled(false);
				this.question2Menu.setEnabled(false);
				this.question3Menu.setEnabled(false);
				answersLabel.setText("You got " + strCorrectAnswers + " correct answers.");
				this.finishButton.setEnabled(false);
				this.retryButton.setEnabled(true);
				lbTextArea.setText("");
				//Makes a print writer variable to write text into the leaderboard.txt file
				try{
					PrintWriter leaderboardFile = new PrintWriter(new FileWriter("leaderboard.txt", true));
					leaderboardFile.println(strName + ": " + strCorrectAnswers + " answers correct");
					leaderboardFile.close();
				}catch(IOException e){
					System.out.println("Cannot find file");
				}
			}
		}
		//If they click the retry button in the testpanel, then it will reset the menus to 0 and reset the name text field. 
		//It will also enable all the menus, the finish button, and nametext again. Will disable the retry button
		if(evt.getSource() == retryButton){
			nameText.setText("");
			question1Menu.setSelectedIndex(0);
			question2Menu.setSelectedIndex(0);
			question3Menu.setSelectedIndex(0);
			this.question1Menu.setEnabled(true);
			this.question2Menu.setEnabled(true);
			this.question3Menu.setEnabled(true);
			this.nameText.setEnabled(true);
			this.finishButton.setEnabled(true);
			this.retryButton.setEnabled(false);
		}
		
		try{
			if(evt.getSource() == massText){
				massSlider.setValue(Integer.parseInt(massText.getText()));
				if(Integer.parseInt(massText.getText()) < 100){
					massText.setText("100");
				} else if (Integer.parseInt(massText.getText()) > 500){
					massText.setText("500");
				}
				forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
			}
			if (evt.getSource() == periodText){
				periodSlider.setValue((int)(Double.parseDouble(periodText.getText()) * 10));
				if(Double.parseDouble(periodText.getText()) < 0){
					periodText.setText("0.0");
				} else if (Double.parseDouble(periodText.getText()) > 16){
					periodText.setText("16.0");
				}
				forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
			} 
			if (evt.getSource() == radiusText){
				radiusSlider.setValue(Integer.parseInt(radiusText.getText()));
				thePanel.dblRadius = (Double.parseDouble(radiusText.getText()));
				if(Integer.parseInt(radiusText.getText()) < 0){
					radiusText.setText("0");
				} else if (Integer.parseInt(radiusText.getText()) > 50){
					radiusText.setText("50");
				}
				forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
			}		
		} catch (NumberFormatException e){
			JFrame errorFrame = new JFrame("Error Message");
			JPanel errorPanel = new JPanel();
			JLabel errorLabel = new JLabel("Error: Please enter a valid number");

			errorLabel.setSize(300, 50);
			errorLabel.setLocation(10, 0);
			errorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

			errorPanel.setLayout(null);
			errorPanel.setPreferredSize(new Dimension(290,50));
			errorPanel.add(errorLabel);

			errorFrame.setContentPane(errorPanel);
			errorFrame.pack();
			errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			errorFrame.setLocationRelativeTo(theFrame);
			errorFrame.setResizable(false);
			errorFrame.setVisible(true);
		}

		if (evt.getSource() == helpNextButton){
			newHelpPanel.intHelpPage++;
		} else if (evt.getSource() == helpBackButton){
			newHelpPanel.intHelpPage--;
		}
	}
	
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == massSlider){
			thePanel.dblMass = massSlider.getValue();
			System.out.println("massSlider change");
			System.out.println("The mass is " + thePanel.dblMass);
			massText.setText(Integer.toString((int)thePanel.dblMass));
        } 
		if(evt.getSource() == radiusSlider){
			thePanel.dblRadius = radiusSlider.getValue();
			System.out.println("radius sliderChange");
			System.out.println("The radius is " + thePanel.dblRadius);
			radiusText.setText(Integer.toString((int)thePanel.dblRadius));
        }
        if(evt.getSource() == periodSlider){
			thePanel.dblPeriod = Double.valueOf(periodSlider.getValue())/10;
			System.out.println("period sliderChange");
			System.out.println("The period is " + thePanel.dblPeriod);
			periodText.setText(Double.toString(thePanel.dblPeriod));
        }
	}
	public void keyReleased(KeyEvent evt){
	}
	public void keyPressed(KeyEvent evt){
	}
	public void keyTyped(KeyEvent evt){
	}
	
	public void mouseExited(MouseEvent evt){
	}
	public void mouseEntered(MouseEvent evt){
	}
	public void mouseReleased(MouseEvent evt){
	}
	public void mouseClicked(MouseEvent evt){
	}
	public void mousePressed(MouseEvent evt){
	}
	
	public void mouseMoved(MouseEvent evt){
	}
	public void mouseDragged(MouseEvent evt){
	}

	// Constructor
	public centripedal(){
		//Setting the panels dimensions and layout to null so that we don't need to use the default values
		thePanel.setLayout(null);
		newTestPanel.setLayout(null);
		newHelpPanel.setLayout(null);
		newCreditPanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(960, 540));
		newTestPanel.setPreferredSize(new Dimension(960, 540));
		newHelpPanel.setPreferredSize(new Dimension(960, 540));
		newCreditPanel.setPreferredSize(new Dimension(960, 540));
		//Add menu bar to the JFrame
		menuBar.add(openMenu);
		openMenu.add(homeItem);
		openMenu.add(helpItem);
		openMenu.add(creditItem);	
		openMenu.add(testItem);
		openMenu.add(leaderboardItem);
		theFrame.setJMenuBar(menuBar);
		
		//Setting the leaderboard text area to be false
		lbTextArea.setEditable(false);
		//the testScroll is vertical and horizontal as needed. Added to the testpanel
		testScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        testScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        newLeaderboardPanel.setLayout(new BorderLayout());
        newLeaderboardPanel.add(testScroll);
		
		//The creditlabel is set location, font, size and then added to the panel
		creditItem.addActionListener(this);
		creditLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		creditLabel.setSize(600, 200);
		creditLabel.setLocation(300, 250);
		newCreditPanel.add(creditLabel);
		creditLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		creditLabel2.setSize(600, 200);
		creditLabel2.setLocation(275, 300);
		newCreditPanel.add(creditLabel2);
		creditLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		creditLabel3.setSize(600, 200);
		creditLabel3.setLocation(400, 350);
		newCreditPanel.add(creditLabel3);
		
		//Added actionListeners and mouselisteners
		leaderboardItem.addActionListener(this);
		
		helpItem.addActionListener(this);
		
		homeItem.addActionListener(this);

		thePanel.addMouseListener(this);

		//Mass slider has the different ticks and set size and location and added changelistener and added to the panel 
		massSlider.addChangeListener(this);
		massSlider.setMajorTickSpacing(100);
		massSlider.setMinorTickSpacing(25);
		massSlider.setPaintTicks(true);
		massSlider.setPaintLabels(true);
		massSlider.setSize(200, 50);
		massSlider.setLocation(30, 80);
		thePanel.add(massSlider);
		//Mass label set font, size, location and added to the panel
		massLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		massLabel.setSize(250, 200);
		massLabel.setLocation(30, -50);
		thePanel.add(massLabel);
		massText.setSize(120,40);
		massText.setLocation(250, 60);
		massText.addActionListener(this);
		massText.setText("300");
		thePanel.add(massText);
		
		//Radius label set font, size, location and added to the panel and added changeListener to listen to the radiusSlider
		radiusSlider.addChangeListener(this);
		radiusSlider.setMajorTickSpacing(10);
		radiusSlider.setMinorTickSpacing(5);
		radiusSlider.setPaintTicks(true);
		radiusSlider.setPaintLabels(true);
		radiusSlider.setSize(200, 50);
		radiusSlider.setLocation(30, 200);
		thePanel.add(radiusSlider);
		radiusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		radiusLabel.setSize(250, 200);
		radiusLabel.setLocation(30, 70);
		//Set the radius textfield's size, location and added actionlistener to listen to when the radius slider changes values, so does the textfield's value
		thePanel.add(radiusLabel);
		radiusText.setSize(120,40);
		radiusText.setLocation(250, 180);
		radiusText.addActionListener(this);
		radiusText.setText("25");
		thePanel.add(radiusText);
		
		//Period slider has the different ticks and set size and location and added changelistener and added to the panel 
		periodSlider.addChangeListener(this);
		periodSlider.setMajorTickSpacing(200);
		periodSlider.setMinorTickSpacing(100);
		periodSlider.setPaintTicks(true);
		periodSlider.setPaintLabels(true);
		periodSlider.setSize(200, 50);
		periodSlider.setLocation(30, 320);
		thePanel.add(periodSlider);

		java.util.Hashtable<Integer,JLabel> periodLabelTable = new java.util.Hashtable<Integer,JLabel>();
		periodLabelTable.put(160, new JLabel("16"));
		periodLabelTable.put(140, new JLabel("14"));
		periodLabelTable.put(120, new JLabel("12"));
		periodLabelTable.put(100, new JLabel("10"));
		periodLabelTable.put(80, new JLabel("8"));
		periodLabelTable.put(60, new JLabel("6"));
		periodLabelTable.put(40, new JLabel("4"));
		periodLabelTable.put(20, new JLabel("2"));
		periodLabelTable.put(0, new JLabel("0"));
		periodSlider.setLabelTable(periodLabelTable);

		//Period label set font, size, location and added to the panel
		//Added actionlistener so when period slider changes values, so does the textfield's valueSet size, location and added the textfield to the panel
		periodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		periodLabel.setSize(250, 200);
		periodLabel.setLocation(30, 190);
		thePanel.add(periodLabel);	
		periodText.setSize(120,40);
		periodText.setText("8.0");
		periodText.addActionListener(this);
		periodText.setLocation(250, 300);
		thePanel.add(periodText);
		
		//Force label set font, size, location and add to the panel. 
		//Added actionlistener so when the force textfield changes  values based on our program 
		//Set size, location and added the textfield to the panel
		forceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		forceLabel.setSize(300, 200);
		forceLabel.setLocation(30, 310);
		thePanel.add(forceLabel);
		forceText.setEditable(false);
		forceText.setSize(120,40);
		forceText.setLocation(80, 450);
		forceText.addActionListener(this);
		forceText.setText(Integer.toString((int)thePanel.dblForceCentr));
		thePanel.add(forceText);
		
		//Added the JComboboxes of question1, question2, and question3 menu to the testpanel
		newTestPanel.add(question1Menu);
		newTestPanel.add(question2Menu);
		newTestPanel.add(question3Menu);
		testItem.addActionListener(this);
		
		//Set the location, size for the jcombobox of question 1. Added actionlistener to the question1menu so that it could read the user's input
		question1Menu.setLocation(525, 60);
		question1Menu.setSize(50, 25);
		question1Menu.addActionListener(this);
		//Set font, size, and location for the question 1 label and added to the testpanel
		testQuestion1Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion1Label.setSize(550, 200);
		testQuestion1Label.setLocation(10,-25);
		newTestPanel.add(testQuestion1Label);
		//Set font, size, and location for "a" as  multiple choice answer to question 1 as a JLabel and added to the testpanel
		testQuestion1AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerA.setSize(450, 50);
		testQuestion1AnswerA.setLocation(10, 75);
		newTestPanel.add(testQuestion1AnswerA);
		//Set font, size, and location for "b" as  multiple choice answer to question 1 as a JLabel and added to the testpanel
		testQuestion1AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerB.setSize(450, 50);
		testQuestion1AnswerB.setLocation(10, 100);
		newTestPanel.add(testQuestion1AnswerB);
		//Set font, size, and location for "c" as  multiple choice answer to question 1 as a JLabel and added to the testpanel
		testQuestion1AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerC.setSize(450, 50);
		testQuestion1AnswerC.setLocation(10, 125);
		newTestPanel.add(testQuestion1AnswerC);
		//Set font, size, and location for "d" as  multiple choice answer to question 1 as a JLabel and added to the testpanel
		testQuestion1AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerD.setSize(450, 50);
		testQuestion1AnswerD.setLocation(10, 150);
		newTestPanel.add(testQuestion1AnswerD);
		
		//Set the location, size for the jcombobox of question 2. Added actionlistener to the question1menu so that it could read the user's input
		question2Menu.setLocation(750, 215);
		question2Menu.setSize(50, 25);
		question2Menu.addActionListener(this);
		//Set font, size, and location for the question 2 label and added to the testpanel
		testQuestion2Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion2Label.setSize(900, 200);
		testQuestion2Label.setLocation(10,125);
		newTestPanel.add(testQuestion2Label);
		//Set font, size, and location for "a" as  multiple choice answer to question 2 as a JLabel and added to the testpanel
		testQuestion2AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerA.setSize(450, 50);
		testQuestion2AnswerA.setLocation(10, 225);
		newTestPanel.add(testQuestion2AnswerA);
		//Set font, size, and location for "b" as  multiple choice answer to question 2 as a JLabel and added to the testpanel
		testQuestion2AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerB.setSize(450, 50);
		testQuestion2AnswerB.setLocation(10, 250);
		newTestPanel.add(testQuestion2AnswerB);
		//Set font, size, and location for "c" as  multiple choice answer to question 2 as a JLabel and added to the testpanel
		testQuestion2AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerC.setSize(450, 50);
		testQuestion2AnswerC.setLocation(10, 275);
		newTestPanel.add(testQuestion2AnswerC);
		//Set font, size, and location for "d" as  multiple choice answer to question 2 as a JLabel and added to the testpanel
		testQuestion2AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerD.setSize(450, 50);
		testQuestion2AnswerD.setLocation(10, 300);
		newTestPanel.add(testQuestion2AnswerD);
		
		//Set the location, size for the jcombobox of question 3. Added actionlistener to the question1menu so that it could read the user's input
		question3Menu.setLocation(550, 365);
		question3Menu.setSize(50, 25);
		question3Menu.addActionListener(this);
		//Set font, size, and location for the question 2 label and added to the testpanel
		testQuestion3Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion3Label.setSize(900, 200);
		testQuestion3Label.setLocation(10,275);
		newTestPanel.add(testQuestion3Label);
		//Set font, size, and location for "a" as  multiple choice answer to question 3 as a JLabel and added to the testpanel
		testQuestion3AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerA.setSize(450, 50);
		testQuestion3AnswerA.setLocation(10, 375);
		newTestPanel.add(testQuestion3AnswerA);
		//Set font, size, and location for "b" as  multiple choice answer to question 3 as a JLabel and added to the testpanel
		testQuestion3AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerB.setSize(450, 50);
		testQuestion3AnswerB.setLocation(10, 400);
		newTestPanel.add(testQuestion3AnswerB);
		//Set font, size, and location for "c" as  multiple choice answer to question 3 as a JLabel and added to the testpanel
		testQuestion3AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerC.setSize(450, 50);
		testQuestion3AnswerC.setLocation(10, 425);
		newTestPanel.add(testQuestion3AnswerC);
		//Set font, size, and location for "d" as  multiple choice answer to question 3 as a JLabel and added to the testpanel
		testQuestion3AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerD.setSize(450, 50);
		testQuestion3AnswerD.setLocation(10, 450);
		newTestPanel.add(testQuestion3AnswerD);
		
		finishButton.addActionListener(this);
		finishButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		finishButton.setSize(100, 20);
		finishButton.setLocation(650, 450);
		retryButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		retryButton.setSize(100, 20);
		retryButton.setLocation(800, 450);
		newTestPanel.add(retryButton);
		newTestPanel.add(finishButton);
		this.retryButton.setEnabled(false);
		answersLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		answersLabel.setLocation(700, 500);
		answersLabel.setSize(250, 20);
		newTestPanel.add(answersLabel);
		retryButton.addActionListener(this);
		
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameLabel.setSize(100, 20);
		nameLabel.setLocation(10, 20);
		newTestPanel.add(nameLabel);
		nameText.setSize(100, 20);
		nameText.setLocation(75, 20);
		newTestPanel.add(nameText);

		helpNextButton.setSize(100, 20);
		helpNextButton.setLocation(850,510);
		helpNextButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		helpNextButton.addActionListener(this);
		helpBackButton.setSize(100,20);
		helpBackButton.setLocation(30, 510);
		helpBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		helpBackButton.addActionListener(this);
		newHelpPanel.add(helpNextButton);
		newHelpPanel.add(helpBackButton);

		
		fcLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		fcLabel.setSize(100,100);
		fcLabel.setLocation(665 + thePanel.intTracerRadius/2, 235);
		thePanel.add(fcLabel);

		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
		
		theTimer.start();
		
	}
	// Main Method
	public static void main(String[] args){
		new centripedal();
	}
}
