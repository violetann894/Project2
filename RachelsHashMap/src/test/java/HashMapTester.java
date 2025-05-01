import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The HashMapTester is the tester class for the Maven project RachelsHashMap. It contains tester methods that test the
 * various methods within the RachelSimpleHashMap class including, add, remove, and contains.
 * @author Rachel Hussmann
 */
public class HashMapTester {

    /**
     * The valueAssociatedWithZero test method checks to see if the hashmap is properly hashing and indexing key value
     * pairs. The expected result from this test is 0.
     */
    @Test
    public void valueAssociatedWithZero(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(0, (int) intHashMap.get("Zero"));
    }

    /**
     * The valueAssociatedWithOne test method checks to see if the hashmap is properly hashing and indexing key value
     * pairs. The expected result from this test is 1.
     */
    @Test
    public void valueAssociatedWithOne(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(1, (int) intHashMap.get("One"));
    }

    /**
     * The valueAssociatedWithThree test method checks to see if the hashmap is properly hashing and indexing key value
     * pairs. The expected result from this test is 3.
     */
    @Test
    public void valueAssociatedWithThree(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(3, (int) intHashMap.get("Three"));
    }

    /**
     * The containsZero test method checks to see if the .contains method is working as expected.
     * The expected result is true.
     */
    @Test
    public void containsZero(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertTrue(intHashMap.contains("Zero"));
    }

    /**
     * The containsZeroDeleted test method checks to see if the .remove and .contains methods are working as expected.
     * The expected result is false.
     */
    @Test
    public void containsZeroDeleted(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        intHashMap.remove("Zero");
        assertFalse(intHashMap.contains("Zero"));
    }

    /**
     * The valueAssociatedWithAustin test method checks to see if the hashmap is properly hashing and indexing key value
     * pairs. This specific test is mainly to check and see if the hashmap is working as expected with objects.
     * The expected result from this test is "Pride and Prejudice".
     */
    @Test
    public void valueAssociatedWithAustin(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertEquals("Pride and Prejudice", bookHashMap.get("Austin").toString());
    }

    /**
     * The valueAssociatedWithShakespeare test method checks to see if the hashmap is properly hashing and indexing
     * key value pairs. This specific test is mainly to check and see if the hashmap is working as expected with objects.
     * The expected result from this test is "Hamlet".
     */
    @Test
    public void valueAssociatedWithShakespeare(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertEquals("Hamlet", bookHashMap.get("Shakespeare").toString());
    }

    /**
     * The containsAustin test method checks to see if the .contains method is working as expected. This is specifically
     * for generic objects, such as the Book class.
     * The expected result is true.
     */
    @Test
    public void containsAustin(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertTrue(bookHashMap.contains("Austin"));
    }

    /**
     * The containsAustinDeleted test method checks to see if the .remove and .contains methods are working as expected.
     * This is specifically for generic objects, such as the Book class.
     * The expected result is false.
     */
    @Test
    public void containsAustinDeleted(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        bookHashMap.remove("Austin");
        assertFalse(bookHashMap.contains("Austin"));
    }

}
