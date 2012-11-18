package birdProgram;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BirdMain {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c = new Controller();
					BackgroundFrame frame = new BackgroundFrame(c);
                    BufferedImage image = null;
//                    try{
//                        image = ImageIO.read(frame.getClass().getResource("birdsill.jpg"));
//                        frame.setIconImage(image);
//                    }catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    frame.setTitle("Team Four's Bird Locator");
					frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
