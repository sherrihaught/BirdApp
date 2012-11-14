package birdProgram;

import java.util.List;
public class BirdDriver {

	private DataManager dm;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BirdDriver();
	}
	
	private BirdDriver(){
		try{
			dm = new DataManager("birds.txt");
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		BirdSearch search = new BirdSearch(dm.getBirds(), new BirdName());
		displayBirds(search.getBirds());
	}

	private void displayBirds(List<Bird> birds){
		for(int i=0;i<birds.size();i++){
			System.out.println(birds.get(i).toString());
		}
	}

}
