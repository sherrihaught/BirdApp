package birdProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Birds {
	private List<Bird> birds;
	
	public Birds(){
		birds = new ArrayList<Bird>();
	}
	
	public Birds(String fileName) throws FileNotFoundException{
		this();
		addBirds(fileName);
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
			BirdDescription description = new BirdDescription(inputFile.nextLine());
			
			birds.add(new Bird(name, familiesList, colorsList, locationsList, size, timeActiveList, description));
		}
		inputFile.close();
	}
}
