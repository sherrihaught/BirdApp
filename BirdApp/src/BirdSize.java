
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
	
	public String toString(){
		return mySize;
	}
}
