package birdProgram;

public class BirdName 
{
	private String myName;

	public BirdName()
	{
		myName = "";	
	}
	
	public BirdName(String name)
	{
		myName = name;
	}
	public String getMyName() 
	{
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	public boolean equals(Object obj){
		if(myName.equals(((BirdName)obj).getMyName()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public int compareTo(BirdName name){
		return myName.compareTo(name.getMyName());
	}
	
	public String toString(){
		return myName;
	}
}

