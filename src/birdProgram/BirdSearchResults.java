package birdProgram;

import java.util.ArrayList;
import java.util.List;

public class BirdSearchResults
{
	List<BirdSearch> searches;
	
	public BirdSearchResults()
	{
		searches = new ArrayList<BirdSearch>();
	}
	
	public List<Bird> getSearchResults(BirdSearch current){ //pass tag?
		for( BirdSearch s : searches){ //if have same tag?
			if( s == current ){ 
				return s.getBirds();
			}
		}
		return new ArrayList<Bird>();
	}
	
	
}
