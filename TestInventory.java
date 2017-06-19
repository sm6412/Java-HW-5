
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Name: Samira Mantri
//Date: 12/3/16
//Assignment: #7
//Summary:this class is used to test the Movie, Action, RomCom, and Inventory classes

public class TestInventory {

  public static void main(String[] args) throws FileNotFoundException {
	// create the inventory
    Inventory inv = new Inventory();

    // TODO:  Read in the input file and populate the movieList. Manage exceptions.
    // On a failed movie load print the message
    // "Exception " + e.getMessage() + " for film " + title. No loading."
    
    // Create a new file object that references a file in the data folder
     File testFile = new File("src/movies_db.txt");
     		
     		// scan contents of file
    		Scanner fileInput = new Scanner(testFile);

          // begin reading data
          while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();

            // split up the line based on the "-" delimiter
            String[] splitLine = line.split("-");

            // take apart each piece of information on the line and set it
            // equal to a variable 
            String title = splitLine[0];
            int year = Integer.parseInt(splitLine[1]);
            int duration = Integer.parseInt(splitLine[2]);
            double rating = Double.parseDouble(splitLine[3]);
            String genre = splitLine[4]; 
            
            // if the genre is a RomCom, create a jerk and friendzone variable
            if (genre.equals("RomCom")){
          	  int jerks= Integer.parseInt(splitLine[5]);
          	  int friendzones= Integer.parseInt(splitLine[6]);
          	  // create Movie object
          	  try{
              	  Movie movieObject= new RomCom(title,year,duration,rating,jerks,friendzones);
              	  inv.add(movieObject); 
          	  }
          	  // catch if illegal arguments or movie inventory exception exists
          	  catch (IllegalArgumentException e){
          		  System.out.println("Illegal value in file. "+e.getMessage()+" for film "+title+". No loading");
          	  }
          	  catch (MovieInventoryException e) {
          		  System.out.println(e.getMessage());
              }

          	  
            }
            else{
            // create an explosions variable
          	  int explosions= Integer.parseInt(splitLine[5]);
          	  // create Movie object
          	  try{
              	  Movie movieObject= new Action(title,year,duration,rating,explosions);
              	  // add the movie into Inventory if no exceptions
                  inv.add(movieObject);
          	  }
          	  // catch if illegal arguments or movie inventory exception exists
          	  catch (IllegalArgumentException e){
          		  System.out.println("Illegal value in file. "+e.getMessage()+" for film "+title+". No loading");
          	  }
          	  catch (MovieInventoryException e) {
          		  System.out.println(e.getMessage());
              }
            }
          }

          // close the Scanner
          fileInput.close();
        
        
        
        
        
    // Original TestInventory code
    System.out.println("Inventory should now contain file contents.");
    System.out.println(inv.toString());
    
    Movie starWars = new Action("Star Wars - A New Hope", 1977, 121, 3.8, 89);
    inv.add(starWars);
    
    Movie numberFour = new Action("I Am Number Four", 2011, 101, 3.2, 11);
    inv.add(numberFour);
    
    Movie someoneLikeYou = new RomCom("Someone Like You", 2011, 101, 3.2, 2, 5);
    inv.add(someoneLikeYou);
    
    Movie crazyStupidLove = new RomCom("Crazy, Stupid, Love 2", 2013, 113, 3.9, 1, 3);
    inv.add(crazyStupidLove);

    System.out.println("Inventory should now contain 13 movies. " + (inv.size() == 13));

    if(inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
      System.out.println("Successfully removed 'Crazy, Stupid, Love'");
      if(!inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
        System.out.println("Successfully ignored second remove attempt for 'Crazy, Stupid, Love'");
      }
    }
    
    try {
      inv.add(new RomCom("27 Dresses", 2008, 103, 4.4, 1, 1));
    } catch (IllegalArgumentException e) {
      System.out.println("Successfully threw exception on invalid parameter.");
    }

    
    try {
      inv.add(someoneLikeYou);
    } catch (MovieInventoryException e) {
    	System.out.println("Successfully threw exception on duplicate add attempt.");
    }

    System.out.println("Inventory should now contain 12 movies. " + (inv.size() == 12));
      
    System.out.println("Inventory should not contain 'The Matrix'? " + !inv.contains("The Matrix", 1999));
    System.out.println("Inventory should not contain 'Something Borrowed'? " + !inv.contains("Something Borrowed", 2009));
    System.out.println("Inventory should not contain '27 Dressed'? " + !inv.contains("27 Dressed", 2008));

    System.out.println("\n" + inv.toString());
  }

}
