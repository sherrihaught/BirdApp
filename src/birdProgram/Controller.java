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
	
	//public List<Bird> getFavorites(){
	//	return favs.getBirds();
	//}
	
	public Vector<BirdLocation> getPossibleLocations(){
		Vector<BirdLocation> locations = new Vector<BirdLocation>();
		locations.add(new BirdLocation("Any"));
		locations.add(new BirdLocation("AL"));
		locations.add(new BirdLocation("AK"));
		locations.add(new BirdLocation("AZ"));
		locations.add(new BirdLocation("AR"));
		locations.add(new BirdLocation("CA"));
		locations.add(new BirdLocation("CO"));
		locations.add(new BirdLocation("CT"));
		locations.add(new BirdLocation("DE"));
		locations.add(new BirdLocation("DC"));
		locations.add(new BirdLocation("FL"));
		locations.add(new BirdLocation("GA"));
		locations.add(new BirdLocation("HI"));
		locations.add(new BirdLocation("ID"));
		locations.add(new BirdLocation("IL"));
		locations.add(new BirdLocation("IN"));
		locations.add(new BirdLocation("IA"));
		locations.add(new BirdLocation("KS"));
		locations.add(new BirdLocation("KY"));
		locations.add(new BirdLocation("LA"));
		locations.add(new BirdLocation("ME"));
		locations.add(new BirdLocation("MD"));
		locations.add(new BirdLocation("MA"));
		locations.add(new BirdLocation("MI"));
		locations.add(new BirdLocation("MN"));
		locations.add(new BirdLocation("MS"));
		locations.add(new BirdLocation("MO"));
		locations.add(new BirdLocation("MT"));
		locations.add(new BirdLocation("NE"));
		locations.add(new BirdLocation("NV"));
		locations.add(new BirdLocation("NH"));
		locations.add(new BirdLocation("NJ"));
		locations.add(new BirdLocation("NM"));
		locations.add(new BirdLocation("NY"));
		locations.add(new BirdLocation("NC"));
		locations.add(new BirdLocation("ND"));
		locations.add(new BirdLocation("OH"));
		locations.add(new BirdLocation("OK"));
		locations.add(new BirdLocation("OR"));
		locations.add(new BirdLocation("PA"));
		locations.add(new BirdLocation("RI"));
		locations.add(new BirdLocation("SC"));
		locations.add(new BirdLocation("SD"));
		locations.add(new BirdLocation("TN"));
		locations.add(new BirdLocation("TX"));
		locations.add(new BirdLocation("UT"));
		locations.add(new BirdLocation("VT"));
		locations.add(new BirdLocation("VA"));
		locations.add(new BirdLocation("WA"));
		locations.add(new BirdLocation("WV"));
		locations.add(new BirdLocation("WI"));
		locations.add(new BirdLocation("WY"));
		return locations;
	}
	
	public Vector<BirdColor> getPossibleColors(){
		Vector<BirdColor> colors = new Vector<BirdColor>();
		colors.add(new BirdColor("Any"));
		colors.add(new BirdColor("Red"));
		colors.add(new BirdColor("Orange"));
		colors.add(new BirdColor("Yellow"));
		colors.add(new BirdColor("Green"));
		colors.add(new BirdColor("Blue"));
		colors.add(new BirdColor("Purple"));
		colors.add(new BirdColor("Pink"));
		colors.add(new BirdColor("Black"));
		colors.add(new BirdColor("White"));
		colors.add(new BirdColor("Brown"));
		colors.add(new BirdColor("Grey"));
		return colors;
	}
	
	public Vector<BirdSize> getPossibleSizes(){
		Vector<BirdSize> sizes = new Vector<BirdSize>();
		sizes.add(new BirdSize("Any"));
		sizes.add(new BirdSize("Very Small"));
		sizes.add(new BirdSize("Small"));
		sizes.add(new BirdSize("Medium"));
		sizes.add(new BirdSize("Large"));
		sizes.add(new BirdSize("Very Large"));		
		return sizes;
	}
}
