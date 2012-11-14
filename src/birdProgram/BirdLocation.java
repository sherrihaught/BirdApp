package birdProgram;

public class BirdLocation 
{

	private String myLocation;
	
	public BirdLocation()
	{
		myLocation = "";
	}
	
	public BirdLocation( String location)
	{
		myLocation = location;
	}

	public String getMyLocation() {
		return myLocation;
	}

	public void setMyLocation(String myLocation) {
		this.myLocation = myLocation;
	}
	
	public int compareTo(BirdLocation location){
		return myLocation.compareTo(location.getMyLocation());
	}
	
	public boolean equals(Object obj){
		if(myLocation.equals(((BirdLocation)obj).getMyLocation()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return myLocation;
	}
}
