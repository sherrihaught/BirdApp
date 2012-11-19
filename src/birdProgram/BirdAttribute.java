package birdProgram;


import java.util.ArrayList;
import java.util.List;

public class BirdAttribute {
	
	//MEMBER DECLARATIONS
	protected String myColor;
	protected String myDescription;
	protected String myFamily;
	protected String myLocation;
	protected String myName;
	protected String mySize;
	protected List<String> myTimesActive;
	
	//----COLOR----
	//get
	public String getMyColor() {
		return myColor;
	}
	
	//set
	public void setMyColors(String myColor) {
		this.myColor = myColor;
	}
	
	//compareTo
	public int compareTo(BirdColor color){
		return myColor.compareTo(color.getMyColor());
	}
	
	//toString
	public String toString(){
		return myColor;
	}
	
	//equals
	public boolean equals(Object obj){
		if(myColor.equals(((BirdColor)obj).getMyColor()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	
	//----DESCRIPTION----
	//get
	public String getMyDescription(){
		return myDescription;
	}
	
	//set
	public void setMyDescription(String myDescription){
		this.myDescription = myDescription;
	}
	
	//compareTo
	public int compareTo(BirdDescription description){
		return myDescription.compareTo(description.getMyDescription());
	}
	
	//toString
	public String toString(){
		return myDescription;
	}
	
	//equals
	public boolean equals(Object obj){
		if(myDescription.equals(((BirdDescription)obj).getMyDescription()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	
	
	//----FAMILY----
	//get
	public String getMyFamily(){
		return myFamily;
	}
	
	//set
	public void setMyFamily(String myFamily){
		this.myFamily = myFamily;
	}
	
	//compareTo
	public int compareTo(BirdFamily family){
		return myFamily.compareTo(family.getMyFamily());
	}
	
	//toString
	public String toString(){
		return myFamily;
	}
	
	//equals
	public boolean equals(Object obj){
		if(myFamily.equals(((BirdFamily)obj).getMyFamily()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	
	
	//----LOCATION----
	//get
	public String getMyLocation() {
		return myLocation;
	}
	
	//set
	public void setMyLocation(String myLocation) {
		this.myLocation = myLocation;
	}
	
	//compareTo
	public int compareTo(BirdLocation location){
		return myLocation.compareTo(location.getMyLocation());
	}
	
	//toString
	public String toString(){
		return myLocation;
	}
	
	//equals
	public boolean equals(Object obj){
		if(myLocation.equals(((BirdLocation)obj).getMyLocation()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	
	
	//----NAME----
	//get
	public String getMyName(){
		return myName;
	}
	
	//set
	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	//compareTo
	public int compareTo(BirdName name){
		return myName.compareTo(name.getMyName());
	}
	
	//toString
	public String toString(){
		return myName;
	}
	
	//equals
	public boolean equals(Object obj){
		if(myName.equals(((BirdName)obj).getMyName()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
	
	
	
	//----SIZE----
	//get
	public String getMySize() {
		return mySize;
	}
	
	//set
	public void setMySize(String mySize) {
		this.mySize = mySize;
	}
	
	//compareTo & getSizeNumber
	public int compareTo(BirdSize size){
		if(this.getSizeNumber()<size.getSizeNumber()){
			return -1;
		}else if(this.getSizeNumber()==size.getSizeNumber()){
			return 0;
		}else{
			return 1;
		}
		
	}
	
	public int getSizeNumber(){
		if(mySize.equals("Very Small")){
			return 1;
		}else if(mySize.equals("Small")){
			return 2;
		}else if(mySize.equals("Medium")){
			return 3;
		}else if(mySize.equals("Large")){
			return 4;
		}else{
			return 5;
		}
		
	}
	
	//toString
	public String toString(){
		return mySize;
	}
	
	//equals
	public boolean equals(Object obj){
		if(mySize.equals(((BirdSize)obj).getMySize()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}

	}
	
	
	
	
	//----TIMES ACTIVE----
	//get
	public List<String> getMyTimesActive(){
		return myTimesActive;
	}
	
	//set
	public void setMyTimesActive(List<String> myTimesActive){
		this.myTimesActive = myTimesActive;
	}

	//toString
	public String toString(){
		return myTimesActive.toString();
	}
	
	//equals
	public boolean equals(Object obj){
		if(myTimesActive.equals(((BirdTimeActive)obj).getMyTimesActive()) && this.getClass().equals(obj.getClass())){
			return true;
		}else{
			return false;
		}
			
	}
	
}
