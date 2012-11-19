package birdProgram;

/*import java.io.IOException; 
import java.io.ObjectStreamException;
import java.io.Serializable;*/
import java.util.*;

//public class BirdFavorites implements Serializable { Not ready to be implemented, more research and testing needed.
public class BirdFavorites  {
	private static final long serialVersionUID = 1L;
	private List<Bird> favorites;
	
	public BirdFavorites(){
		favorites = new ArrayList<Bird>();
	}
	
	public boolean addFavorite(Bird bird){
		return favorites.add(bird);
	}
	
	public boolean removeFavorite(Bird bird){
		return favorites.remove(bird);
	}
	
	public List<Bird> getFavorites(){
		return favorites;
	}
	/* 
	private void writeObject(java.io.ObjectOutputStream out)throws IOException{
		out.defaultWriteObject();
	}
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
	}*/
}
