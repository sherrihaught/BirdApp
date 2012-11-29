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
		if(searches.size() == 10){
			searches.removeFirst();
		}
		searches.addLast(searchResults);
	}
	
	public BirdSearch getLast(){
		if(searches.size() > 0){
			return searches.getLast();
		}
		return null;
	}	
}
