/**
 * The TchebysheffsTheorem class holds methods that handle and test Tchebysheff's theorem.
 * @author Rachel Hussmann
 */
public class TchebysheffsTheorem {

    /**
     * The tchebysheffsTheorem method finds the percentage of data that is between two points.
     * @param lowerBound The lower value in the range of data
     * @param upperBound The higher value in the range of data
     * @param SD The standard deviation of the data
     * @param mean The mean (or expected value) of the data
     * @return The percentage of data that is between the two bounds given
     */
    public double tchebysheffsTheorem(int lowerBound, int upperBound, double SD, int mean){
        //First we need to find k
        double k = 0;

        //Check the inbetween values
        int inBetweenLower = mean - lowerBound;
        int inBetweenUpper = upperBound - mean;

        //Make sure they are the same
        if(inBetweenLower == inBetweenUpper){
            k = inBetweenLower/SD;
        }

        //Check if k is greater than 1
        if(k > 1){

            //If it is, use the 1 - 1/k^2 formula to calculate the percentage
            return 1 - 1/Math.pow(k,2);
        }else{

            //If it isn't, use the 1/k^2 formula to calculate the percentage
            return 1/Math.pow(k,2);
        }
    }

    /**
     * The testOutput method tests the methods held within the class
     */
    public void testOutput(){

    }

}
