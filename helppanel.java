import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class helppanel extends JPanel{
	//Properties
	BufferedImage imgPoon = null;
	int PoonX = 380;
	int PoonY = 100;

	//Methods
	public void paintComponent(Graphics g){
		g.drawImage(imgPoon, PoonX, PoonY, null);
	}
	
	//Constructor
	public helppanel(){
		try{
			imgPoon = ImageIO.read(new File("poon.png"));
		}catch(Exception e){
			System.out.println("Unable to load image");
		}
	}

}
