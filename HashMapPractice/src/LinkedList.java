import java.util.Iterator;

/**
 * The LinkedList class is responsible for creating and managing a linked list of items. This class can handle generic
 * types and has a nested class called the Node class, which manages each part of the linked list separately.
 * @param <E> A generic object, can accept any item
 * @author Rachel Hussmann
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    /**
     * The add method accepts a new item and adds it to the linked list.
     * @param item The object to be added to the list
     */
    public void add(E item) {

        //Create the new generic node
        Node<E> newNode = new Node<>(item);

        //Check to see if the head node is null
        if (head == null) {

            //If it is, then the newNode is now the head node
            head = newNode;
        } else {

            //If the head node is not null

            //Then create a temp node that will hold the information from the head node
            Node<E> temp = head;

            //Iterate through the linked list until we reach the end
            while (temp.next != null) {
                temp = temp.next;
            }

            //Once we reach the end of the list, add the previous node's next pointer to the newNode
            temp.next = newNode;
        }

        //Increase the size by one
        size++;
    }

    /**
     * The add method inserts a new node at the given index.
     * @param item The object to be added to the linked list
     * @param index The index to add the new item at
     */
    public void add(E item, int index) {

        //Create the new generic node
        Node<E> node = new Node(item);

        //Create the Node objects we will need to save objects as we change things
        Node<E> prevNode;
        Node<E> temp;

        //Check to see if the list is empty
        if (size == 0) {

            //If the linked list is empty

            //Set the new node as the head node and increment the size of the linked list by one
            node.next = head;
            head = node;
            size++;
        }else if(index == 0){

            //if the index is 0

            //Save the head node in the prevNode variable
            prevNode = head;

            //Set the new node as the head node
            head = node;

            //Update the .next pointer for the new head node
            node.next = prevNode;

            //Add one to the size variable
            size++;
        }else if (index > size) {

            //if the index is outside the bounds of the linked list

            //Throw an IndexOutOfBoundsException
            throw new IndexOutOfBoundsException();
        }else {

            //Else the item is being added at a non-edge case index

            //Set the temp node to be the head node
            temp = head;

            //Iterate through the .next pointers of the temp node until we reach the index the new Node needs to be
            // added at
            for(int x = 0; x < index-1; x++) {
                temp = temp.next;
            }

            //Set the new node's .next pointer to be the temp node's .next pointer
            node.next = temp.next;

            //Set the temp node's .next pointer to be the new node
            temp.next = node;

            //Add one to the size variable
            size++;
        }
    }

    /**
     * The remove method deletes the item at the specified index
     * @param index The index to of the Node to be deleted
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

            //Set the temp node to be the head node
            Node<E> temp = head;

            //Set the previous node to be the temp node
            Node<E> prevNode = temp;

            //Set the next node to be null
            Node<E> nextNode = null;

            //Check to see if the index is the head node
            if(index == 0) {

                //Then set the head node to be the head's .next pointer node
                head = temp.next;
            }else if(index == size) {

                //if the index is the same as the size of the linked list

                //Iterate through the linked list until we reach the end, keeping track of the previous node and the
                //current node
                for(int x = 0; x < index-1; x++) {
                    prevNode = temp;
                    temp = temp.next;
                }

                //Once we reach the end, set the previous node's .next pointer to null since we are removing the last
                //node
                prevNode.next = null;
            }else {

                //Else, the node is within the bounds of the linked list

                //Iterate through the list until we get to the index, keeping track of the current node, previous node
                //and next node
                for(int x = 0; x < index; x++) {
                    prevNode = temp;
                    temp = temp.next;
                    nextNode = temp.next;
                }

                //Since we are removing a node, set the previous node's .next pointer to the next node, which removes
                //the pointer from the object at this index
                prevNode.next = nextNode;

            }

            //Decrease the node
            size--;
        }
    }

    /**
     * The get method returns the item that is in the specified index of the list.
     * @param index The index of the object the user wants returned
     * @return The object at the specified index
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

            //Set the temp node as the head node and create a count node
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
     * @param index The index of the object to be changed
     * @param item The new item to be set at the specified index
     * @return The new object that has been set to the specified index
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

            //Set the temp node equal to the head node
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
     * The size method returns the current number of nodes in the linked list
     * @return The current number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * The iterator method is a method that comes from the Iterable<E> interface, that must be implemented when used.
     * This implementation of the iterator is to
     * @return The iterator object for the LinkedList class
     */
    @Override
    public Iterator<E> iterator() {

        //Returns a new Iterator object
        return new Iterator<E>() {

            //Create a Node that stores the current instance of a node in the where node
            //Set the where node equal to the head node
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
             * The next method captures that data from a node, returns it and moves down the list to the next node.
             * @return The object within the current node.
             */
            @Override
            public E next() {

                //Capture the data of the current node
                E item = where.data;

                //Move to the next node using the .next pointer
                where = where.next;

                //Return the data of the current node
                return item;
            }
        };
    }

    /**
     * The Node class is responsible for creating each collection of data for each part of the linked list.
     * @param <E> A generic, can accept any item
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
