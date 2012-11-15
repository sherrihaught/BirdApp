package birdProgram;

import java.util.ArrayList;
import java.util.List;

public class BirdTimeActive 
{
	private List<String> myTimesActive;
	
	public BirdTimeActive()
	{
		myTimesActive = new ArrayList<String>();
	}
	
	public BirdTimeActive(String timeActive)
	{
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
	
	public List<String> getMyTimesActive()
	{
		return myTimesActive;
	}
	
	public void setMyTimesActive(List<String> myTimesActive) 
	{
		this.myTimesActive = myTimesActive;
	}
	
	public boolean equals(Object obj){
		if(myTimesActive.equals(((BirdTimeActive)obj).getMyTimesActive()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return myTimesActive.toString();
	}
}
