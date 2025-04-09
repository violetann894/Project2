import java.util.ArrayList;
import org.jfree.chart.*;

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

    }

}
