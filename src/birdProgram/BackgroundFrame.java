package birdProgram;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class BackgroundFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackgroundFrame frame = new BackgroundFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BackgroundFrame() {		
		setResizable(false);
		Dimension currScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)currScreen.getWidth() -10, (int)currScreen.getHeight() - 50);
		setLocation(5, 5);
		
		JTabbedPane tabBackground = new JTabbedPane();
		tabBackground.setFont(new Font("Calibri", Font.BOLD, (int)currScreen.getWidth()/50));
		
		SearchPane searchPane = new SearchPane(currScreen);		
		tabBackground.addTab("   Search   ", searchPane);
		
		ResultsPane resultsPane = new ResultsPane(currScreen);
		tabBackground.addTab("   Search Results   ", resultsPane);
		
		BirdPane birdPane = new BirdPane(currScreen);
		tabBackground.addTab("   Bird   ", birdPane);
		
		FavoritesPane favoritesPane = new FavoritesPane(currScreen);
		tabBackground.addTab("   Favorites   ", favoritesPane);
		
		setContentPane(tabBackground);
	}
}
