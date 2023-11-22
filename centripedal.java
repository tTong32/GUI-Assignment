// Centripdeal Force
// By Addison and Thomson

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Font;

public class centripedal implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	// Properties
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	
	Timer theTimer = new Timer(1000/48, this);
	
	JLabel massLabel = new JLabel("Mass");
	JSlider massSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
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
		if (evt.getSource() == theTimer){
				thePanel.repaint();
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
		
		//massText.setSize(100, 30);
		//massText.setLocation(100,20);
		//thePanel.add(massText);
		massSlider.setMajorTickSpacing(25);
		massSlider.setMinorTickSpacing(5);
		massSlider.setPaintTicks(true);
		massSlider.setPaintLabels(true);
		massSlider.setSize(200, 50);
		massSlider.setLocation(30, 130);
		thePanel.add(massSlider);
		massLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		massLabel.setSize(200, 200);
		massLabel.setLocation(30, 0);
		thePanel.add(massLabel);
		
		
		//velocityText.setSize(100, 30);
		//velocityText.setLocation(100,70);
		//thePanel.add(velocityText);
		velocityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		velocityLabel.setSize(200, 200);
		velocityLabel.setLocation(30, 120);
		thePanel.add(velocityLabel);
		
		
		//radiusText.setSize(100, 30);
		//radiusText.setLocation(100,120);
		//thePanel.add(radiusText);
		radiusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		radiusLabel.setSize(200, 200);
		radiusLabel.setLocation(30, 240);
		radiusText.setSize(100, 30);
		thePanel.add(radiusLabel);
		
		//periodText.setSize(100, 30);
		//periodText.setLocation(100, 170);
		//thePanel.add(periodText);
		periodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		periodLabel.setSize(200, 200);
		periodLabel.setLocation(30, 360);
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
