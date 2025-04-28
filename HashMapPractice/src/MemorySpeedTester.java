import java.util.ArrayList;

/**
 * The MemorySpeedTester is the class responsible for experimenting with RachelSimpleHashMap class by importing .csv
 * data of differing sizes and exporting a .txt file containing the number of collisions, the memory used and how long
 * the program took.
 * @author Rachel Hussmann
 */
public class MemorySpeedTester {
    public static void main(String[] args) {
        //Using HashMap with .csv data
        System.out.println("Creating new hashmap . . . \n");
        RachelSimpleHashMap<EmergencyCallEntry> entryHashMap = new RachelSimpleHashMap<>();
        Importer importer = new Importer();
        ArrayList<EmergencyCallEntry> entries =
                importer.importFile("\\C:\\Users\\Rache\\IdeaProjects\\Project2\\HashMapPractice\\911Data.csv");
        for(EmergencyCallEntry entry : entries){
            entryHashMap.add(entry.getTwp(), entry);
        }
        Exporter exporter = new Exporter();
        StopWatch stopwatch = new StopWatch();

        stopwatch.start();
        String data = entryHashMap.checkNumberOfCollisions();
        stopwatch.stop();

        Runtime runtime = Runtime.getRuntime();
        double memoryUsed = (runtime.totalMemory() - runtime.freeMemory())/1048576.00;
        String stringMemoryUsed = "\nAmount of memory used: " + memoryUsed + " MB";

        String timeElapsed = "\nAmount of time elapsed: " + stopwatch.getElapsedTime() + " seconds";

        exporter.createFile("NumberOfCollisions.txt", data + stringMemoryUsed + timeElapsed);
    }
}
