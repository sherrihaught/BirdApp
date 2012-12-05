package birdProgram;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class BirdSearchResults
{
	LinkedList<BirdSearch> searches;
	
	public BirdSearchResults(){
		deserializationOfSearches();
	}
	
	public void serializationOfSearches(){
		try { 
			FileOutputStream fos = new FileOutputStream("searches"); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(searches); 
			oos.flush(); 
			oos.close(); 
		}
		catch(Exception e) { 
			System.out.println("Exception during serialization: " + e); 
			System.exit(0); 
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deserializationOfSearches(){
		try { 
			FileInputStream fis = new FileInputStream("searches"); 
			ObjectInputStream ois = new ObjectInputStream(fis); 
			searches = (LinkedList<BirdSearch>)ois.readObject(); 
			ois.close(); 
		} 
		catch(Exception e) { 
			System.out.println("Exception during deserialization: " + e); 
			searches = new LinkedList<BirdSearch>();
		}
	}
	
	public void add(BirdSearch searchResults){
		if(searches.size() == 10){
			searches.removeFirst();
		}
		searches.addLast(searchResults);
		serializationOfSearches();
	}
	
	public BirdSearch getLast(){
		if(searches.size() > 0){
			return searches.getLast();
		}
		return null;
	}	
}
