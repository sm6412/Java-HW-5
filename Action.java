// Name: Samira Mantri
// Date: 12/3/16
// Assignment: #7
// Summary: The Action class represents an action movie.
// Action extends Movie, adds some additional data, implements the getPrice() and overrides toString().

public class Action extends Movie {
	// create private instance variable to represent the number of explosions
	private int explosions;
	
	// create a Action constructor
	public Action(String title,int year, int duration, double rating,int explosions){
		// send the title, year, duration, and rating to the constructor taking these parameters in the 
		// Movie constructor
		super(title,year,duration,rating);
		// make sure that there is a valid number of explosions, if not, throw an exception
		if(explosions<1||explosions>100){
			throw new IllegalArgumentException("Invalid number of 'explosions'");
		}
		else{
			// set explosions
			setExplosions(explosions);
		}
	}

	// set explosions
	public void setExplosions(int explosions){
		this.explosions=explosions;
	}
	
	// get explosions
	public int getExplosions(){
		return this.explosions;
	}
	
	// override toString
	public String toString(){
		// get initial toString string 
		String movieInfo=super.toString();
		// create string that displays explosions and add with initial string
		movieInfo+=String.format(", explosions: %2d", explosions);
		return movieInfo;
	}
	
	// get price
	public double getPrice(){
		double price= (year+explosions*duration)/1000;
		return price;
	}

}
