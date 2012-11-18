package birdProgram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class FavoriteButtonListener implements ActionListener{
    private Bird bird;
    private boolean favorite;
    private Controller c;
    private JButton favButton;
    
    public FavoriteButtonListener(JButton favButton, Bird bird, Controller c){
        this.favButton = favButton;
    	this.bird = bird;
        favorite = c.isFavorite(bird);
    }
    
    public boolean getFavoriteStatus(){
    	return favorite;
    }

	public void actionPerformed(ActionEvent e) {
        favorite = !favorite;
        if(getFavoriteStatus()){
        	favButton.setText("Favorite");
        }else{
        	favButton.setText("Not Favorite");
        }
        c.setFavorite(bird, favorite);		
	}
}
