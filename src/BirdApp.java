import javax.swing.JFrame;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BirdApp{
	public JFrame background;
	
	public BirdApp(){
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		BirdApp b = new BirdApp();
		Canvas canvas = b.setBackground();
		
		
		// DataManager tested by printing to output using Bird's toString-- comment to not run.
		DataManager test = new DataManager("birds.txt");
		ArrayList<Bird> testList = test.getBirds();
		for (int i = 0; i < testList.size(); i++){
			System.out.println(testList.get(i).toString());
		}
	}
	
	public Canvas setBackground(){
		Dimension currScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		currScreen.setSize(currScreen.getWidth() -20, currScreen.getHeight() - 75);
		JFrame frame = new JFrame();
		Canvas c = new Canvas();
		c.setPreferredSize(currScreen);
		frame.setTitle("A Bird Lover's Dream");
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		return c;
	}
}
