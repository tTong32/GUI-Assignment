// By Addison and Thomson
// December 6th, 2023
// A program designed to graphically show centripetal force, and the effect that certain parameters have on circular motion

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Font;

public class centripedal implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ChangeListener{
	// Properties
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	helppanel newHelpPanel = new helppanel();
	creditpanel newCreditPanel = new creditpanel();
	testpanel newTestPanel = new testpanel();
	
	int correctAnswers = 0;
	JLabel helpLabel = new JLabel("Poon");
	JLabel creditLabel = new JLabel("Poon made this");
	Timer theTimer = new Timer(1000/48, this);
	JScrollPane testScroll = new JScrollPane(newTestPanel);
	
	JMenuBar menuBar = new JMenuBar();
	JMenu openMenu = new JMenu("Menu");
	JMenuItem homeItem = new JMenuItem("Home");
	JMenuItem helpItem = new JMenuItem("Help");
	JMenuItem creditItem = new JMenuItem("Credits");
	JMenuItem testItem = new JMenuItem("Test");
	
	JLabel massLabel = new JLabel("Mass (kg)");
	JSlider massSlider = new JSlider(100, 500);
	JTextField massText = new JTextField();
	
	JSlider radiusSlider = new JSlider(0, 50);
	JLabel radiusLabel = new JLabel("Radius (m)");
	JTextField radiusText = new JTextField();
	
	JSlider periodSlider = new JSlider(0, 16);
	JLabel periodLabel = new JLabel("Period (s)");
	JTextField periodText = new JTextField();

	JSlider forceSlider = new JSlider(0, 100000);
	JLabel forceLabel = new JLabel("Force (π^2N)");
	JTextField forceText = new JTextField();
	
	String[] question1Box = {"a", "b", "c", "d"};
	JComboBox question1Menu = new JComboBox(question1Box);
	JLabel testQuestion1Label = new JLabel("1. What is the defintiion of centripedal force?");
	JLabel testQuestion1AnswerA = new JLabel("a. The force that causes an object to move in a straight line.");
	JLabel testQuestion1AnswerB = new JLabel("b. The force that causes an object to move in a circular path.");
	JLabel testQuestion1AnswerC = new JLabel("c. The force of gravity acting on the object.");
	JLabel testQuestion1AnswerD = new JLabel("d. The force exerted by an object in motion."); 
	
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
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if (evt.getSource() == theTimer){
			forceSlider.setValue((int)thePanel.dblForceCentr);
			
			thePanel.repaint();
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
			if(question1Answer == 1){
				correctAnswers++;
			}else if(question2Answer == 2){
				correctAnswers++;
			}else if(question3Answer == 3){
				correctAnswers++;
			}
			System.out.println("You have " + correctAnswers +" correct answers.");
			this.finishButton.setEnabled(false);
		}
		
		if(evt.getSource() == massText){
			System.out.println("mass");
		}
		if (evt.getSource() == periodText){
			System.out.println("Period");
		} 
		if (evt.getSource() == radiusText){
			System.out.println("Radius");
		}
		if (evt.getSource() == forceText){
			System.out.println("force");
		}
	}
	
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == massSlider){
			thePanel.dblMass = massSlider.getValue();
			System.out.println("The mass is " + thePanel.dblMass);
			massText.setText(Integer.toString((int)thePanel.dblMass));
        } 
		if(evt.getSource() == radiusSlider){
			thePanel.dblRadius = radiusSlider.getValue();
			System.out.println("The radius is " + thePanel.dblRadius);
			radiusText.setText(Integer.toString((int)thePanel.dblRadius));
        }
        if(evt.getSource() == periodSlider){
			thePanel.dblPeriod = periodSlider.getValue();
			System.out.println("The period is " + thePanel.dblPeriod);
			periodText.setText(Integer.toString((int)thePanel.dblPeriod));
        }
		if(evt.getSource() == forceSlider){
			thePanel.dblForceCentr = forceSlider.getValue();
			System.out.println("The force is " + thePanel.dblForceCentr);
			if(forceSlider.getValueIsAdjusting() == true){
				thePanel.dblMass = (thePanel.dblForceCentr*thePanel.dblPeriod*thePanel.dblPeriod)/(4*thePanel.dblRadius);
				if (thePanel.dblMass >= 500){
					thePanel.dblMass = 500;
					thePanel.dblRadius = (thePanel.dblForceCentr*thePanel.dblPeriod*thePanel.dblPeriod)/(4*thePanel.dblMass);
					System.out.println("Adjusting Radius" + thePanel.dblRadius);
					if (thePanel.dblRadius >= 50){
						thePanel.dblRadius = 50;
						thePanel.dblPeriod = Math.sqrt(thePanel.dblForceCentr/(4*thePanel.dblMass*thePanel.dblRadius));
						if (thePanel.dblPeriod <= 1){
							thePanel.dblPeriod = 1;
						}
						periodSlider.setValue((int)thePanel.dblPeriod);
						System.out.println("Adjusting Period" + thePanel.dblPeriod);
					}	
					radiusSlider.setValue((int)thePanel.dblRadius);
				} else if (thePanel.dblMass <= 100){
					thePanel.dblMass = 100;
					thePanel.dblRadius = (thePanel.dblForceCentr*thePanel.dblPeriod*thePanel.dblPeriod)/(4*thePanel.dblMass);
					if (thePanel.dblRadius <= 1){
						thePanel.dblRadius = 1;
						thePanel.dblPeriod = Math.sqrt(thePanel.dblForceCentr/(4*thePanel.dblMass*thePanel.dblRadius));
						if (thePanel.dblPeriod >= 16){
							thePanel.dblPeriod = 16;
						}
						periodSlider.setValue((int)thePanel.dblPeriod);
					}
					radiusSlider.setValue((int)thePanel.dblRadius);
				}
				massSlider.setValue((int)thePanel.dblMass);
				System.out.println("Adjusting Mass" + thePanel.dblMass);
				forceText.setText(Integer.toString((int)thePanel.dblForceCentr));
			}
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
		theFrame.setJMenuBar(menuBar);
		
		creditItem.addActionListener(this);
		creditLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		creditLabel.setSize(200, 200);
		creditLabel.setLocation(0, -50);
		newCreditPanel.add(creditLabel);
		
		helpItem.addActionListener(this);
		helpLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		helpLabel.setSize(200, 200);
		helpLabel.setLocation(30, -50);
		newHelpPanel.add(helpLabel);
		
		homeItem.addActionListener(this);

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
		periodSlider.setMajorTickSpacing(2);
		periodSlider.setMinorTickSpacing(1);
		periodSlider.setPaintTicks(true);
		periodSlider.setPaintLabels(true);
		periodSlider.setSize(200, 50);
		periodSlider.setLocation(30, 320);
		thePanel.add(periodSlider);
		periodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		periodLabel.setSize(250, 200);
		periodLabel.setLocation(30, 190);
		thePanel.add(periodLabel);
		periodText.setSize(120,40);
		periodText.setText("8");
		periodText.addActionListener(this);
		periodText.setLocation(250, 300);
		thePanel.add(periodText);
		
		forceSlider.addChangeListener(this);
		forceSlider.setMajorTickSpacing(25000);
		forceSlider.setMinorTickSpacing(2500);
		forceSlider.setPaintTicks(true);
		forceSlider.setPaintLabels(true);
		forceSlider.setSize(200, 50);
		forceSlider.setValue(1473);
		forceSlider.setLocation(30, 440);
		thePanel.add(forceSlider);
		forceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		forceLabel.setSize(300, 200);
		forceLabel.setLocation(30, 310);
		thePanel.add(forceLabel);
		forceText.setSize(120,40);
		forceText.setLocation(250, 420);
		forceText.addActionListener(this);
		forceText.setText(Integer.toString((int)thePanel.dblForceCentr));
		thePanel.add(forceText);
		
		newTestPanel.add(question1Menu);
		newTestPanel.add(question2Menu);
		newTestPanel.add(question3Menu);
		testItem.addActionListener(this);
		
				
		question1Menu.setLocation(400, 35);
		question1Menu.setSize(50, 25);
		question1Menu.addActionListener(this);
		testQuestion1Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion1Label.setSize(400, 200);
		testQuestion1Label.setLocation(10,-50);
		newTestPanel.add(testQuestion1Label);
		testQuestion1AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerA.setSize(450, 50);
		testQuestion1AnswerA.setLocation(10, 50);
		newTestPanel.add(testQuestion1AnswerA);
		testQuestion1AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerB.setSize(450, 50);
		testQuestion1AnswerB.setLocation(10, 75);
		newTestPanel.add(testQuestion1AnswerB);
		testQuestion1AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerC.setSize(450, 50);
		testQuestion1AnswerC.setLocation(10, 100);
		newTestPanel.add(testQuestion1AnswerC);
		testQuestion1AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion1AnswerD.setSize(450, 50);
		testQuestion1AnswerD.setLocation(10, 125);
		newTestPanel.add(testQuestion1AnswerD);
		
		question2Menu.setLocation(750, 190);
		question2Menu.setSize(50, 25);
		question2Menu.addActionListener(this);
		testQuestion2Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion2Label.setSize(900, 200);
		testQuestion2Label.setLocation(10,100);
		newTestPanel.add(testQuestion2Label);
		testQuestion2AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerA.setSize(450, 50);
		testQuestion2AnswerA.setLocation(10, 200);
		newTestPanel.add(testQuestion2AnswerA);
		testQuestion2AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerB.setSize(450, 50);
		testQuestion2AnswerB.setLocation(10, 225);
		newTestPanel.add(testQuestion2AnswerB);
		testQuestion2AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerC.setSize(450, 50);
		testQuestion2AnswerC.setLocation(10, 250);
		newTestPanel.add(testQuestion2AnswerC);
		testQuestion2AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion2AnswerD.setSize(450, 50);
		testQuestion2AnswerD.setLocation(10, 275);
		newTestPanel.add(testQuestion2AnswerD);
		
		question3Menu.setLocation(550, 340);
		question3Menu.setSize(50, 25);
		question3Menu.addActionListener(this);
		testQuestion3Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion3Label.setSize(900, 200);
		testQuestion3Label.setLocation(10,250);
		newTestPanel.add(testQuestion3Label);
		testQuestion3AnswerA.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerA.setSize(450, 50);
		testQuestion3AnswerA.setLocation(10, 350);
		newTestPanel.add(testQuestion3AnswerA);
		testQuestion3AnswerB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerB.setSize(450, 50);
		testQuestion3AnswerB.setLocation(10, 375);
		newTestPanel.add(testQuestion3AnswerB);
		testQuestion3AnswerC.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerC.setSize(450, 50);
		testQuestion3AnswerC.setLocation(10, 400);
		newTestPanel.add(testQuestion3AnswerC);
		testQuestion3AnswerD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		testQuestion3AnswerD.setSize(450, 50);
		testQuestion3AnswerD.setLocation(10, 425);
		newTestPanel.add(testQuestion3AnswerD);
		
		finishButton.addActionListener(this);
		finishButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		finishButton.setSize(100, 20);
		finishButton.setLocation(850, 450);
		newTestPanel.add(finishButton);
		/*
		pictureButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		pictureButton.setSize(300, 70);
		pictureButton.setLocation(30, 450);
		pictureButton.addActionListener(this);
		thePanel.add(pictureButton);
		*/
		
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
