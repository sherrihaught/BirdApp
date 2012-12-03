// uncomment to run image test from database
// remember to comment BirdMain.java

/*package birdProgram;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.*;

public class addBirdsTest
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Birds test = new Birds("birds.txt");
        List<Bird> birds = test.getBirds();
        
        // test to see if images display from bird list
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(birds.get(0).getBirdImage())));
        frame.pack();
        frame.setVisible(true);
	}
}*/
