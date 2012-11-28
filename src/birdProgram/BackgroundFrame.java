package birdProgram;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class BackgroundFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private SearchPane searchPane;
	private ResultsPane resultsPane;
	private BirdPane birdPane;
	private FavoritesPane favoritesPane;

	public BackgroundFrame(Controller c) {		
		setResizable(false);
		Dimension currScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int)currScreen.getWidth() -10, (int)currScreen.getHeight() - 50);
        setLocationRelativeTo(null);
        setLocation(5, 5);
		
		JTabbedPane tabBackground = new JTabbedPane();
		tabBackground.setFont(new Font("Calibri", Font.BOLD, (int)currScreen.getWidth()/50));
		
		searchPane = new SearchPane(currScreen, c);		
		tabBackground.addTab("   Search   ", searchPane);
		
		resultsPane = new ResultsPane(currScreen, c);
		JScrollPane resultsScrollView = new JScrollPane(resultsPane);
		tabBackground.addTab("   Search Results   ", resultsScrollView);
		
		birdPane = new BirdPane(currScreen, c.getSelectedBird(), c);
		birdPane.setBackground(new Color(139, 123, 139));
        JScrollPane birdScrollView = new JScrollPane(birdPane);
		tabBackground.addTab("   Bird   ", birdScrollView);
		
		favoritesPane = new FavoritesPane(currScreen);
		tabBackground.addTab("   Favorites   ", favoritesPane);
		
		setContentPane(tabBackground);
	}
	
	public SearchPane getSearchPane(){
		return searchPane;
	}

	public ResultsPane getResultsPane(){
		return resultsPane;
	}
	
	public BirdPane getBirdPane(){
		return birdPane;
	}
	
	public FavoritesPane getFavoritesPane(){
		return favoritesPane;
	}
	
	public void switchPane(int index){
		((JTabbedPane) getContentPane()).setSelectedIndex(index);
	}
}
