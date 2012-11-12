import java.util.*;

public class Bird {
	private BirdName name;
	private List<BirdFamily> families;
	private List<BirdLocation> locations;
	private List<BirdColor> colors;
	private BirdSize size;
	private BirdDescription description;
	
	public Bird(BirdName name, List<BirdFamily> families, List<BirdLocation> locations, 
			List<BirdColor> colors, BirdSize size, BirdDescription description){
		this.name = name;
		this.families = families;
		this.locations = locations;
		this.colors = colors;
		this.size = size;
		this.description = description;
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
}
