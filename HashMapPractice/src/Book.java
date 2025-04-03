/**
 * The Book class is responsible for holding information about a book, such as the name. This class is used to test the
 * generic functionality of the LinkedList and RachelSimpleHashMap classes.
 * @author Rachel Hussmann
 */
public class Book {

    private String name;

    /**
     * Default constructor for the Book class
     * @param name
     */
    public Book(String name){
        this.name = name;
    }

    /**
     * The toString method converts the Book object into a string format by returning the name of the book.
     * @return The name of the Book
     */
    @Override
    public String toString(){
        return name;
    }

}
