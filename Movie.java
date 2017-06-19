

// Name: Samira Mantri
// Date: 12/3/16
// Assignment: #7
// Summary: this abstract class represents a single movie offered by amazon

public abstract class Movie implements Comparable<Movie> {
	// create rating, year, duration, and title variables
	private double rating;
	protected final int year;
	protected final int duration;
	protected final String title;
	
	// create a constructor that throws an IllegalArgumentException if any of the 
	// four entered values for the parameters is invalid
	public Movie(String title, int year, int duration, double rating){
		if ((rating<0.0||rating>4.0)){
			throw new IllegalArgumentException("Invalid 'rating'");
		}
		else{
			setRating(rating);
		}
		if (year<1870||year>2015){
			throw new IllegalArgumentException("Invalid 'year'");
		}
		else{
			this.year=year;
		}
		if (duration<=0){
			throw new IllegalArgumentException("Invalid 'duration'");
		}
		else{
			this.duration=duration;
		}
		this.title=title;
	}
	 // override the compareTo method in the comparable interface 
	public int compareTo(Movie movieObject){
	    if (movieObject.getYear() < this.year) {
	        // return 1 if the movie object's year is less 
	    	// than the year of the year in this movie class
	        return 1;
	      } else if (movieObject.getYear() == this.year) {
	  	    if (movieObject.getRating() < this.rating) {
		        // return 1 if the movie object's rating is less than 
		    	// than the rating of the movie in this movie class 
		        return 1;
		      } else if (movieObject.getRating() == this.rating) {
		        // if the rating is the same, return 0
		        return 0;
		      } else {
		        // if the rating of the movie object is greater than the rating
		    	// of the movie in this class return -1
		        return -1;
		      }
		    }
	       
	      else {
	        // if the movie object's year is greater than the year of the movie in this 
	        // movie class return -1
	        return -1;
	      }
	    }
	
	


	// create a setter for rating
	public void setRating(double rating){
		this.rating=rating;
	}
	
	// create a to string method
	public String toString(){
		String movieInfo=String.format("%2s: %d, rating: %2.1f, price: %2.1f",title,year,rating,getPrice());
		return movieInfo;
	}
	// create a getter for rating
	public double getRating(){
		return this.rating;
	}
	
	// create a getter for year
	public int getYear(){
		return this.year;
	}
	
	// create a getter for duration
	public int getDuration(){
		return this.duration;
	}
	
	// create a getter for title
	public String getTitle(){
		return this.title;
	}
	
	// create an abstract method that gets the price of a movie and returns a double
	public abstract double getPrice();

}
