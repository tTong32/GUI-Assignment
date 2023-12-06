import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class creditpanel extends JPanel{
	//Properties for position of the image as well as the image of sta is put inside a variable
	BufferedImage imgSTA = null;
	int posX = 350;
	int posY = 0;
	
	public void paintComponent(Graphics g){
		//Drawing the stalogo at the position x at 350 and position y at 0
		g.drawImage(imgSTA, posX, posY, null);
	}
	
	public creditpanel(){
		InputStream imageclass = null;
		imageclass = this.getClass().getResourceAsStream("stalogo.png");
		if (imageclass == null){
		} else {
			try{
			//Initalizing the image to read from the folder
				imgSTA = ImageIO.read(new File("stalogo.png"));
			}catch(Exception e){
				System.out.println("Unable to find image from jar");
			}
		}
		if (imgSTA == null){
			try{
				imgSTA = ImageIO.read(new File("stalogo.png"));
			} catch (IOException e){
				System.out.println("Unable to load image");
			}
		}
	}

}
