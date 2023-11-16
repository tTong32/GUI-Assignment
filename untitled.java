import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class untitled implements KeyListener, MouseListener, MouseMotionListener{
	// Properties
	JFrame theFrame = new JFrame("GUI Project");
	newpanel thePanel = new newpanel();
	// Methods
	public void keyReleased(KeyEvent evt){
		
	}
	public void keyPressed(KeyEvent evt){
		
	}
	public void keyTyped(KeyEvent evt){
		
	}
	public void mouseMoved(MouseEvent evt){
		
	}
	public void mouseDragged(MouseEvent evt){
		
	}
	public void mouseExited(MouseEvent evt){
		
	}
	public void mouseEntered(MouseEvent evt){
		
	}
	public void mouseReleased(MouseEvent evt){
		
	}
	public void mousePressed(MouseEvent evt){
		
	}
	public void mouseClicked(MouseEvent evt){
		
	}
	// Constructor
	public untitled(){
		thePanel.setPreferredSize(new Dimension(1000, 1000));
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
	}
	// Main Method
	public static void main(String[] args){
		//Dljsladfkjlafjlk
		new untitled();
	}
}
