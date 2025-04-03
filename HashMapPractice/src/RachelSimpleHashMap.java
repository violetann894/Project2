/**
 * The RachelSimpleHashMap class is responsible for creating and managing a hashmap with our own simple hashing
 * algorithm.
 * @author Rachel Hussmann
 */
public class RachelSimpleHashMap<E>{

    private LinkedList<KeyValuePair>[] data;
    private int size;


    /**
     * Default constructor for the RachelSimpleHashMap class
     */
    public RachelSimpleHashMap(){
        data = new LinkedList[5];
    }

    /**
     * KeyValuePair is an inner class used to hold key-value pairs
     */
    private class KeyValuePair{

        private String key;
        private E data;

        /**
         * Constructor for the KeyValuePair class
         * @param key The key for the pair
         * @param data The data associated with the pair
         */
        public KeyValuePair(String key, E data){
            this.key = key;
            this.data = data;
        }
    }

    /**
     * The add method adds a key and an item to the hashmap
     * @param key The key value that will be hashed and used to find the item
     * @param item The object or data to be stored
     */
    public void add(String key, E item){

        //Create the new key value pair since we are adding a new object
        KeyValuePair keyAndData = new KeyValuePair(key, item);

        //Create the hash
        int hash = dumbHash(key);

        //Check to see if the hash index is greater than the length of the array
        if(hash >= data.length){

            //if the hash index is greater than the array

            //Resize the array until the index will fit
            while (hash >= data.length){
                resize();
            }
        }

        //Check to see if the linked list is null
        if(data[hash] == null){

            //If it is null, create a new linked list
            data[hash] = new LinkedList<>();
        }

        //Add the key value pair to the linked list of that hash
        data[hash].add(keyAndData);

        //Increment the size by one
        size++;
    }

    /**
     * The get method returns the data associated with a key.
     * @param key The key value for the desired object
     * @return The object associated with the given key
     */
    public E get(String key){

        //Create the hash for the key
        int hash = dumbHash(key);

        //Create a variable to hold the value if we find it
        E wantedData = null;

        //Check if the hash is outside the bounds of the list
        checkBounds(hash);

        //Check if the linked list is null
        if(data[hash] == null){

            //If it is, let the user know that the linked list is null
            System.err.println("Error: No element to get, linked list is null.");
        }else if(data[hash].size() == 0){

            //Else if, check if the linked list is empty

            //If it is, let the user know that the linked list is empty
            System.err.println("Error: No element to get, linked list is empty");
        }else{

            //Grab the LinkedList from the array
            LinkedList<KeyValuePair> list = data[hash];

            //Iterate through the key value pairs to find the key
            for(KeyValuePair kvp : list){

                //Check to see if the key is in the linked list
                if(kvp.key.equalsIgnoreCase(key)){

                    //If it is, set the data of that key value pair to the wantedData variable
                    wantedData = kvp.data;
                }
            }
        }

        //Return the desired data
        return wantedData;
    }

    /**
     * The remove method removes a key and value from the hashmap.
     * @param key The key value that will be hashed and used to find the item
     */
    public void remove(String key){

        //Create the hash for the key
        int hash = dumbHash(key);

        //Check if the hash is outside the bounds of the list
        checkBounds(hash);

        //Check if the linked list is null
        if(data[hash] == null){

            //If it is, let the user know that the linked list is null
            System.err.println("Error: No element to remove, linked list is null.");
        }else if(data[hash].size() == 0){

            //Else if, check if the linked list is empty

            //If it is, let the user know that the linked list is empty
            System.err.println("Error: No element to remove, linked list is empty");
        }else{

            //Grab the LinkedList from the array
            LinkedList<KeyValuePair> list = data[hash];

            //Iterate through the key value pairs to find if the key is in the linked list
            for(int i = 0; i < list.size(); i++){

                //Grab the key value pair for the index
                KeyValuePair temp = list.get(i);

                //Check to see if temp variable is the key value pair to delete
                if(temp.key.equalsIgnoreCase(key)){

                    //If it is, remove it using the linked list's remove method
                    list.remove(i);
               }
            }
        }

        //Remove one from the size variable
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
        return size == 0;
    }

    /**
     * The checkNumberOfCollisions prints out the structure of the Hashmap with the number of collisions next to it.
     * @return A string of the HashMap structure with the number of collisions in the string
     */
    public String checkNumberOfCollisions(){

        //Create the string that will hold the contents of the hashmap
        String contentsOfHashMap = "";

        //Iterate over the entire hashmap
        for(int i = 0; i < data.length; i++){

            //Create a variable to count the number of key value pairs in each linked list
            int numberOfKeyValuePairs = 0;

            //Check if the specific linked list at the index is null
            if(data[i] != null) {

                //If it isn't, continue with the process

                //Add the to string the index of the linked list
                contentsOfHashMap = contentsOfHashMap.concat("Linked List at index " + i + ": ");

                //Iterate over the linked list
                for (KeyValuePair kvp : data[i]) {

                    //Add each key value pair to the string
                    contentsOfHashMap = contentsOfHashMap.concat("\n[" + kvp.key + ", " + kvp.data + "]");

                    //Increment the number of key value pairs in the linked list
                    numberOfKeyValuePairs++;
                }

                //Add to the string the number of collisions that happened at that index
                contentsOfHashMap = contentsOfHashMap.concat("\nNumber of collisions: " +
                        (numberOfKeyValuePairs - 1) + "\n\n");

            }
        }

        //Return the completed string of the hashmap structure and collisions
        return contentsOfHashMap;
    }

    /**
     * The dumbHash method take a key value and hashes it but returning the number of characters in the string.
     * @param key The key to be hashed
     * @return The hashed key (the number of characters in the key)
     */
    public int dumbHash(String key) {
        return key.length();
    }

    /**
     * The contains method checks to see if a key exists in the HashMap.
     * @param key The key value to check if it is in the HashMap
     * @return True - If the key was found in the HashMap, False - If the key was not found in the HashMap
     */
    public boolean contains(String key) {

        //Create the hash for the key
        int hash = dumbHash(key);

        //Check if the hash is outside the bounds of the list
        checkBounds(hash);

        //Check if the linked list is null or empty
        if(data[hash] == null || data[hash].size() == 0){

            //If it is, return false because the key cannot be in a null or empty list
            return false;

        }else{

            //Grab the LinkedList from the array
            LinkedList<KeyValuePair> list = data[hash];

            //Iterate through the key value pairs to find the key
            for(KeyValuePair kvp : list){

                //Check to see if the key is in the linked list
                if(kvp.key.equalsIgnoreCase(key)){

                    //If the key value was found, return true
                    return true;
                }
            }
        }

        //Return false, because the value was never found
        return false;
    }

    /**
     * The checkBounds method checks to see if the hash is larger than the size of the hashmap.
     * @param hash The hashed key value
     */
    public void checkBounds(int hash){
        if(hash >= data.length){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * The resize method dynamically resizes the array when the array needs to expand.
     */
    public void resize() {

        //Capture the current size of the array
        int size = data.length;

        //Save the array in a temp variable
        LinkedList<KeyValuePair>[] temp = data;

        //Create a new array with double the size of the previous array
        data = new LinkedList[size*2];

        //Iterate through the list to copy the array values back
        for(int i = 0; i < size; i++){
            data[i] = temp[i];
        }
    }

}
