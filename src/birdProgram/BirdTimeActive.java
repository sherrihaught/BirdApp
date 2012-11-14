package birdProgram;

public class BirdTimeActive 
{

	private String myTimeActive;
	
	public BirdTimeActive()
	{
		myTimeActive = "";
	}
	
	public BirdTimeActive(String timeActive)
	{
		this.myTimeActive = timeActive;
	}
	
	public String getMyTimeActive()
	{
		return myTimeActive;
	}
	
	public void setMyTimeActive(String myTimeActive) 
	{
		this.myTimeActive = myTimeActive;
	}
	
	public boolean equals(Object obj){
		if(myTimeActive.equals(((BirdTimeActive)obj).getMyTimeActive()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public int compareTo(BirdTimeActive timeActive){
		return myTimeActive.compareTo(timeActive.getMyTimeActive());
	}
	
	public String toString(){
		return myTimeActive;
	}
}
