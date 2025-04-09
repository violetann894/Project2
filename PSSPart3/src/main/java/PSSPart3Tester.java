import org.jfree.data.xy.XYDataset;
import java.util.ArrayList;

/**
 * The PSSPart3Tester class is responsible for testing the Function, Plotter, Salter and Smoother classes of the
 * PSSPart3 Project.
 * @author Rachel Hussmann
 */
public class PSSPart3Tester {
    public static void main(String[] args) {

        //Create the Function object to create the original graph
        Function function = new Function();
        function.logFunction(1, 1000, 500, 500);

        //Create the Salter object to salt the yValues
        Salter salter = new Salter();
        ArrayList<Double> saltedYValues = salter.addSalt(function.getYValues(), -100, 101);

        //Create the Plotter object to plot the salted yValues
        Plotter plotter = new Plotter();
        XYDataset data = plotter.createXYDataset(function.getXValues(), saltedYValues, "Salted Function");
        plotter.plotXYData(data, "Salted Function", 500, 500);

        //Create the Smoother object to smooth the yValues and plot them
        Smoother smoother = new Smoother(saltedYValues);
        smoother.runSmoother(250, 3, 500, 500);
    }
}
