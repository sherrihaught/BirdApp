package birdProgram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonActionListener implements ActionListener{

	private SearchPane pane;
	
	public ResetButtonActionListener(SearchPane pane){
		this.pane = pane;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		pane.resetStates();
		
	}

}
