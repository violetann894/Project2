import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The PoissonDistribution class contains methods that
 * @author Rachel Hussmann
 */
public class PoissonDistribution {

    /**
     * The poissonDistribution method calculates the probability of an event happening based on a Poisson
     * Probability Distribution
     * @param n The number of units
     * @param k The total number of events
     * @param scalar Scalar value for lambda
     * @param y The number of events that occur
     * @return The probability of the event occurring
     */
    public double poissonDistribution(int n, int k, int scalar, int y){

        double lambda = lambda(n, k, scalar);

        double numerator = Math.pow(lambda, y) * Math.pow(Math.E, -1*lambda);

        Factorial factorial = new Factorial();

        double denominator = factorial.factorial(y);

        return numerator/denominator;
    }

    /**
     * The poissonDistribution method calculates the probability of an event happening based on a Poisson
     * Probability Distribution
     * @param lambda The mean or variance of the Poisson Distribution
     * @param y The number of events that occur
     * @return The probability of the event occurring
     */
    public double poissonDistribution(double lambda, int y){
        double numerator = Math.pow(lambda, y)*Math.pow(Math.E, -lambda);

        Factorial factorial = new Factorial();

        double denominator = factorial.factorial(y);

        return numerator/denominator;
    }

    /**
     * The poissonDistribution method calculates the probability of an event happening based on a Poisson
     * Probability Distribution
     * @param n The number of units
     * @param k The total number of events
     * @param scalar Scalar value for lambda
     * @param y The number of events that occur
     * @return The probability of the event occurring
     */
    public BigDecimal poissonDistribution(BigInteger n, BigInteger k, BigInteger scalar, BigInteger y){

        BigDecimal lambda = lambda(n,k,scalar);

        BigDecimal numerator1 = lambda.pow(y.intValue());

        BigDecimal numerator2 = BigDecimal.valueOf(Math.pow(Math.E, -1*lambda.doubleValue()));

        Factorial factorial = new Factorial();

        BigInteger denominator = factorial.factorial(y);

        BigDecimal denominatorDecimal = new BigDecimal(denominator);

        return numerator1.multiply(numerator2).divide(denominatorDecimal, 3, RoundingMode.UP);
    }

    /**
     * The poissonDistribution method calculates the probability of an event happening based on a Poisson
     * Probability Distribution
     * @param lambda The mean or variance of the Poisson Distribution
     * @param y The number of events that occur
     * @return The probability of the event occurring
     */
    public BigDecimal poissonDistribution(BigDecimal lambda, BigInteger y){
        BigDecimal numerator1 = lambda.pow(y.intValue());

        BigDecimal numerator2 = BigDecimal.valueOf(Math.pow(Math.E, -1*lambda.doubleValue()));

        Factorial factorial = new Factorial();

        BigInteger denominator = factorial.factorial(y);

        BigDecimal denominatorDecimal = new BigDecimal(denominator);

        BigDecimal numerator = numerator1.multiply(numerator2);

        return numerator.divide(denominatorDecimal, 3, RoundingMode.UP);
    }

    /**
     * The lambda method finds the value of lambda for a Poisson distribution. Lambda is equal to the mean and variance
     * of the distribution, so this method can be used to find either.
     * @param n The number of units
     * @param k The total number of events
     * @param scalar Scalar value for lambda
     * @return The value of lambda
     */
    public double lambda(int n, int k, int scalar){
        return ((double) k/n)*scalar;
    }

    /**
     * The lambda method finds the value of lambda for a Poisson distribution. Lambda is equal to the mean and variance
     * of the distribution, so this method can be used to find either.
     * @param n The number of units
     * @param k The Total number of events
     * @param scalar Scalar value for lambda
     * @return The value of lambda
     */
    public BigDecimal lambda(BigInteger n, BigInteger k, BigInteger scalar){
        BigDecimal nDecimal = new BigDecimal(n);
        BigDecimal kDecimal = new BigDecimal(k);
        BigDecimal scalarDecimal = new BigDecimal(scalar);
        return kDecimal.divide(nDecimal, 3, RoundingMode.UP).multiply(scalarDecimal);
    }

    /**
     * The standardDeviation method finds the standard deviation of a Poisson Distribution.
     * @param lambda The mean or variance of the distribution
     * @return The standard deviation of the distribution
     */
    public double standardDeviation(double lambda){
        return Math.sqrt(lambda);
    }

    /**
     * The standardDeviation method finds the standard deviation of a Poisson Distribution.
     * @param lambda The mean or variance of the distribution
     * @return The standard deviation of the distribution
     */
    public BigDecimal standardDeviation(BigDecimal lambda){
        return lambda.sqrt(MathContext.DECIMAL32);
    }

    /**
     * The testOutput method is used to test the methods that have been developed in this class.
     */
    public void testOutput(){

        //Using problem 3.121 part a to test
        System.out.println("Poisson Distribution using lambda = 2 and y = 4: " + poissonDistribution(2.0, 4));
        System.out.println("Standard deviation of the distribution: " + standardDeviation(2.0));

        System.out.println("Poisson Distribution using lambda = 2, y = 4, BigInteger and BigDecimal: " +
                poissonDistribution(BigDecimal.valueOf(2.0), BigInteger.valueOf(4)));
        System.out.println("Standard deviation of distribution using BigDecimal: " +
                standardDeviation(BigDecimal.valueOf(2.0)));

        //Example Poisson distribution where lambada has not been calculated
        //Homework problem 3.128
        System.out.println("Poisson Distribution using k = 80, n = 60 and y = 0: " +
                poissonDistribution(60, 80, 1, 0));

        BigInteger n = BigInteger.valueOf(60);
        BigInteger k = BigInteger.valueOf(80);

        System.out.println("Poisson Distribution using k = 80, n = 60, y = 0 and BigInteger: " +
                poissonDistribution(n, k, BigInteger.ONE, BigInteger.ZERO));
    }

}
