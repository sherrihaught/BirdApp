package birdProgram;

import java.awt.EventQueue;

public class BirdMain {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c = new Controller();
					BackgroundFrame frame = new BackgroundFrame(c);
					c.setFrame(frame);
//                    BufferedImage image = null;
//                    try{
//                        image = ImageIO.read(frame.getClass().getResource("birdsill.jpg"));
//                        frame.setIconImage(image);
//                    }catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    frame.setTitle("Team Four's Bird Locator");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
