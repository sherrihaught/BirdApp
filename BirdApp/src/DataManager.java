import java.util.*;

public class DataManager {
	private ArrayList<Bird> birds;

	public DataManager(String fileName){
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
	
	public void addBirds(String fileName){
		//read from file, creating new Birds and adding them to birds
	}
}
