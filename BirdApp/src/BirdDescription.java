
public class BirdDescription 
{

	private String myDescription;
	
	public BirdDescription()
	{
		myDescription = "";
	}
	public BirdDescription(String description)
	{
		myDescription = description;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}
	
	public boolean equals(Object obj){
		if(myDescription.equals(((BirdDescription)obj).getMyDescription()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
		
	}
	
	public String toString(){
		return myDescription;
	}
}
