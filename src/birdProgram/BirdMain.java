package birdProgram;

import java.awt.EventQueue;

public class BirdMain {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c = new Controller();
					BackgroundFrame frame = new BackgroundFrame(c);
					frame.setVisible(true);
					wait(4000);
					frame.getSearchPane().resetStates();
					frame.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
