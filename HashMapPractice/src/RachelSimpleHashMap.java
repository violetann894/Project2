/**
 * The RachelSimpleHashMap class is responsible for creating and managing a hashmap with our own simple hashing
 * algorithm.
 * @author Rachel Hussmann
 */
public class RachelSimpleHashMap<E>{

    //Array of linkedlists
    private LinkedList[] data;
    private int size;


    /**
     * Default constructor for the RachelSimpleHashMap class
     */
    public RachelSimpleHashMap(){
        data = new LinkedList[5];
    }

    /**
     * The add method adds a key and an item to the hashmap
     * @param key The key value that will be hashed and used to find the item
     * @param item The object or data to be stored
     */
    public void add(String key, E item){

        //
        Object[] keyAndData = new Object[2];

        //
        keyAndData[0] = key;
        keyAndData[1] = data;

        //
        int hash = dumbHash(key);

        //
        if(hash > data.length){

            //
            while (hash > data.length){

                //
                resize();
            }
        }

        //
        if(data[hash] == null){

            //

            //
            data[hash] = new LinkedList<>();
        }

        //
        data[hash].add(keyAndData);
        size++;
    }

    /**
     *
     * @return
     */
    public E get(String key){
        int hash = dumbHash(key);

        checkBounds(hash);

        return (E)data[hash].get(0);
    }

    /**
     * The remove method removes a key and value from the hashmap.
     * @param key The key value that will be hashed and used to find the item
     */
    public void remove(String key){
        int hash = dumbHash(key);

        checkBounds(hash);

        if(data[hash] == null){
            System.err.println("Error: No element to remove, linked list is null.");
        }else if(data[hash].size() == 0){
            System.err.println("Error: No element to remove, linked list is empty");
        }else{
            LinkedList<E> list = data[hash];
            for(int i = 0; i < list.size(); i++){
                if(list.get())
            }
        }

        size--;
    }

    /**
     * The size method returns the number of arrays in the linked list.
     * @return The size of the linked list
     */
    public int size(){
        return size;
    }

    /**
     * The isEmpty method checks to see if the hashmap is empty.
     * @return True - If the hashmap is empty, False - If the hashmap is not empty
     */
    public Boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     */
    // Have this method print out the number of collision for each index of the hashmap
    public void checkNumberOfCollision(){

    }

    /**
     *
     * @param key
     * @return
     */
    public int dumbHash(String key) {
        return key.length();
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {

        int hash = key.length();



        return false;
    }

    /**
     *
     * @param hash
     */
    public void checkBounds(int hash){
        if(hash > data.length){
            throw new IndexOutOfBoundsException();
        }
    }


    /**
     *
     */
    public void resize() {

        //
        int size = data.length;

        //
        LinkedList[] temp = data;

        //
        data = new LinkedList[size*2];

        //
        for(int i = 0; i < size; i++){

            //
            data[i] = temp[i];
        }
    }
}
