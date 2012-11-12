
public class BirdColor 
{
	private String myColor;
	
	public BirdColor()
	{
		myColor = "";
	}
	public BirdColor(String color)
	{
		myColor = color;
	}

	public String getMyColor() {
		return myColor;
	}

	public void setMyColors(String myColor) {
		this.myColor = myColor;
	}
	
	public boolean equals(Object obj){
		if(myColor.equals(((BirdColor)obj).getMyColor()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
		
	}

	public String toString(){
		return myColor;
	}
}
