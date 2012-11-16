package birdProgram;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class TextEntryListener implements KeyListener{
	private String TextEntered;
	private JTextField TextEntry;
	
	public TextEntryListener(JTextField TextEntry){
		this.TextEntry = TextEntry;
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		TextEntered = TextEntry.getText();
	}
	
	public String getTextEntered(){
		return TextEntered;
	}
	
	public void setDefault(){
		TextEntry.setText("");
		TextEntered = TextEntry.getText();
	}
}
