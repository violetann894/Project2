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

        int xCount = 1;

        for(int i = 0; i < yValues.size(); i++){
            double sum = 0.0;
            int averageCount = 0;

            for(int j = 1; j <= windowValue; j++){
                if(i-j >= 0){
                    sum += yValues.get(i-j);
                    averageCount++;
                }
            }

            for(int j = 1; j <= windowValue; j++){
                if(i+j < yValues.size()){
                    sum += yValues.get(i+j);
                    averageCount++;
                }
            }

            tempXValues.add(xCount);
            xCount++;
            tempYValues.add(sum/averageCount);
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
