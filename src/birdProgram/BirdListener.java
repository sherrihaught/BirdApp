package birdProgram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirdListener implements ActionListener{
	private Controller c;
	private Bird b;
	
	public BirdListener(Bird b, Controller c){
		this.b = b;
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent e){
		c.setBird(b);
		c.updateBird(true);
	}
}
