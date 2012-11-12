

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class BirdAppSherri extends JPanel
{
	BufferedImage image;
	
	
	public BirdAppSherri(BufferedImage image)
	{
		this.image = image;
	}	
	
	
	public static void main(String args[]) throws IOException
	{
		JFrame frame = new JFrame("Bird App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String penguinsPic = "pics/Penguins.jpg";
		
		BufferedImage image = ImageIO.read(new File(penguinsPic));
		BirdAppSherri contentPane = new BirdAppSherri(image);
		contentPane.setOpaque(true);
		contentPane.setLayout(new BorderLayout());
		
		
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		
	}
}
