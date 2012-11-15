package birdProgram;

//import java.util.List;
import java.util.Vector;

public class Controller {

	private BirdFavorites favs;
	private Birds birds;
	private BirdSearchResults results;
	
	public Controller(){
		favs = new BirdFavorites();
		birds = new Birds();
		results = new BirdSearchResults();
	}
	
	//public List<Bird> getLastSearch(){
	//	return results.getLast();
	//}
	public Vector<BirdLocation> getPossibleLocations(){
		Vector<BirdLocation> locations = new Vector<BirdLocation>();
		locations.add(new BirdLocation("WA"));
		locations.add(new BirdLocation("CA"));
		locations.add(new BirdLocation("ME"));
		locations.add(new BirdLocation("OR"));
		locations.add(new BirdLocation("MT"));
		return locations;
	}
	
	public Vector<BirdColor> getPossibleColors(){
		Vector<BirdColor> colors = new Vector<BirdColor>();
		return colors;
	}
	
	public Vector<BirdSize> getPossibleSizes(){
		Vector<BirdSize> sizes = new Vector<BirdSize>();
		sizes.add(new BirdSize("Very Small"));
		sizes.add(new BirdSize("Small"));
		sizes.add(new BirdSize("Medium"));
		sizes.add(new BirdSize("Large"));
		sizes.add(new BirdSize("Very Large"));		
		return sizes;
	}
}
