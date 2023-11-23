import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class newpanel extends JPanel{
	//Properties
	int intPosX = 740;
	int intVeloX;
	int intAccelX;
	
	int intPosY = 270;
	int intVeloY;
	int intAccelY;
	
	boolean blnGravity = true;
	
	double dblDegrees = 0;
	
	double dblMass = 10;
	double dblVelocity = 5;
	double dblPeriod = 2; // seconds it takes for a revolution
	double dblRadius = 20; // every 5 pixels is 1 m
	double dblForceCentr;
	
	//Methods
	public void paintComponent(Graphics g){
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960,540);
		
		g.setColor(Color.RED);
		g.fillOval(intPosX, intPosY, (int)(dblMass), (int)(dblMass));
		
		dblDegrees += 360/(48*dblPeriod);
		
		intPosY = (int)((dblRadius*5)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
		intPosX = (int)((dblRadius*5)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);
		
		dblForceCentr = (dblMass * dblVelocity * dblVelocity) / dblRadius;
		//System.out.println("Centripedal force is: " + dblForceCentr);
		
	}
}



