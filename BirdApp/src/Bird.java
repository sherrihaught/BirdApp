import java.util.List;

public class Bird {
	private BirdName name;
	private List<BirdFamily> families;
	private List<BirdLocation> locations;
	private List<BirdColor> colors;
	private BirdSize size;
	private BirdDescription description;
	private BirdTimeMostActive timeActive;
	
	public Bird(BirdName name, List<BirdFamily> families, List<BirdLocation> locations, 
			List<BirdColor> colors, BirdSize size, BirdDescription description, BirdTimeMostActive timeActive){
		this.name = name;
		this.families = families;
		this.locations = locations;
		this.colors = colors;
		this.size = size;
		this.description = description;
		this.timeActive = timeActive;
	}

//--get methods---------------------------
	public BirdName getName(){
		return name;
	}
	
	public List<BirdFamily> getFamilies(){
		return families;
	}
	
	public List<BirdLocation> getLocations(){
		return locations;
	}
	
	public List<BirdColor> getColors(){
		return colors;
	}
	
	public BirdSize getSize(){
		return size;
	}
	
	public BirdDescription getDescription(){
		return description;
	}
	
	public BirdTimeMostActive getTimeMostActigve(){
		return timeActive;
	}
	
//--set methods---------------------------
	public void setName(BirdName name){
		this.name = name;
	}
	
	public void setFamilies(List<BirdFamily> families){
		this.families = families;
	}
	
	public void setLocations(List<BirdLocation> locations){
		this.locations = locations;
	}
	
	public void setColors(List<BirdColor> colors){
		this.colors = colors;
	}
	
	public void setSize(BirdSize size){
		this.size = size;
	}
	
	public void getDescription(BirdDescription description){
		this.description = description;
	}
	
	public void getTimeMostActive(BirdTimeMostActive timeActive){
		this.timeActive = timeActive;
	}
}
