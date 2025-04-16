import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The UniformDistribution class contains methods to calculate the probability of a random event, the expected value,
 * variance and the standard deviation.
 * @author Rachel Hussmann
 */
public class UniformDistribution {

    /**
     * The uniformDistribution method calculates the probability of an event occurring between two values, a and b,
     * where a is less than or equal to y less than or equal to b.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @param c The lower value of the probability question
     * @param d The higher value of the probability question
     * @return The probability of an event occurring based on a uniform distribution
     */
    public double uniformDistribution(int a, int b, int c, int d){

        //Check if a is larger than b
        if(a > b){

            //If it is, return 0 because that probability is not possible
            return 0;
        }

        //Check if c is larger than d
        if(c > d){

            //If it is, return 0 because that probability is not possible
            return 0;
        }

        //Otherwise, return d-c divided b-a
        return ((double)d-c) / (b-a);
    }

    /**
     * The uniformDistribution method calculates the probability of an event occurring between two values, a and b,
     * where a is less than or equal to y less than or equal to b.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @param c The lower value of the probability question
     * @param d The higher value of the probability question
     * @return The probability of an event occurring based on a uniform distribution
     */
    public BigDecimal uniformDistribution(BigInteger a, BigInteger b, BigInteger c, BigInteger d){

       //Check if a is larger than b
       if(a.compareTo(b) > 0){

           //If it is, return 0 because that probability is not possible
           return BigDecimal.ZERO;
       }

       //Check if c is larger than d
       if(c.compareTo(d) > 0){

           //If it is, return 0 because that probability is not possible
           return BigDecimal.ZERO;
       }

       //Create the BigDecimal object from the BigInteger objects to be able to perform the calculation
       BigDecimal aDecimal = new BigDecimal(a);
       BigDecimal bDecimal = new BigDecimal(b);
       BigDecimal cDecimal = new BigDecimal(c);
       BigDecimal dDecimal = new BigDecimal(d);

       //Create the numerator and denominator objects to easily calculate the answer
       BigDecimal numerator = dDecimal.subtract(cDecimal);
       BigDecimal denominator = bDecimal.subtract(aDecimal);

       //Return d-c / b-a
       return numerator.divide(denominator, 4, RoundingMode.UP);
    }

    /**
     * The expectedValue method calculated the expected value (mean) of the distribution.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @return The expected value (mean) of the distribution
     */
    public double expectedValue(int a, int b){
        return ((double) b+a)/2;
    }

    /**
     * The expectedValue method calculated the expected value (mean) of the distribution.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @return The expected value (mean) of the distribution
     */
    public BigDecimal expectedValue(BigInteger a, BigInteger b){

        //Create the BigDecimal objects from the BigInteger objects to be able to perform the calculations
        BigDecimal aDecimal = new BigDecimal(a);
        BigDecimal bDecimal = new BigDecimal(b);

        //Return a+b/2
        return aDecimal.add(bDecimal).divide(BigDecimal.TWO, 4, RoundingMode.UP);
    }

    /**
     * The variance method calculated the variance of the distribution.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @return The variance of the distribution
     */
    public double variance(int a, int b){
        return Math.pow(b-a, 2)/12;
    }

    /**
     * The variance method calculated the variance of the distribution.
     * @param a The lower constant of the uniform distribution
     * @param b The higher constant of the uniform distribution
     * @return The variance of the distribution
     */
    public BigDecimal variance(BigInteger a, BigInteger b){

        //Create the BigDecimal objects from the BigInteger objects to perform the calculations
        BigDecimal aDecimal = new BigDecimal(a);
        BigDecimal bDecimal = new BigDecimal(b);

        //Create the BigDecimal numerator and denominator for ease of calculation
        BigDecimal numerator = bDecimal.subtract(aDecimal).pow(2);
        BigDecimal denominator = BigDecimal.valueOf(12);

        //Return (b-a)^2/12
        return numerator.divide(denominator, 4, RoundingMode.UP);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the distribution.
     * @param variance The variance of the distribution
     * @return The standard deviation of the distribution
     */
    public double standardDeviation(double variance){
        return Math.sqrt(variance);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the distribution.
     * @param variance The variance of the distribution
     * @return The standard deviation of the distribution
     */
    public BigDecimal standardDeviation(BigDecimal variance){
        return variance.sqrt(MathContext.DECIMAL32);
    }

    /**
     * The testOutput method is used to test the methods that have been developed in this class.
     */
    public void testOutput(){

        //Using question 4.45 to test the methods
        System.out.println("Uniform distribution using a = 20, b = 25, c = 20, d = 22: " +
                uniformDistribution(20, 25, 20, 22));
        System.out.println("Expected value using a = 20 and b = 25: " +
                expectedValue(20, 25));
        System.out.println("Variance using a = 20 and b = 25: " + variance(20, 25));
        System.out.println("Standard deviation using a = 20 and b = 25: " + standardDeviation(variance(20,25)));

        System.out.println();

        System.out.println("Now using BigInteger and BigDecimal objects");

        //Using the same problem but testing with BigIntegers and BigDecimals
        BigInteger a = BigInteger.valueOf(20);
        BigInteger b = BigInteger.valueOf(25);
        BigInteger c = BigInteger.valueOf(20);
        BigInteger d = BigInteger.valueOf(22);

        System.out.println("Uniform distribution using a = 20, b = 25, c = 20, d = 22: " +
                uniformDistribution(a, b, c, d));
        System.out.println("Expected value using a = 20 and b = 25: " +
                expectedValue(a, b));
        System.out.println("Variance using a = 20 and b = 25: " + variance(a, b));
        System.out.println("Standard deviation using a = 20 and b = 25: " + standardDeviation(variance(a,b)));
        System.out.println();
    }

}
