package lists;

/**
 * ******************************
 * Project: Data Structures
 * Creator: Daniel Papanek
 * Date :   1/21/2016
 * ******************************
 **/
public class Stack<Type> extends AbstractList<Type> {
    // declare head of list and length
    private Node head;
    private int length;

    // constructor
    public Stack() {
        //initialize variables
        head = null;
        length = 0;
    }

    /**
     * Check if the stack is empty
     *
     * @return boolean isEmpty
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retrieve the first element of the stack without removing it
     *
     * @return First element of the stack
     */
    public Type peek() {
        return head.data;
    }

    /**
     * Remove the first element from the stack
     *
     * @return First element
     */
    public Type pop() {
        // store the heads data
        Type data = head.data;
        //remove head
        head = head.next;
        length--;
        return data;
    }

    /**
     * Push a element onto the stack
     *
     * @param data element to be added
     */
    public void push(Type data) {
        head = new Node(data, head);
        length++;
    }

    /**
     * Searches the stack for a element
     *
     * @param data Element to be searched
     * @return Index of the element, -1 if no element
     */
    public int search(Type data) {
        int index = 0;
        Node current = head;
        //loop through stack
        while (current != null) {
            // if data is found return index
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        // no data found, -1
        return -1;
    }
}
