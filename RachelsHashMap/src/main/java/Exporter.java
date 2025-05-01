import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Exporter class holds a method that handles saving data into a .txt file.
 * @author Rachel Hussmann
 */
public class Exporter {

    /**
     * The createFile method creates a .txt file that holds the number of collisions for a RachelSimpleHashMap filled
     * with EmergencyCallEntry objects.
     * @param nameOfFile The name of the file to be created
     * @param data The data to be saved in the file
     */
    public void createFile(String nameOfFile, String data){

        //Using a try catch block due to chance of an exception being thrown
        try {

            //Create a PrintWriter object to handle copying the data into a file
            PrintWriter out = new PrintWriter(nameOfFile);

            //Print the string to the file
            out.print(data);

            //Inform the user if the creation of the file was successful
            System.out.println("File Creation Successful");

            //Close the PrintWriter object
            out.close();

        } catch (FileNotFoundException e) {

            //If a FileNotFoundException is thrown, catch it and inform the user of the error
            System.err.println("File Could Not Be Created: " + e.getMessage());
        }
    }
}
