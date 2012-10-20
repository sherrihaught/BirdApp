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
	
	public ArrayList<Bird> getSortedBirds(String sortCategory){
		ArrayList<Bird> sorted = birds;
		//sort sorted based on given sortCategory
		return sorted;
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
	}
}
