
public class BirdLocation 
{

	private String myLoc;
	
	public BirdLocation()
	{
		myLoc = "";
	}
	
	public BirdLocation( String location)
	{
		myLoc = location;
	}

	public String getMyLocation() {
		return myLoc;
	}

	public void setMyLocation(String myLoc) {
		this.myLoc = myLoc;
	}
	
	public boolean equals(Object obj){
		if(myLoc.equals(((BirdLocation)obj).getMyLocation()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
		
	}
	
	public String toString(){
		return myLoc;
	}
}
