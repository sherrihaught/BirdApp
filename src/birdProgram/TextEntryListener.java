package birdProgram;

import javax.swing.JTextField;

public class TextEntryListener {

	private JTextField TextEntry;
	
	public TextEntryListener(JTextField TextEntry){
		this.TextEntry = TextEntry;
		setDefault();
	}
	
	public String getTextEntered(){
		return TextEntry.getText();
	}
	
	public void setDefault(){
		TextEntry.setText("");
	}
}
