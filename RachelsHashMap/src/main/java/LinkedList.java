import java.util.Iterator;

/**
 * The LinkedList class is responsible for creating and managing a linked list of items. This class can handle generic
 * types and has a nested class called the Node class, which manages each part of the linked list separately.
 * @param <E> A generic object of any class
 * @author Rachel Hussmann
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    /**
     * The add method accepts a new item and adds it to the linked list.
     * @param item The generic object to be added to the list
     */
    public void add(E item) {

        //Create the new generic Node
        Node<E> newNode = new Node<>(item);

        //Check to see if the head Node is null
        if (head == null) {

            //If it is, then the newNode is now the head Node
            head = newNode;
        } else {

            //If the head Node is not null

            //Then create a temp Node that will hold the information from the head Node
            Node<E> temp = head;

            //Iterate through the linked list until we reach the end
            while (temp.next != null) {
                temp = temp.next;
            }

            //Once we reach the end of the list, add the previous Node's next pointer to the newNode
            temp.next = newNode;
        }

        //Increase the size by one
        size++;
    }

    /**
     * The add method inserts a new Node at the given index.
     * @param item The object to be added to the linked list
     * @param index The index to add the new Node at
     */
    public void add(E item, int index) {

        //Create the new generic Node
        Node<E> node = new Node(item);

        //Create the Node objects we will need to save objects as we change things
        Node<E> prevNode;
        Node<E> temp;

        //Check to see if the list is empty
        if (size == 0) {

            //If the linked list is empty

            //Set the new Node as the head Node and increment the size of the linked list by one
            node.next = head;
            head = node;
            size++;
        }else if(index == 0){

            //if the index is 0

            //Save the head Node in the prevNode variable
            prevNode = head;

            //Set the new Node as the head Node
            head = node;

            //Update the .next pointer for the new head Node
            node.next = prevNode;

            //Add one to the size variable
            size++;
        }else if (index > size) {

            //if the index is outside the bounds of the linked list

            //Throw an IndexOutOfBoundsException
            throw new IndexOutOfBoundsException();
        }else {

            //Else the item is being added at a non-edge case index

            //Set the temp Node to be the head Node
            temp = head;

            //Iterate through the .next pointers of the temp Node until we reach the index the new Node needs to be
            //added at
            for(int x = 0; x < index-1; x++) {
                temp = temp.next;
            }

            //Set the new Node's .next pointer to be the temp Node's .next pointer
            node.next = temp.next;

            //Set the temp Node's .next pointer to be the new Node
            temp.next = node;

            //Add one to the size variable
            size++;
        }
    }

    /**
     * The remove method deletes the Node at the specified index
     * @param index The index of the Node to be deleted
     */
    public void remove(int index) {

        //Check to see if the linked list is empty
        if(size == 0) {

            //If the linked list is empty, throw an exception because there are no values to remove
            throw new IndexOutOfBoundsException();
        }else if (index > size) {

            //If the index is outside the bounds of the linked list, throw an exception because there are no values
            //there
            throw new IndexOutOfBoundsException();
        }else {

            //Else, the index is within the bounds of linked list

            //Set the temp Node to be the head Node
            Node<E> temp = head;

            //Set the previous Node to be the temp Node
            Node<E> prevNode = temp;

            //Set the next Node to be null
            Node<E> nextNode = null;

            //Check to see if the index is the head Node
            if(index == 0) {

                //Then set the head Node to be the head's .next pointer Node
                head = temp.next;
            }else if(index == size) {

                //if the index is the same as the size of the linked list

                //Iterate through the linked list until we reach the end, keeping track of the previous Node and the
                //current Node
                for(int x = 0; x < index-1; x++) {
                    prevNode = temp;
                    temp = temp.next;
                }

                //Once we reach the end, set the previous Node's .next pointer to null since we are removing the last
                //Node
                prevNode.next = null;
            }else {

                //Else, the Node is within the bounds of the linked list

                //Iterate through the list until we get to the index, keeping track of the current Node, previous Node
                //and next Node
                for(int x = 0; x < index; x++) {
                    prevNode = temp;
                    temp = temp.next;
                    nextNode = temp.next;
                }

                //Since we are removing a Node, set the previous Node's .next pointer to the next Node, which removes
                //the pointer from the object at this index
                prevNode.next = nextNode;

            }

            //Decrease the Node
            size--;
        }
    }

    /**
     * The get method returns the item that is in the specified index of the list.
     * @param index The index of the object the user wants returned
     * @return The generic object at the specified index
     */
    public E get(int index) {

        //Check to see if the linked list is empty
        if (size == 0) {

            //if it is, throw an exception because you cannot get objects from an empty list
            throw new IndexOutOfBoundsException();
        }
        else if (index > size) {

            //if the index is out of the bounds of the linked list

            //Throw an exception, because we cannot get anything that is outside the linked list
            throw new IndexOutOfBoundsException();
        }
        else {

            //Else, the index is within the bounds of the linked list

            //Set the temp Node as the head Node and create a count Node
            Node<E> temp = head;

            //Iterate through the linked list until we reach the desired index
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }

            //Return the object at the requested index
            return temp.data;
        }
    }

    /**
     * The set method changes the object at the specified index.
     * @param index The index of the Node to be changed
     * @param item The new data to be set at the specified index
     * @return The data that has been replaced
     */
    public E set(int index, E item) {

        //Check to see if the linked list is empty
        if(size == 0) {

            //If it is empty, thrown an exception because we cannot set any values to an empty list
            throw new IndexOutOfBoundsException();
        }else if (index > size) {

            //if the index is outside the bounds of the linked list

            //Throw an exception, because we cannot set anything that is outside the linked list
            throw new IndexOutOfBoundsException();
        }else {

            //Else, the set index is within the bounds of the list

            //Set the temp Node equal to the head Node
            Node<E> temp = head;

            //Iterate over the list until we get to the desired index
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }

            //Set the current contents of the temp.data variable to the oldData variable
            E oldData = temp.data;

            //Set the temp.data equal to the new data
            temp.data = item;

            //Return the oldData that has been removed
            return oldData;
        }
    }

    /**
     * The size method returns the current number of Nodes in the linked list
     * @return The current number of Nodes in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * The iterator method is a method that comes from the Iterable interface, that must be implemented when used.
     * This implementation of the iterator is used to create a way for the class to use foreach loops and other
     * iteration based methods.
     * @return The Iterator object for the LinkedList class
     */
    @Override
    public Iterator<E> iterator() {

        //Returns a new Iterator object
        return new Iterator<E>() {

            //Create a Node that stores the current instance of a Node in the where variable
            //Set the where variable equal to the head Node
            private Node<E> where = head;

            /**
             * The hasNext method checks to see if the current Node has an object attached to the .next pointer by
             * checking to see if the .next object is null.
             * @return True - If the list does have a next element, False - If the list does not have a next element
             */
            @Override
            public boolean hasNext() {
                return where != null;
            }

            /**
             * The next method captures the data from a Node, returns it and moves down the list to the next Node.
             * @return The object within the current Node.
             */
            @Override
            public E next() {

                //Capture the data of the current Node
                E item = where.data;

                //Move to the next Node using the .next pointer
                where = where.next;

                //Return the data of the current Node
                return item;
            }
        };
    }

    /**
     * The Node class is responsible for creating each collection of data for each part of the linked list.
     * @param <E> A generic object, can accept any class
     * @author Rachel Hussmann
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * Constructor for the Node class
         * @param dataItem The data to be held within the Node
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
    }
}
