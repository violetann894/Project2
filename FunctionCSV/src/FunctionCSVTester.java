import java.util.ArrayList;

/**
 * The FunctionCSVTester is the tester class for the Exporter and Function classes. It contains the main method to
 * run the methods called.
 * @author Rachel Hussmann
 */
public class FunctionCSVTester {

    public static void main(String[] args) {

        //Create the function object
        Function function = new Function();

        //Call the logFunction method to calculate and save log values
        function.logFunction(1, 1000, -500, 501);

        //Create the importer object
        Importer importer = new Importer();

        //Import the SaltedLogFunction.csv to smooth it
        ArrayList<Double> importedData =
                importer.importFile("C:\\Users\\Rache\\IdeaProjects\\Project2\\SaltedLogFunction.csv");

        //Create the smoother object
        Smoother smoother = new Smoother();

        //Call the smoothData method to save the smoothed data
        smoother.smoothData(importedData, 5);
    }
}
