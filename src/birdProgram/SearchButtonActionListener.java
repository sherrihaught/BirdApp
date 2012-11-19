package birdProgram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SearchButtonActionListener implements ActionListener {
	
	private SearchPane pane;
	private Controller c;
	
	public SearchButtonActionListener(SearchPane pane, Controller c){
		this.pane = pane;
		this.c = c;
	}
	
	public void actionPerformed(ActionEvent e){
		List<Object> list = pane.getStates();
		BirdName name = (BirdName)list.get(0);
		BirdFamily family = (BirdFamily)list.get(1);
		BirdLocation location = new BirdLocation((String)list.get(2));
		BirdColor color = new BirdColor((String)list.get(3));
		BirdSize size = new BirdSize((String)list.get(4));
		BirdTimeActive timeActive = ((BirdTimeActive)list.get(5));
		BirdSearch birdSearch = new BirdSearch(c.getBirds(), name, color, family, location, size, timeActive);
		c.addNewBirdSearch(birdSearch);
    }


}
