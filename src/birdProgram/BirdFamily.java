package birdProgram;

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
	
	public int compareTo(BirdFamily family){
		return myFamily.compareTo(family.getMyFamily());
	}
	
	public boolean equals(Object obj){
		if(myFamily.equals(((BirdFamily)obj).getMyFamily()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return myFamily;
	}
}
