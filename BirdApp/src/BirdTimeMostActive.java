
public class BirdTimeMostActive 
{

	private String myActivity;
	
	public BirdTimeMostActive()
	{
		myActivity = "";
	}
	
	public BirdTimeMostActive(String active)
	{
		myActivity = active;
	}
	
	public String getMyActivity()
	{
		return myActivity;
	}
	
	public void setMyActivity(String myActivity) 
	{
		this.myActivity = myActivity;
	}
	
	public boolean equals(Object obj){
		if(myActivity.equals(((BirdTimeMostActive)obj).getMyActivity()) && this.getClass().equals(obj.getClass()))
			return true;
		else
			return false;
	}
	
	public String toString(){
		return myActivity;
	}
}
