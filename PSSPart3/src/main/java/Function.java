import org.jfree.data.xy.XYDataset;
import java.util.ArrayList;

/**
 * The Function class holds a method that calculates the answer to a mathematical function using x and y values and a
 * method that plots the x and y values.
 * @author Rachel Hussmann
 */
public class Function {

    private ArrayList<Integer> xValues;
    private ArrayList<Double> yValues;

    /**
     * Default Constructor for the Function class
     */
    public Function(){
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
    }

    /**
     * The logFunction method calculates the value of ln(x) and saves the x and y values into ArrayLists.
     * @param startingValue The starting x value (inclusive)
     * @param finishingValue The last x value (inclusive)
     * @param width The width for the graph
     * @param height The height for the graph
     */
    public void logFunction(int startingValue, int finishingValue, int width, int height){

        //Loop through the x values and save the x and y values
        for(int i = startingValue; i <= finishingValue; i++){
            xValues.add(i);
            yValues.add(Math.log(i));
        }

        //Create a Plotter object
        Plotter plotter = new Plotter();

        //Create the dataset and plot it
        XYDataset logData = plotter.createXYDataset(xValues, yValues, "Natural Log Function");

        //Plot the XY graph for the data
        plotter.plotXYData(logData, "Natural Log Function", width, height);
    }

    /**
     * Getter for the xValues variable
     * @return The ArrayList of x values from the function
     */
    public ArrayList<Integer> getXValues(){
        return xValues;
    }

    /**
     * Getter for the yValues variable
     * @return The ArrayList of y values from the function
     */
    public ArrayList<Double> getYValues(){
        return yValues;
    }
}
