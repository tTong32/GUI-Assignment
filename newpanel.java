import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class newpanel extends JPanel{
	
	//Properties

	// x and y position of ball
	int intPosX = 740;
	int intPosY = 270;
	
	// how many degrees the ball has rotated off the horizontal
	double dblDegrees = 0;
	
	// variables that determine the overall projection
	double dblMass = 300; // in kg
	double dblPeriod = 8; // seconds it takes for a revolution
	double dblRadius = 25; // every 5 pixels is 1 m
	double dblForceCentr; // in pi N

	// Setting up the force indicator
	Rectangle forceRect = new Rectangle(690, 265, 0, 10);
	// Affine transform is used such that only the rectangle can rotate according to an anchor point
	// Using g2d.rotate also rotates other JComponents and thus does not work
	AffineTransform t = new AffineTransform();
	Shape rForceRect = t.createTransformedShape(forceRect);
	
	// Setting up mass and radius as an integer in order for easier graphical conversion
	int intMass = (int)dblMass / 10;
	int intRadius = (int)dblRadius * 5;

	// The "tracer", or the projection of the overall movement of the "mass"
	int intTracerDiameter = intRadius*2 + intMass/4;
	int intTracerRadius = intRadius + intMass/8;
	int intTracerWidth = intMass / 4;

	// set a new color for left side of screen
	Color greyColor = new Color(247, 242, 242);

	// Default color settings for the force rectangle
	int intForceR = 255;
	int intForceG = 180;
	int intForceB = 180;
	Color forceColor = new Color(intForceR, intForceG, intForceB);

	//Methods
	public void paintComponent(Graphics g){
		
		// Every repaint(), update the mass and radius, even if the user has not changed it
		intMass = (int)dblMass / 10;
		intRadius = (int)dblRadius * 5;

		// The tracer is used to "map" out the movement of the ball - update every repaint()
		intTracerDiameter = intRadius*2 + intMass/4;
		intTracerRadius = intRadius + intMass/8;
		intTracerWidth = intMass / 4;

		// Since centripetal force is divided by period, a math error occurs if period = 0
		if (dblPeriod == 0){
			dblForceCentr = 0;
		} else {
			// otherwise, the use the derived equation for centripetal force using mass, radius and period
			dblForceCentr = (4*dblMass*dblRadius) / (dblPeriod*dblPeriod);
		}
		
		// Graphics 2D is required in order to rotate the centripetal foce rectangle
		Graphics2D g2d = (Graphics2D)g;

		// set the force color back to default settings
		intForceR = 255;
		intForceB = 180;
		intForceG = 180;

		// and if else if chain setting the size and color of the force rectangle indicator
		if (dblForceCentr > 0 && dblForceCentr < 200 && dblPeriod != 0){
			forceRect.height = 1;
			forceRect.width = intTracerRadius;
			forceRect.y = 270;
		} else if (dblPeriod == 0 || dblForceCentr == 0){
			forceRect.height = 0;
			forceRect.width = 0;
		} else if (dblForceCentr > 10000){
			try{
				intForceG = 180 - (int)(dblForceCentr/400);
				intForceB = 180 - (int)(dblForceCentr/400);
				forceColor = new Color(intForceR, intForceG, intForceB);
			} catch (IllegalArgumentException e){
				intForceR = 255 - (int)(dblForceCentr*1.5/100000);
				intForceB = 0;
				intForceG = 0;
				forceColor = new Color(intForceR, intForceG, intForceB);
			}
			forceRect.width = intTracerRadius;
			forceRect.height = 50;
			forceRect.y = (245);
		} else {
			forceRect.width = intTracerRadius;
			forceRect.height = (int)dblForceCentr/200;
			forceRect.y = (int)(270 - dblForceCentr/400);
		}

		g.setColor(greyColor);
		g.fillRect(0, 0, 400, 540);
		
		g.setColor(Color.WHITE);
		g.fillRect(400,0,560,540);
		
		g.setColor(Color.RED);
		g.fillOval(690 - intTracerRadius, 270 - intTracerRadius, intTracerDiameter, intTracerDiameter);
		
		g.setColor(Color.WHITE);
		g.fillOval(690 - intTracerRadius + intTracerWidth, 270 - intTracerRadius + intTracerWidth, intTracerDiameter - intTracerWidth*2, intTracerDiameter - intTracerWidth*2);

		g.setColor(forceColor);
		g2d.fill(rForceRect);

		g.setColor(Color.RED);
		g.fillOval(intPosX - (intMass / 2), intPosY - (intMass / 2), intMass, intMass);
		
		if (dblPeriod != 0){
			dblDegrees += 360/(48*dblPeriod);
			intPosY = (int)((dblRadius * 5)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
			intPosX = (int)((dblRadius * 5)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);
			t.translate(690, 270);
			t.rotate(Math.toRadians(360/(48*dblPeriod)));
			t.translate(-690, -270);
			rForceRect = t.createTransformedShape(forceRect);
		} 
		

		//System.out.println("Centripedal force is: " + dblForceCentr);
	}

}



