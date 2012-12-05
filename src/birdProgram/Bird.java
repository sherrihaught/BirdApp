package birdProgram;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

public class Bird implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2049983782365439512L;
	private BirdName name;
	private List<BirdFamily> families;
	private List<BirdLocation> locations;
	private List<BirdColor> colors;
	private BirdSize size;
	private BirdDescription description;
	private List<BirdTimeActive> timeActive;
	private String imageLocation;
	
	public Bird(BirdName name, List<BirdFamily> families, List<BirdColor> colors, List<BirdLocation> locations, 
			 BirdSize size, List<BirdTimeActive> timeActive, BirdDescription description, String imageLocation){
		this.name = name;
		this.families = families;
		this.locations = locations;
		this.colors = colors;
		this.size = size;
		this.description = description;
		this.timeActive = timeActive;
		this.imageLocation = imageLocation;
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
	
	public List<BirdTimeActive> getTimeActive(){
		return timeActive;
	}
	
	public BufferedImage getBirdImage(){
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imageLocation));
		} catch (IOException e){
			// image remains null if nextLine is empty
		}
		return image;
	}
	
	public String getImageLocation(){
		return imageLocation;
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
	
	public void setTimeActive(List<BirdTimeActive> timeActive){
		this.timeActive = timeActive;
	}
	
	public void setImageLocation(String imageLocation){
		this.imageLocation = imageLocation;
	}
	
	public String toString(){
		return "Name: " + name.toString() + " Families: " + families.toString() + " Locations: " + locations.toString() + " Colors: " + colors.toString() + " Size: " + size.toString() + " Time Most Active: " + timeActive.toString() + " Description: " + description.toString();
	}
}
