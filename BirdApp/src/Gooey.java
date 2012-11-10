import javax.swing.JFrame;
import java.awt.*;
import java.util.*;

public class Gooey {
	private static JFrame frame;
	private static Canvas canvas;
	private static DataManager dm;
	
	public static void main(String args[]){
		dm = new DataManager("birds.txt");
		createScreen();
		displayBirds(dm.getBirds());
		frame.setVisible(true);
		//create buttons, etc.
	}
	
	public static void sort(String sortCategory){
		displayBirds(dm.getSortedBirds(sortCategory));
	}
	
	public static void search(String searchCategory, String searchValue){
		displayBirds(dm.getSubsetBirds(searchCategory, searchValue));
	}
	
	private static void createScreen(){
		Dimension currScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		currScreen.setSize(currScreen.getWidth() -20, currScreen.getHeight() - 75);
		frame = new JFrame();
		canvas = new Canvas();
		canvas.setPreferredSize(currScreen);
		frame.setTitle("A Bird Lover's Dream"); //App Title here
		frame.add(canvas, BorderLayout.NORTH);
		frame.pack();
	}
	
	private static void displayBirds(ArrayList<Bird> birds){
		//show list on canvas...
	}
}
