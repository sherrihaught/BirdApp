
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
	
	public String toString(){
		return myDescription;
	}
}
