import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The Importer class contains methods to import a file and extract the contents of it. For this specific instance, it
 * accepts .csv data of 911 calls and creates the appropriate list of EmergencyCallEntry objects. The .csv file comes
 * from the Kaggle dataset "Emergency - 911 calls" and has been trimmed to only have columns with the data of
 * ["title", "timeStamp", "twp", "address"].
 * Link to dataset: https://www.kaggle.com/datasets/mchirico/montcoalert?resource=download
 * @author Rachel Hussmann
 */
public class Importer {

    /**
     * The importFile method imports a file and puts all the lines from the file into an ArrayList of strings
     * @param filepath The filepath of the file that needs to be imported
     * @return The y values from the processed file
     */
    public ArrayList<EmergencyCallEntry> importFile(String filepath){

        ArrayList<String> dataFromFile = new ArrayList<>();

        // Open the file
        File file = new File(filepath);

        // Create the Scanner object and scope to the entire main method
        Scanner in = null;

        try {
            // Try to open the file
            in = new Scanner(file);

            try {
                // Read in the data one line at a time
                while(in.hasNextLine()) {
                    // Do something with this String
                    dataFromFile.add(in.nextLine());
                }


                // Fix anything that broke and clean up
            } catch (NoSuchElementException e) {
                System.err.println("Record Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Parse Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Data Error: " + e.getMessage());
            } finally {
                in.close();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File Unavailable: " + e.getMessage());
        }

        //Trim the unnecessary data and prepare the data for use
        return trimAndProcess(dataFromFile);
    }

    /**
     * The trimAndProcess method trims the extra information off of the imported file and separates the values into
     * x and y values.
     * @param data The ArrayList of strings to be processed
     * @return An ArrayList of doubles that holds the y values
     */
    public ArrayList<EmergencyCallEntry> trimAndProcess(ArrayList<String> data){

        //Remove the first string because that is just the titles of the columns
        data.remove(0);

        //Create the arraylist that will hold the new EmergencyCallEntry objects
        ArrayList<EmergencyCallEntry> entryObjects = new ArrayList<>();

        /*Iterate through the list of strings to split the values at the comma, the first value being the title of the
        emergency, the second being the timeStamp of the emergency, the third being the township that the emergency
        occurred, and the fourth being the address of emergency*/
        for(String line : data){
            String[] entryData = line.split(",");
            entryObjects.add(new EmergencyCallEntry(entryData[0], entryData[1], entryData[2], entryData[3]));
        }

        //Return the ArrayList of EmergencyCallEntry objects
        return entryObjects;
    }

}
