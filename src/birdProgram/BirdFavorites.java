package birdProgram;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class BirdFavorites  {
	private List<BirdName> favorites;
	
	public BirdFavorites(){
		favorites = new ArrayList<BirdName>();
		deserializationOfFavorites();
	}
	
	public void serializationOfFavorites(){
		try { 
			FileOutputStream fos = new FileOutputStream("favorites"); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(favorites); 
			oos.flush(); 
			oos.close(); 
		}
		catch(Exception e) { 
			System.out.println("Exception during serialization: " + e); 
			System.exit(0); 
		}
	}
	
	public void deserializationOfFavorites(){
		try { 
			FileInputStream fis = new FileInputStream("favorites"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			favorites = (ArrayList<BirdName>)ois.readObject(); 
			ois.close(); 
		} 
		catch(Exception e) { 
			System.out.println("Exception during deserialization: " + e); 
			favorites = new ArrayList<BirdName>();
			//System.exit(0); 
		}
	}
	
	public boolean addFavorite(BirdName birdName){
		return favorites.add(birdName);
	}
	
	public boolean removeFavorite(BirdName birdName){
		return favorites.remove(birdName);
	}
	
	public List<BirdName> getFavorites(){
		return favorites;
	}
	
	private void writeObject(java.io.ObjectOutputStream out)throws IOException{
		out.defaultWriteObject();
	}
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
	}
}
