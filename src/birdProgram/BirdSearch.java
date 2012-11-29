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
			getBirdsBySize(size);
		if(timeActive != null)
			getBirdsByTimeActive(timeActive);
	}
	
	public List<Bird> getBirds(){
		return results;
	}
	
	private void getBirdsByName(BirdName name){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getName().get().toLowerCase().contains(name.get().toLowerCase())){
				results.remove(i);
				i--;
			}
		}
	}
	
	private void getBirdsByTimeActive(BirdTimeActive timeActive){
		for(int i=0;i<results.size();i++){
			List<BirdTimeActive> times = results.get(i).getTimeActive();
			boolean found = false;
			for(BirdTimeActive time : times){
				if(time.equals(timeActive)){
					found = true;
					break;
				}
			}
			if(!found){
				results.remove(i);
				i--;
			}
		}
	}
	
	private void getBirdsByColor(BirdColor color){
		for(int i=0;i<results.size();i++){
			List<BirdColor> colors = results.get(i).getColors();
			boolean found = false;
			for(BirdColor col : colors){
				if(col.equals(color)){
					found = true;
					break;
				}
			}
			if(!found){
				results.remove(i);
				i--;
			}
		}
	}
	
	private void getBirdsBySize(BirdSize size){
		for(int i=0;i<results.size();i++){
			if(!results.get(i).getSize().equals(size)){
				results.remove(i);
				i--;
			}
		}
	}
	
	private void getBirdsByFamily(BirdFamily family){
		for(int i=0;i<results.size();i++){
			List<BirdFamily> fams = results.get(i).getFamilies();
			boolean found = false;
			for(BirdFamily fam : fams){
				if(fam.get().toLowerCase().contains(family.get().toLowerCase())){
					found = true;
					break;
				}
			}
			if(!found){
				results.remove(i);
				i--;
			}
		}
	}
	
	private void getBirdsByLocation(BirdLocation location){
		for(int i=0;i<results.size();i++){
			List<BirdLocation> locs = results.get(i).getLocations();
			boolean found = false;
			for(BirdLocation loc : locs){
				if(loc.equals(location)){
					found = true;
					break;
				}
			}
			if(!found){
				results.remove(i);
				i--;
			}
		}
	}
	
}
