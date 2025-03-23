import java.util.ArrayList;

/**
 * The Function class holds a method that calculates the answer to a mathematical function using x and y values and a
 * method that saves the x and y values.
 * @author Rachel Hussmann
 */
public class Function {

    /**
     * The logFunction method calculates the value of ln(x) and saves the x and y values into ArrayLists.
     * @param startingValue The starting x value (inclusive)
     * @param finishingValue The last x value (inclusive)
     * @param origin The origin of the random function (inclusive)
     * @param bound The upper bound of the random function (exclusive)
     */
    public void logFunction(int startingValue, int finishingValue, int origin, int bound){

        //Create the ArrayLists that will hold the x and y values
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        //Loop through the x values and save the x and y values
        for(int i = startingValue; i <= finishingValue; i++){
            xValues.add(i);
            yValues.add(Math.log(i));
        }

        //Call the saveFunction and saveSaltedFunction method to save the x and y values in a csv file
        saveFunction(xValues, yValues);
        saveSaltedFunction(xValues, yValues, origin, bound);
    }

    /**
     * The saveFunction method creates an Exporter object and saves the x and y values from the function that was
     * calculated.
     * @param xValues The ArrayList of x values from the function
     * @param yValues The ArrayList of y values calculated using the function and the x values
     */
    public void saveFunction(ArrayList<Integer> xValues, ArrayList<Double> yValues){

        //Create the exporter object
        Exporter exporter = new Exporter();

        //Call the createFile method to save the values in a csv file
        exporter.createFile(xValues, yValues);
    }

    /**
     * The saveSaltedFunction method creates an Exporter object, salts the y values, and saves the x and y values
     * from the function that was calculated.
     * @param xValues The ArrayList of x values from the function
     * @param yValues The ArrayList of y values calculated using the function and the x values
     * @param origin The origin of the random function (inclusive)
     * @param bound The upper bound of the random function (exclusive)
     */
    public void saveSaltedFunction(ArrayList<Integer> xValues, ArrayList<Double> yValues, int origin, int bound){

        //Create the exporter object
        Exporter exporter = new Exporter();

        //Create the salter object
        Salter salter = new Salter();

        //Salt the yValues data
        ArrayList<Double> saltedYValues = salter.addSalt(yValues, origin, bound);

        //Call the createFile method to save the values in a csv file
        exporter.createSaltedFile(xValues, saltedYValues);
    }
}
