import java.util.ArrayList;
import java.util.List;

public class BirdSearch{
	private List<Bird> results;
	public BirdSearch(List<Bird> birdList, BirdName name, BirdColor color, BirdFamily family, BirdLocation location, BirdSize size, BirdTimeMostActive timeActive, BirdDescription description){
		results = new ArrayList<Bird>();
		results = birdList;
		if(!name.equals(new BirdName()))
			results = getBirdsByName(name);
		if(!color.equals(new BirdColor()))
			results = getBirdsByColor(color);
		if(!family.equals(new BirdFamily()))
			results = getBirdsByFamily(family);
		if(!location.equals(new BirdLocation()))
			results = getBirdsByLocation(location);
		if(!timeActive.equals(new BirdTimeMostActive()))
			results = getBirdsByTimeActive(timeActive);
		if(!size.equals(new BirdSize()))
			results = getBirdsBySize(size);
		if(!description.equals(new BirdDescription()))
			results = getBirdsByDescription(description);
	}
	
	public List<Bird> getBirds(){
		return results;
	}
	
	private List<Bird> getBirdsByName(BirdName name){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getName().getMyName().matches(name.getMyName()))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private List<Bird> getBirdsByDescription(BirdDescription description){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getDescription().getMyDescription().matches(description.getMyDescription()))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByTimeActive(BirdTimeMostActive timeActive){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getTimeMostActive().contains(timeActive))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByColor(BirdColor color){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getColors().contains(color))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsBySize(BirdSize size){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getSize().equals(size))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByFamily(BirdFamily family){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getFamilies().contains(family))
				subset.add(results.get(i));
		}
		return subset;
	}
	
	private ArrayList<Bird> getBirdsByLocation(BirdLocation location){
		ArrayList<Bird> subset = new ArrayList<Bird>();
		for(int i=0;i<results.size();i++){
			if(results.get(i).getLocations().contains(location))
				subset.add(results.get(i));
		}
		return subset;
	}
	
}
