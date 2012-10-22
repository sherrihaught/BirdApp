import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DataManager {
	private ArrayList<Bird> birds;

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
	
	//I think the best way to do this would be to have separate categories for each instead of what's below
	public ArrayList<Bird> getSortedBirds(String sortCategory){
		ArrayList<Bird> sorted = birds;
		if(sortCategory.equals("Name"))
			Collections.sort(birds,new CompareName());
		else if(sortCategory.equals("Size"))
			Collections.sort(birds,new CompareSize());
		//sort sorted based on given sortCategory
		return sorted;
	}
	
	public ArrayList<Bird> getBirdsByColor(String color){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birds.size();i++){
			if(birds.get(i).getColors().contains(color))
				subset.add(birds.get(i));
		}
		return subset;
	}
	
	public ArrayList<Bird> getBirdsByFamily(String family){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birds.size();i++){
			if(birds.get(i).getFamilies().contains(family))
				subset.add(birds.get(i));
		}
		return subset;
	}
	
	public ArrayList<Bird> getBirdsByLocation(String location){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<birds.size();i++){
			if(birds.get(i).getLocations().contains(location))
				subset.add(birds.get(i));
		}
		return subset;
	}
	
	public ArrayList<Bird> getSubsetBirds(String searchCategory, String searchValue){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		//search through birds based on searchCategory
		//if Bird has searchValue, add to subset
		return subset;
	}
	
	public void addBirds(String fileName) throws FileNotFoundException{
		//read from file 6 lines at a time, creating new Birds and adding them to birds
		Scanner inputFile = new Scanner(new File(fileName));
		while (inputFile.hasNextLine())
		{
			birds.add(new Bird(
				inputFile.nextLine(), 
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 
				new ArrayList<String>(Arrays.asList(inputFile.nextLine().split("`"))), 
				inputFile.nextLine(), 
				inputFile.nextLine()
				));
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
