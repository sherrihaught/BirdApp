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
	
	public List<Bird> getSortedBirds(String sortCategory){
		List<Bird> sorted = new ArrayList<Bird>();
		sorted = birds;
		//sort sorted based on given sortCategory
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
			
			String []timesActive = inputFile.nextLine().split("`");
			ArrayList<BirdTimeMostActive> timesActiveList = new ArrayList<BirdTimeMostActive>();
			for(int i=0; i<timesActive.length; i++){
				timesActiveList.add(new BirdTimeMostActive(timesActive[i]));
			}
			BirdDescription  description = new BirdDescription(inputFile.nextLine());
			
			birds.add(new Bird(name, familiesList, colorsList, locationsList, size, timesActiveList, description));
		}
		inputFile.close();
	}
}

