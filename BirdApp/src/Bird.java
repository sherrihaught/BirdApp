import java.util.List;

public class Bird {
	private BirdName name;
	private List<BirdFamily> families;
	private List<BirdLocation> locations;
	private List<BirdColor> colors;
	private BirdSize size;
	private BirdDescription description;
	private List<BirdTimeMostActive> timeActive;
	
	public Bird(BirdName name, List<BirdFamily> families, List<BirdColor> colors, List<BirdLocation> locations, 
			 BirdSize size, List<BirdTimeMostActive> timeActive, BirdDescription description){
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
	
	public List<BirdTimeMostActive> getTimeMostActive(){
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
	
	public void setDescription(BirdDescription description){
		this.description = description;
	}
	
	public void setTimeMostActive(List<BirdTimeMostActive> timeActive){
		this.timeActive = timeActive;
	}
	
	public String toString(){
		return "Name: " + name.toString() + " Families: " + families.toString() + " Locations: " + locations.toString() + " Colors: " + colors.toString() + " Size: " + size.toString() + " Time Most Active: " + timeActive.toString() + " Description: " + description.toString();
	}
}
