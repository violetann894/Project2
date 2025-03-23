/**
 * The StatsLibraryTester class is used to test the classes contained within the StatsLibrary project for project 2.
 * @author Rachel Hussmann
 */
public class StatsLibraryTester {
    public static void main(String[] args) {
        PoissonDistribution pTester = new PoissonDistribution();
        TchebysheffsTheorem tTester = new TchebysheffsTheorem();

        pTester.testOutput();
        tTester.testOutput();
    }
}
