package birdProgram;


public class BirdAttribute {
	
	private String attributeName;

	public BirdAttribute(String attributeName){
		set(attributeName);
	}
	
	public String toString(){
		return attributeName;
	}
	
	public String get(){
		return attributeName;
	}
	
	public void set(String attributeName){
		this.attributeName = attributeName;
	}	
	
	public int compareTo(BirdAttribute other){
		return(attributeName.compareTo(other.get()));
	}
	
	public boolean equals(BirdAttribute other){
		return this.attributeName.equals(other.get());
	}
}
