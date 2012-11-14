package birdProgram;

import java.util.List;

public class ViewManager {

	private BirdFavorites favs;
	private Birds birds;
	private BirdSearchResults results;
	
	public ViewManager(){
		favs = new BirdFavorites();
		birds = new Birds();
		results = new BirdSearchResults();
	}
	
	public List<Bird> getSearchResults(BirdSearch current){
		return results.getSearchResults(current);
	}
}
