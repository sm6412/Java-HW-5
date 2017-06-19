
//Name: Samira Mantri
//Date: 12/3/16
//Assignment: #7
//Summary:this class creates a movie inventory exception that extends the runtime exception
public class MovieInventoryException extends RuntimeException{
	public MovieInventoryException ( String title ) {
		super ( title + " already in inventory. " );
		}
}
