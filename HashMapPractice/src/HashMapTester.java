/**
 * The HashMapTester class is responsible for testing the methods within the RachelSimpleHashMap to see if they are
 * functioning as expected.
 * @author Rachel Hussmann
 */
public class HashMapTester {

    public static void main(String[] args) {

        //Create the intHashMap for testing
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();

        //Checking if methods work
        System.out.println("Adding new items to the hashmap . . .\n");
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        System.out.println("What value is associated with the key Zero: " + intHashMap.get("Zero"));
        System.out.println("What value is associated with the key One: " + intHashMap.get("One"));
        System.out.println("What value is associated with the key Three: " + intHashMap.get("Three") + "\n");
        System.out.println("What is the size of the HashMap: " + intHashMap.size() + "\n");
        System.out.println("Adding more new items to the hashmap . . . \n");
        intHashMap.add("Four", 4);
        intHashMap.add("Seven", 7);
        System.out.println(intHashMap.checkNumberOfCollisions());
        System.out.println("Does the hashmap contain the key Zero before deleting: " + intHashMap.contains("Zero") +
                "\n");
        System.out.println("Deleting key Zero . . .\n");
        intHashMap.remove("Zero");
        System.out.println("Does the hashmap contain the key Zero after deleting: " + intHashMap.contains("Zero") +
                "\n");


        //Checking if generic classes work
        System.out.println("Creating new hashmap . . . \n");
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Shakespeare", new Book("Romeo and Juliet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        System.out.println(bookHashMap.checkNumberOfCollisions());
    }

}
