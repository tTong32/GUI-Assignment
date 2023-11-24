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
	
	double dblMass = 200; // in kg
	double dblVelocity = 5;
	double dblPeriod = 5; // seconds it takes for a revolution
	double dblRadius = 50; // every 5 pixels is 1 m
	double dblForceCentr;
	
	//Methods
	public void paintComponent(Graphics g){
		
		int intMass = (int)dblMass / 10;
		int intRadius = (int)dblRadius * 5;
		
		int intTracerDiameter = intRadius*2 + intMass/4;
		int intTracerRadius = intRadius + intMass/8;
		int intTracerWidth = intMass / 4;
		
		Color color = new Color(247, 242, 242);
		g.setColor(color);
		g.fillRect(0, 0, 400, 540);
		
		g.setColor(Color.WHITE);
		g.fillRect(400,0,560,540);
		
		g.setColor(Color.RED);
		g.fillOval(690 - intTracerRadius, 270 - intTracerRadius, intTracerDiameter, intTracerDiameter);
		
		g.setColor(Color.WHITE);
		g.fillOval(690 - intTracerRadius + intTracerWidth, 270 - intTracerRadius + intTracerWidth, intTracerDiameter - intTracerWidth*2, intTracerDiameter - intTracerWidth*2);

		g.setColor(Color.RED);
		g.fillOval(intPosX - (intMass / 2), intPosY - (intMass / 2), intMass, intMass);
		
		dblDegrees += 360/(48*dblPeriod);
		
		intPosY = (int)((dblRadius * 5)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
		intPosX = (int)((dblRadius * 5)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);
		
		dblForceCentr = (dblMass * dblVelocity * dblVelocity) / dblRadius;
		//System.out.println("Centripedal force is: " + dblForceCentr);
		
	}
}



