import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class helppanel extends JPanel{
	//Properties
	BufferedImage imgHelp = null;

	//Methods
	public void paintComponent(Graphics g){
		g.drawImage(imgHelp, 0, 0, null);
	}
	
	//Constructor
	public helppanel(){
		try{
			imgHelp = ImageIO.read(new File("helpScreen.png"));
		}catch(Exception e){
			System.out.println("Unable to load image");
		}
	}

}
