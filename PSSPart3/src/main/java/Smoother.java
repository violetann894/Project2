import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.data.xy.XYDataset;
import java.util.ArrayList;

/**
 * The Smoother class is responsible for taking salted data and making it more understandable.
 * @author Rachel Hussmann
 */
public class Smoother {

    private ArrayList<Integer> xValues;
    private ArrayList<Double> yValues;

    /**
     * Additional constructor for the Smoother class
     * @param yValues The salted y values from the function
     */
    public Smoother(ArrayList<Double> yValues){
        this.xValues = new ArrayList<>();
        this.yValues = yValues;
    }

    /**
     * The smoothData method takes in salted values and finds the average of a set number of values to smooth the data.
     * @param windowValue The number of data points to be averaged to smooth the data
     */
    public void smoothData(int windowValue){

        //Create the temp ArrayLists that will hold the data
        ArrayList<Integer> tempXValue = new ArrayList<>();
        ArrayList<Double> tempYValue = new ArrayList<>();

        //Create a new DescriptiveStatistics object to calculate the rolling mean
        DescriptiveStatistics statistics = new DescriptiveStatistics();

        //Set the window size
        statistics.setWindowSize(windowValue);

        //Create a count variable to count how many values from yValues have been added to the DescriptiveStatistics
        //object
        int count = 0;

        //Iterate through the yValues
        for (Double yValue : yValues) {

            //Add them to the DescriptiveStatistics object
            statistics.addValue(yValue);

            //Check to see if the number of values is greater than the window value
            if (count >= windowValue) {

                //If it is, start calculating the rolling mean and add it to the tempYValues list
                tempYValue.add(statistics.getMean());
            }

            //Increment the count variable by one
            count++;
        }

        //Iterate through the number of tempYValues and add the indexes to the tempXValues list
        for(int i = 1; i <= tempYValue.size(); i++){
            tempXValue.add(i);
        }

        //Save the temp values to the instance variables
        xValues = tempXValue;
        yValues = tempYValue;
    }

    /**
     * The runSmoother method is responsible for running the smoothData method the number of times the user would like
     * and plotting the results of the smoothing.
     * @param windowValue The number of values to left and to the right of each value to average
     * @param numberOfRuns The number of times to run the smoothData method
     * @param width The width of the frame for the graph
     * @param height The height of the frame for the graph
     */
    public void runSmoother(int windowValue, int numberOfRuns, int width, int height){

        //Runs the smoothData method the user requested number of times
        for(int i = 0; i < numberOfRuns; i++){

            //Call the smoothData method
            smoothData(windowValue);
        }

        //Save the data that has been smoothed
        Plotter plotter = new Plotter();
        XYDataset data = plotter.createXYDataset(xValues, yValues, "Smoothed Function");
        plotter.plotXYData(data, "Smoothed Function", width, height);
    }
}
