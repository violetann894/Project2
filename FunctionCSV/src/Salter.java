import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Salter {

    /**
     *
     * @param yValues
     * @return
     */
    public ArrayList<Double> addSalt(ArrayList<Double> yValues){
        Random random = new Random();

        for(int i = 0; i < yValues.size(); i++){
            int randomNumber = random.nextInt(-500, 501);
            double numberToSalt = yValues.get(i);
            yValues.set(i, numberToSalt+randomNumber);
        }

        return yValues;
    }

}
