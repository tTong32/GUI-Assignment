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
			// once forceCentr becomes too small, set the force rectangle to a minimum size
			forceRect.height = 1;
			forceRect.width = intTracerRadius;
			forceRect.y = 270;
		} else if (dblPeriod == 0 || dblForceCentr == 0){
			// if period or forceCentr are 0, hide the rectangle
			forceRect.height = 0;
			forceRect.width = 0;
		} else if (dblForceCentr > 10000){
			try{
				// Once dblForceCentr exceeds 10000, instead of increasing the size, increase the color
				intForceG = 180 - (int)(dblForceCentr/400);
				intForceB = 180 - (int)(dblForceCentr/400);
				forceColor = new Color(intForceR, intForceG, intForceB);
			} catch (IllegalArgumentException e){
				// however, RGB ranges from 0-255, therefore the darkness will increase once the range is exceeded
				intForceR = 255 - (int)(dblForceCentr*1.5/100000); // made such that the range 0-255 will never be exceeded
				intForceB = 0;
				intForceG = 0;
				forceColor = new Color(intForceR, intForceG, intForceB);
			}
			// Draw the rectangle with a minimum height of 50
			forceRect.width = intTracerRadius;
			forceRect.height = 50;
			forceRect.y = (245);
		} else {
			// if Centripetal force is between 200 and 10000, increase the size of the force indicator rectangle
			forceRect.width = intTracerRadius;
			forceRect.height = (int)dblForceCentr/200;
			forceRect.y = (int)(270 - dblForceCentr/400);
		}

		// Draw out the UI
		g.setColor(greyColor);
		g.fillRect(0, 0, 400, 540);
		
		g.setColor(Color.WHITE);
		g.fillRect(400,0,560,540);
		
		// Draw the tracer indicator as a circle
		g.setColor(Color.RED);
		// Tracer must be created such that the middle of the tracer line is positioned on the middle of the mass
		g.fillOval(690 - intTracerRadius, 270 - intTracerRadius, intTracerDiameter, intTracerDiameter);
		
		// White out the middle of the circle
		g.setColor(Color.WHITE);
		// The larger the mass, the larger larger the circle indicator
		g.fillOval(690 - intTracerRadius + intTracerWidth, 270 - intTracerRadius + intTracerWidth, intTracerDiameter - intTracerWidth*2, intTracerDiameter - intTracerWidth*2);

		// Draw out the force rectangle using the calculated force color
		g.setColor(forceColor);
		g2d.fill(rForceRect);

		// Draw the mass, with size based on it's mass. Adjust its position accordingly such that it won't be shifted off center
		g.setColor(Color.RED);
		g.fillOval(intPosX - (intMass / 2), intPosY - (intMass / 2), intMass, intMass);
		
		// if period = 0, then the image should be frozen, therefore the rotation should only occur if period != 0
		if (dblPeriod != 0){
			// 1 revolution occurs every 360 degrees
			dblDegrees += 360/(48*dblPeriod);

			// The mass starts on the right side of the circle @ 0 degrees, where cos0 = 1 and sin0 = 0
			// Therefore, the movement of the mass can be graphically shown through cos and sin equations
			intPosY = (int)((dblRadius * 5)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
			intPosX = (int)((dblRadius * 5)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);

			// AffineTransform - seems to work backwards
			// move the rectagnle back towards the original point, except now it's rotated
			t.translate(690, 270);
			//rotate the rectangle however many degrees
			t.rotate(Math.toRadians(360/(48*dblPeriod)));
			// move the rectangle towards origin, or (0,0)
			t.translate(-690, -270);

			// Draw the rotated rectangle
			rForceRect = t.createTransformedShape(forceRect);
		} else if (dblPeriod == 0){
			// Draw the new "hidden" rectangle
			rForceRect = t.createTransformedShape(forceRect);
		}
	}

}



