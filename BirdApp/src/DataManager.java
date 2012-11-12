import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DataManager {
	private List<Bird> birds;

	public DataManager(String fileName) throws FileNotFoundException{
		birds = new ArrayList<Bird>();
		addBirds(fileName);
	}
	
	public List<Bird> getBirds(){
		return birds;
	}
	
	/**Sorts the Bird objects by the specified sortCategory
	 * @param sortCategory string representing sort criteria
	 * @return a sorted ArrayList of Bird objects
	 */
	public List<Bird> getSortedBirds(String sortCategory){
		List<Bird> sorted = birds;
		if(sortCategory == "name"){
			sorted = getSortedByName(sorted);
		}else if(sortCategory == "family"){
			sorted = getSortedByFamily(sorted);
		}else if(sortCategory == "location"){
			sorted= getSortedByLocation(sorted);
		}else if(sortCategory == "color"){
			sorted = getSortedByColor(sorted);
		}else if(sortCategory == "size"){
			sorted = getSortedBySize(sorted);
		}else if(sortCategory == "timeActive"){
			sorted = getSortedByTimeActive(sorted);
		}
		return sorted;
	}
	
	private List<Bird> getSortedByName(List<Bird> sorted){
		Collections.sort(sorted,new CompareName());
		return sorted;
	}
	
	private List<Bird> getSortedByFamily(List<Bird> sorted){
		Collections.sort(sorted,new CompareFamily());
		return sorted;
	}
	
	private List<Bird> getSortedByLocation(List<Bird> sorted){
		Collections.sort(sorted,new CompareLocation());
		return sorted;
	}
	
	private List<Bird> getSortedByColor(List<Bird> sorted){
		Collections.sort(sorted,new CompareColor());
		return sorted;
	}
	
	private List<Bird> getSortedBySize(List<Bird> sorted){
		Collections.sort(sorted,new CompareSize());
		return sorted;
	}
	
	private List<Bird> getSortedByTimeActive(List<Bird> sorted){
		Collections.sort(sorted,new CompareTimeActive());
		return sorted;
	}
	
	public void addBirds(String fileName) throws FileNotFoundException{
		//read from file, creating new Birds and adding them to birds
		Scanner inputFile = new Scanner(new File(fileName));
		while (inputFile.hasNextLine()){
			BirdName name = new BirdName(inputFile.nextLine());
			
			String []families = inputFile.nextLine().split("`");
			ArrayList<BirdFamily> familiesList = new ArrayList<BirdFamily>();
			for(int i=0; i<families.length; i++){
				familiesList.add(new BirdFamily(families[i]));
			}
			
			String []locations = inputFile.nextLine().split("`");
			ArrayList<BirdLocation> locationsList = new ArrayList<BirdLocation>();
			for(int i=0; i<locations.length; i++){
				locationsList.add(new BirdLocation(locations[i]));
			}
			
			String []colors = inputFile.nextLine().split("`");
			ArrayList<BirdColor> colorsList = new ArrayList<BirdColor>();
			for(int i=0; i<colors.length; i++){
				colorsList.add(new BirdColor(colors[i]));
			}
			
			BirdSize size = new BirdSize(inputFile.nextLine());
			
			String []timeActive = inputFile.nextLine().split("`");
			ArrayList<BirdTimeActive> timeActiveList = new ArrayList<BirdTimeActive>();
			for(int i=0; i<timeActive.length; i++){
				timeActiveList.add(new BirdTimeActive(timeActive[i]));
			}
			BirdDescription  description = new BirdDescription(inputFile.nextLine());
			
			birds.add(new Bird(name, familiesList, colorsList, locationsList, size, timeActiveList, description));
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
		return one.getSize().compareTo(two.getSize());
	}
}

class CompareTimeActive implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getTimeActive().get(0).compareTo(two.getTimeActive().get(0));
	}
}


