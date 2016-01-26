/**
 * ******************************
 * Project: Data Structures
 * Creator: Daniel Papanek
 * Date :   1/21/2016
 * ******************************
 **/
public class LinkedList<Type> {
    // private inner class node
    private class Node {
        private Type data;
        private Node next;

        Node(Type data) {
            this.data = data;
            this.next = null;
        }

        Node(Type data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // declare head, and length
    private Node head;
    private int length;

    // constructor
    public LinkedList() {
        head = null;
        length = 0;
    }

    /**
     * Print the contents of the linked list
     */
    public void print() {
        // calls private print method which takes a node for recursion
        print(head);
    }

    /**
     * Prints a linked list starting from the node given
     *
     * @param node Node to start from
     */
    private void print(Node node) {
        // base case, once end is reached
        if (node == null) {
            return;
        }
        // print node data
        System.out.print(node.data + " | ");
        //print the next node
        print(node.next);
    }

    /**
     * Prints the linked list in reverse order
     */
    public void reversePrint() {
        // calls private reversePrint method for recursion
        reversePrint(head);
    }

    /**
     * Prints a given linked list in reverse
     *
     * @param node Any node of the list
     */
    private void reversePrint(Node node) {
        // base case, end of linked list reached
        if (node == null) {
            return;
        }
        // call reverse print before printing to reach end first
        reversePrint(node.next);
        // print out the data
        System.out.print(" | " + node.data);
    }

    /**
     * Add data element to the start of the linked list
     *
     * @param data Element to be added
     */
    public void prepend(Type data) {
        head = new Node(data, head);
        length++;
    }

    /**
     * Add data element to the end of the linked list
     *
     * @param data Element to be added
     */
    public void append(Type data) {
        // if empty list add data at front
        if (head == null) {
            prepend(data);
            return;
        }
        Node current = head;
        //loop to the end of the list
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        length++;
    }

    /**
     * Inserts a data element at the specified index
     *
     * @param data  Element to be added
     * @param index Index to be inserted
     */
    public void insert(Type data, int index) {
        // check if valid index
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index must be in 0..length-1");
        }
        // add data to the front
        if (index == 0) {
            prepend(data);
            return;
        }
        Node current = head;
        Node previous = null;
        // loop to specified index
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        // insert data at index
        if(previous!=null) {
            previous.next = new Node(data, current);
            length++;
        }
    }

    /**
     * Removes the first element of the linked list
     */
    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        length--;
    }

    /**
     * Remove the first occurrence of an element
     *
     * @param data Element to be removed
     */
    public void remove(Type data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            removeFirst();
            return;
        }
        Node current = head;
        Node previous;
        // loop until element is found
        while (current.next != null) {
            previous = current;
            current = current.next;
            // if data is found, cut it out
            if (current.data == data) {
                previous.next = current.next;
                length--;
                // end
                return;
            }
        }
    }

    /**
     * Remove all occurrences of an element
     *
     * @param data Element to be completely removed from the list
     */
    public void removeAll(Type data) {
        //while head is = data remove head
        while (head != null && head.data == data) {
            removeFirst();
        }
        if (head != null) {
            Node current = head;
            Node previous;
            // loop until element is found
            while (current.next != null) {
                previous = current;
                current = current.next;
                if (current.data == data) {
                    // loop to remove all consecutive elements
                    while (current.next != null && current.next.data == data) {
                        current = current.next;
                        length--;
                    }
                    previous.next = current.next;
                    length--;
                }
            }
        }
    }

    /**
     * Removes data element at specified index
     *
     * @param index Index of an element to be removed
     */
    public void remove(int index) {
        if (head == null) {
            return;
        }
        // validate index
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index must be in 0..length-1");
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        Node previous = null;
        // loop towards index
        while (index-- > 0) {
            previous = current;
            current = current.next;
        }
        // remove element
        if(previous!=null) {
            previous.next = current.next;
            length--;
        }
    }

    /**
     * Returns the first index of a given element
     *
     * @param data Element to be searched
     * @return Index of element, -1 for not found
     */
    public int indexOf(Type data) {
        if (head == null) {
            return -1;
        }
        int index = 0;
        Node current = head;
        while (current != null) {
            // if data found return index
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        // no data found
        return -1;
    }

    /**
     * Reverses the linked list
     */
    public void reverseList() {
        //calls the private reverseList for recursion
        reverseList(head);
    }

    /**
     * Reverses the linked list recursively
     *
     * @param node Head node of a linked list
     */
    private void reverseList(Node node) {
        // return empty list
        if (node == null) {
            return;
        }
        // base case, end of linked list reached
        if (node.next == null) {
            // set head equal to last node
            head = node;
            return;
        }
        // recursive call to reach the end of the list
        reverseList(node.next);

        // set the next nodes next to the current node
        node.next.next = node;
        // set current nodes next to null
        node.next = null;
    }
}
