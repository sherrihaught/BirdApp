package birdProgram;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract public class SortManager {
	
	/**Sorts the Bird objects by the specified sortCategory
	 * @param sortCategory string representing sort criteria
	 * @param sortCategory string representing sort criteria
	 * @return a sorted ArrayList of Bird objects
	 */
	public List<Bird> getSortedBirds(List<Bird> birds, String sortCategory){
		List<Bird> sorted = birds;
		if(sortCategory == "name"){
			sorted = getSortedByName(sorted);
		}else if(sortCategory == "family"){
			sorted = getSortedByFamily(sorted);
		}else if(sortCategory == "location"){
			sorted= getSortedByLocation(sorted);
		}else if(sortCategory == "color"){
			sorted = getSortedByColor(sorted);
		}else if(sortCategory == "size"){
			sorted = getSortedBySize(sorted);
		}else if(sortCategory == "timeActive"){
			sorted = getSortedByTimeActive(sorted);
		}
		return sorted;
	}
	
	private List<Bird> getSortedByName(List<Bird> sorted){
		Collections.sort(sorted,new CompareName());
		return sorted;
	}
	
	private List<Bird> getSortedByFamily(List<Bird> sorted){
		Collections.sort(sorted,new CompareFamily());
		return sorted;
	}
	
	private List<Bird> getSortedByLocation(List<Bird> sorted){
		Collections.sort(sorted,new CompareLocation());
		return sorted;
	}
	
	private List<Bird> getSortedByColor(List<Bird> sorted){
		Collections.sort(sorted,new CompareColor());
		return sorted;
	}
	
	private List<Bird> getSortedBySize(List<Bird> sorted){
		Collections.sort(sorted,new CompareSize());
		return sorted;
	}
	
	private List<Bird> getSortedByTimeActive(List<Bird> sorted){
		Collections.sort(sorted,new CompareTimeActive());
		return sorted;
	}
}


class CompareName implements Comparator<Bird>{

	public int compare(Bird one, Bird two) {
		return one.getName().compareTo(two.getName());
	}
}

class CompareColor implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getColors().get(0).compareTo(two.getColors().get(0));
	}
}

class CompareFamily implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getFamilies().get(0).compareTo(two.getFamilies().get(0));
	}
}

class CompareLocation implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getLocations().get(0).compareTo(two.getLocations().get(0));
	}
}

class CompareString implements Comparator<String>{

	@Override
	public int compare(String one, String two) {
		return one.compareTo(two);
	}
}

class CompareSize implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getSize().compareTo(two.getSize());
	}
}

class CompareTimeActive implements Comparator<Bird>{

	@Override
	public int compare(Bird one, Bird two) {
		return one.getTimeActive().get(0).compareTo(two.getTimeActive().get(0));
	}
}
