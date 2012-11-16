package birdProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

public class RadioListener implements MouseListener{
	private JRadioButton radioButton;
	private boolean selected;
	
	public RadioListener(JRadioButton radioButton){
		this.radioButton = radioButton;
		selected = radioButton.isSelected();
	}

	public void mouseClicked(MouseEvent e) {
		selected = radioButton.isSelected();
	}

	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {	
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	public boolean isSelected(){
		return selected;
	}
	
	public void setSelected(boolean b){
		radioButton.setSelected(b);
		selected = isSelected();
	}
}
