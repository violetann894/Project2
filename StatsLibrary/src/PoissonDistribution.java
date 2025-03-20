import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The PoissonDistribution class contains methods that calculate the probability of en event based on a
 * Poisson Probability Distribution.
 * @author Rachel Hussmann
 */
public class PoissonDistribution {

    /**
     *
     * @param n
     * @param k
     * @param scalar
     * @param y
     * @return
     */
    public double poissonDistribution(int n, int k, int scalar, int y){

    }

    /**
     *
     * @param n
     * @param k
     * @param scalar
     * @param y
     * @return
     */
    public BigDecimal poissonDistribution(BigInteger n, BigInteger k, BigInteger scalar, BigInteger y){

    }

    /**
     * The lambda method finds the value of lambda for a Poisson distribution. Lambda is equal to the mean and variance
     * of the distribution, so this method can be used to find either.
     * @param n The number of units
     * @param k The Total number of events
     * @param scalar Scalar value for lambda
     * @return The value of lambda
     */
    public double lambda(int n, int k, int scalar){
        return (double) (k/n)*scalar;
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
        return kDecimal.divide(nDecimal, 3, RoundingMode.UNNECESSARY).multiply(scalarDecimal);
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
     *
     */
    public void tester(){

    }

}
