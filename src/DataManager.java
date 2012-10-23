import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataManager {
	private ArrayList<Bird> birds;
	private ArrayList<Bird> birdSearchSubset;

	public DataManager(String fileName) throws FileNotFoundException{
		birds = new ArrayList<Bird>();
		addBirds(fileName);
	}
	
	public ArrayList<Bird> getBirds(){
		return birds;
	}
	
	public ArrayList<Bird> getReverseOrder(){
		ArrayList<Bird> reverse = birds;
		Collections.reverse(reverse);
		return reverse;
	}
	
	public ArrayList<Bird> getSortedByName(){
		ArrayList<Bird> sorted = birds;
		Collections.sort(sorted,new CompareName());
		return sorted;
	}
	
	public ArrayList<Bird> getSortedBySize(){
		ArrayList<Bird> sorted = birds;
		Collections.sort(sorted,new CompareSize());
		return sorted;
	}
	
	public ArrayList<Bird> getSortedByColor(){
		ArrayList<Bird> sorted = birds;
		Collections.sort(sorted,new CompareColor());
		return sorted;
	}
	
	public ArrayList<Bird> getSortedByFamily(){
		ArrayList<Bird> sorted = birds;
		Collections.sort(sorted,new CompareFamily());
		return sorted;
	}
	
	public ArrayList<Bird> getSortedByLocation(){
		ArrayList<Bird> sorted = birds;
		Collections.sort(sorted,new CompareLocation());
		return sorted;
	}
	
	private ArrayList<Bird> getBirdsByColor(String color){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birdSearchSubset.size();i++){
			if(birdSearchSubset.get(i).getColors().contains(color))
				subset.add(birdSearchSubset.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByFamily(String family){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birdSearchSubset.size();i++){
			if(birdSearchSubset.get(i).getFamilies().contains(family))
				subset.add(birdSearchSubset.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByLocation(String location){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birdSearchSubset.size();i++){
			if(birdSearchSubset.get(i).getLocations().contains(location))
				subset.add(birdSearchSubset.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByName(String name){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birdSearchSubset.size();i++){
			if(birdSearchSubset.get(i).getName().matches(name))
				subset.add(birdSearchSubset.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsBySize(String size){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birdSearchSubset.size();i++){
			if(birdSearchSubset.get(i).getSize().matches(size))
				subset.add(birdSearchSubset.get(i));
		}
		return subset;
	}
	
	/**
	 * Search through birds by categories, any blank categories will be ignored. 
	 * @param searchName Search by name, done with regular expression and can be a partial name
	 * @param searchFamily Search by family, full family names only
	 * @param searchColor Search by color, full color names only
	 * @param searchSize Search by size, full sizes only
	 * @param searchLocation Seach by location, full locations only
	 * @return An ArrayList of Bird objects that is 
	 */
	public ArrayList<Bird> getSubsetBirds(String searchName, String searchFamily, String searchColor, 
		String searchSize, String searchLocation){
		birdSearchSubset = birds;
		
		if (!searchLocation.equals("")){
			birdSearchSubset = getBirdsByLocation(searchLocation);
		}
		if (!searchFamily.equals("")){
			birdSearchSubset = getBirdsByFamily(searchFamily);
		}
		if (!searchColor.equals("")){
			birdSearchSubset = getBirdsByColor(searchColor);
		}
		if (!searchName.equals("")){
			birdSearchSubset = getBirdsByName(searchName);
		}
		if (!searchSize.equals("")){
			birdSearchSubset = getBirdsBySize(searchSize);
		}
		return birdSearchSubset;
	}
	
	/**
	 * Returns the ArrayList of Birds that was returned via the function getSubsetBirds.
	 * @return Searched ArrayList of Bird objects.
	 */
	public ArrayList<Bird> getSearchSubset(){
		return birdSearchSubset;
	}
	
	public void addBirds(String fileName) throws FileNotFoundException{
		//read from file 6 lines at a time, creating new Birds and adding them to birds
		Scanner inputFile = new Scanner(new File(fileName));
		while (inputFile.hasNextLine())
		{
			birds.add(new Bird(
				inputFile.nextLine(),													//Name
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 	//Families
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 	//Colors
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 	//Locations
				inputFile.nextLine(), 													//Size
				inputFile.nextLine()													//Description
				)
			);
			//Alphabetically organizes the Locations, Colors, and Families
			Collections.sort(birds.get(birds.size()-1).getLocations(), new CompareString());
			Collections.sort(birds.get(birds.size()-1).getColors(), new CompareString());
			Collections.sort(birds.get(birds.size()-1).getFamilies(), new CompareString());
		}
		inputFile.close();
	}
}

class CompareName implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getName().compareTo(two.getName());
	}
}

class CompareColor implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getColors().get(0).compareTo(two.getColors().get(0));
	}
}

class CompareFamily implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getFamilies().get(0).compareTo(two.getFamilies().get(0));
	}
}

class CompareLocation implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getLocations().get(0).compareTo(two.getLocations().get(0));
	}
}

class CompareString implements Comparator<String>{

	@Override
	public int compare(String one, String two) {
		return one.compareTo(two);
	}
}

class CompareSize implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		if(getSizeNumber(one.getSize())<getSizeNumber(two.getSize()))
			return -1;
		else if(getSizeNumber(one.getSize())==getSizeNumber(two.getSize()))
			return 0;
		else
			return 1;
	}
	
	private int getSizeNumber(String size){
		if(size.equals("Very Small"))
			return 1;
		else if(size.equals("Small"))
			return 2;
		else if(size.equals("Medium"))
			return 3;
		else if(size.equals("Large"))
			return 4;
		else
			return 5;
	}
}
