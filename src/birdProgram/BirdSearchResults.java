package birdProgram;

import java.util.LinkedList;
import java.util.List;

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
	
	public List<Bird> getSearchResults(BirdSearch current){ //pass tag?
		for( BirdSearch s : searches){ //if have same tag?
			if( s == current ){ 
				return s.getBirds();
			}
		}
		return new LinkedList<Bird>();
	}
	
	
}
