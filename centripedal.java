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
	
	JLabel helpLabel = new JLabel("Poon");
	JLabel creditLabel = new JLabel("Poon made this");
	Timer theTimer = new Timer(1000/48, this);
	
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

	JSlider forceSlider = new JSlider(0, 10000);
	JLabel forceLabel = new JLabel("Force (πN)");
	JTextField forceText = new JTextField();
	
	JButton pictureButton = new JButton("Form Picture");
	
	String[] questionBox = {"Question 5", "Question 4", "Question 3", "Question 2", "Question 1"};
	JComboBox questionMenu = new JComboBox(questionBox);
	
	int correctAnswers = 0;
	JLabel testQuestion1Label = new JLabel("1. Centripedal Force is the force that causes an object to move in a circular path.");
	JButton testQuestion1A = new JButton("True");
	JButton testQuestion1B = new JButton("False");
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if (evt.getSource() == theTimer){
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
		}if(evt.getSource() == testQuestion1A){
			correctAnswers++;
			
		}if(evt.getSource() == questionMenu){
		
			
		}
	}
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == radiusSlider){
				thePanel.dblRadius = radiusSlider.getValue();
				System.out.println("The radius is " + thePanel.dblRadius);
        }
        if(evt.getSource() == periodSlider){
				int previousValue = (int)thePanel.dblPeriod;
				thePanel.dblPeriod = periodSlider.getValue();
				System.out.println("The period is " + thePanel.dblPeriod);
				if (thePanel.dblPeriod != 0){
					thePanel.dblForceCentr = thePanel.dblForceCentr * (previousValue / (thePanel.dblPeriod));
					forceSlider.setValue((int)thePanel.dblForceCentr);
				}
        }
		if(evt.getSource() == massSlider){
				thePanel.dblMass = massSlider.getValue();
				System.out.println("The mass is " + thePanel.dblMass);
        }
        if(evt.getSource() == forceSlider){
				thePanel.dblForceCentr = forceSlider.getValue();
				System.out.println("The force is " + thePanel.dblForceCentr); 
				
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
		
		//massText.setSize(100, 30);
		//massText.setLocation(100,20);
		//thePanel.add(massText);
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
		
		//radiusText.setSize(100, 30);
		//radiusText.setLocation(100,120);
		//thePanel.add(radiusText);
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
		
		//periodText.setSize(100, 30);
		//periodText.setLocation(100, 170);
		//thePanel.add(periodText);
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

		//velocityText.setSize(100, 30);
		//velocityText.setLocation(100,70);
		//thePanel.add(velocityText);

		forceSlider.addChangeListener(this);
		forceSlider.setMajorTickSpacing(2500);
		forceSlider.setMinorTickSpacing(250);
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
		
		questionMenu.setLocation(400, 100);
		questionMenu.setSize(100, 100);
		questionMenu.addActionListener(this);
		newTestPanel.add(questionMenu);
		testItem.addActionListener(this);
		testQuestion1Label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		testQuestion1Label.setSize(400, 200);
		testQuestion1Label.setLocation(10,-50);
		newTestPanel.add(testQuestion1Label);
		testQuestion1A.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		testQuestion1A.setSize(100, 50);
		testQuestion1A.setLocation(10, 80);
		newTestPanel.add(testQuestion1A);
		testQuestion1B.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		testQuestion1B.setSize(100, 50);
		testQuestion1B.setLocation(160, 80);
		newTestPanel.add(testQuestion1B);
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
