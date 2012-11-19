package birdProgram;

import java.util.List;

public class BirdSearch{
	private List<Bird> results;
	
	/**
	 * Searches through all of the birds in the list passed into it.
	 * @param birdList The List of birds
	 * @param name The name to search by, checks for partial equality
	 * @param color The color to search for
	 * @param family The family to search for
	 * @param location The location to search for
	 * @param size The size to search for
	 * @param timeActive The time active to search for
	 * @param description The description to search for, checks for partial equality
	 */
	public BirdSearch(List<Bird> birdList, BirdName name, BirdColor color, BirdFamily family, BirdLocation location, 
						BirdSize size, BirdTimeActive timeActive){
		searchBirds(birdList, name, color, family, location, size, timeActive);
	}
	
	private void searchBirds(List<Bird> birdList, BirdName name, BirdColor color, BirdFamily family, BirdLocation location, BirdSize size, BirdTimeActive timeActive){
		// results = new ArrayList<Bird>();
		results = birdList; // initialization
		if(name != null)
			getBirdsByName(name);
		if(color != null)
			getBirdsByColor(color);
		if(family != null)
			getBirdsByFamily(family);
		if(location != null)
			getBirdsByLocation(location);
		if(size != null)
			getBirdsByTimeActive(timeActive);
		if(timeActive != null)
			getBirdsBySize(size);
	}
	
	public List<Bird> getBirds(){
		return results;
	}
	
	private void getBirdsByName(BirdName name){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getName().get().equals(name.get()))
				results.remove(results.get(i));
		}
	}
	
	private void getBirdsByTimeActive(BirdTimeActive timeActive){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getTimeActive().contains(timeActive))
				results.remove(results.get(i));
		}
	}
	
	private void getBirdsByColor(BirdColor color){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getColors().contains(color))
				results.remove(results.get(i));
		}
	}
	
	private void getBirdsBySize(BirdSize size){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getSize().equals(size))
				results.remove(results.get(i));
		}
	}
	
	private void getBirdsByFamily(BirdFamily family){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getFamilies().contains(family))
				results.remove(results.get(i));
		}
	}
	
	private void getBirdsByLocation(BirdLocation location){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getLocations().contains(location))
				results.remove(results.get(i));
		}
	}
	
}
