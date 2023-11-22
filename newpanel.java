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
	
	double dblDegrees = 0;
	
	double dblMass;
	double dblVelocity;
	double dblPeriod = 2;
	double dblRadius = 200;
	//Methods
	public void paintComponent(Graphics g){
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960,540);
		
		g.setColor(Color.RED);
		g.fillOval(intPosX, intPosY, 20, 20);
		
		dblDegrees += 360/(48*dblPeriod);
		
		intPosY = (int)((dblRadius)*(Math.sin(Math.toRadians(dblDegrees)))+ 270);
		intPosX = (int)((dblRadius)*(Math.cos(Math.toRadians(dblDegrees)))+ 690);
		
	}
	//Constructor
}



