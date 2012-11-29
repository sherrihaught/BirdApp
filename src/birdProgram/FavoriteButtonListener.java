package birdProgram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class FavoriteButtonListener implements ActionListener{
    private Bird bird;
    private boolean favorite;
    private Controller c;
    private JButton favButton;
    
    public FavoriteButtonListener(JButton favButton, Bird bird, Controller c){
        this.favButton = favButton;
        this.c = c;
    	this.bird = bird;
        displayIcon(favorite = c.isFavorite(bird));
    }
    
    public boolean getFavoriteStatus(){
    	return favorite;
    }

	public void actionPerformed(ActionEvent e) {
        displayIcon(favorite = !favorite);
        c.setFavorite(bird, favorite);
        c.updateFavorites();
        c.updateBird(false);
        c.updateResults(false);
	}
	
	private void displayIcon(boolean favorite){
        if(getFavoriteStatus()){
        	favButton.setIcon(new ImageIcon("FavStarSel.jpg"));
        }else{
        	favButton.setIcon(new ImageIcon("FavStar.jpg"));
        }
	}
}
