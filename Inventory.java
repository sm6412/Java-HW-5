
import java.util.Collections;
import java.util.ArrayList;
import java.io.File;
//Name: Samira Mantri
//Date: 12/3/16
//Assignment: #7
//Summary:this class is used to create an inventory that holds Movie objects in an array list
// that can be manipulated


public class Inventory {
	// create array list to hold Movie objects
	private ArrayList<Movie> list= new ArrayList<Movie>();
	

	
	// If a movie matching the title and year does not exist in the inventory,
	// then the movie is added to the ArrayList.
	public void add(Movie movieObject){
		for (int x=0; x<list.size();x++){
			if (((list.get(x)).getTitle()).equals(movieObject.getTitle())&&((list.get(x)).getYear())==(movieObject.getYear())){
				throw new MovieInventoryException(movieObject.getTitle());
			}
		}
		list.add(movieObject);
		// sort the movies
		Collections.sort(list);
	}
	 // If the movie matching the title and year exist in the
	 // inventory remove it from the inventory and return true. If the movie matching the title 
	 // and year does not exist in the inventory, return false.
	public boolean remove(String title,int year){
		for (int x=0; x<list.size();x++){
			if (((list.get(x)).getTitle().equals(title))&&((list.get(x)).getYear()==year)){
				list.remove(list.get(x));
				// sort the movies
				Collections.sort(list);
				return true;
			}
		}
		return false;
	}
	
	// If the movie matching the title and year exist in the inventory
	// return true, else return false.
	public boolean contains(String title, int year){
		for (int x=0; x<list.size();x++){
			if ((((list.get(x)).getTitle()).equals(title))&&(((list.get(x)).getYear())==year)){
				return true;
			}
		}
		return false;
	}
	
	// takes no arguments and returns the number of movies
	// in the inventory
	public int size(){
		int size=list.size();
		return size;
	}
	
	// returns multi-line String object containing the list of all the movies
	// in inventory
	public String toString(){
		String movieList="";
		for(int x=0; x<list.size();x++){
			movieList+=((list.get(x)).toString())+"\n";
		}
		return movieList;
		
	}
}


