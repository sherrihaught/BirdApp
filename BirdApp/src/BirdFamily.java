
public class BirdFamily 
{

	private String myFamily;
	
	public BirdFamily()
	{
		myFamily = "";
	}
	public BirdFamily(String family)
	{
		myFamily = family;
	}

	public String getMyFamily() {
		return myFamily;
	}

	public void setMyFamily(String myFamily) {
		this.myFamily = myFamily;
	}
	
	public String toString(){
		return myFamily;
	}
}
