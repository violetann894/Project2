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
    public double tchebysheffsTheorem(int lowerBound, int upperBound, int SD, int mean){
        //First we need to find k
        double k = 0;

        //Check the inbetween values
        int inBetweenLower = mean - lowerBound;
        int inBetweenUpper = upperBound - mean;

        //Make sure they are the same
        if(inBetweenLower == inBetweenUpper){
            k = (double) inBetweenLower /SD;
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
     * The tchebysheffsTheorem method finds the percentage of data that is between two points.
     * @param lowerBound The lower value in the range of data
     * @param upperBound The higher value in the range of data
     * @param SD The standard deviation of the data
     * @param mean The mean (or expected value) of the data
     * @return The percentage of data that is between the two bounds given
     */
    public double tchebysheffsTheorem(double lowerBound, double upperBound, double SD, double mean){
        //First we need to find k
        double k = 0;

        //Check the inbetween values
        double inBetweenLower = mean - lowerBound;
        double inBetweenUpper = upperBound - mean;

        //Make sure they are the same
        if(inBetweenLower == inBetweenUpper){
            k = (double) inBetweenLower /SD;
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

        //Using example 3.28 from the book (answer should be 3/4 or .75)
        System.out.println("Using Tchebysheff's Theorem (Integers): " + tchebysheffsTheorem(16,24,2,20));
        System.out.println();

        //Using problem 3.170 from the book (Answer should be 3/4 or .75)
        System.out.println("Using Tchebysheff's Theorem (Double): " + tchebysheffsTheorem(.48, .52, .01, .5));

    }

}
