// Centripdeal Force
// By Addison and Thomson

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
	
	Timer theTimer = new Timer(1000/48, this);
	
	JMenuBar menuBar = new JMenuBar();
	JMenu openMenu = new JMenu("Menu");
	JMenuItem helpItem = new JMenuItem("Help");
	JMenuItem creditItem = new JMenuItem("Credits");
	
	JLabel massLabel = new JLabel("Mass");
	JSlider massSlider = new JSlider();
	JTextField massText = new JTextField();
	
	JSlider velocitySlider = new JSlider();
	JLabel velocityLabel = new JLabel("Velocity");
	JTextField velocityText = new JTextField();
	
	JSlider radiusSlider = new JSlider();
	JLabel radiusLabel = new JLabel("Radius");
	JTextField radiusText = new JTextField();
	
	JSlider periodSlider = new JSlider(0, 20);
	JLabel periodLabel = new JLabel("Period");
	JTextField periodText = new JTextField();
	
	JButton pictureButton = new JButton("Form Picture");
	// Methods
	public void actionPerformed(ActionEvent evt){
		if (evt.getSource() == theTimer){
				thePanel.repaint();
		}
		if(evt.getSource() == helpItem){
			theFrame.setVisible(false);
			theFrame.setContentPane(thePanel);
			theFrame.setVisible(true);
		}
	}
	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == radiusSlider){
			JSlider theSlider = (JSlider)evt.getSource();
			if(!theSlider.getValueIsAdjusting()) {
				int radius = (int)theSlider.getValue();
				System.out.println("The radius is " + radius);
			} 
        }if(evt.getSource() == velocitySlider){
			JSlider theSlider = (JSlider)evt.getSource();
			if(!theSlider.getValueIsAdjusting()) {
				int velocity = (int)theSlider.getValue();
				System.out.println("The velocity is " + velocity);
			} 
        }if(evt.getSource() == periodSlider){
			JSlider theSlider = (JSlider)evt.getSource();
			if(!theSlider.getValueIsAdjusting()) {
				int period = (int)theSlider.getValue();
				System.out.println("The period is " + period);
			} 
        }if(evt.getSource() == massSlider){
			JSlider theSlider = (JSlider)evt.getSource();
			if(!theSlider.getValueIsAdjusting()) {
				int mass = (int)theSlider.getValue();
				System.out.println("The mass is " + mass);
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
		thePanel.setPreferredSize(new Dimension(960, 540));
		menuBar.add(openMenu);
		openMenu.add(helpItem);
		openMenu.add(creditItem);	
		theFrame.setJMenuBar(menuBar);
		
		helpItem.addActionListener(this);
		
		//massText.setSize(100, 30);
		//massText.setLocation(100,20);
		//thePanel.add(massText);
		massSlider.addChangeListener(this);
		massSlider.setMajorTickSpacing(25);
		massSlider.setMinorTickSpacing(5);
		massSlider.setPaintTicks(true);
		massSlider.setPaintLabels(true);
		massSlider.setSize(200, 50);
		massSlider.setLocation(30, 80);
		thePanel.add(massSlider);
		massLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		massLabel.setSize(200, 200);
		massLabel.setLocation(30, -50);
		thePanel.add(massLabel);
		
		
		//velocityText.setSize(100, 30);
		//velocityText.setLocation(100,70);
		//thePanel.add(velocityText);
		velocitySlider.addChangeListener(this);
		velocitySlider.setMajorTickSpacing(25);
		velocitySlider.setMinorTickSpacing(5);
		velocitySlider.setPaintTicks(true);
		velocitySlider.setPaintLabels(true);
		velocitySlider.setSize(200, 50);
		velocitySlider.setLocation(30, 200);
		thePanel.add(velocitySlider);
		velocityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		velocityLabel.setSize(200, 200);
		velocityLabel.setLocation(30, 70);
		thePanel.add(velocityLabel);
		
		
		//radiusText.setSize(100, 30);
		//radiusText.setLocation(100,120);
		//thePanel.add(radiusText);
		radiusSlider.addChangeListener(this);
		radiusSlider.setMajorTickSpacing(25);
		radiusSlider.setMinorTickSpacing(5);
		radiusSlider.setPaintTicks(true);
		radiusSlider.setPaintLabels(true);
		radiusSlider.setSize(200, 50);
		radiusSlider.setLocation(30, 320);
		thePanel.add(radiusSlider);
		radiusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		radiusLabel.setSize(200, 200);
		radiusLabel.setLocation(30, 190);
		radiusText.setSize(100, 30);
		thePanel.add(radiusLabel);
		
		//periodText.setSize(100, 30);
		//periodText.setLocation(100, 170);
		//thePanel.add(periodText);
		periodSlider.addChangeListener(this);
		periodSlider.setMajorTickSpacing(5);
		periodSlider.setMinorTickSpacing(1);
		periodSlider.setPaintTicks(true);
		periodSlider.setPaintLabels(true);
		periodSlider.setSize(200, 50);
		periodSlider.setLocation(30, 440);
		thePanel.add(periodSlider);
		periodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		periodLabel.setSize(200, 200);
		periodLabel.setLocation(30, 310);
		thePanel.add(periodLabel);
		
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
