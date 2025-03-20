import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The Exporter class holds a method that handles placing x and y data into a csv file.
 * @author Rachel Hussmann
 */
public class Exporter {

    /**
     * The createFile method creates a csv file called "Function.csv" that holds the X and Y values of a mathematical
     * function.
     * @param xValues The ArrayList of x values that were used to with the function to calculate the y values
     * @param yValues The ArrayList of y values that were calculated using the function
     */
    public void createFile(ArrayList<Integer> xValues, ArrayList<Double> yValues){

        //Using a try catch block due to chance of an exception being thrown
        try {

            //Create a PrintWriter object to handle copying the data into a file
            PrintWriter out = new PrintWriter("Function.csv");

            //Create the header for the csv file so it knows how to categorize the data
            out.println("X,Y,");

            //Iterate through the xValues and yValues list to format the data and print it to the csv file
            for(int i = 0; i < xValues.size(); i++){
                out.printf("%d,%.4f,\n", xValues.get(i), yValues.get(i));
            }

            //Inform the user if the creation of the file was successful
            System.out.println("File Creation Successful");

            //Close the PrintWriter object
            out.close();

        } catch (FileNotFoundException e) {

            //If a FileNotFoundException is thrown, catch it and inform the user of the error
            System.err.println("File Could Not Be Created: " + e.getMessage());
        }
    }

    /**
     * The createSaltedFile method creates a csv file called "SaltedFunction.csv" that holds the X and Y values of a
     * mathematical function that has had the y values changed in someway (salted).
     * @param xValues The ArrayList of x values that were used to with the function to calculate the y values
     * @param yValues The ArrayList of y values that were calculated using the function and changed by the salter
     */
    public void createSaltedFile(ArrayList<Integer> xValues, ArrayList<Double> yValues){

        //Using a try catch block due to chance of an exception being thrown
        try {

            //Create a PrintWriter object to handle copying the data into a file
            PrintWriter out = new PrintWriter("SaltedFunction.csv");

            //Create the header for the csv file so it knows how to categorize the data
            out.println("X,Y,");

            //Iterate through the xValues and yValues list to format the data and print it to the csv file
            for(int i = 0; i < xValues.size(); i++){
                out.printf("%d,%.4f,\n", xValues.get(i), yValues.get(i));
            }

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
