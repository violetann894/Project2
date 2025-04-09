import java.util.ArrayList;
import java.util.Random;

/**
 * The Salter class holds the method responsible for salting data that it is given, specifically the y values to a
 * computed function.
 * @author Rachel Hussmann
 */
public class Salter {

    /**
     * The addSalt method adds a random value to the y values to hide the original values.
     * @param yValues The ArrayList of y values calculated using the function and the x values
     * @param origin The origin of the random function (inclusive)
     * @param bound The upper bound of the random function (exclusive)
     * @return The yValues that have been salted
     */
    public ArrayList<Double> addSalt(ArrayList<Double> yValues, int origin, int bound){

        //Create the new random object
        Random random = new Random();

        //Iterate through the yValues, add the random number to the y value, and set the new y value to the same index
        //as the old one
        for(int i = 0; i < yValues.size(); i++){
            int randomNumber = random.nextInt(origin, bound);
            double numberToSalt = yValues.get(i);
            yValues.set(i, numberToSalt+randomNumber);
        }

        //Return the new yValues
        return yValues;
    }
}
