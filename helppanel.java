import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class helppanel extends JPanel{
	//Properties
	BufferedImage imgHelp1 = null;
	BufferedImage imgHelp2 = null;
	BufferedImage imgHelp3 = null;
	BufferedImage imgHelp4 = null;
	BufferedImage imgHelp5 = null;

	int intHelpPage = 1;

	//Methods
	public void paintComponent(Graphics g){

		g.setColor(Color.WHITE);
		g.fillRect(0,0,980,540);

		if (intHelpPage < 1){
			intHelpPage = 1;
		} else if (intHelpPage > 5){
			intHelpPage = 5;
		}
		if (intHelpPage == 1){
			g.drawImage(imgHelp1, 0, 0, null);
		} else if (intHelpPage == 2){
			g.drawImage(imgHelp2, 0, 0, null);
		} else if (intHelpPage == 3){
			g.drawImage(imgHelp3, 0, 0, null);
		} else if (intHelpPage == 4){
			g.drawImage(imgHelp4, 0, 0, null);
		} else if (intHelpPage == 5){
			g.drawImage(imgHelp5, 0, 0, null);
		}
	}
	
	//Constructor
	public helppanel(){
		InputStream imageclass1 = null;
		imageclass1 = this.getClass().getResourceAsStream("helpScreen1.png");

		InputStream imageclass2 = null;
		imageclass2 = this.getClass().getResourceAsStream("helpScreen2.png");

		InputStream imageclass3 = null;
		imageclass3 = this.getClass().getResourceAsStream("helpScreen3.png");

		InputStream imageclass4 = null;
		imageclass4 = this.getClass().getResourceAsStream("helpScreen4.png");

		InputStream imageclass5 = null;
		imageclass5 = this.getClass().getResourceAsStream("helpScreen5png");
			
		if (imageclass1 == null || imageclass2 == null || imageclass3 == null || imageclass4 == null || imageclass5 == null ){
		} else {
			try{
				imgHelp1 = ImageIO.read(new File("helpScreen1.png"));
				imgHelp2 = ImageIO.read(new File("helpScreen2.png"));
				imgHelp3 = ImageIO.read(new File("helpScreen3.png"));
				imgHelp4 = ImageIO.read(new File("helpScreen4.png"));
				imgHelp5 = ImageIO.read(new File("helpScreen5.png"));
			}catch(Exception e){
				System.out.println("Unable to load image");
			}
		}
		if (imgHelp1 == null){
			try{
				imgHelp1 = ImageIO.read(new File("helpScreen1.png"));
			} catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
		if (imgHelp2 == null){
			try{
				imgHelp2 = ImageIO.read(new File("helpScreen2.png"));
			} catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
		if (imgHelp3 == null){
			try{
				imgHelp3 = ImageIO.read(new File("helpScreen3.png"));
			} catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
		if (imgHelp4 == null){
			try{
				imgHelp4 = ImageIO.read(new File("helpScreen4.png"));
			} catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
		if (imgHelp5 == null){
			try{
				imgHelp5 = ImageIO.read(new File("helpScreen5.png"));
			} catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
		
	}

}
