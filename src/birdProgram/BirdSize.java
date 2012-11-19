package birdProgram;


public class BirdSize extends BirdAttribute
{
	public BirdSize(String size){
		super(size); //hah
	}
	
	public int compareTo(BirdSize other){
		if(this.getSizeNumber()<other.getSizeNumber()){
			return -1;
		}else if(this.getSizeNumber()==other.getSizeNumber()){
			return 0;
		}else{
			return 1;
		}
	}
		
	private int getSizeNumber(){
		if(get().equals("Very Small")){
			return 1;
		}else if(get().equals("Small")){
			return 2;
		}else if(get().equals("Medium")){
			return 3;
		}else if(get().equals("Large")){
			return 4;
		}else{ //Very Large
			return 5;
		}
	}
}
