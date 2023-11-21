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
	
	int intChangeX = 690;
	int intChangeY = 270;
	
	double dblMass;
	double dblVelocity;
	double dblPeriod;
	double dblRadius;
	//Methods
	public void paintComponent(Graphics g){
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960,540);
		
		g.setColor(Color.RED);
		g.fillOval(intPosX, intPosY, 20, 20);
		
		if(intPosX < intChangeX){
			intAccelX = accelChange;
		}
		if(intPosX >= intChangeX){
			intAccelX = -accelChange;
		}
		if (intPosY <= intChangeY){
			intAccelY = accelChange;
			System.out.println("Going down");
		}
		if (intPosY >= intChangeY){
			intAccelY = -accelChange;
			System.out.println("Going up");
		}
		
		intVeloX += intAccelX;
		intVeloY += intAccelY;
		intPosX += intVeloX;
		//intPosY += intVeloY;
		
		System.out.println(intVeloX);
		System.out.println(intVeloY);
	}
	//Constructor
}



