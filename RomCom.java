// Name: Samira Mantri
// Date: 12/3/16
// Assignment: #7
// Summary: The RomCom class represents a romantic comedy.
// RomCom extends Movie, adds some additional data, implements the getPrice() and overrides toString().

public class RomCom extends Movie {
	// create jerks and friendzones instance variables
	private int jerks;
	private int friendzones;
	
	// create a constructor for RomCom
	public RomCom(String title,int year,int duration,double rating,int jerks, int friendzones){
		// send the title, year, duration, and rating to the constructor taking these parameters in the 
		// Movie constructor
		super(title,year,duration,rating);
		// ensure number of jerks and friendzones is valid for the movie
		if (jerks<1||jerks>10){
			throw new IllegalArgumentException("Invalid number of 'jerks'");
		}
		else{
			setJerks(jerks);
		}
		if (friendzones<1||friendzones>10){
			throw new IllegalArgumentException("Invalid number of 'friendzones'");
		}
		else{
			setFriendzones(friendzones);
		}
	}

	// set jerks
	public void setJerks(int jerks){
		this.jerks=jerks;
	}
	// set friendzones
	public void setFriendzones(int friendzones){
		this.friendzones=friendzones;
	}
	// get jerks
	public int getJerks(){
		return jerks;
	}
	// get friendzones
	public int getFriendzones(){
		return friendzones;
	}
	
	// override toString
	public String toString(){
		// get initial toString string 
		String movieInfo=super.toString();
		// add string with new string displaying the number of jerks and friendzones
		movieInfo+=String.format(", jerks: %1d, friendzones: %1d",jerks,friendzones);
		return movieInfo;
	}
	// get price
	public double getPrice(){
		double price= (jerks+friendzones+year-duration)/100;
		return price;
	}

}
