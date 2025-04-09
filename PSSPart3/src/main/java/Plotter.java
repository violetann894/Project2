import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Plotter class is responsible for creating the dataset for the graph and creating and displaying the graph for
 * the user to see.
 * @author Rachel Hussmann
 */
public class Plotter {

    /**
     * The createXYDataset method creates the XYDataset needed to create the graph.
     * @param xValues The ArrayList of x values
     * @param yValues The ArrayList of y values
     * @param title The title for the graph / key for the series
     * @return The XYDataset object with the x and y values from the ArrayLists loaded in
     */
    public XYDataset createXYDataset(ArrayList<Integer> xValues, ArrayList<Double> yValues, String title){

        //Create the DefaultXYDataset to input the x and y values into
        DefaultXYDataset dataXY = new DefaultXYDataset();

        //Create the 2d array to store the x and y values
        double[][] xyValues = new double[2][xValues.size()];

        //Iterate through the x values, adding them to the first row of the 2d array
        for(int i = 0; i < xValues.size(); i++){
            xyValues[0][i] = xValues.get(i);
        }

        //Iterate through the y values, adding them to the second row of the 2d array
        for(int i = 0; i < yValues.size(); i++){
            xyValues[1][i] = yValues.get(i);
        }

        //Add the data to the DefaultXYDataset object along with the key for the series
        dataXY.addSeries(title, xyValues);

        //Return the DefaultXYDataset object
        return dataXY;
    }

    /**
     * The plotXYData method creates the chart, panel, and frame needed to display the chart to the user.
     * @param dataXY The XYDataset object with the x and y values loaded in
     * @param titleOfChart The title for the chart
     * @param width The width of the chart
     * @param height The height of the chart
     */
    public void plotXYData(XYDataset dataXY, String titleOfChart, int width, int height){

        //Used Baelbung "Introduction to JFreeChart" tutorial to assist with writing this code
        //Link: https://www.baeldung.com/jfreechart-visualize-data

        //Create the chart that will be used to place the x and y values on
        JFreeChart plot = ChartFactory.createXYLineChart(titleOfChart, "X Axis", "Y Axis", dataXY);

        //Create the panel needed to display the chart
        ChartPanel panel = new ChartPanel(plot);

        //Create the frame needed to display the ChartPanel object
        JFrame mainFrame = new JFrame();

        //Set the size of the frame
        mainFrame.setSize(width, height);

        //Set what should be displayed on the frame
        mainFrame.setContentPane(panel);

        //Allow the user to close the graph
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Allow the user to see the frame with the graph on it
        mainFrame.setVisible(true);
    }

}
