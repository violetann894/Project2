import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The HashMapTester is the tester class for the Maven project RachelsHashMap. It contains tester methods that test the
 * various methods within the RachelSimpleHashMap class including, add, remove, and contains.
 * @author Rachel Hussmann
 */
public class HashMapTester {

    @Test
    public void valueAssociatedWithZero(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(0, (int) intHashMap.get("Zero"));
    }

    @Test
    public void valueAssociatedWithOne(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(1, (int) intHashMap.get("One"));
    }

    @Test
    public void valueAssociatedWithThree(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertEquals(3, (int) intHashMap.get("Three"));
    }

    @Test
    public void containsZero(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        assertTrue(intHashMap.contains("Zero"));
    }

    @Test
    public void containsZeroDeleted(){
        RachelSimpleHashMap<Integer> intHashMap = new RachelSimpleHashMap<>();
        intHashMap.add("Zero", 0);
        intHashMap.add("One", 1);
        intHashMap.add("Three", 3);
        intHashMap.remove("Zero");
        assertFalse(intHashMap.contains("Zero"));
    }


    @Test
    public void valueAssociatedWithAustin(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertEquals("Pride and Prejudice", bookHashMap.get("Austin").toString());
    }

    @Test
    public void valueAssociatedWithShakespeare(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertEquals("Hamlet", bookHashMap.get("Shakespeare").toString());
    }

    @Test
    public void containsAustin(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        assertTrue(bookHashMap.contains("Austin"));
    }

    @Test
    public void containsAustinDeleted(){
        RachelSimpleHashMap<Book> bookHashMap = new RachelSimpleHashMap<>();
        bookHashMap.add("Shakespeare", new Book("Hamlet"));
        bookHashMap.add("Austin", new Book("Pride and Prejudice"));
        bookHashMap.remove("Austin");
        assertFalse(bookHashMap.contains("Austin"));
    }

}
