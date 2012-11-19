package birdProgram;


import java.util.ArrayList;
import java.util.List;

public class BirdTimeActive extends BirdAttribute
{
	
	public BirdTimeActive(){
		myTimesActive = new ArrayList<String>();
	}
	
	public BirdTimeActive(String timeActive){
		this();
		addTime(timeActive);
	}
	
	public BirdTimeActive(List<String> timesActive){
		myTimesActive = timesActive;
	}
	
	public void addTime(String timeActive){
		if(!myTimesActive.contains(timeActive)){
			myTimesActive.add(timeActive);
		}
	}
	
}
