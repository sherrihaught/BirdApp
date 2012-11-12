
import java.util.ArrayList;
public class BirdDriver {

	private DataManager dm;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BirdDriver drive = new BirdDriver();
	}
	
	private BirdDriver(){
		try{
			dm = new DataManager("birds.txt");
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		displayBirds(dm.getBirds());
	}

	private void displayBirds(ArrayList<Bird> birds){
		for(int i=0;i<birds.size();i++){
			System.out.println(birds.get(i).toString());
		}
	}

}
