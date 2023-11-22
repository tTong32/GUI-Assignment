// Centripdeal Force
// By Addison and Thomson

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class centripedal implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	// Properties
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	Timer theTimer = new Timer(1000/48, this);
	JLabel massLabel = new JLabel("Mass");
	JTextField massText = new JTextField();
	JLabel velocityLabel = new JLabel("Velocity");
	JTextField velocityText = new JTextField();
	JLabel radiusLabel = new JLabel("Radius");
	JTextField radiusText = new JTextField();
	JLabel periodLabel = new JLabel("Period");
	JTextField periodText = new JTextField();
	JButton pictureButton = new JButton("Form Picture");
	
	// Methods
	public void actionPerformed(ActionEvent evt){
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
		
		
		massText.setSize(100, 30);
		massText.setLocation(100,20);
		thePanel.add(massText);
		massLabel.setSize(75, 65);
		massLabel.setLocation(30, 0);
		thePanel.add(massLabel);
		
		velocityText.setSize(100, 30);
		velocityText.setLocation(100,70);
		thePanel.add(velocityText);
		velocityLabel.setSize(75, 115);
		velocityLabel.setLocation(30, 30);
		thePanel.add(velocityLabel);
		
		radiusText.setSize(100, 30);
		radiusText.setLocation(100,120);
		thePanel.add(radiusText);
		radiusLabel.setSize(75, 165);
		radiusLabel.setLocation(30, 50);
		radiusText.setSize(100, 30);
		thePanel.add(radiusLabel);
		
		periodText.setSize(100, 30);
		periodText.setLocation(100, 170);
		thePanel.add(periodText);
		periodLabel.setSize(75, 215);
		periodLabel.setLocation(30, 80);
		thePanel.add(periodLabel);
		
		pictureButton.setSize(190, 40);
		pictureButton.setLocation(25, 225);
		pictureButton.addActionListener(this);
		thePanel.add(pictureButton);
		
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
		
	}
	// Main Method
	public static void main(String[] args){
		new centripedal();
	}
}
