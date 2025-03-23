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

        //Create the ArrayLists to save the x and y values
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        //Create the variables that will be needed for the averaging process
        int xCount = 1;
        int averageCount = 1;
        double sum = 0.0;

        //Loop through the data
        for(double y : data){

            //Check if the averageCount variable is less than the windowValue times 2
            if(averageCount < windowValue*2){

                //If it is, then add the value of y to the sum and add one to the averageCount
                sum += y;
                averageCount++;
            }else{

                //Else, if the averageCount is greater than the windowValue times 2

                //Add the average of the sum and the averageCount variable to the yValues arraylist
                yValues.add(sum/averageCount);

                //Add the xCount to the xValues arraylist
                xValues.add(xCount);

                //Reset all the variables used for the averaging process
                averageCount = 1;
                xCount++;
                sum = 0.0;
            }
        }

        //Send the new smoothed data to the saveSmoothedFunction method
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
