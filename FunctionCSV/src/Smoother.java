import java.util.ArrayList;

/**
 * The Smoother class is responsible for taking salted data and making it more understandable.
 * @author Rachel Hussmann
 */
public class Smoother {

    /**
     * The smoothData method takes in salted values and finds the average of a set number of values to smooth the data.
     * @param data The data that needs to be smoothed
     * @param windowValue The number of data points to be averaged to smooth the data
     */
    public void smoothData(ArrayList<Double> data, int windowValue){

        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        int xCount = 1;

        for(int i = windowValue-1; i < data.size(); i+=windowValue*2){


        }

        saveSmoothedFunction(xValues, yValues);
    }

    /**
     * The saveSmoothedFunction method saves the x values and the smoothed y values into a .CSV file
     * @param xValues The x values of the function
     * @param yValues The smoothed y values of the function
     */
    public void saveSmoothedFunction(ArrayList<Integer> xValues, ArrayList<Double> yValues){
        //Create the exporter object
        Exporter exporter = new Exporter();

        //Call the createFile method to save the values in a csv file
        exporter.createFile(xValues, yValues, "SmoothedLogFunction.csv");
    }
}
