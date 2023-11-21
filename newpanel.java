import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class newpanel extends JPanel{
	//Properties
	int intPosX = 740;
	int intPosY = 220;
	int intVeloX = 0;
	int intVeloY = 10;
	int intAccel;
	int intAccelX = 2;
	int intAccelY = -2;
	int accelChange = 2;
	
	int intMaxX = 740;
	int intMinX = 640;
	int intMaxY = 320;
	int intMinY = 220;
	
	double dblMass;
	double dblVelocity;
	double dblRadius;
	double dblPeriod;
	
	//Methods
	public void paintComponent(Graphics g){
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960,540);
		
		g.setColor(Color.RED);
		g.fillOval(intPosX, intPosY, 20, 20);
		
		if(intPosX <= intMinX){
			intAccelX = accelChange;
		}
		if(intPosX >= intMaxX){
			intAccelX = -accelChange;
		}
		if (intPosY <= intMinY){
			intAccelY = accelChange;
			System.out.println("Going down");
		}
		if (intPosY >= intMaxY){
			intAccelY = -accelChange;
			System.out.println("Going up");
		}
		
		intVeloX += intAccelX;
		intVeloY += intAccelY;
		intPosX += intVeloX;
		intPosY += intVeloY;
		
		System.out.println(intVeloX);
		System.out.println(intVeloY);
	}
	//Constructor
}



