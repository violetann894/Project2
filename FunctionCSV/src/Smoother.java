import java.util.ArrayList;

/**
 * The Smoother class is responsible for taking salted data and making it more understandable.
 * @author Rachel Hussmann
 */
public class Smoother {

    private ArrayList<Integer> xValues;
    private ArrayList<Double> yValues;

    /**
     *
     * @param yValues
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

        //Create the variables that will be needed for the averaging process
        int xCount = 1;
        int averageCount = 1;
        double sum = 0.0;

        //Loop through the data
        for(double y : yValues){

            //Check if the averageCount variable is less than the windowValue times 2
            if(averageCount < windowValue*2){

                //If it is, then add the value of y to the sum and add one to the averageCount
                sum += y;
                averageCount++;
            }else{

                //Else, if the averageCount is greater than the windowValue times 2

                //Add the average of the sum and the averageCount variable to the yValues arraylist
                tempYValues.add(sum/averageCount);

                //Add the xCount to the xValues arraylist
                tempXValues.add(xCount);

                //Reset all the variables used for the averaging process
                averageCount = 1;
                xCount++;
                sum = 0.0;
            }
        }

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
     *
     * @param windowValue
     * @param numberOfRuns
     */
    public void runSmoother(int windowValue, int numberOfRuns){
        for(int i = 0; i < numberOfRuns; i++){
            smoothData(windowValue);
        }

        saveSmoothedFunction();
    }
}
