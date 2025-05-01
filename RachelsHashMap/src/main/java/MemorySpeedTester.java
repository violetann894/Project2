import java.util.ArrayList;

/**
 * The MemorySpeedTester is the class responsible for experimenting with RachelSimpleHashMap class by importing .csv
 * data of differing sizes and exporting a .txt file containing the number of collisions, the memory used and how long
 * the program took.
 * @author Rachel Hussmann
 */
public class MemorySpeedTester {
    public static void main(String[] args) {
        //Create the exporter and stopwatch object for future use
        Exporter exporter = new Exporter();
        StopWatch stopwatch = new StopWatch();

        //Start the stopwatch
        stopwatch.start();

        //Using HashMap with .csv data
        System.out.println("Creating new hashmap . . . \n");
        RachelSimpleHashMap<EmergencyCallEntry> entryHashMap = new RachelSimpleHashMap<>();

        //Create the importer object and import the 911 call entry data into EmergencyCallEntry objects
        Importer importer = new Importer();
        ArrayList<EmergencyCallEntry> entries =
                importer.importFile("\\C:\\Users\\Rache\\IdeaProjects\\Project2\\RachelsHashMap\\911OneSixthData.csv");

        //Iterate through all the EmergencyCallEntry and add them to the new hashmap
        for(EmergencyCallEntry entry : entries){
            entryHashMap.add(entry.getTwp(), entry);
        }

        //Check the number of collisions per index
        String data = entryHashMap.checkNumberOfCollisions();

        //Stop the stopwatch because we have finished the important parts of the program
        stopwatch.stop();

        //Create a runtime object to get the memory that has been used by the JVM during all the operations
        Runtime runtime = Runtime.getRuntime();
        double memoryUsed = (runtime.totalMemory() - runtime.freeMemory())/1048576.00;

        //Create the strings to add at the bottom of the .txt file for the memory used and the amount of time the
        //program took
        String stringMemoryUsed = "\nAmount of memory used: " + memoryUsed + " MB";
        String timeElapsed = "\nAmount of time elapsed: " + stopwatch.getElapsedTime() + " milliseconds";

        //Create the file with all the collision data, amount of memory used and the time the program took
        exporter.createFile("NumberOfCollisionsOneSixthsDataTEST.txt", data + stringMemoryUsed + timeElapsed);
    }
}
