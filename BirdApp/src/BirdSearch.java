import java.util.ArrayList;
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
	public BirdSearch(List<Bird> birdList, BirdName name, BirdColor color, BirdFamily family, BirdLocation location, BirdSize size, BirdTimeMostActive timeActive, BirdDescription description){
		searchBirds(birdList, name, color, family, location, size, timeActive, description);
	}
	
	/**
	 * Takes an object that can be of any attribute of the bird and searches for it in all birds.
	 * @param birdList The list of birds to be searched.
	 * @param searchObject The object to be searched for, must be a BirdName, BirdColor, BirdFamily, BirdSize, BirdTimeMostActive, or BirdDescription object.
	 */
	public BirdSearch(List<Bird> birdList, Object searchObject){
		if(searchObject.getClass().equals(new BirdName().getClass())) //Name
			searchBirds(birdList, (BirdName)searchObject, new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchObject.getClass().equals(new BirdColor().getClass())) //Color
			searchBirds(birdList,  new BirdName(), (BirdColor)searchObject, new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchObject.getClass().equals(new BirdFamily().getClass())) //Family
			searchBirds(birdList,  new BirdName(), new BirdColor(), (BirdFamily)searchObject, new BirdLocation() , new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchObject.getClass().equals(new BirdLocation().getClass())) //Location
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), (BirdLocation)searchObject, new BirdSize(),  new BirdTimeMostActive(), new BirdDescription());
		else if(searchObject.getClass().equals(new BirdSize().getClass())) //Size
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), (BirdSize)searchObject, new BirdTimeMostActive(), new BirdDescription());
		else if(searchObject.getClass().equals(new BirdTimeMostActive().getClass())) //Time Active
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), (BirdTimeMostActive)searchObject, new BirdDescription());
		else if(searchObject.getClass().equals(new BirdDescription().getClass())) //Description
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(), (BirdDescription)searchObject);
		else
			System.out.println("searchObject class type not found.");
	}
	
	/**
	 * 
	 * @param birdList The list of birds to be searched.
	 * @param searchCategory The category to be searched. Only accepts: name, color, family, location, size, timeActive, or description.
	 * @param searchString The categories string to be checked for
	 */
	public BirdSearch(List<Bird> birdList, String searchCategory, String searchString){
		if(searchCategory.equals("name")) //Name
			searchBirds(birdList, new BirdName(searchString), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchCategory.equals("color")) //Color
			searchBirds(birdList,  new BirdName(), new BirdColor(searchString), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchCategory.equals("family")) //Family
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(searchString), new BirdLocation() , new BirdSize(), new BirdTimeMostActive(), new BirdDescription());
		else if(searchCategory.equals("location")) //Location
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(searchString), new BirdSize(),  new BirdTimeMostActive(), new BirdDescription());
		else if(searchCategory.equals("size")) //Size
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(searchString), new BirdTimeMostActive(), new BirdDescription());
		else if(searchCategory.equals("timeActive")) //Time Active
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(searchString), new BirdDescription());
		else if(searchCategory.equals("description")) //Description
			searchBirds(birdList,  new BirdName(), new BirdColor(), new BirdFamily(), new BirdLocation(), new BirdSize(), new BirdTimeMostActive(),  new BirdDescription(searchString));
		else
			System.out.println("searchString doens't match.");
	}
	
	private void searchBirds(List<Bird> birdList, BirdName name, BirdColor color, BirdFamily family, BirdLocation location, BirdSize size, BirdTimeMostActive timeActive, BirdDescription description){
		results = new ArrayList<Bird>();
		results = birdList;
		if(!name.equals(new BirdName()))
			results = getBirdsByName(name);
		if(!color.equals(new BirdColor()))
			results = getBirdsByColor(color);
		if(!family.equals(new BirdFamily()))
			results = getBirdsByFamily(family);
		if(!location.equals(new BirdLocation()))
			results = getBirdsByLocation(location);
		if(!timeActive.equals(new BirdTimeMostActive()))
			results = getBirdsByTimeActive(timeActive);
		if(!size.equals(new BirdSize()))
			results = getBirdsBySize(size);
		if(!description.equals(new BirdDescription()))
			results = getBirdsByDescription(description);
	}
	
	public List<Bird> getBirds(){
		return results;
	}
	
	private List<Bird> getBirdsByName(BirdName name){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getName().getMyName().indexOf(name.getMyName())>=0)
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private List<Bird> getBirdsByDescription(BirdDescription description){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getDescription().getMyDescription().indexOf(description.getMyDescription())>=0)
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByTimeActive(BirdTimeMostActive timeActive){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getTimeMostActive().contains(timeActive))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByColor(BirdColor color){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getColors().contains(color))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsBySize(BirdSize size){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getSize().equals(size))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByFamily(BirdFamily family){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getFamilies().contains(family))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByLocation(BirdLocation location){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getLocations().contains(location))
				subset.add(results.get(i));
		}
		return subset;
	}
	
}
