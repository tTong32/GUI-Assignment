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
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	helppanel newHelpPanel = new helppanel();
	creditpanel newCreditPanel = new creditpanel();
	testpanel newTestPanel = new testpanel();
	leaderboard newLeaderboardPanel = new leaderboard();
	
	int correctAnswers = 0;
	JLabel helpLabel = new JLabel("Poon");
	JLabel creditLabel = new JLabel("The students Addison and Thomson");
	JLabel creditLabel2 = new JLabel("at St. Augustine CHS Computer Science");
	JLabel creditLabel3 = new JLabel("made this program");
	Timer theTimer = new Timer(1000/48, this);
	JScrollPane testScroll = new JScrollPane(newTestPanel);
	String strCorrectAnswers = "";
	JLabel answersLabel = new JLabel();
	String strName = "";
	
	JMenuBar menuBar = new JMenuBar();
	JMenu openMenu = new JMenu("Menu");
	JMenuItem homeItem = new JMenuItem("Home");
	JMenuItem helpItem = new JMenuItem("Help");
	JMenuItem creditItem = new JMenuItem("Credits");
	JMenuItem testItem = new JMenuItem("Test");
	JMenuItem leaderboardItem = new JMenuItem("Leaderboard");
	
	JLabel massLabel = new JLabel("Mass (kg)");
	JSlider massSlider = new JSlider(100, 500);
	JTextField massText = new JTextField();
	
	JSlider radiusSlider = new JSlider(0, 50);
	JLabel radiusLabel = new JLabel("Radius (m)");
	JTextField radiusText = new JTextField();
	
	JSlider periodSlider = new JSlider(0, 160);
	JLabel periodLabel = new JLabel("Period (s)");
	JTextField periodText = new JTextField();

	JLabel forceLabel = new JLabel("Force (π^2N)");
	JTextField forceText = new JTextField();
	
	JLabel nameLabel = new JLabel("Name");
	JTextField nameText = new JTextField();
	
	String[] question1Box = {"a", "b", "c", "d"};
	JComboBox question1Menu = new JComboBox(question1Box);
	JLabel testQuestion1Label = new JLabel("1. What is the observed relationship between force and period?");
	JLabel testQuestion1AnswerA = new JLabel("a. Force is indirectly proportional to period");
	JLabel testQuestion1AnswerB = new JLabel("b. Force is directly proportional to period");
	JLabel testQuestion1AnswerC = new JLabel("c. Force is directly proportional to period cubed");
	JLabel testQuestion1AnswerD = new JLabel("d. Force is indirectly proportional to period squared."); 
	
	String[] question2Box = {"a", "b", "c", "d"};
	JComboBox question2Menu = new JComboBox(question2Box);
	JLabel testQuestion2Label = new JLabel("2. Which of the following is a necessary condition for an object to move in a circular path?");
	JLabel testQuestion2AnswerA = new JLabel("a. Constant speed.");
	JLabel testQuestion2AnswerB = new JLabel("b. Constant velocity.");
	JLabel testQuestion2AnswerC = new JLabel("c. Constant acceleration");
	JLabel testQuestion2AnswerD = new JLabel("d. Constant displacement.");
	
	String[] question3Box = {"a", "b", "c", "d"};
	JComboBox question3Menu = new JComboBox(question3Box);
	JLabel testQuestion3Label = new JLabel("3. In circular motion, what is the direction of the centripetal force?");
	JLabel testQuestion3AnswerA = new JLabel("a. Outward from the center of the circle");
	JLabel testQuestion3AnswerB = new JLabel("b. Tangential to the circle");
	JLabel testQuestion3AnswerC = new JLabel("c. Radial, toward the center of the circle");
	JLabel testQuestion3AnswerD = new JLabel("d. Opposite to the direction of motion");
	
	JButton finishButton = new JButton("Finish");
	JButton retryButton = new JButton("Retry");

	JLabel fcLabel = new JLabel("Fc");
	Timer forceTimer = new Timer(2, this);

	boolean blnForceTextChange = false;
	boolean blnMousePressed = false;
	int intChangeSlider;
	int intSecondaryChange;

	// Methods
	public void actionPerformed(ActionEvent evt){
		if (evt.getSource() == theTimer){
			thePanel.repaint();
			forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
			int intFCFontSize = thePanel.intTracerRadius/3;			
			int intFCPosX = (int)((thePanel.intTracerRadius/2)*(Math.cos(Math.toRadians(thePanel.dblDegrees)))+ 690 - intFCFontSize/2);
			int intFCPosY = (int)((thePanel.intTracerRadius/2)*(Math.sin(Math.toRadians(thePanel.dblDegrees)))+ 270 - intFCFontSize/2);
			fcLabel.setFont(new Font("Times New Roman", Font.PLAIN, intFCFontSize));
			fcLabel.setLocation(intFCPosX, intFCPosY);
		}
		if (evt.getSource() == forceTimer){
			blnForceTextChange = false;
			forceTimer.stop();
		}
		if(evt.getSource() == helpItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newHelpPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}if(evt.getSource() == homeItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(thePanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}if(evt.getSource() == creditItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newCreditPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}if(evt.getSource() == testItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newTestPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}if(evt.getSource() == leaderboardItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(newLeaderboardPanel);
			theFrame.setVisible(true);
			theFrame.repaint();
		}if(evt.getSource() == question1Menu){
			int question1Answer = question1Menu.getSelectedIndex();
			if(question1Answer==0){
				System.out.println("Your answer to the question was a");
			}else if(question1Answer==1){
				System.out.println("Your answer to the question was b");
			}else if(question1Answer == 2){
				System.out.println("Your answer to the question was c");
			}else if(question1Answer == 3){
				System.out.println("Your answer to the question was d");
			}
		}if(evt.getSource() == question2Menu){
			int question2Answer = question2Menu.getSelectedIndex();
			if(question2Answer==0){
				System.out.println("Your answer to the question was a");
			}else if(question2Answer==1){
				System.out.println("Your answer to the question was b");
			}else if(question2Answer == 2){
				System.out.println("Your answer to the question was c");
			}else if(question2Answer == 3){
				System.out.println("Your answer to the question was d");
			}
		}if(evt.getSource() == question3Menu){
			int question3Answer = question3Menu.getSelectedIndex();
			if(question3Answer==0){
				System.out.println("Your answer to the question was a");
			}else if(question3Answer==1){
				System.out.println("Your answer to the question was b");
			}else if(question3Answer == 2){
				System.out.println("Your answer to the question was c");
			}else if(question3Answer == 3){
				System.out.println("Your answer to the question was d");
			}
		}if(evt.getSource() == finishButton){
			int question1Answer = question1Menu.getSelectedIndex();
			int question2Answer = question2Menu.getSelectedIndex();
			int question3Answer = question3Menu.getSelectedIndex();
			if(question1Answer == 3){
				correctAnswers++;
			}else if(question2Answer == 2){
				correctAnswers++;
			}else if(question3Answer == 2){
				correctAnswers++;
			}
			strCorrectAnswers = Integer.toString(correctAnswers);
			strName = nameText.getText();
			this.nameText.setEnabled(false);
			this.question1Menu.setEnabled(false);
			this.question2Menu.setEnabled(false);
			this.question3Menu.setEnabled(false);
			answersLabel.setText("You got " + strCorrectAnswers + " correct answers.");
			System.out.println("You have " + correctAnswers +" correct answers.");
			this.finishButton.setEnabled(false);
			this.retryButton.setEnabled(true);
		}if(evt.getSource() == retryButton){
			nameText.setText("");
			question1Menu.setSelectedIndex(0);
			question2Menu.setSelectedIndex(0);
			question3Menu.setSelectedIndex(0);
			this.question1Menu.setEnabled(true);
			this.question2Menu.setEnabled(true);
			this.question3Menu.setEnabled(true);
			this.nameText.setEnabled(true);
			this.finishButton.setEnabled(true);
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
				if(Integer.parseInt(radiusText.getText()) < 0){
					radiusText.setText("0");
				} else if (Integer.parseInt(radiusText.getText()) > 50){
					radiusText.setText("50");
				}
				forceText.setText(Integer.toString((int)(thePanel.dblForceCentr)));
			}
			if (evt.getSource() == forceText){
				blnForceTextChange = true;
				forceTimer.start();
				if(Integer.parseInt(forceText.getText()) < 0){
					forceText.setText("0");
				} else if(Integer.parseInt(forceText.getText()) > 10000000){
					forceText.setText("10000000");
				}
			}			
		} catch (NumberFormatException e){
			JFrame errorFrame = new JFrame("Error Message");
			JPanel errorPanel = new JPanel();
			JLabel errorLabel = new JLabel("Error: Please enter a number");

			errorLabel.setSize(300, 50);
			errorLabel.setLocation(10, 0);
			errorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

			errorPanel.setLayout(null);
			errorPanel.setPreferredSize(new Dimension(250,50));
			errorPanel.add(errorLabel);

			errorFrame.setContentPane(errorPanel);
			errorFrame.pack();
			errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			errorFrame.setLocationRelativeTo(theFrame);
			errorFrame.setResizable(false);
			errorFrame.setVisible(true);
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
		System.out.println("releasing");
	}
	public void mouseClicked(MouseEvent evt){
	}
	public void mousePressed(MouseEvent evt){
		System.out.println("pressing");
	}
	
	public void mouseMoved(MouseEvent evt){
	}
	public void mouseDragged(MouseEvent evt){
	}

	// Constructor
	public centripedal(){
		thePanel.setLayout(null);
		newTestPanel.setLayout(null);
		newHelpPanel.setLayout(null);
		newCreditPanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(960, 540));
		newTestPanel.setPreferredSize(new Dimension(960, 540));
		newHelpPanel.setPreferredSize(new Dimension(960, 540));
		newCreditPanel.setPreferredSize(new Dimension(960, 540));
		menuBar.add(openMenu);
		openMenu.add(homeItem);
		openMenu.add(helpItem);
		openMenu.add(creditItem);	
		openMenu.add(testItem);
		openMenu.add(leaderboardItem);
		theFrame.setJMenuBar(menuBar);
		
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
		
		leaderboardItem.addActionListener(this);
		
		helpItem.addActionListener(this);
		helpLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		helpLabel.setSize(200, 200);
		helpLabel.setLocation(30, -50);
		newHelpPanel.add(helpLabel);
		
		homeItem.addActionListener(this);

		thePanel.addMouseListener(this);

		massSlider.addChangeListener(this);
		massSlider.setMajorTickSpacing(100);
		massSlider.setMinorTickSpacing(25);
		massSlider.setPaintTicks(true);
		massSlider.setPaintLabels(true);
		massSlider.setSize(200, 50);
		massSlider.setLocation(30, 80);
		thePanel.add(massSlider);
		massLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		massLabel.setSize(250, 200);
		massLabel.setLocation(30, -50);
		thePanel.add(massLabel);
		massText.setSize(120,40);
		massText.setLocation(250, 60);
		massText.addActionListener(this);
		massText.setText("300");
		thePanel.add(massText);
		
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
		radiusText.setSize(100, 30);
		thePanel.add(radiusLabel);
		radiusText.setSize(120,40);
		radiusText.setLocation(250, 180);
		radiusText.addActionListener(this);
		radiusText.setText("25");
		thePanel.add(radiusText);
		
		periodSlider.addChangeListener(this);
		periodSlider.setMajorTickSpacing(200);
		periodSlider.setMinorTickSpacing(100);
		periodSlider.setPaintTicks(true);
		periodSlider.setPaintLabels(true);

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

		periodSlider.setSize(200, 50);
		periodSlider.setLocation(30, 320);
		thePanel.add(periodSlider);

		periodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		periodLabel.setSize(250, 200);
		periodLabel.setLocation(30, 190);
		thePanel.add(periodLabel);
		periodText.setSize(120,40);
		periodText.setText("8.0");
		periodText.addActionListener(this);
		periodText.setLocation(250, 300);
		thePanel.add(periodText);
		
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
		
		newTestPanel.add(question1Menu);
		newTestPanel.add(question2Menu);
		newTestPanel.add(question3Menu);
		testItem.addActionListener(this);
				
		question1Menu.setLocation(400, 60);
		question1Menu.setSize(50, 25);
		question1Menu.addActionListener(this);
		testQuestion1Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion1Label.setSize(400, 200);
		testQuestion1Label.setLocation(10,-25);
		newTestPanel.add(testQuestion1Label);
		testQuestion1AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerA.setSize(450, 50);
		testQuestion1AnswerA.setLocation(10, 75);
		newTestPanel.add(testQuestion1AnswerA);
		testQuestion1AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerB.setSize(450, 50);
		testQuestion1AnswerB.setLocation(10, 100);
		newTestPanel.add(testQuestion1AnswerB);
		testQuestion1AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerC.setSize(450, 50);
		testQuestion1AnswerC.setLocation(10, 125);
		newTestPanel.add(testQuestion1AnswerC);
		testQuestion1AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerD.setSize(450, 50);
		testQuestion1AnswerD.setLocation(10, 150);
		newTestPanel.add(testQuestion1AnswerD);
		
		question2Menu.setLocation(750, 215);
		question2Menu.setSize(50, 25);
		question2Menu.addActionListener(this);
		testQuestion2Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion2Label.setSize(900, 200);
		testQuestion2Label.setLocation(10,125);
		newTestPanel.add(testQuestion2Label);
		testQuestion2AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerA.setSize(450, 50);
		testQuestion2AnswerA.setLocation(10, 225);
		newTestPanel.add(testQuestion2AnswerA);
		testQuestion2AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerB.setSize(450, 50);
		testQuestion2AnswerB.setLocation(10, 250);
		newTestPanel.add(testQuestion2AnswerB);
		testQuestion2AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerC.setSize(450, 50);
		testQuestion2AnswerC.setLocation(10, 275);
		newTestPanel.add(testQuestion2AnswerC);
		testQuestion2AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerD.setSize(450, 50);
		testQuestion2AnswerD.setLocation(10, 300);
		newTestPanel.add(testQuestion2AnswerD);
		
		question3Menu.setLocation(550, 365);
		question3Menu.setSize(50, 25);
		question3Menu.addActionListener(this);
		testQuestion3Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion3Label.setSize(900, 200);
		testQuestion3Label.setLocation(10,275);
		newTestPanel.add(testQuestion3Label);
		testQuestion3AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerA.setSize(450, 50);
		testQuestion3AnswerA.setLocation(10, 370);
		newTestPanel.add(testQuestion3AnswerA);
		testQuestion3AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerB.setSize(450, 50);
		testQuestion3AnswerB.setLocation(10, 400);
		newTestPanel.add(testQuestion3AnswerB);
		testQuestion3AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerC.setSize(450, 50);
		testQuestion3AnswerC.setLocation(10, 425);
		newTestPanel.add(testQuestion3AnswerC);
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
		answersLabel.setLocation(800, 500);
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
