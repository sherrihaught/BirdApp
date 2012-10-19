import javax.swing.JFrame;
import java.awt.*;

public class BirdApp{
	public JFrame background;
	
	public BirdApp(){
	}
	
	public static void main(String args[]){
		BirdApp b = new BirdApp();
		Canvas canvas = b.setBackground();
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
