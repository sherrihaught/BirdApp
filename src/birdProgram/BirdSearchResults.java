package birdProgram;

import java.util.LinkedList;

public class BirdSearchResults
{
	LinkedList<BirdSearch> searches;
	
	public BirdSearchResults()
	{
		searches = new LinkedList<BirdSearch>();
	}
	
	public void add(BirdSearch searchResults){
		
		searches.addLast(searchResults);
	}
	
	public BirdSearch getLast(){
		return searches.getLast();
	}	
}
