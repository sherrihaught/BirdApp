package birdProgram;

public class BirdSize
{
	private String mySize;

	public BirdSize()
	{
		setMySize("");
	}
	
	public BirdSize(String size)
	{
		mySize = size;
	}

	public String getMySize() {
		return mySize;
	}

	public void setMySize(String mySize) {
		this.mySize = mySize;
	}
	
	public boolean equals(Object obj){
		if(mySize.equals(((BirdSize)obj).getMySize()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public int getSizeNumber(){
		if(mySize.equals("Very Small"))
			return 1;
		else if(mySize.equals("Small"))
			return 2;
		else if(mySize.equals("Medium"))
			return 3;
		else if(mySize.equals("Large"))
			return 4;
		else
			return 5;
	}
	
	public int compareTo(BirdSize size){
		if(this.getSizeNumber()<size.getSizeNumber())
			return -1;
		else if(this.getSizeNumber()==size.getSizeNumber())
			return 0;
		else
			return 1;
	}
	
	public String toString(){
		return mySize;
	}
}
