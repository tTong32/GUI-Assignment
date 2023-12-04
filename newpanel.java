import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

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
	
	double dblMass = 300; // in kg
	double dblPeriod = 8; // seconds it takes for a revolution
	double dblRadius = 25; // every 5 pixels is 1 m
	double dblForceCentr; // in pi N

	Rectangle forceRect = new Rectangle(690, 265, 0, 10);
	AffineTransform t = new AffineTransform();
	Shape rForceRect = t.createTransformedShape(forceRect);
	
	int intMass = (int)dblMass / 10;
	int intRadius = (int)dblRadius * 5;

	int intTracerDiameter = intRadius*2 + intMass/4;
	int intTracerRadius = intRadius + intMass/8;
	int intTracerWidth = intMass / 4;

	JLabel fcLabel = new JLabel();

	//Methods
	public void paintComponent(Graphics g){
		
		intMass = (int)dblMass / 10;
		intRadius = (int)dblRadius * 5;
		
		// The tracer is used to "map" out the movement of the ball
		intTracerDiameter = intRadius*2 + intMass/4;
		intTracerRadius = intRadius + intMass/8;
		intTracerWidth = intMass / 4;

		if (dblPeriod == 0){
			dblForceCentr = 0;
		} else {
			dblForceCentr = (4*dblMass*dblRadius) / (dblPeriod*dblPeriod);
		}
		
		Graphics2D g2d = (Graphics2D)g;
		if (dblForceCentr < 200 && dblPeriod != 0){
			forceRect.height = 1;
			forceRect.width = intTracerRadius;
		} else {
			forceRect.width = intTracerRadius;
			forceRect.height = (int)dblForceCentr/150;
			forceRect.y = (int)(270 - dblForceCentr/300);
		}
			
		Color grey = new Color(247, 242, 242);
		g.setColor(grey);
		g.fillRect(0, 0, 400, 540);
		
		g.setColor(Color.WHITE);
		g.fillRect(400,0,560,540);
		
		g.setColor(Color.RED);
		g.fillOval(690 - intTracerRadius, 270 - intTracerRadius, intTracerDiameter, intTracerDiameter);
		
		g.setColor(Color.WHITE);
		g.fillOval(690 - intTracerRadius + intTracerWidth, 270 - intTracerRadius + intTracerWidth, intTracerDiameter - intTracerWidth*2, intTracerDiameter - intTracerWidth*2);

		g.setColor(Color.RED);
		g.fillOval(intPosX - (intMass / 2), intPosY - (intMass / 2), intMass, intMass);

		g2d.fill(rForceRect);
		
		if (dblPeriod != 0){
			dblDegrees += 360/(48*dblPeriod);
			intPosY = (int)((dblRadius * 5)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
			intPosX = (int)((dblRadius * 5)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);
			//g2d.rotate(Math.toRadians(dblDegrees), 690, 270);
			t.translate(690, 270);
			t.rotate(Math.toRadians(360/(48*dblPeriod)));
			t.translate(-690, -270);

			rForceRect = t.createTransformedShape(forceRect);
		} 
		

		//System.out.println("Centripedal force is: " + dblForceCentr);
	}

}



