import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class creditpanel extends JPanel{
	
	BufferedImage imgSTA = null;
	int posX = 350;
	int posY = 0;
	
	public void paintComponent(Graphics g){
		g.drawImage(imgSTA, posX, posY, null);
	}
	
	public creditpanel(){
		try{
			imgSTA = ImageIO.read(new File("stalogo.png"));
		}catch(Exception e){
			System.out.println("Unable to find image");
		}
	}

}
