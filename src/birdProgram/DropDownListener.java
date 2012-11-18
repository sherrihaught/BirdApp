package birdProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;

public class DropDownListener implements MouseListener{
	private BirdAttribute selected;
	private JComboBox dropDown;
	
	public DropDownListener(JComboBox dropDown){
		this.dropDown = dropDown;
	}

	public void mouseClicked(MouseEvent e){
		selected = (BirdAttribute)dropDown.getSelectedItem();
	}

	public void mouseEntered(MouseEvent e){	
	}

	public void mouseExited(MouseEvent e){
	}

	public void mousePressed(MouseEvent e){
	}

	public void mouseReleased(MouseEvent e){
	}

	public BirdAttribute getSelected(){
		if(selected.toString().equals("Any")){
			return null;
		}else{
			return selected;
		}
	}
	
	public void setDefault(){
		dropDown.setSelectedIndex(0);
		selected = (BirdAttribute)dropDown.getSelectedItem();
	}
}
