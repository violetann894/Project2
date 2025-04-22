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

        //Create the ArrayLists to save the x and y values
        ArrayList<Integer> tempXValues = new ArrayList<>();
        ArrayList<Double> tempYValues = new ArrayList<>();

        //Initialize the xCount value to keep track of the x values
        int xCount = 1;

        //Outer for loop iterates through the salted dataset
        for(int i = 0; i < yValues.size(); i++){

            //Initialize the sum and average count needed to create the averaged values
            double sum = 0.0;
            int averageCount = 0;

            //First for loop adds up the values to the left of the current index and the current index
            for(int j = i - windowValue; j <= i; j++){

                //Check to see if the value is outside the range of the list
                if(j >= 0){

                    //If the value is within the bounds of the list, add it to the sum and increment the average count
                    sum += yValues.get(j);
                    averageCount++;
                }
            }

            //Second for loop adds up the right side values (excluding the current index because that was handled in
            //the first for loop)
            for(int j = i + 1; j <= i + windowValue; j++){

                //Check to see if the value is outside the range of the list
                if(j < yValues.size()){

                    ////If the value is within the bounds of the list, add it to the sum and increment the average count
                    sum += yValues.get(j);
                    averageCount++;
                }
            }

            //Add the current count of x to the tempXValues and increment the xCount variables by 1
            tempXValues.add(xCount);
            xCount++;

            //Add the average of the window to the tempYValues arraylist
            tempYValues.add(sum/averageCount);
        }

        //Clear out the xValues and yValues arraylists to copy the new values into them
        xValues.clear();
        xValues.addAll(tempXValues);
        yValues.clear();
        yValues.addAll(tempYValues);
    }

    /**
     * The saveSmoothedFunction method saves the x values and the smoothed y values into a .CSV file
     */
    public void saveSmoothedFunction(){
        //Create the exporter object
        Exporter exporter = new Exporter();

        //Call the createFile method to save the values in a csv file
        exporter.createFile(xValues, yValues, "SmoothedLogFunction.csv");
    }

    /**
     * The runSmoother method is responsible for running the smoothData method the number of times the user would like
     * and saving the results of the smoothing.
     * @param windowValue The number of values to left and to the right of each value to average
     * @param numberOfRuns The number of times to run the smoothData method
     */
    public void runSmoother(int windowValue, int numberOfRuns){

        //Runs the smoothData method the user requested number of times
        for(int i = 0; i < numberOfRuns; i++){

            //Call the smoothData method
            smoothData(windowValue);
        }

        //Save the data that has been smoothed
        saveSmoothedFunction();
    }
}
