package birdProgram;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;


public class Birds {
	private List<Bird> birds;
	
	public Birds(){
		birds = new ArrayList<Bird>();
	}
	
	public Birds(String fileName) throws FileNotFoundException{
		this();
		addBirds(fileName);
	}
	
	public void addBirds(String fileName) throws FileNotFoundException{
		//read from file, creating new Birds and adding them to birds
		Scanner inputFile = new Scanner(new File(fileName));
		while (inputFile.hasNextLine()){
			BirdName name = new BirdName(inputFile.nextLine());
			
			String []families = inputFile.nextLine().split("`");
			ArrayList<BirdFamily> familiesList = new ArrayList<BirdFamily>();
			for(int i=0; i<families.length; i++){
				familiesList.add(new BirdFamily(families[i]));
			}
			
			String []locations = inputFile.nextLine().split("`");
			ArrayList<BirdLocation> locationsList = new ArrayList<BirdLocation>();
			for(int i=0; i<locations.length; i++){
				locationsList.add(new BirdLocation(locations[i]));
			}
			
			String []colors = inputFile.nextLine().split("`");
			ArrayList<BirdColor> colorsList = new ArrayList<BirdColor>();
			for(int i=0; i<colors.length; i++){
				colorsList.add(new BirdColor(colors[i]));
			}
			
			BirdSize size = new BirdSize(inputFile.nextLine());
			
			String []timeActive = inputFile.nextLine().split("`");
			ArrayList<BirdTimeActive> timeActiveList = new ArrayList<BirdTimeActive>();
			for(int i=0; i<timeActive.length; i++){
				timeActiveList.add(new BirdTimeActive(timeActive[i]));
			}
			
			BirdDescription description = new BirdDescription(inputFile.nextLine());
			
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File(inputFile.nextLine()));
				image = scaleImage(image);									// scale image prior to adding to bird
			} catch (IOException e){
				// image remains null if nextLine is empty
			}
			
			birds.add(new Bird(name, familiesList, colorsList, locationsList, size, timeActiveList, description, image));
		}
		inputFile.close();
	}
	
	public List<Bird> getBirds(){
		return birds;
	}
	
	public BufferedImage scaleImage(BufferedImage image)
	{
		BufferedImage scaledImage = new BufferedImage(200, 200,
			BufferedImage.TYPE_BYTE_INDEXED);

	    AffineTransform tx = new AffineTransform();
	    tx.scale(3, 3);

	    AffineTransformOp op = new AffineTransformOp(tx,
	    	AffineTransformOp.TYPE_BILINEAR);
	    scaledImage = op.filter(image, null);
		
		return scaledImage;
	}
}
