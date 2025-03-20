/**
 * The FunctionCSVTester is the tester class for the Exporter and Function classes. It contains the main method to
 * run the methods called.
 * @author Rachel Hussmann
 */
public class FunctionCSVTester {

    public static void main(String[] args) {

        //Create the function object
        Function function = new Function();

        //Call the logFunction to calculate and save log values
        function.logFunction(1, 1000);
    }
}
