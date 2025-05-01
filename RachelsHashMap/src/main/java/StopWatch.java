/**
 * The StopWatch class contains methods that keep track of how long it takes code to run.
 * @author Rachel Hussmann
 */
public class StopWatch {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;

    /**
     * Default Constructor for the StopWatch class
     */
    public StopWatch() {

        //Make sure that it starts at 0
        reset();
    }

    /**
     * The start method starts the stopwatch and begins counting how many milliseconds the code takes.
     */
    public void start() {

        //If the stopwatch is already running, ignore the start command
        if (isRunning) {
            return;
        }

        //Set the isRunning variable equal to true and start counting the number of milliseconds the program is taking
        isRunning = true;
        startTime = System.currentTimeMillis();
    }

    /**
     * The stop method stops that stopwatch and saves how long the program took into the elapsedTime variable.
     */
    public void stop() {

        //If the stopwatch is not running, ignore the stop command
        if (!isRunning) {
            return;
        }

        //Set the isRunning variable to false
        isRunning = false;

        //Mark the end time for the code
        long endTime = System.currentTimeMillis();

        //Save the time in the elapsedTime variable
        elapsedTime = elapsedTime + endTime - startTime;
    }

    /**
     * The getElapsedTime method returns how long the code took.
     * @return The amount of time the code took in milliseconds
     */
    public long getElapsedTime() {

        //Check to see if the stopwatch is running
        if (isRunning) {

            //If it is, give a snapshot of the current elapsed time
            long endTime = System.currentTimeMillis();
            return elapsedTime + endTime - startTime;
        } else {

            //If it is not, return the complete elapsedTime for the code
            return elapsedTime;
        }
    }

    /**
     * The reset method sets the StopWatch object back to its original state.
     */
    public void reset() {

        //Set everything back to default values
        elapsedTime = 0;
        isRunning = false;
    }
}
