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

            //First for loop adds up the left side values and the current i value
            for(int j = 1; j <= windowValue; j++){

                //Check to see if the value is outside the range of the list
                if(i-j >= 0){

                    //If the value is within the bounds of the list, add it to the sum and increment the average count
                    sum += yValues.get(i-j);
                    averageCount++;
                }
            }

            //Second for loop adds up the right side values
            for(int j = 1; j <= windowValue; j++){

                //Check to see if the value is outside the range of the list
                if(i+j < yValues.size()){

                    //
                    sum += yValues.get(i+j);
                    averageCount++;
                }
            }

            //If the value is within the bounds of the list, add it to the sum and increment the average count
            tempXValues.add(xCount);
            xCount++;
            tempYValues.add(sum/averageCount);
        }

        //clear out the xValues and yValues arraylists to copy the new values into them
        xValues.clear();
        xValues.addAll(tempXValues);
        yValues.clear();
        yValues.addAll(tempYValues);
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

    }
}
